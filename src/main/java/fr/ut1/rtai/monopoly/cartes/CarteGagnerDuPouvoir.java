package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;

public class CarteGagnerDuPouvoir extends Carte {
	
	private int montantGagne;
	
    public CarteGagnerDuPouvoir(String titre, String description, int montant) {
        super(titre, description);
        this.montantGagne=montant;
    }

	@Override
	public void actionCarte(Joueur j) throws InterruptedException {
		this.afficherCarte();
		j.gagnerduPouvoir(this.montantGagne);
		System.out.println(">>> Vous gagnez "+this.montantGagne+" ୩.");
		super.estPiocheeEtRemiseAuFondDuPaquet();
		Thread.sleep(2000);
	}
	
	public void traiterCarteAnniv(Joueur j) {
		if (this.getDesc().equals("C’est votre anniversaire : chaque joueur vous donne 10 de pouvoir.")) {
		}
	}
	


}
