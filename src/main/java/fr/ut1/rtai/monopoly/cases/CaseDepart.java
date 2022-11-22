package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.*;

public class CaseDepart extends Case {

	/**
	 * Indique le nom de la case
	 */
	public CaseDepart(String nom, int valeur) {
		super("Depart", 0);
	}

	/**
	 * Ajoute l'argent du passage sur la case
	 */
	public void actionCase(Joueur joueur, Plateau plateau) {

		joueur.ajouterArgent(200);
		System.out.println(" > " + joueur.getNom() + " s'arrete sur la case départ: il reçoit 200 supplémentaire !");

	}

	public static void main(String[] args) {

		System.out.println("TEST DE LA CLASSE : CaseDepart\n");
		Joueur j = new Joueur("Yann", 1500);
		Plateau p = new Plateau();

		CaseDepart c = (CaseDepart) p.getCase(0);

		j.setPosition(38);
		System.out.println("\nLe joueur est sur la case " + p.getCase(j.getPosition()).toString() + "\n");
		p.deplacerJoueur(j, 2);
		c.actionCase(j, p);
		System.out.println("Le joueur possede : " + j.getArgent() + "\n");

		j.setPosition(38);
		System.out.println("\nLe joueur est sur la case " + p.getCase(j.getPosition()).toString() + "\n");
		p.deplacerJoueur(j, 3);
		System.out.println("\nLe joueur est sur la case " + p.getCase(j.getPosition()).getNom() + "\n");
		System.out.println("Le joueur possede : " + j.getArgent() + "\n");
	}

	@Override
	public String getCouleur() {
		return null;
	}

	@Override
	public int getLoyer() {
		return 0;
	}

	@Override
	public int getPrixPlaceForte() {
		return 0;
	}

	@Override
	public void setProprietaire(Joueur j) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "CaseDepart [" + super.toString() + "]";
	}

	@Override
	public boolean getReponseQuestion() {
		// TODO Auto-generated method stub
		return false;
	}

}
