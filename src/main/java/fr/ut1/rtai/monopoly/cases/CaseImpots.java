package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.*;

public class CaseImpots extends Case {

	public CaseImpots(String nom, int valeur) {
		super(nom, valeur);
	}

	public void actionCase(Joueur joueur, Plateau plateau) {
		System.out.println(" > " + joueur.getNom() + " dépose " + this.getPrix() + " au Parc Gratuit.");
		joueur.retirerArgent(this.getPrix());

		int nouveauMontantParcGratuit = plateau.getCase(20).getPrix() + this.getPrix();
		plateau.getCase(20).setPrix(nouveauMontantParcGratuit);
	}

	public static void main(String[] args) {

		System.out.println("TEST DE LA CLASSE : CaseImpots");
		Joueur j = new Joueur("Yann", 1000);
		Plateau p = new Plateau();

		CaseImpots c = (CaseImpots) p.getCase(4);
		j.setPosition(4);
		c.actionCase(j, p);
		System.out.println(c.toString());
		System.out.println(p.getCase(20).toString());
		System.out.println(j.toString());
	}

	@Override
	public String getCouleur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoyer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPrixPlaceForte() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setProprietaire(Joueur j) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getReponseQuestion() {
		// TODO Auto-generated method stub
		return false;
	}

}
