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
	
	public boolean isEstEnPrison() {
		return this.estEnPrison;
	}

	public Pion getPion() {
		return this.pion;
	}
	
	public boolean getNbCartesSortiePrisonPeuple() {
		return this.possedeCarteSortiePrisonPeuple;
	}
	public boolean getNbCartesSortiePrisonEvenement() {
		return this.possedeCarteSortiePrisonEvenement;
	}

	public void setNbCartesSortiePrison(boolean b) {
		this.possedeCarteSortiePrisonPeuple = b;
	}
	
	//  --------  Méthodes du joueur ----------
	
	public void piocherUneCartePeuple() {
		this.plateau.getCartesPeuple().get(0).actionCarte(this, this.plateau);
	}
	
	public void gagnerduPouvoir(int pouvoir) {
		this.solde += pouvoir;
	}

	public void perdrePouvoir(int pouvoir) {
		this.solde -= pouvoir;

	}
	
	public int getNbMonturesPossedees() {
		return this.monturesPossedees.size();
	}
	
	public int getNbBatonsDeMagicienPossedes() {
		return this.batonsDeMagicienPossedes.size();
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
	
	/**
	 * @param c
	 * Permet au joueur d'acheter une case donnee.
	 */
	public void acheterCase(CasePropriete c) {
		c.setProprietaire(this);
		if (c instanceof Monture) {
			this.monturesPossedees.add((Monture) c);
		}
		else if (c instanceof Territoire) {
			this.territoiresPossedes.add((Territoire) c);
		}
		else {
			this.batonsDeMagicienPossedes.add((BatonDeMagicien) c);
		}
	}
	

	
	public void estMisEnPrison() {
		this.nbToursPrison = 0;
		this.estEnPrison = true;
	}

	public boolean getEstEmprisonne() {
		return this.estEnPrison;
	}
	
	public String toString() {
		return this.nom + " dans le rôle de "+ this.pion.getTypePion().afficherPion();
	}


	
	
	
	
}
