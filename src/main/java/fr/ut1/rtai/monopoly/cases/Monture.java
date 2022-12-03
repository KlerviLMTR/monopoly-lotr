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
	

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		//Dans tous les cas, afficher la case
		this.afficherCase();
		//Si la case n'est a personne, afficher le message descriptif
		if(this.getProprietaire()==null) {
			System.out.println(MessagesJeu.descriptionCaseMonture+"\n                         Prix : "+this.getCoutAchat()+ " ୩\n                         ------------\n");
			//declencher la procedure d'achat
			PartieDeMonopoly.affichageMessageDelai(15, MessagesJeu.questionMontureAPersonne+ this.getCoutAchat()+ " ୩ ?");	
			this.proposerAchatCase(j);
		}
		else if (this.getProprietaire()==j) {
			if (!this.estEnHypotheque()) {
				System.out.println("                         Loyer actuel :" + this.getLoyerActuel()+ " ୩\n                         -------------------\n");
				PartieDeMonopoly.affichageMessageDelai(15, MessagesJeu.caseMonturePropOK);
				this.gererLaMonturePossedee(j);
			}
			else {
				int montantAPayer = (int) (this.getValeurHypothequee()*1.1);
				System.out.println(MessagesJeu.descCaseMontureHyp) ;
				PartieDeMonopoly.affichageMessageDelai(15, ">>> Vous pouvez lever l'hypothèque pour  "+ montantAPayer +" ୩. Que voulez vous faire ?\n");
				this.gererLaMonturePossedee(j);
			}
		}
		else {
			PartieDeMonopoly.affichageMessageDelai(15,">>> Cette monture est la propriété de " + this.getProprietaire()+ ". Vous lui devez "+ this.getLoyerActuel()+" ୩.\n");
			j.payerJoueur(this.getProprietaire(), this.getLoyerActuel());
		}
	}
	
	private void proposerAchatCase(Joueur j) throws InterruptedException {
		int cptErr = 0;
		boolean premierAff = true;
		boolean inputOk = false;
		boolean tourFini = false;
		int choixMenu=0;
		while (!inputOk && !tourFini) {
			try {
				if (!premierAff) {
					PartieDeMonopoly.afficherBarreChargement();
					PartieDeMonopoly.afficherBarreChargement();
					System.out.println("\n>>> Que voulez vous faire ensuite ?");
				}
				System.out.println(MessagesJeu.afficherMenuMontureLibre);
				String question = super.poserQuestionChoixMenus(cptErr,premierAff);
				choixMenu = PartieDeMonopoly.poserQuestionJoueurInt(">>> "+question);
				if (this.verifierNumMenuMontureLibre(choixMenu)) {	
					tourFini=this.traiterChoixMenuMontureLibre(j,choixMenu, tourFini);

				}
				premierAff=false;
			}
			catch (IllegalArgumentException e) {
				cptErr++;
			}
		}
	}
	
	
	private boolean traiterChoixMenuMontureLibre(Joueur j, int choixMenu, boolean tourFini) {
		switch(choixMenu) {
			case 1:
				j.acheterCase(this);
				tourFini=true;
				break;
			case 2:
				this.afficherTabLoyers();
				break;
			case 3:
				System.out.println(MessagesJeu.choixNeRienFaire);
				tourFini=true;
		}
		return tourFini;
	}

	private void gererLaMonturePossedee(Joueur j) throws InterruptedException {
		int cptErr = 0;
		boolean premierAff = true;
		boolean inputOk = false;
		boolean tourFini = false;
		int choixMenu=0;
		while (!inputOk && !tourFini) {
			if (!premierAff) {
				PartieDeMonopoly.afficherBarreChargement();
				PartieDeMonopoly.afficherBarreChargement();
				System.out.println("\n>>> Que voulez vous faire ensuite ?");
			}
			try {
				if(this.estEnHypotheque()) {
					System.out.println(MessagesJeu.afficherMenuPropHypo);
				}
				else {
					System.out.println(MessagesJeu.afficherMenuMontureAJoueur);
				}
				String question = super.poserQuestionChoixMenus(cptErr,premierAff);
				choixMenu = PartieDeMonopoly.poserQuestionJoueurInt(">>> "+question);
				if (this.verifierNumMenuMontureNonLibre(choixMenu)) {
					tourFini=this.traiterChoixMenuMontureAuJoueur(j,choixMenu, tourFini);
				}
				premierAff=false;
			}
			catch (IllegalArgumentException e) {
				cptErr++;
			}
		}
	}
	
	
	
	
	private boolean verifierNumMenuMontureLibre(int numChoisi) throws IllegalArgumentException {
		if (numChoisi < 1 || numChoisi > 3) {
			throw new IllegalArgumentException("Numéro choisi invalide.");
		}
		return true;
	}
	
	private boolean verifierNumMenuMontureNonLibre(int numChoisi) throws IllegalArgumentException {
		if (!this.estEnHypotheque()) {
			if (numChoisi < 1 || numChoisi > 3) {
				throw new IllegalArgumentException("Numéro choisi invalide.");
			}
		}
		else {
			if (numChoisi < 1 || numChoisi > 2) {
				throw new IllegalArgumentException("Numéro choisi invalide.");
			}
		}
		return true;
	}
	
	public boolean traiterChoixMenuMontureAuJoueur(Joueur j, int choixMenu, boolean tourFini) throws InterruptedException {
		if (this.estEnHypotheque()) {
			switch(choixMenu){
				case 1:
					super.leverLHypotheque(j);
					tourFini=true;
					break;
				case 2:
					System.out.println(MessagesJeu.choixNeRienFaire);
					tourFini=true;
			}
		}
		else {
			switch(choixMenu){
			case 1:
				super.mettreEnHypotheque(j);
				tourFini=true;
				break;
			case 2:
				this.afficherTabLoyers();
				break;
			case 3:
				System.out.println(MessagesJeu.choixNeRienFaire);
				tourFini=true;
			}
		}
		return tourFini;

	}
	
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
