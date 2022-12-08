package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public abstract class CasePropriete extends Case {
	
	private int coutAchat;
	private int valeurHypotheque;
	private Joueur proprietaire;
	private int loyerActuel;
	private boolean estHypothequee;

	
    public CasePropriete(String nom, int coutAchat, int valeurHypotheque) {
        super(nom);
        this.coutAchat=coutAchat;
        this.valeurHypotheque=valeurHypotheque;
        this.estHypothequee=false;
    }
    
    public void actionCase(Joueur j) throws InterruptedException {
    	int position = this.getNumCase()+1;
		PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive sur la case n°"+ position+ ": \""+this.getNomCase()+"\"");

    	//Dans tous les cas, afficher la case
    			this.afficherCase();
    			//Si la case n'est a personne, afficher le message descriptif
    			if(this.getProprietaire()==null) {
    				if (this instanceof Monture) {
        				//declencher la procedure d'achat
        				PartieDeMonopoly.affichageMessageDelai(15, MessagesJeu.questionMontureAPersonne+ this.getCoutAchat()+ " ୩ ?");	
    				}
    				else if (this instanceof BatonDeMagicien) {
        				//declencher la procedure d'achat
        				PartieDeMonopoly.affichageMessageDelai(15, MessagesJeu.questionBatonAPersonne+ this.getCoutAchat()+ " ୩ ?");	
    				}
    				else if (this instanceof Territoire) {
        				//declencher la procedure d'achat
        				PartieDeMonopoly.affichageMessageDelai(15, MessagesJeu.questionTerrainAPersonne+ this.getCoutAchat()+ " ୩ ?");	
    				}
    				this.proposerAchatCase(j);

    			}
    			//Si le joueur tombe sur une de ses propriétés
    			else if (this.getProprietaire()==j) {
    		    	//Verifier les possessions du proprio et adapter le loyer en consequence
    		    	
    				if (!this.estEnHypotheque()) {
    					if (this instanceof Monture) {
        					PartieDeMonopoly.affichageMessageDelai(15, MessagesJeu.caseMonturePropOK);
    					}
    					else if (this instanceof BatonDeMagicien) {
        					PartieDeMonopoly.affichageMessageDelai(15, MessagesJeu.caseBatonPropOK);
    					}
        				else if (this instanceof Territoire) {
        					PartieDeMonopoly.affichageMessageDelai(15, MessagesJeu.caseTerritoirePropOK);
        				}
    					this.gererLaPropriete(j);
    				}
    				else {
    					int montantAPayer = (int) (this.getValeurHypothequee()*1.1);
    					if (this instanceof Monture) {
    						System.out.println(MessagesJeu.descCaseMontureHyp) ;
    					}
    					else if (this instanceof BatonDeMagicien) {
    						System.out.println(MessagesJeu.descCaseBatHyp) ;
    					}
        				else if (this instanceof Territoire) {
    						System.out.println(MessagesJeu.descCaseTerrHyp) ;
        				}
    					PartieDeMonopoly.affichageMessageDelai(15, ">>> Vous pouvez lever l'hypothèque pour  "+ montantAPayer +" ୩. Que voulez vous faire ?\n");
    					this.gererLaPropriete(j);
    				}
    			}
    			//Si la case n'est pas au joueur
    			else {
    		    	//Verifier les possessions du proprio et adapter le loyer en consequence
  
    				if (!this.estEnHypotheque()) {
    					if (this instanceof Monture) {
        					PartieDeMonopoly.affichageMessageDelai(15,">>> Cette monture est la propriété de " + this.getProprietaire()+ ". Vous lui devez "+ this.getLoyerActuel()+" ୩.\n");
        					j.payerJoueur(this.getProprietaire(), this.getLoyerActuel());
    					}
    					else if (this instanceof BatonDeMagicien) {
    						int montantAPayer=0;
        					//Compter le nombre de bâtons possédés par le proprio et adapter le montant à payer
        					if (this.getProprietaire().estPropdeNbBatons()==1) {
        						montantAPayer= PartieDeMonopoly.lancerCourant*4;	
            					PartieDeMonopoly.affichageMessageDelai(15,">>> Ce bâton est la propriété de " + this.getProprietaire()+ ". Vous lui devez un loyer de 4x votre lancer de dés.\n");
            					
        					}
        					if (this.getProprietaire().estPropdeNbBatons()==2) {
            					montantAPayer= PartieDeMonopoly.lancerCourant*10;
            					PartieDeMonopoly.affichageMessageDelai(15,">>> Ce bâton est la propriété de " + this.getProprietaire()+ ". Vous lui devez un loyer de 10x votre lancer de dés.\n");

        					}
        					j.payerJoueur(this.getProprietaire(), montantAPayer);

        					
    					}
        				else if (this instanceof Territoire) {
        					PartieDeMonopoly.affichageMessageDelai(15,">>> Ce territoire est la propriété de " + this.getProprietaire()+ ". Vous lui devez "+ this.getLoyerActuel()+" ୩.\n");
        					j.payerJoueur(this.getProprietaire(), this.getLoyerActuel());

        				}
    				}
    				else {
    					if (this instanceof Monture) {
        					PartieDeMonopoly.affichageMessageDelai(15,">>> Cette monture est la propriété de " + this.getProprietaire()+ ", mais est hypothéquée. Vous ne perdez pas de pouvoir.\n");		
    					}
    					else if (this instanceof BatonDeMagicien) {
        					PartieDeMonopoly.affichageMessageDelai(15,">>> Ce bâton est la propriété de " + this.getProprietaire()+ ", mais est hypothéqué. Vous ne perdez pas de pouvoir.\n");		
    					}
        				else if (this instanceof Territoire) {
        					PartieDeMonopoly.affichageMessageDelai(15,">>> Ce territoire est la propriété de " + this.getProprietaire()+ ", mais est hypothéqué. Vous ne perdez pas de pouvoir.\n");		
        				}
    				}
    				
    			}
    }
    
    
    // -------- GETTERS ET SETTERS UTILES --------



	public boolean estEnHypotheque() {
    	return this.estHypothequee;
    }
    
    public void setEstEnHypotheque(boolean b) {
    	this.estHypothequee=b;
    }
  
    public void setProprietaire(Joueur j) {
    	this.proprietaire = j;
    }
        
    public void setLoyerActuel(int loyer) {
    	this.loyerActuel=loyer;
    }
    
    public int getLoyerActuel(){
    	return this.loyerActuel;
    }
    
    public int getCoutAchat() {
    	return this.coutAchat;
    }
    
    public int getValeurHypothequee() {
    	return this.valeurHypotheque;
    }
    
    public Joueur getProprietaire() {
    	return this.proprietaire;
    }


    
    // --------------- Methodes utilitaires des cases propriété --------
    

    
    /**
     * Propose au joueur d'acheter une case. verifie le format de la réponse à l'aide de la methode verifierNumMenuPropLibre
     * Traite le résultat à l'aide de la méthode traiterChoixMenuPropLibre
     * @param j
     * @throws InterruptedException
     */
    public void proposerAchatCase(Joueur j) throws InterruptedException {
		int cptErr = 0;
		boolean premierAff = true;
		boolean inputOk = false;
		boolean tourFini = false;
		int choixMenu=0;
		while (!inputOk && !tourFini) {
			try {
				if (!premierAff) {
					if (cptErr==0) {
						PartieDeMonopoly.afficherBarreChargement();
					}
					System.out.println("\n>>> Que voulez vous faire ensuite ?");
				}
				if (this instanceof Monture) {
					System.out.println(MessagesJeu.afficherMenuMontureLibre);
				}
				else if (this instanceof Territoire) {
					System.out.println(MessagesJeu.afficherMenuTerritoireLibre);
				}
				else {
					System.out.println(MessagesJeu.afficherMenuBatonLibre);		
				}
				String question = this.poserQuestionChoixMenus(cptErr,premierAff);
				choixMenu = PartieDeMonopoly.poserQuestionJoueurInt(">>> "+question);
				if (this.verifierNumMenuPropLibre(choixMenu)) {	
					tourFini=this.traiterChoixMenuPropLibre(j,choixMenu, tourFini);
					premierAff=false;
					cptErr =0;
				}
				
			}
			catch (IllegalArgumentException e) {
				cptErr++;
			}
		}
	}
    
    
	/**
	 * declenche la procédure d'achat chez le joueur s'il a selectionné la premiere option
	 * affiche la table des loyers de la propriété s'il selectionne la seconde option
	 * Ne fait rien si le joueur selectionne la troisieme
	 * @param j
	 * @param choixMenu
	 * @param tourFini
	 * @return
	 * @throws InterruptedException
	 */
	private boolean traiterChoixMenuPropLibre(Joueur j, int choixMenu, boolean tourFini) throws InterruptedException {
		switch(choixMenu) {
			case 1:
				j.acheterCase(this);
				tourFini=true;
				Thread.sleep(1500);

				break;
			case 2:
				this.afficherTabLoyers();
				Thread.sleep(2000);

				break;
			case 3:
				System.out.println(MessagesJeu.choixNeRienFaire);
				tourFini=true;
				Thread.sleep(1500);

		}
		return tourFini;
	}
    
    private boolean verifierNumMenuPropLibre(int numChoisi) throws IllegalArgumentException {
		if (numChoisi < 1 || numChoisi > 3) {
			throw new IllegalArgumentException("Numéro choisi invalide.");
		}
		return true;
	}
    
    public void gererLaPropriete(Joueur j) throws InterruptedException {
		int cptErr = 0;
		boolean premierAff = true;
		boolean inputOk = false;
		boolean tourFini = false;
		int choixMenu=0;
		while (!inputOk && !tourFini) {
			if (!premierAff) {
				Thread.sleep(3000);
				if(cptErr==0) {
					PartieDeMonopoly.afficherBarreChargement();			
				}
				System.out.println("\n>>> Que voulez vous faire ensuite ?");
			}
			try {
				if(this.estEnHypotheque()) {
					System.out.println(MessagesJeu.afficherMenuPropHypo);
				}
				else {
					this.afficherMenuPropAJoueur();
				}
				String question = this.poserQuestionChoixMenus(cptErr,premierAff);
				choixMenu = PartieDeMonopoly.poserQuestionJoueurInt(">>> "+question);
				if (this.verifierNumMenuPropNonLibre(choixMenu)) {
					tourFini=this.traiterChoixMenuPropAuJoueur(j,choixMenu, tourFini);
				}
				premierAff=false;
				cptErr =0;
			}
			catch (IllegalArgumentException e) {
				cptErr++;
			}
		}
	}
    
    public abstract void afficherMenuPropAJoueur();
    
	
    
	
	public boolean verifierNumMenuPropNonLibre(int numChoisi) throws IllegalArgumentException {
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
	
	public boolean traiterChoixMenuPropAuJoueur(Joueur j, int choixMenu, boolean tourFini) throws InterruptedException {
		if (this.estEnHypotheque()) {
			switch(choixMenu){
				case 1:
					this.leverLHypotheque(j);
					tourFini=true;
					Thread.sleep(1500);
					break;
				case 2:
					System.out.println(MessagesJeu.choixNeRienFaire);
					tourFini=true;
			}
		}
		else {
			switch(choixMenu){
			case 1:
				this.mettreEnHypotheque(j);
				Thread.sleep(1500);
				tourFini=true;
				break;
			case 2:
				this.afficherTabLoyers();
				Thread.sleep(2000);
				break;
			case 3:
				System.out.println(MessagesJeu.choixNeRienFaire);
				tourFini=true;
			}
		}
		return tourFini;

	}
    
    
    
    
    //TODO : faire mieux ...
	public void declencherPaiement(Joueur j) {
		// --> pour l'instant : on considere que si le joueur n'a plus assez d'argent pour payer, il est en faillite 
		if (j.getSolde()< this.getLoyerActuel()) {
			System.out.println("Vous n'avez pas assez pour payer !");
			j.estMisEnFaillite();
		}
		else {
			j.payerJoueur(this.proprietaire, this.loyerActuel);
			System.out.println("Vous payez un loyer de "+ this.loyerActuel + " à "+ this.getProprietaire()+".");
		}
	}
	
	protected void mettreEnHypotheque(Joueur j) {
		System.out.println("Vous mettez "+this.getNomCase()+ " en hypothèque pour "+ this.getValeurHypothequee()+" ୩.\n");
		this.estHypothequee=true;
		j.gagnerduPouvoir(this.valeurHypotheque);
	}
	
    protected String poserQuestionChoixMenus(int repetitionDeLaQuestion, boolean premierAff) {
        String question;
        if (repetitionDeLaQuestion == 0) {
            question = MessagesJeu.questionMenu1;
        } else if (repetitionDeLaQuestion <= 4) {
            question = MessagesJeu.questionMenuErr;
        } else {
            question = MessagesJeu.texteSiTropDerreurs;
        }
        return question;
    }
    
    
    // --------------- Methodes d'affichage des cases propriété ---------
    public abstract void afficherTabLoyers();


	public void leverLHypotheque(Joueur j) {
		double montantAPayer = this.valeurHypotheque*1.1;
		System.out.println("Vous levez l'hypothèque sur "+ this.getNomCase()+ " pour "+ (int)montantAPayer+" ୩.\n");
		j.perdreDuPouvoir(montantAPayer);
		this.estHypothequee=false;
	} 
    

}
