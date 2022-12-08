package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CaseAllerPrison extends Case {

	public CaseAllerPrison() {
		super("Allez en prison");
	}

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		int position = this.getNumCase()+1;
		PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive sur la case n°"+ position+ ": \""+this.getNomCase()+"\"");
		Thread.sleep(1000);
		this.afficherCase();
		System.out.println("Oh non ! Vous vous êtes faits prendre par une bande d'Uruks de l'Isengard! Vous êtes amené en prison pour 3 tours.");
		j.estMisEnPrison();
		j.getPion().avancerPion(10);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1);
		aff +=  "                                 ⛓ Allez en prison ⛓  \n"+ MessagesJeu.affichageSepCase;		
		System.out.println(aff);
		
	}


}
