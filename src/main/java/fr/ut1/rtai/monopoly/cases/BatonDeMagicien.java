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
	
	
	public void calculerLeLoyerActuel() {
		switch(this.getProprietaire().estPropdeNbBatons()) {
			case 1:
				this.setLoyerActuel(PartieDeMonopoly.lancerDeDesCourant*4);
				break;
			case 2:
				this.setLoyerActuel(PartieDeMonopoly.lancerDeDesCourant*10);
				break;
		}
	}
	


	@Override
	public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1);
		if (this.getProprietaire()==null) {
			aff +=  "                   🧙 "+this.getNomCase()+" 🧙 - LIBRE \n" + MessagesJeu.affichageSepCase + MessagesJeu.descriptionCaseBatons+"\n                         Prix : "+this.getCoutAchat()+ " ୩\n                         ------------\n";
		}

		else {
			if (this.estEnHypotheque()) {
				aff +="        🧙 "+this.getNomCase()+" 🧙 - EN HYPOTHEQUE \n" + MessagesJeu.affichageSepCase + "\n                      Propriétaire : "+this.getProprietaire().getNomPion()+"\n";
			}
			else {
				aff +="            🧙 "+this.getNomCase()+" 🧙 - "+ this.getProprietaire().getNomPion().toUpperCase()+"\n" + MessagesJeu.affichageSepCase + "\n                      Propriétaire : "+this.getProprietaire()+"\n";			
			}
			if (this.getProprietaire().estPropDeNbMontures()==1) {
				aff +="\n                             🧙              \n                        ------------\n";
			}
			else if(this.getProprietaire().estPropDeNbMontures()==2) {
				aff +="\n                            🧙 🧙             \n                        ------------\n";
			}
			else if(this.getProprietaire().estPropDeNbMontures()==3) {
				aff +="\n                           🧙 🧙 🧙           \n-                        -----------\n";
			}
			else if(this.getProprietaire().estPropDeNbMontures()==4) {
				aff +="\n                          🧙 🧙 🧙 🧙            \n                        ------------\n";
			}
			if (!this.estEnHypotheque()) {
				aff +="                         Loyer :"+ this.getLoyerActuel() + " ୩.\n";      
			}
			else {
				aff +="                         Loyer : 0 ୩.\n";      
			}
		}
		System.out.println(aff);
	}

	@Override
	public void afficherMenuPropAJoueur() {
		System.out.println(MessagesJeu.afficherMenuBatonAJoueur);
	}


}


