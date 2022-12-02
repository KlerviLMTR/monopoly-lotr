package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public class CartePerdreDuPouvoir extends Carte {
	
	private int montantAPayer;
	
	public CartePerdreDuPouvoir(String titre, String description, int montant) {
		super(titre, description);
		this.montantAPayer=montant;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionCarte(Joueur j) {
		System.out.println("Completez moi! ...");

		super.estPiocheeEtRemiseAuFondDuPaquet();

	}

}