package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CaseParcGratuit extends Case {
	public CaseParcGratuit() {
		super("Case parc gratuit");

	}

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		int position = this.getNumCase()+1;
		PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive sur la case n°"+ position+ ": \""+this.getNomCase()+"\"");
		Thread.sleep(1000);
		this.afficherCase();
		System.out.println("Vous vous détendez pour un tour.");
		
	}

	@Override
	public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1);
		aff +=  "                                 🚗 Parc Gratuit 🚗  \n"+ MessagesJeu.affichageSepCase;		
		System.out.println(aff);
		
	}

}
