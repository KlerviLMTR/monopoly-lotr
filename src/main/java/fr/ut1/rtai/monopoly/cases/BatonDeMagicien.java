package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class BatonDeMagicien extends CasePropriete {

	public BatonDeMagicien(String nom) {
		super(nom,150,75);
	}


	

	

	@Override
	public void afficherTabLoyers() {
		System.out.println("                       --- Loyers --- \n\n>>>");
		PartieDeMonopoly.affichageMessageDelai(15," Obtenez les deux bâtons de magiciens pour voir les loyers augmenter !\n");
		System.out.println(MessagesJeu.tabLoyerMagiciens);
	}

	@Override
    public void afficherCase() throws InterruptedException {
		String aff;
		if (!this.estEnHypotheque()) {
			aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1)+ "                   🧙 "+this.getNomCase()+" 🧙 \n" + MessagesJeu.affichageSepCase;

		}
		else {
			aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1)+ "        🧙 "+this.getNomCase()+" 🧙 - EN HYPOTHEQUE \n" + MessagesJeu.affichageSepCase;
		}
		System.out.println(aff);
		
    }



}
