package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public class CarteDeplacementSpecial extends Carte {
	
	private String typeDeplacement ; //Monture: se deplace jusqua la monture la plus proche
									//Magicien : "        "       au magicien le plus proche
									//recul3cases 
	public CarteDeplacementSpecial(String titre, String description, String typeD) {
		super(titre, description);
		this.typeDeplacement=typeD;
	}

	@Override
	public void actionCarte(Joueur j, Plateau p) {
		System.out.println("Completez moi! ...");
		super.estPiocheeEtRemiseAuFondDuPaquet();

	}

}
