package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CasePeuple extends Case {

    public CasePeuple() {
        super("Case peuple");
    }

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		this.afficherCase();
		PartieDeMonopoly.affichageMessageDelai(15, j.getPion().getTypePion() + " arrive sur une case peuple. Vous piochez une carte évènement.\n");
		Thread.sleep(1000);
		PartieDeMonopoly.afficherBarreChargement();
		j.piocherUneCartePeuple();
	}

	@Override
	public void afficherCase() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}



}
