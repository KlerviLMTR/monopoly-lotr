package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CasePrison extends Case {

	public CasePrison() {
		super("Case Prison");
	}

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		int position = this.getNumCase()+1;
		PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive sur la case n°"+ position+ ": \""+this.getNomCase()+"\"");
		Thread.sleep(1000);
		this.afficherCase();
		if (!j.estEnPrison()) {
			PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " visite les prisons ...");
		}
	}

	@Override
	public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1);
		aff +=  "                   ⛓ Prison ⛓  \n"+ MessagesJeu.affichageSepCase;		
		System.out.println(aff);
		
	}
}