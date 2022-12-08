package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CasePrison extends Case {

	public CasePrison() {
		super("Case Prison");
	}

	@Override
	public void actionCase(Joueur j) {
		if (!j.estEnPrison()) {
			PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " visite les prisons ...");
		}
	}

	@Override
	public void afficherCase() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

}