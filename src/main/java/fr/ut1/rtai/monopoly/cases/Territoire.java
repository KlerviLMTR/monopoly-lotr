package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.CouleurCase;
import fr.ut1.rtai.monopoly.Joueur;

public class Territoire extends CasePropriete {
	
	private int [] tableDesLoyers;
	private int coutConstruction;
	private String nomRegion;
	private CouleurCase couleur;
	
	public Territoire(String nom,CouleurCase coul,int coutAchat,int valHyp, int coutConstru, int[] loyers) {
		super(nom,coutAchat, valHyp);
		this.coutConstruction=coutConstru;
		this.tableDesLoyers=loyers;
		this.couleur=coul;
	}

	@Override
	public void actionCase(Joueur j) {
		
	}

}