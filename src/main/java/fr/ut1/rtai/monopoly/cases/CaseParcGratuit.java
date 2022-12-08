package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CaseParcGratuit extends Case {
	public CaseParcGratuit() {
		super("Case parc gratuit");

	}

	@Override
	public void actionCase(Joueur j) {
		PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive sur une case parc gratuit ! ");
		System.out.println("Vous vous détendez pendant 1 tour.");
		
	}

	@Override
	public void afficherCase() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

}
