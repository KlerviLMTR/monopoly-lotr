package fr.ut1.rtai.monopoly.cartes;

public class CarteGagnerDuPouvoir extends Carte {
	
	private int montantGagne;
	
    public CarteGagnerDuPouvoir(String titre, String description, int montant) {
        super(titre, description);
        this.montantGagne=montant;
    }

}
