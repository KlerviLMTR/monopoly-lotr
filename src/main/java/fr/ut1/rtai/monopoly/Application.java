package fr.ut1.rtai.monopoly;

import fr.ut1.rtai.monopoly.cartes.CarteAllerEnPrison;
import fr.ut1.rtai.monopoly.cases.CasePropriete;
import fr.ut1.rtai.monopoly.cases.Monture;
import fr.ut1.rtai.monopoly.cases.Territoire;

public class Application {

	public static void main(String[] args) throws InterruptedException {
	

		PartieDeMonopoly p = new PartieDeMonopoly();

		p.jouerAuMonopoly();
		
		

	
	}

}
