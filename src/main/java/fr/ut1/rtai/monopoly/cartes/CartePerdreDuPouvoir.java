package fr.ut1.rtai.monopoly.cartes;

public class CartePerdreDuPouvoir extends Carte {
	
	private int montantAPayer;
	
	public CartePerdreDuPouvoir(String titre, String description, int montant) {
		super(titre, description);
		this.montantAPayer=montant;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionCarte() {
		// TODO Auto-generated method stub
		
	}

}