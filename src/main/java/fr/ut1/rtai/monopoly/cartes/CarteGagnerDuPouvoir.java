package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public class CarteGagnerDuPouvoir extends Carte {
	
	private int montantGagne;
	
    public CarteGagnerDuPouvoir(String titre, String description, int montant) {
        super(titre, description);
        this.montantGagne=montant;
    }

	@Override
	public void actionCarte(Joueur j, Plateau p) {
		System.out.println("Completez moi! ...");
		super.estPiocheeEtRemiseAuFondDuPaquet();

	}
}
