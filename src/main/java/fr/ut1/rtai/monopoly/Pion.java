package fr.ut1.rtai.monopoly;

import fr.ut1.rtai.monopoly.cases.Case;

public class Pion {
	private EPion typePion;
	private int numeroCase;
	private boolean passageCaseDepart;

	
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
	 */
	public void avancer(int nbCases) {
		this.passageCaseDepart = false;
		int nbTotal = this.numeroCase + nbCases;
		this.numeroCase = nbTotal % 40;
		if (nbTotal > 40) {
			this.passageCaseDepart = true;
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

	/**
	 * Deplacer le pion jusqu'a une nouvelle case.
	 * 
	 * @param nouvelleCase -> la nouvelle case
	 */
	public void seDeplacerCase(Case nouvelleCase) {
		this.numeroCase = nouvelleCase.getNumCase();
	}


}
