package fr.ut1.rtai.monopoly;


import java.util.HashSet;
import java.util.Set;

import fr.ut1.rtai.monopoly.cartes.CarteSortirDePrison;
import fr.ut1.rtai.monopoly.cases.BatonDeMagicien;
import fr.ut1.rtai.monopoly.cases.Case;
import fr.ut1.rtai.monopoly.cases.CasePropriete;
import fr.ut1.rtai.monopoly.cases.Monture;
import fr.ut1.rtai.monopoly.cases.Territoire;

public class Joueur {

	private String nom;
	private Pion pion;
	private int solde;
	private boolean estEnPrison;
	private Set<Monture> monturesPossedees; //Choix d'un set car l'ordre des montures possedees n'a pas d'importance
	private Set<Territoire> territoiresPossedes;//idem
	private Set<BatonDeMagicien> batonsDeMagicienPossedes;//idem
	private boolean possedeCarteSortiePrisonPeuple;
	private boolean possedeCarteSortiePrisonEvenement;
	private int nbToursPrison;
	private boolean estEnFaillite;
	private Plateau plateau;
	
	public Joueur(String nom) {
		this.nom=nom;
		this.estEnPrison=false;
		this.possedeCarteSortiePrisonPeuple=false;
		this.possedeCarteSortiePrisonEvenement=false;
		this.estEnFaillite=false;
		this.monturesPossedees = new HashSet<Monture>();
		this.territoiresPossedes = new HashSet<Territoire>();
		this.batonsDeMagicienPossedes = new HashSet<BatonDeMagicien>();
		this.solde=1500;
	}
	
	
	// -------- Getters et setters utiles ----------

	public int getSolde() {
		return solde;
	}
	
	public int getNbToursEnPrison() {
		return this.nbToursPrison;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setPlateau(Plateau p) {
		this.plateau = p;
	}
	
	public void setPion(Pion pion) {
		this.pion=pion;
		
	}

	
	public String getNomPion() {
		return this.pion.getTypePion().name();
	}
	
	public boolean estEnPrison() {
		return this.estEnPrison;
	}

	public Pion getPion() {
		return this.pion;
	}
	
	public boolean possedeUneCarteSortiePrison() {
		return this.possedeCarteSortiePrisonEvenement || this.possedeCarteSortiePrisonPeuple;
	}
	
	public boolean getPossedeCartesSortiePrisonPeuple() {
		return this.possedeCarteSortiePrisonPeuple;
	}
	public boolean getPossedeCartesSortiePrisonEvenement() {
		return this.possedeCarteSortiePrisonEvenement;
	}

	public void setPossedeCartesSortiePrisonPeuple(boolean b) {
		this.possedeCarteSortiePrisonPeuple = b;
	}
	
	public void setPossedeCartesSortiePrisonEvenement(boolean b) {
		this.possedeCarteSortiePrisonEvenement = b;
	}
	
	public Set<Monture> getMonturesPossedees(){
		return this.monturesPossedees;
	}
	public Set<BatonDeMagicien> getBatonsDeMagicienPossedes(){
		return this.batonsDeMagicienPossedes;
	}
	public Set<Territoire> getTerritoiresPossedees(){
		return this.territoiresPossedes;
	}
	
	
	//  --------  Méthodes du joueur ----------
	
	/**
	 * compte le nombre de montures possédées
	 * @return
	 */
	public int estPropDeNbMontures() {
		return this.monturesPossedees.size();
	}
	
	/**
	 * compte le nombre de bâtons possédés
	 * @return
	 */
	public int estPropdeNbBatons() {
		return this.batonsDeMagicienPossedes.size();
	}
	
	/**
	 * vérifie si le joueur est propriétaire de tous les lots d'une couleur donnée
	 * @param c
	 * @return
	 */
	public boolean estPropDeTousLesLotsCoul(ECouleurCase c) {
		return this.compterLotParCouleur(c)== this.plateau.NBLOTPARCOULEUR.get(c);
	}
	
	/**
	 * Compte le nombre de lots possédés par le joueur pour une couleur donnée
	 * @param c
	 * @return
	 */
	public int compterLotParCouleur(ECouleurCase c) {
		int cptCoul=0;
		for (Territoire t : this.territoiresPossedes) {
			if(t.getCouleurCase()==c) {
				cptCoul++;
			}
		}
		return cptCoul;
	}
	
	public void afficherLesProprietes() {
		
	}

	
	public void piocherUneCartePeuple() {
		this.plateau.getCartesPeuple().get(0).actionCarte(this);
	}
	
	public void piocherUneCarteEvenement() {
		this.plateau.getCartesEvenement().get(0).actionCarte(this);
	}


	public void gagnerduPouvoir(double pouvoir) {
		this.solde += pouvoir;
	}

	public void perdreDuPouvoir(double montantAPayer) {
		this.solde -= montantAPayer;

	}
	
	/**
	 * @param c
	 * @return
	 * Verifie que le joueur possede ou non une case donnee
	 */
	public boolean possedeCase(Case c) {
		return this.territoiresPossedes.contains(c) || this.monturesPossedees.contains(c) || this.batonsDeMagicienPossedes.contains(c);
	
	}
	
	public int getNbMonturesPossedees() {
		return this.monturesPossedees.size();
	}
	
	public int getNbBatonsDeMagicienPossedes() {
		return this.batonsDeMagicienPossedes.size();
	}
	
	public int getNbTerritoiresPossedes() {
		return this.territoiresPossedes.size();
	}
	
	/**
	 *Precondition : possede au moins 1 carte sortie de prison 
	 * @throws InterruptedException 
	 */
	public void utiliserCarteSortiePrison() throws InterruptedException {
		if(this.possedeCarteSortiePrisonEvenement || this.possedeCarteSortiePrisonPeuple) {
			System.out.println("Vous utilisez votre carte Sortie de prison et vous évadez ! ");
			Thread.sleep(1000);
			System.out.println("Vous replacez la carte dans son  paquet.");
			this.estEnPrison = false;
			
			if (this.possedeCarteSortiePrisonEvenement){
				//retirer la carte au joueur
				this.possedeCarteSortiePrisonEvenement=false;
				//la replacer dans son paquet
				this.plateau.getCartesEvenement().add( new CarteSortirDePrison("Carte Evenement", "Vous vous évadez de prison. Vous pouvez conserver cette carte et vous en servir à tout moment."));
			}
			else if (this.possedeCarteSortiePrisonPeuple) {
				this.possedeCarteSortiePrisonPeuple=false;
				this.plateau.getCartesPeuple().add(new CarteSortirDePrison("Carte Peuple", "Vous vous évadez de prison. Vous pouvez conserver cette carte et vous en servir à tout moment."));
			}
		}
		else {
			System.out.println("Vous ne disposez pas de carte sortie de prison.");
		}

	}
	
	
	public boolean estTerrainHypothequeSurLot(ECouleurCase c) {
		boolean hypothequeTrouvee = false;
		for (Territoire t : this.territoiresPossedes) {
			if (t.getCouleurCase() == c) {
				if(t.estEnHypotheque()) {
					hypothequeTrouvee = true;
				}
			}
			
		}
		return hypothequeTrouvee;
	}
	
	
	/**
	 * @param c
	 * @return
	 * Verifie si le joueur est proprietaire de tous les terrains d'une couleur donnee
	 */
	public boolean possedeTousLesTerrainsSurLotCouleur(ECouleurCase c) {
		int nbApparitionCoul = 0;
		for(Territoire t: this.territoiresPossedes) {
			if(t.getCouleurCase() == c ) {
				nbApparitionCoul++;
			}
		}
		return (nbApparitionCoul == Plateau.NBLOTPARCOULEUR.get(c)) ;
		
	}
	
	public void estMisFaillite(int montantDette) {
		this.estEnFaillite = true;
		this.declencherProcedureDeFaillite(montantDette);
	}
	
	//TODO: A completer ...
	private void declencherProcedureDeFaillite(int montantDette) {
		System.out.println("Vous avez perdu.");
	}


	/**
	 * @param case1
	 * Permet au joueur d'acheter une case donnee.
	 * @throws InterruptedException 
	 */
	public void acheterCase(Case case1){
		if (case1 instanceof CasePropriete) {
		
			if (this.solde >= ((CasePropriete)case1).getCoutAchat()) {
				((CasePropriete)case1).setProprietaire(this);
				if (case1 instanceof Monture) {
					this.monturesPossedees.add((Monture) case1);
					System.out.println("Vous achetez "+ case1.getNomCase()+" pour "+((CasePropriete)case1).getCoutAchat()+" ୩.");
					if (this.getNbMonturesPossedees()>1) {
						this.setLoyersMonturesPossedees();
						PartieDeMonopoly.affichageMessageDelai(15,". . . Les loyers de vos montures augmentent !\n");
					}
				}
				else if (case1 instanceof Territoire) {
					this.territoiresPossedes.add((Territoire) case1);
					System.out.println("Vous achetez "+ case1.getNomCase()+" pour "+((CasePropriete)case1).getCoutAchat()+" ୩.");
					if (this.estPropDeTousLesLotsCoul(((Territoire)case1).getCouleurCase())){
						PartieDeMonopoly.affichageMessageDelai(15,". . . Vous êtes propriétaire de tous les terrains de cette couleur ! Les loyers issus des terrains nus sont multipliés par 2.\n");
						this.setLoyersterrainsNusSiTousPossedes(((Territoire)case1).getCouleurCase());
					}
				}
				else {
					System.out.println("Vous achetez "+ case1.getNomCase()+" pour "+((CasePropriete)case1).getCoutAchat()+" ୩.");
					this.batonsDeMagicienPossedes.add((BatonDeMagicien) case1);
					System.out.println("Vous achetez "+ case1.getNomCase()+" pour "+((CasePropriete)case1).getCoutAchat()+" ୩.");
					if (this.estPropdeNbBatons()==2) {
						PartieDeMonopoly.affichageMessageDelai(15,". . . Vous avez obtenu tous les bâtons ! Attendez vous à percevoir des loyers magiques !\n");
					}

				}
				this.perdreDuPouvoir(((CasePropriete)case1).getCoutAchat());



				
	
			}
			else {
				PartieDeMonopoly.affichageMessageDelai(15,". . . Vous n'avez pas assez de pouvoir !");
			}
		
		}
	}
	
	
	private void setLoyersMonturesPossedees() {
		for (Monture m : this.monturesPossedees) {
			m.setLoyerActuel(this.calculerLoyerMontures(m));
		}
	}
	
	private void setLoyersterrainsNusSiTousPossedes(ECouleurCase c) {
		int cpt =0;
		for (Territoire t : this.territoiresPossedes) {
			if(t.getCouleurCase()==c) {
				if (t.estTerrainVide()) {
					int nouveauLoyer = t.getLoyerActuel()*2;			
					t.setLoyerActuel(nouveauLoyer);
					cpt++;

				}
			}
		}
	}
	
	
	private int calculerLoyerMontures(Monture case1) {
		int loyer=0;
	
		switch(this.estPropDeNbMontures()) {
		case 1:
			loyer = case1.getLoyers()[0];
			break;
		case 2:
			loyer = case1.getLoyers()[1];
			break;
		case 3:
			loyer = case1.getLoyers()[2];
			break;
		case 4:
			loyer = case1.getLoyers()[3];
		}
		return loyer;
	}
		


	
	public void payerJoueur(Joueur j, int montant) {
		this.perdreDuPouvoir(montant);
		j.gagnerduPouvoir(montant);
	}
	

	
	public void estMisEnPrison() {
		this.nbToursPrison = 0;
		this.estEnPrison = true;
	}

	
	public String toString() {
		return this.nom;
	}







	
	
	
	
}
