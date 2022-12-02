package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;

public class CarteGagnerDuPouvoir extends Carte {
	
	private int montantGagne;
	
    public CarteGagnerDuPouvoir(String titre, String description, int montant) {
        super(titre, description);
        this.montantGagne=montant;
    }

	@Override
	public void actionCarte(Joueur j) {
		System.out.println("Completez moi! ...");
		super.estPiocheeEtRemiseAuFondDuPaquet();

	}
}
