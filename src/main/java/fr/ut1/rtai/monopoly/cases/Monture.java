package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;

public class Monture extends CasePropriete {
	
	private int[] loyers;
	
	public Monture(String nom) {
		super(nom, 200, 100);
		this.loyers= new int[] {25,50,100,200};
	}

	@Override
	public void actionCase(Joueur j) {
		
	}

}
