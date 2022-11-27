package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.ECouleurCase;
import fr.ut1.rtai.monopoly.Joueur;

public class Territoire extends CasePropriete {
	
	private int [] tableDesLoyers;
	private int coutConstruction;
	private ECouleurCase couleur;

	
	public Territoire(String nom,ECouleurCase coul,int coutAchat,int valHyp, int coutConstru, int[] loyers) {
		super(nom,coutAchat, valHyp);
		this.coutConstruction=coutConstru;
		this.tableDesLoyers=loyers;
		this.couleur=coul;
	}
	
	public ECouleurCase getCouleurCase() {
		return this.couleur;
	}

	public int[] getTableDesLoyers() {
		return this.tableDesLoyers;
	}

	public int getCoutConstruction() {
		return this.coutConstruction;
	}


	@Override
	public void actionCase(Joueur j) {
		
	}

}