package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;
import fr.ut1.rtai.monopoly.cases.Case;

public class CarteDeplacement extends Carte {
	
	Case caseCible;
	public CarteDeplacement(String titre, String description, Case caseCible) {
		super(titre, description);
		this.caseCible=caseCible;
	}
	@Override
	public void actionCarte(Joueur j) {
		System.out.println("Completez moi! ...");
		super.estPiocheeEtRemiseAuFondDuPaquet();
	}
}