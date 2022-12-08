package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;
import fr.ut1.rtai.monopoly.Plateau;
import fr.ut1.rtai.monopoly.cases.Case;

public class CarteDeplacement extends Carte {
	
	Case caseCible;
	public CarteDeplacement(String titre, String description, Case caseCible) {
		super(titre, description);
		this.caseCible=caseCible;
	}
	
	@Override
	public void actionCarte(Joueur j) throws InterruptedException {
		this.afficherCarte();
		PartieDeMonopoly.affichageMessageDelai(15,j.getPion().getTypePion()+ " se déplace jusqu'à la case \"" + this.caseCible.getNomCase()+"\"");
		j.getPion().avancerPion(caseCible.getNumCase());
		super.estPiocheeEtRemiseAuFondDuPaquet();
		PartieDeMonopoly.poserQuestionJoueurChaine("Appuyez sur entrée pour continuer ...");
		//declencher l'action
		this.caseCible.actionCase(j);
	}

}