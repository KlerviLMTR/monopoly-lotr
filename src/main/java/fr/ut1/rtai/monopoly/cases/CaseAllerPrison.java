package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;

public class CaseAllerPrison extends Case {

	public CaseAllerPrison() {
		super("Allez en prison");
	}

	@Override
	public void actionCase(Joueur j) {
		System.out.println("Oh non ! Vous vous êtes faits prendre par une bande d'Uruks de l'Isengard! Vous êtes amené en prison pour 3 tours.");
	}


}
