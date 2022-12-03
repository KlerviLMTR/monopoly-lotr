package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;

public class Monture extends CasePropriete {
	
	private int[] loyers;
	
	public Monture(String nom) {
		super(nom, 200, 100);
		this.loyers= new int[] {25,50,100,200};
	}

	@Override
	public void actionCase(Joueur j) {
		
	}
	
	@Override
	public String afficherTabLoyers() {
		String aff = "--- Loyers --- \n\nCollectionnez toutes les montures pour voir les loyers augmenter !\n - 1 monture possédée : 25 de pouvoir\n -2 montures possédées : 50 de pouvoir\n - 3 montures possédées: 100 de pouvoir\n - 4 montures possédées : 200 de pouvoir ";
		return aff;
	}
	


}
