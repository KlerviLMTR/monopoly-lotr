package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;

public abstract class Case {
	private String intitule;
	private int numCase;
	
	public Case(String intitule) {
		this.intitule=intitule;
		this.numCase=-1; //valeur par defaut choisie avant definition du numero de case par le plateau
	}
	
	/**
	 * @param numero
	 * Affecte le numero de la case. Methode appelee une seule fois par le plateau lors de l'initialisation
	 */
	public void setNumCase(int numero) {
		this.numCase=numero;
	}
	

	
	/**
	 * @return le numero de la case
	 */
	public int getNumCase() {
		return this.numCase;
	}
	
	/**
	 *Methode a implementer dans les classes filles definissant l'action a effectuer sur la case 
	 */
	public abstract void actionCase(Joueur j);
	
	/**
	 *Affichage d'une case
	 */
	public String toString() {
		return "Case n°"+this.numCase +" : "+ this.intitule;
	}
	

}