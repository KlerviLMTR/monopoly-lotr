package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;

public class CarteSortirDePrison extends Carte {

	public CarteSortirDePrison(String titre, String description) {
		super(titre, description);
	}

	@Override
	public void actionCarte(Joueur j) {
		if (this.getTitre().equals("Carte Peuple")){
			super.getPlateau().getCartesPeuple().remove(0);
			j.setPossedeCartesSortiePrisonPeuple(true);
		}
		else {
			super.getPlateau().getCartesEvenement().remove(0);
			j.setPossedeCartesSortiePrisonEvenement(true);
		}
	}

}
