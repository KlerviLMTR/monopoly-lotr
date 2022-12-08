package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CaseEvenement extends Case {

    public CaseEvenement() {
        super("Case évenement");
        // TODO Auto-generated constructor stub
    }

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		int position = this.getNumCase()+1;
		PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive sur la case n°"+ position+ ": \""+this.getNomCase()+"\"");
		Thread.sleep(1000);
		this.afficherCase();
		PartieDeMonopoly.affichageMessageDelai(15, "Vous piochez une carte évènement.\n");
		Thread.sleep(1000);
		PartieDeMonopoly.afficherBarreChargement();
		j.piocherUneCarteEvenement();
	}

	@Override
	public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1);
		aff +=  "                                 ⚔ Evènement ⚔  \n"+ MessagesJeu.affichageSepCase;		
		System.out.println(aff);
		
	}


}
