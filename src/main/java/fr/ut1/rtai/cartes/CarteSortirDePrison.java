package fr.ut1.rtai.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public class CarteSortirDePrison extends Carte {

	public CarteSortirDePrison(String titre, String description) {
		super(titre, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionCarte(Joueur joueur, Plateau plateau) {

		System.out.println(" > " + joueur.getNom() + " recoit la carte 'Sortir de prison' !");

		joueur.setCarteSortiePrison(true);
	}

	@Override
	public String toString() {
		return "CarteSortirPrison [" + super.toString() + "]";
	}

}
