package fr.ut1.rtai.monopoly;


public class Pion {
	private EPion typePion;
	private int numeroCase;
	private boolean passageCaseDepart;
	private Joueur joueur;
	
	public Pion(EPion typeP) {
		this.typePion=typeP;
	}
	
	// ---------- Getters et setters utiles --------------
	
	public EPion getTypePion() {
		return this.typePion;
	}
	
	public void setNumeroCase(int num) {
		this.numeroCase = num;
	}
	
	
	public void setJoueur(Joueur j) {
		this.joueur = j;
	}
	
	public int getNumCase() {
		return this.numeroCase;
	}
	
	// ---------- Méthodes de déplacement du pion --------------
	
	/**
	 * Savoir si le pion est passe par la case depart.
	 * 
	 * @return si c'est le cas
	 */
	public boolean getPassageCaseDepart() {
		return this.passageCaseDepart;
	}

	/**
	 * Avancer le pion d'un certain nombre de cases.
	 * 
	 * @param nbCases -> le nombre de cases dont il doit avancer
	 * @throws InterruptedException 
	 */
	public void avancerPion(int nbCases) throws InterruptedException {
		this.passageCaseDepart = false;
		int nbTotal = this.getNumCase() + nbCases;
		this.numeroCase = nbTotal % 40;
		if (nbTotal >= 40) {
			this.passageCaseDepart = true;
			
		}
		if(this.passageCaseDepart) {
			//Toucher un salaire 
			PartieDeMonopoly.affichageMessageDelai(15, "Vous passez par la case départ et touchez un salaire de 200 ୩.");
			this.joueur.gagnerduPouvoir(200);
			Thread.sleep(500);
			
		}
	}

	/**
	 * Deplacer le pion jusqu'a une nouvelle case.
	 * 
	 * @param numeroCase -> le numero de la nouvelle case
	 */
	public void seDeplacerNumCase(int numeroCase) {
		this.numeroCase = numeroCase;
	}




}
