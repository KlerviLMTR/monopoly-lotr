package fr.ut1.rtai.monopoly;

public enum EPion {
	Gandalf("Gandalf Le Magicien"),
	Frodon("Frodon Le Hobbit"),
	Aragorn("Aragorn Le Rodeur"),
	Legolas("Legolas L'Elfe"),
	Gimli("Gimli Le Nain"),
	Galadriel("Galadriel L'Elfe");
	
	private String nomPion;
	

	private EPion(String nomComplet) {
		this.nomPion=nomComplet;
	}
	
	public String afficherPion() {
		return this.nomPion;
	}
}
