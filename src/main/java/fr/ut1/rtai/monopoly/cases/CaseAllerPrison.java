package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public class CaseAllerPrison extends Case {

	public CaseAllerPrison() {
		super("Aller en prison", 0);
	}

	public void actionCase(Joueur joueur, Plateau plateau) {

		if (joueur.getCarteSortiePrison()) {
			System.out.println(" > " + joueur.getNom() + " utilise sa carte et évite la prison !");
			joueur.setCarteSortiePrison(false);
			plateau.remettreCarteSortiePrisonDansPaquet();
		} else {
			joueur.setEstPrison(true);
			joueur.setPosition(10);
			System.out.println(" > " + joueur.getNom() + " est envoyé en prison!");

		}
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
	}

	@Override
	public String toString() {
		return "CaseAllerPrison [" + super.toString() + "]";
	}

	@Override
	public boolean getReponseQuestion() {
		// TODO Auto-generated method stub
		return false;
	}

}
