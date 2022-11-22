package fr.ut1.rtai.monopoly.cases;

import java.util.ArrayList;

import fr.ut1.rtai.monopoly.*;

public abstract class Case {

	private String nom;
	private int valeur = 0;

	public ArrayList<Object> fortes = new ArrayList<Object>();

	public Case(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;

		/* OUI ON SAIT QUE C'EST PAS BIEN, PARDON */
		for (int i = 0; i < 6; i++) {
			Object forte = new String(nom);
			fortes.add(forte);
		}

	}

	public abstract void actionCase(Joueur joueur, Plateau plateau);

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Renvoie le prix de la case
	 */
	public int getPrix() {
		return valeur;
	}

	/**
	 * le prix de la case
	 */

	public void setPrix(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Renvoie la couleur de la case
	 */
	public abstract String getCouleur();

	/**
	 * Renvoie le loyer du terrain en fonction du nombre de la palce forte poées sur
	 * plateaux
	 * terrain
	 */
	public abstract int getLoyer();

	/**
	 * le prix d'une Place Forte
	 */
	public abstract int getPrixPlaceForte();

	/**
	 * Definit le proprietaire de la case.
	 */
	public abstract void setProprietaire(Joueur j);

	/**
	 * Renvoie la réponse a une question (Pour l'achat d'un terrain par exemple)
	 * 
	 * @return reponseQuestion
	 */
	public abstract boolean getReponseQuestion();

	@Override
	public String toString() {
		return "Case [nom=" + nom + ", valeur=" + valeur + "]";
	}
}