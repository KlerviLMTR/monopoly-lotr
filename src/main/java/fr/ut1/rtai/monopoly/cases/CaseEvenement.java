package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CaseEvenement extends Case {

    public CaseEvenement() {
        super("Case évenement");
        // TODO Auto-generated constructor stub
    }

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		this.afficherCase();
		PartieDeMonopoly.affichageMessageDelai(15, j.getPion() + " arrive sur une case évènement. Vous piochez une carte évènement.\n");
		Thread.sleep(1000);
		PartieDeMonopoly.afficherBarreChargement();
		j.piocherUneCarteEvenement();
	}

	@Override
	public void afficherCase() throws InterruptedException {
		
	}



}
