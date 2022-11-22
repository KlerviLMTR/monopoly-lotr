package fr.ut1.rtai.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public class CarteDeplacement extends Carte {

	private int position;
	private boolean deplacementRelatif;

	public CarteDeplacement(String titre, String description, int position, boolean deplacementRelatif) {
		super(titre, description);
		this.position = position;
		this.deplacementRelatif = deplacementRelatif;
	}

	public void actionCarte(Joueur joueur, Plateau plateau) {

		if (deplacementRelatif) // Pour les cartes "Reculez/avancez et X cases"
			plateau.deplacerJoueur(joueur, position);
		else {
			if (getTitre().equals("Prison")) {
				if (joueur.getCarteSortiePrison()) {
					System.out.println(" > " + joueur.getNom() + " utilise sa carte pour  évite la prison !");

					joueur.setCarteSortiePrison(false);
					plateau.remettreCarteSortiePrisonDansPaquet();
				} else {
					joueur.setEstPrison(true);
					plateau.deplacerJoueur(joueur, position - joueur.getPosition());
				}
			} else if (position - joueur.getPosition() < 0)
				plateau.deplacerJoueur(joueur, position - joueur.getPosition() + 40);
			else
				plateau.deplacerJoueur(joueur, position - joueur.getPosition());
		}

		if (getTitre().equals("Prison")) {
			System.out.println(" > " + joueur.getNom() + " se retrouve en prison.");

		} else {
			System.out.println(" > " + joueur.getNom() + " atterit sur " + plateau.getCaseActive().getNom());

			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			plateau.getCase(joueur.getPosition());
			joueur.deplacerPion(joueur);
			joueur.getPartie();
			plateau.getCase(joueur.getPosition()).actionCase(joueur, plateau);
		}

	}

	@Override
	public String toString() {
		return "CarteDeplacement [" + super.toString() + "]";
	}

}