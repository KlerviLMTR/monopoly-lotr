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
	private PartieDeMonopoly partie;
	private int nbDoubles; //Compte les doubles effectués pour un tour de jeu
	private boolean aFaitUnDouble;
	private int montantTotalFinDePartie;
	
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
		this.nbDoubles=0;
		this.aFaitUnDouble=false;
		this.montantTotalFinDePartie=0;
	
	}


	// -------- Getters et setters utiles ----------

	public int getSolde() {
		return solde;
	}

	public void setPartie(PartieDeMonopoly p) {
		this.partie=p;
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
	
	public int getMontantTotalFinDePartie() {
		return this.montantTotalFinDePartie;
	}
	
	public void setMontantTotalFinDePartie(int montant) {
		this.montantTotalFinDePartie=montant;
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
	
	public boolean estEnFaillite() {
		return this.estEnFaillite;
	}
	
	public void setNbDoubles(int nbD) {
		this.nbDoubles = nbD;
	}
	
	public int getNbDoubles() {
		return this.nbDoubles;
	}
	
	public void setAFaitUnDouble(boolean b) {
		this.aFaitUnDouble=b;
	}
	
	public boolean aFaitUnDouble() {
		return this.aFaitUnDouble;
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

	/**
	 *Elimine un joueur de la partie 
	 */
	public void estMisEnFaillite() {
		this.estEnFaillite=true;
		this.partie.eliminerJoueur();
	}


	public void piocherUneCartePeuple() throws InterruptedException {
		this.plateau.getCartesPeuple().get(0).actionCarte(this);
	}

	public void piocherUneCarteEvenement() throws InterruptedException {
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

	public boolean possedeCarteSortiePrison() {
		return this.possedeCarteSortiePrisonEvenement || this.possedeCarteSortiePrisonPeuple;
	}

	/**
	 *Precondition : possede au moins 1 carte sortie de prison 
	 * @throws InterruptedException 
	 */
	public void utiliserCarteSortiePrison() throws InterruptedException {
		System.out.println("Vous utilisez votre carte Sortie de prison et vous évadez ! ");
		Thread.sleep(1000);
		PartieDeMonopoly.affichageMessageDelai(15, ". . . Vous replacez la carte dans son paquet.");
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





	/**
	 * Vérifie si le lot concerné possède au moins un terrain en hypothèque
	 * @param c
	 * @return
	 */
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
	
	/**
	 * Calcule l'ensemble de la fortune d'un joueur
	 * @return
	 */
	public void calculerTotalFinDePartie() {
		int total=this.solde;
		for (Monture m : this.monturesPossedees) {
			total+=m.getCoutAchat();
		}
		for(BatonDeMagicien b : this.batonsDeMagicienPossedes) {
			total+=b.getCoutAchat();
		}
		for (Territoire t : this.territoiresPossedes) {
			total+=t.getCoutAchat();
			//Compter pour chaque territoire le nb de PF possedees et additioner le cout de chacune
			int nbPlacesFortes = t.getNbPlacesFortes();
			total+=t.getCoutConstruction()*nbPlacesFortes;
			if (t.getPossedeForteresse()) {
				//S'il possede une forteresse, le cout qui en resulte = les 3 places fortes + le cout de la forteresse
				total+= t.getCoutConstruction()*4;
			}
		}
		this.setMontantTotalFinDePartie(total);

	}



	/**
	 * Retourne tous les biens après une faillite.
	 * @param j
	 */
	public void rendreTousLesBiens(){
	    Set <CasePropriete> biensRendus = new HashSet<CasePropriete>();

	    for (Monture m : this.monturesPossedees){
	        //Retirer le propriétaire
	        m.setProprietaire(null);
	        //reinitialiser les loyers
	        m.setLoyerActuel(m.getLoyers()[0]);
	        //Ajouter la monture au set
	        biensRendus.add(m);
	    }

	    for (BatonDeMagicien b : this.batonsDeMagicienPossedes){
	        //Retirer le propriétaire
	        b.setProprietaire(null);
	        //reinitialiser les loyers
	        b.setLoyerActuel(b.getLoyerActuel());
	        //Ajouter le baton au set
	        biensRendus.add(b);
	    }
	    for(Territoire t : this.territoiresPossedes){
	        //Retirer le propriétaire
	        t.setProprietaire(null);
	        //Detruire les constructions
	        t.setNbPlacesFortes(0);
	        t.setPossedeForteresse(false);
	        //Enlever l'hypotheque
	        t.setEstEnHypotheque(false);
	        //Reinitialiser le loyer
	        t.setLoyerActuel(t.getTableDesLoyers()[0]);
	        //Ajouter le territoire au set
	        biensRendus.add(t);
	    }

	    //Afficher les biens rendus
	    System.out.println("--- Biens à nouveau disponibles : ---");
	    for(CasePropriete c : biensRendus){
	        System.out.println(" - "+ c.getNomCase());
	    }

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


	/**
	 * Permet de changer le loyer des montures possedées. Cette méthode est déclenchée lorsque le joueur achète + d'une monture
	 * 
	 */
	private void setLoyersMonturesPossedees() {
		for (Monture m : this.monturesPossedees) {
			m.setLoyerActuel(this.calculerLoyerMontures(m));
		}
	}
	/**
	 * Permet de changer le loyer des montures possedées. Cette méthode est déclenchée si le joueur achète le dernier terraind d'un lot dont il est intégralement propriétaire
	 * 
	 */
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


	/**
	 * calcule les montants des loyers sur les montures possedées
	 * @param case1
	 * @return
	 */
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






	/**
	 * permet au joueur de payer un loyer à un autre joueur.
	 * @param j
	 * @param montant
	 */
	public void payerJoueur(Joueur j, int montant) {
		if (this.solde<montant) {
			PartieDeMonopoly.affichageMessageDelai(15, ". . . Mais vous n'avez pas assez de pouvoir ! Vous êtes mis en faillite.");
			this.estMisEnFaillite();
		}
		this.perdreDuPouvoir(montant);
		j.gagnerduPouvoir(montant);
	}




	/**
	 * Tente de mettre le joueur en prison. Le joueur s'enfuit s'il possede une carte sortie de prison.
	 * @throws InterruptedException
	 */
	public void estMisEnPrison() throws InterruptedException {
		//Si le joueur possede une carte sortie de prison, l'utiliser
		if(this.possedeCarteSortiePrison()) {
			this.utiliserCarteSortiePrison();
			System.out.println("\n"+this.getPion().getTypePion()+ " s'enfuit à toute vitesse !");		
		}
		else {
            PartieDeMonopoly.affichageMessageDelai(15,this.getNomPion()+ " est amené en prison pour 3 tours.");
			this.nbToursPrison = 0;
			this.estEnPrison = true;
		}

	}

	/**
	 * Traite les differents tours passes en prison
	 * @param lancerDes
	 * @throws InterruptedException
	 */
	public void sejournerEnPrison() throws InterruptedException {
		if (this.estEnPrison) {
			if (this.nbToursPrison<3 ) {
				PartieDeMonopoly.affichageMessageDelai(15, "Vous êtes en prison.");


				PartieDeMonopoly.affichageMessageDelai(15, "\nVous lancez les dés pour tenter de sortir de prison.");
				this.partie.lancerDesJoueur(this);
				Thread.sleep(1500);

				if (this.partie.getDes().estUnDouble()){
					PartieDeMonopoly.affichageMessageDelai(15, "\nVous avez obtenu un double! Fuyez vite !");
					this.estEnPrison=false;
					this.nbToursPrison=0;
					System.out.println("\n"+this.getPion().getTypePion()+ " s'évade de prison.");
				}
				else {
					PartieDeMonopoly.affichageMessageDelai(15, "\n Raté...");
					System.out.println("\n"+this.getPion().getTypePion()+ " reste croupir en prison.");
					this.nbToursPrison++;

				}

			}	

			else {
				PartieDeMonopoly.affichageMessageDelai(15, "\nVous avez purgé votre peine de 3 tours. Vous pourrez jouer au prochain tour.");
				System.out.println(this.getPion().getTypePion()+ " sort enfin de prison.");
				this.estEnPrison=false;
			}
		}
	}
	
	
	// ----- Methodes d'affichage du joueur ------
	
	/**
	 * Affichage global du joueur. Appelee au début de chaque tour de jeu
	 */
	public void afficherJoueurDebutTourDeJeu() {
		System.out.println("※---※---※ "+ this.getNom().toUpperCase() +" - "+this.getPion().getTypePion().afficherPion()+ " ※---※---※\n");
		System.out.println("୩ Solde actuel : " + this.getSolde()+ " ୩\n");
		int position = this.getPion().getNumCase()+1;
		System.out.println("⚑ Position actuelle : Case n°"+ position+", \"" +this.plateau.getCaseNumero(this.getPion().getNumCase()+1).getNomCase()+"\"" );
		System.out.println("\n🏠 Territoires possédés : "+ this.territoiresPossedes.size());
		System.out.println("\n🐴 Montures possédées : "+ this.getNbMonturesPossedees());
		System.out.println("\n🏠 Bâtons possédés : "+ this.getNbBatonsDeMagicienPossedes()+"\n\n");

	}
	
	/**
	 * Affichage concis du joueur. Appelee au début de chaque tour de jeu du joueur
	 */
	public void afficherJoueurDebutTourDeJeuJoueur() {
		PartieDeMonopoly.affichageMessageDelai(15, "\n... C'est au tour de "+this.nom+"\n");
		System.out.println("※---※---※ "+ this.getNom().toUpperCase() + " ※---※---※\n");
		System.out.println("୩ Solde actuel : " + this.getSolde()+ " ୩\n");
		int position = this.getPion().getNumCase()+1;
		System.out.println("⚑ Position actuelle : Case n°"+ position+", \"" +this.plateau.getCaseNumero(this.getPion().getNumCase()+1).getNomCase()+"\"" );


	}


	public String toString() {
		return this.nom;
	}











}
