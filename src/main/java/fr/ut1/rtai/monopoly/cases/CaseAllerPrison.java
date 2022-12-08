package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CaseAllerPrison extends Case {

	public CaseAllerPrison() {
		super("Allez en prison");
	}

	/**
	 *définit l'action effecutée lorsqu'un joueur arrive sur une case prison
	 */
	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		int position = this.getNumCase()+1;
		PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive sur la case n°"+ position+ ": \""+this.getNomCase()+"\"");
		Thread.sleep(1000);
		this.afficherCase();
		System.out.println("Oh non ! Vous vous êtes faits prendre par une bande d'Uruks de l'Isengard! Vous êtes amené en prison pour 3 tours.");
		j.estMisEnPrison();
		//Si le joueur n'a pas pu s'échapper à l'aide d'une carte, son pion est déplacé jusqu'en prison
		//Le pion est déplacé mais le joueur ne touche pas de salaire
		if (j.estEnPrison()) {
			j.getPion().setNumeroCase(10);
			//Annuler les doubles s'il est arrivé sur cette case après un doublé
			j.setNbDoubles(0);
			j.setAFaitUnDouble(false);
		}
	
	
	}


	@Override
	public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1);
		aff +=  "                                 ⛓ Allez en prison ⛓  \n"+ MessagesJeu.affichageSepCase;		
		System.out.println(aff);
		
	}


}
