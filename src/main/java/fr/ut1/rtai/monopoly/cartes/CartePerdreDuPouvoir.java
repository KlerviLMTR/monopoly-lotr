package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;

public class CartePerdreDuPouvoir extends Carte {
	
	private int montantAPayer;
	
	public CartePerdreDuPouvoir(String titre, String description, int montant) {
		super(titre, description);
		this.montantAPayer=montant;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionCarte(Joueur j) throws InterruptedException {
		this.afficherCarte();
		j.perdreDuPouvoir(this.montantAPayer);
		System.out.println(">>> Vous perdez "+this.montantAPayer+" ୩.");
		super.estPiocheeEtRemiseAuFondDuPaquet();
		Thread.sleep(2000);
	}



}