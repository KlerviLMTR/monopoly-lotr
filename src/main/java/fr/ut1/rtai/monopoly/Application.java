package fr.ut1.rtai.monopoly;
public class Application {

	public static void main(String[] args) {
	
		PartieDeMonopoly partie = new PartieDeMonopoly();
		partie.definirNbJoueurs();
		System.out.println(partie.getNbJoueurs());
		partie.creerLesJoueurs();
		System.out.println(partie.afficherJoueurs());

		
	}

}
