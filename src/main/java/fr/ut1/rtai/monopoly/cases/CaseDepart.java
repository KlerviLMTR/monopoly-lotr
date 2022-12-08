package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CaseDepart extends Case {

	public CaseDepart() {
		super("Case départ");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		int position = this.getNumCase()+1;
		PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive sur la case n°"+ position+ ": \""+this.getNomCase()+"\"");
		Thread.sleep(1000);
		this.afficherCase();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1);
		aff +=  "                                 ୩ Départ ୩  \n"+ MessagesJeu.affichageSepCase;		
		System.out.println(aff);
		
	}

}
