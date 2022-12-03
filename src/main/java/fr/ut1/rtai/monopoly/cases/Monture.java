package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class Monture extends CasePropriete {
	
	private int[] loyers;
	
	public Monture(String nom) {
		super(nom, 200, 100);
		this.loyers= new int[] {25,50,100,200};
	}

	@Override
	public void actionCase(Joueur j) {
		
	}
	
	// ------------ Methodes d'affichage des Montures --------------
	
	@Override
	public String afficherTabLoyers() {
		String aff = "--- Loyers --- \n\nCollectionnez toutes les montures pour voir les loyers augmenter !\n - 1 monture possédée : 25 de pouvoir\n -2 montures possédées : 50 de pouvoir\n - 3 montures possédées: 100 de pouvoir\n - 4 montures possédées : 200 de pouvoir ";
		return aff;
	}
	
	
	public void montureAQuelquunDautre() {
		
	}

	public void gererSaMonture() {
		
	}
	


	
	public void traiterChoixMenuMontureAuJoueur() {
		int choix = PartieDeMonopoly.poserQuestionJoueurInt(">>> Votre choix ?:");
	}
	

	
	@Override
    public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1)+ "                   🐴 "+this.getNomCase()+" 🐴\n" + MessagesJeu.affichageSepCase;
		System.out.println(aff);
		//Si la case n'est a personne, afficher le message descriptif
		if(this.getProprietaire()==null) {
			System.out.println(MessagesJeu.descriptionCaseMonture+"\n                         Prix : "+this.getCoutAchat()+ " ୩\n                         ------------\n");
		
			PartieDeMonopoly.affichageMessageDelai(15, MessagesJeu.questionMontureAPersonne+ this.getCoutAchat()+ " ୩ ?");	

		}
		
    }
	


}
