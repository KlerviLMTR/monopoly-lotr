package fr.ut1.rtai.monopoly;

import fr.ut1.rtai.monopoly.cartes.CarteAllerEnPrison;
import fr.ut1.rtai.monopoly.cases.CasePropriete;

public class Application {

	public static void main(String[] args) throws InterruptedException {
	
		PartieDeMonopoly partie = new PartieDeMonopoly();
		partie.definirNbJoueurs();
		System.out.println(partie.getNbJoueurs());
		partie.creerLesJoueurs();
		partie.genererPions();		
		
	}

}
