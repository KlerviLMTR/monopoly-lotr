package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CasePeuple extends Case {

    public CasePeuple() {
        super("Case peuple");
    }

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		int position = this.getNumCase()+1;
		PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive sur la case n°"+ position+ ": \""+this.getNomCase()+"\"");
		Thread.sleep(1000);
		this.afficherCase();
		PartieDeMonopoly.affichageMessageDelai(15, "Vous piochez une carte peuple.\n");
		Thread.sleep(1000);
		PartieDeMonopoly.afficherBarreChargement();
		j.piocherUneCartePeuple();
	}

	@Override
	public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1);
		aff +=  "                                 🧍 Peuple 🧍  \n"+ MessagesJeu.affichageSepCase;		
		System.out.println(aff);
		
	}


}
