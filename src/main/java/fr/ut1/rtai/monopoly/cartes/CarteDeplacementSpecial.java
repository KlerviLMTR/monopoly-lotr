package fr.ut1.rtai.monopoly.cartes;

public class CarteDeplacementSpecial extends Carte {
	
	private String typeDeplacement ; //Monture: se deplace jusqua la monture la plus proche
									//Magicien : "        "       au magicien le plus proche
									//recul3cases 
	public CarteDeplacementSpecial(String titre, String description, String typeD) {
		super(titre, description);
		this.typeDeplacement=typeD;
	}

	@Override
	public void actionCarte() {
		// TODO Auto-generated method stub

	}

}
