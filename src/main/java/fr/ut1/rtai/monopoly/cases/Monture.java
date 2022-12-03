package fr.ut1.rtai.monopoly.cases;

import java.util.ArrayList;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;
import fr.ut1.rtai.monopoly.Pion;

public class Monture extends CasePropriete {
	
	private int[] loyers;
	private int loyerActuel;
	
	public Monture(String nom) {
		super(nom, 200, 100);
		this.loyers= new int[] {25,50,100,200};
		this.loyerActuel=this.loyers[0];
	}
	
	public int getLoyerActuel() {
		return this.loyerActuel;
	}
	
	// --------- Methodes des montures --------------
	

	
	// ------------ Methodes d'affichage des Montures --------------
	



	public void afficherTabLoyers() {
		System.out.println("                              --- Loyers --- \n\n" );
		PartieDeMonopoly.affichageMessageDelai(15, ">>> Obtenez toutes les montures pour voir les loyers augmenter !\n");
		System.out.println(MessagesJeu.tabLoyerMontures);
	}
	
	
	
	
	@Override
    public void afficherCase() throws InterruptedException {
		String aff;
		if (!this.estEnHypotheque()) {
			aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1)+ "                   🐴 "+this.getNomCase()+" 🐴\n" + MessagesJeu.affichageSepCase;

		}
		else {
			aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1)+ "        🐴 "+this.getNomCase()+" 🐴 - EN HYPOTHEQUE \n" + MessagesJeu.affichageSepCase;
		}
		System.out.println(aff);
		
    }
	


}
