package fr.ut1.rtai.monopoly;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;


public class PartieDeMonopoly {
	private Plateau plateau;
	private ArrayList<Joueur> joueurs;
	private int nbJoueurs;
	private int joueursEncoreEnLice;
	private Des des;
	private boolean arretDeLaPartie;
	public static int lancerCourant;
	
	
	public PartieDeMonopoly() throws InterruptedException {
		// Ecrire les messages destinés aux joueurs
		System.out.println("===============================================");
		System.out.println("|---****************************************--|");
		System.out.println("|------MONOPOLY - LE SEIGNEUR DES ANNEAUX-----|");
		System.out.println("|---****************************************--|");
		System.out.println("|----- CREATION DE LA PARTIE DE MONOPOLY -----|");
		System.out.println("|---****************************************--|");
		System.out.println("===============================================");
		PartieDeMonopoly.afficherBarreChargement();
		// Creer le plateau
		this.plateau = new Plateau();
		this.plateau.melangerLesPaquets();
		this.des = new Des();
		this.arretDeLaPartie=false;
		PartieDeMonopoly.lancerCourant=0;
	}

	// ---------- Getters et setters utiles --------------
	
	public Des getDes() {
		return this.des;
	}

	public int getNbJoueurs() {
		return this.nbJoueurs;
	}

	public ArrayList<Joueur> getJoueurs() {
		return this.joueurs;
	}
	public void eliminerJoueur() {
		this.joueursEncoreEnLice--;
	}
	public int getNbJoueursEncoreEnLice() {
		return this.joueursEncoreEnLice;
	}
	


	// ---------- Methodes relatives à la creation des joueurs --------------

	/**
	 *definit le nb de joueurs particpant a la partie. Utilise traiterReponseQuestionNbJoueurs() et verifierNbJoueurs 
	 */
    public void definirNbJoueurs() {
        // Ecrire les messages destinés aux joueurs
        System.out.println("\n--- Inscription des joueurs ---\n\n");
        boolean inputOk = false;
        int cptErr = 0;
        while (!inputOk) {
            try {
                String question = poserQuestionNombreDeJoueurs(cptErr);
                int nbJoueurs = poserQuestionJoueurInt(question);
                if (verifierNbJoueurs(nbJoueurs)) {
                    this.nbJoueurs = nbJoueurs;
                }
                inputOk = true;
            } catch (IllegalArgumentException e) {
                cptErr++;
            }
        }
    }

    private String poserQuestionNombreDeJoueurs(int repetitionDeLaQuestion) {
        String question;
        if (repetitionDeLaQuestion == 0) {
            question = MessagesJeu.questionNbJoueurs1;
        } else if (repetitionDeLaQuestion <= 4) {
            question = MessagesJeu.questionNbJoueursERR;
        } else {
            question = MessagesJeu.texteSiTropDerreurs;
        }
        return question;
    }
   
	

	/**
	 * @param nb
	 * @throws IllegalArgumentException genere une exception si l'utilisateur saisit un nb de joueurs invalide
	 */
	protected boolean verifierNbJoueurs(int nb) throws IllegalArgumentException {
		if (nb < 2 || nb > 6) {
			throw new IllegalArgumentException("Format de reponse invalide");
		}
		return true;
	}

	/**
	 * Demande aux joueurs leurs noms d'usage et les genere en consequence
	 */
	public void creerLesJoueurs() {
		// Pour chaque joueur, lui demander son nom
		String[] nomsJoueurs = new String[this.nbJoueurs];
		for (int i = 0; i < this.nbJoueurs; i++) {
			String nomJ = PartieDeMonopoly.poserQuestionJoueurChaine(">>> Quel sera le nom du joueur " + (i + 1) + " ? :");
			String validation = PartieDeMonopoly.poserQuestionJoueurChaine(">>> " + nomJ + ", c'est bien ça ? (oui/non) :");
			while (!validation.toUpperCase().equals("OUI")) {
				if (!validation.toUpperCase().equals("NON")) {
					validation = PartieDeMonopoly.poserQuestionJoueurChaine("Veuillez répondre par oui ou par non. :");
				} else {
					nomJ = PartieDeMonopoly.poserQuestionJoueurChaine(
							">>> OK, quel  nom préférez vous pour le joueur " + (i + 1) + " ? :");
					validation = PartieDeMonopoly.poserQuestionJoueurChaine(nomJ + ", c'est bien ça ? (oui/non) :");
				}
			}
			nomsJoueurs[i] = nomJ;
			this.genererJoueurs(this.nbJoueurs, nomsJoueurs);
			this.joueursEncoreEnLice=this.joueurs.size();
			//donner le plateau et la partie courant.e aux joueurs
			for (Joueur j : this.joueurs) {
				j.setPlateau(this.plateau);
				j.setPartie(this);
			}
		}
	}

	/**
	 * @param nbJoueurs
	 * @param nomsJoueurs Cree la liste des joueurs participant a la partie. Appelee
	 *                    par la methode creerLesJoueurs.
	 */
	protected void genererJoueurs(int nbJoueurs, String[] nomsJoueurs) {
		this.joueurs = new ArrayList<Joueur>();
		for (int i = 0; i < nomsJoueurs.length; i++) {
			this.joueurs.add(new Joueur(nomsJoueurs[i]));
		}
	}


	
	// ---------- Methodes relatives a la generation et distribution des pions --------------

	/**
	 * Genere les pions et les attribue aux joueurs
	 * 
	 * @throws InterruptedException
	 */
	public void genererPions() throws InterruptedException {

		// Ecrire les messages destinés aux joueurs
		PartieDeMonopoly.afficherBarreChargement();

		System.out.println("\n--- CHOIX DES PIONS ---\n\n");

		// Liste dynamique dans laquelle les joueurs vont choisir leurs pions a tour de
		// role
		Pion p1 = new Pion(EPion.Gandalf);
		Pion p2 = new Pion(EPion.Frodon);
		Pion p3 = new Pion(EPion.Aragorn);
		Pion p4 = new Pion(EPion.Legolas);
		Pion p5 = new Pion(EPion.Gimli);
		Pion p6 = new Pion(EPion.Galadriel);

		ArrayList<Pion> pionsDispo = new ArrayList<Pion>();
		pionsDispo.add(p1);
		pionsDispo.add(p2);
		pionsDispo.add(p3);
		pionsDispo.add(p4);
		pionsDispo.add(p5);
		pionsDispo.add(p6);

		for (Joueur j : this.joueurs) {
			Thread.sleep(1000);
			
			this.afficherLesPions(pionsDispo);
			int cptErr = 0;
			boolean inputOk = false;
			//Demander la saisie d'un nombre
			while(!inputOk) {
				try {
	                String question = poserQuestionChoixPion(cptErr);
	                int choixPion = PartieDeMonopoly.poserQuestionJoueurInt(">>> "+ j.getNom()+", "+question)-1;
	                if (this.verifierNumPionOK(choixPion, pionsDispo)) {
	                	System.out.println("OK ! \n");
						Thread.sleep(1000);
						j.setPion(pionsDispo.get(choixPion));
						j.getPion().setNumeroCase(0);
						j.getPion().setJoueur(j);
						pionsDispo.remove(choixPion);
	                }		
	                inputOk = true;
				} catch (Exception e) {
					cptErr ++;
				}
			}

		}

		Thread.sleep(1000);
		System.out.println("... Creation des joueurs et de leurs pions ...");
		PartieDeMonopoly.afficherBarreChargement();
		this.afficherJoueursEtPions();
	}
	
   

	/**
	 * @param numeroPionChoisi
	 * @param pionsDispo
	 * @return
	 * @throws IllegalArgumentException
	 * Verifie que l'utilisateur a saisi un numero de pion qui correspond bien a un pion disponible
	 */
	private boolean verifierNumPionOK(int numeroPionChoisi, ArrayList<Pion> pionsDispo) throws IllegalArgumentException {
		if (numeroPionChoisi < 0 || numeroPionChoisi >= pionsDispo.size()) {
			throw new IllegalArgumentException("Numéro choisi invalide.");
		}
		return true;
	}
	
	
	// --------------  Méthodes relatives aux tours de jeu ----------------------
	
		/**
		 * Lance une partie de Monopoly, effectue toutes les actions nécessaires à celle ci
		 * @throws InterruptedException
		 */
		public void jouerAuMonopoly() throws InterruptedException {
			this.definirNbJoueurs();
			this.creerLesJoueurs();
			this.genererPions();	
	        // vérifier qu'il y a plus de 2 joueurs tjs en lice
			while (this.joueursEncoreEnLice>1 && !this.arretDeLaPartie){
				this.tourDeJeu();
				
			}
			System.out.println("La partie est terminée !");
			this.trouverLeGagnant();

		}
	
		
		/**
		 * Lance un tour de jeu dans lequel tous les joueurs jouent à tour de rôle
		 * @throws InterruptedException
		 */
		public void tourDeJeu() throws InterruptedException{
			System.out.println("\n\n============= NOUVEAU TOUR DE JEU =============\n");
			//afficher les joueurs 
			PartieDeMonopoly.afficherBarreChargement();
			Thread.sleep(1000);
			for (Joueur j:this.joueurs) {
				if (!j.estEnFaillite()) {
					j.afficherJoueurDebutTourDeJeu();
				}
				else {
					System.out.println("※---※---※"+ j.getNom().toUpperCase() + " - EN FAILLITE ※---※---※\n");
				}

			}
			
			Thread.sleep(1000);
			System.out.println();
			boolean b = this.demanderContinuerPartie();
		    if (b){
		        for (Joueur j : this.joueurs){
		        	//Si le joueur en lice est le seul restant, le tour est sauté
		        	if (this.joueursEncoreEnLice!=1) {
		        		 //Seuls les joueurs encore en lice jouent
			            if(!j.estEnFaillite()){
			                //Reinitialiser les compteurs de doubles
			                j.setNbDoubles(0);
			                j.setAFaitUnDouble(false);
			                this.jouerUnTour(j);
			                //Si le joueur fait un double, il rejoue jusqu'à 3 fois, sauf s'il est emprisonné
			                while(j.aFaitUnDouble() && j.getNbDoubles()<=3 && !j.estEnPrison()){
			                	
			                    this.jouerUnTour(j);
			                }
			            }
		        	}
		           
		        
		            
		        }
				PartieDeMonopoly.poserQuestionJoueurChaine("\nLe tour est terminé ! Appuyez sur entrée pour continuer ...");
		    }
		    else {
		    	this.arretDeLaPartie=true;
		    }
	      

		}
		/**
		 * verifie en debut de tour de jeu si les joueurs veulent continuer a jouer
		 * @return
		 */
		public boolean demanderContinuerPartie(){
		    //recuperer oui ou non 
		    String rep = PartieDeMonopoly.poserQuestionReponseOuiOuNon(MessagesJeu.menuDebutTour);
		    return (rep.toUpperCase().equals("OUI")); 
		}
		
		
		// Tour du joueur :
		
		/**
		 *Demande au début du tour du joueur s'il veut continuer la partie ou non
		 * @param j
		 * @return
		 */
		public boolean demanderChoixMenuDebutTourJ(Joueur j){
		    //Demander au joueur ce qu'il veut faire
		    boolean inputOk=false;
		    boolean continuer=false;
		    int cptErr=0;
		    while (!inputOk)
		    try{
		        //Afficher le message selon le cpt err
		    	//Appel à la méthode de vérification des saisies de type entier 
		        int choix = PartieDeMonopoly.poserQuestionJoueurInt(this.poserQuestiondebutTourJoueur(cptErr));
		        //Appel à la méthode de vérification des saisies spécifiques à ce menu
		        this.verifierReponseChoixMenuDT(choix);// LANCE L'EXCEPTION SI LA REPONSE N EST PAS CORRECTE 
		        									   // -- Suite du bloc ignoré
		        
		       	//Si OK, traiter la réponse
		        if (choix==2) {
		        	continuer = false;
		        }
		        else if (choix==1) {
		        	continuer=true;
		        }
		        inputOk = true;
		    }catch(IllegalArgumentException e){
		    	//Incrémenter le compteur d'erreurs pour modifier les affichages
		        cptErr++;
		    }
		    return continuer;
		}


		/**
		 * Vérifie le choix effectué par le joueur
		 * @param choix
		 * @throws IllegalArgumentException
		 */
		private void verifierReponseChoixMenuDT(int choix) throws IllegalArgumentException{
			if(choix <1 || choix >2) {
				throw new IllegalArgumentException("Choix du menu du tour du joueur invalide!");
			}
			
		}


	    /**
	     * @param repetitionDeLaQuestion
	     * @return
	     * genere les questions pour le choix du debut de tour du joueur
	     */
	    private String poserQuestiondebutTourJoueur(int repetitionDeLaQuestion) {
	        String question;
	        if (repetitionDeLaQuestion == 0) {
	            question = MessagesJeu.menuJoueurDebutTour;
	        } else if (repetitionDeLaQuestion <= 4) {
	            question = MessagesJeu.questionMenuErr;
	        } else {
	            question = MessagesJeu.texteSiTropDerreurs;
	        }
	        return question;
	    }
		
	    /**
	     * Lance le tour de jeu d'un joueur. Lui demande s'il veut arreter
	     * @param j
	     * @throws InterruptedException
	     */
	    public void jouerUnTour(Joueur j) throws InterruptedException{
	        boolean continuer ;
	        j.afficherJoueurDebutTourDeJeuJoueur();
	        Thread.sleep(1000);
	        continuer = this.demanderChoixMenuDebutTourJ(j);
	        //Demander au joueur s'il veut continuer à jouer
	        if(continuer){
	        	
	        //Si c'est le cas, Jouer un tour 

	        	//verifier si le joueur est en prison
	        	if (j.estEnPrison()){
		            j.sejournerEnPrison();
		        }
		        else{
		            //Verifier le compteur de doubles du joueur
		            if (j.getNbDoubles()<3){
		                //lancer les dés et jouer
		                this.lancerDesJoueur(j);
	
		                //Verifier si le joueur a fait un double
		                if(this.des.estUnDouble()){
		                    //Incrémenter le compteur de doubles du joueur
		                    j.setNbDoubles(j.getNbDoubles()+1);
		                    j.setAFaitUnDouble(true);
		                    System.out.println(MessagesJeu.lancerDeDesDoubleCasNom);
		                }
		                else {
		                	//reinitialiser les doubles
		                	j.setNbDoubles(0);
		                	j.setAFaitUnDouble(false);
		                }
		                
		                //Faire avancer le pion du joueur et declencher l'action de la case d'arrivee
		                j.getPion().avancerPion(this.des.getLancerTotal());
		                int positionPion = j.getPion().getNumCase()+1;
		                this.plateau.getCaseNumero(positionPion).actionCase(j); 
	            }
	            else{
	                //Si le joueur a fait 3 doubles de suite, il est amené en prison
	                System.out.println(MessagesJeu.lancerDeDes3fois);
	                j.estMisEnPrison();
	                //Reinitialiser les compteurs de doubles
	                j.setNbDoubles(0);
	                j.setAFaitUnDouble(false);
	            }
	        }
	        	//A la fin du tour, verifier le solde
	        	if (j.getSolde()<=0) {
	        		j.estMisEnFaillite();
	    			PartieDeMonopoly.poserQuestionJoueurChaine("\nVotre pouvoir est tombé à 0! Vous êtes mis en faillite.");

	        	}
	        }
	        else{
	            //Sinon éliminer le joueur
	            this.eliminerJoueur(j);
	        }
			PartieDeMonopoly.poserQuestionJoueurChaine("\nAppuyez sur entrée pour continuer ...");

	       
	    }
		
		/**
		 * procède à l'élimination d'un joueur
		 * @param j
		 */
		public void eliminerJoueur(Joueur j){
		    j.estMisEnFaillite();
		    PartieDeMonopoly.affichageMessageDelai(15, j.getNom()+" abandonne la partie ! Toutes ses contructions sont détruites et ses biens sont de nouveau à l'achat.");
		    j.rendreTousLesBiens();
        	j.setNbDoubles(0);
        	j.setAFaitUnDouble(false);
		}
		
	// ----------Methodes relatives à la fin de partie ---------------
		
	public void trouverLeGagnant() {
		//Creer un tableau pour chaque joueur non éliminé
		ArrayList<Joueur> joueursRestants = new ArrayList<Joueur>();
		for (Joueur j : this.joueurs) {
			// calculer pour chaque joueur le montant de sa fortune
			j.calculerTotalFinDePartie();
			if (!j.estEnFaillite()) {
				//Ne conserver que les joueurs non éliminés pour le calcul du max
				joueursRestants.add(j);
			}
		}
		//Trouver le vainqueur en cherchant le max
		
		//Par defaut, positionner le gagnant au premier
		Joueur gagnant = joueursRestants.get(0);
		for (int i = 1; i<joueursRestants.size();i++ ) {
			if (joueursRestants.get(i).getMontantTotalFinDePartie()> gagnant.getMontantTotalFinDePartie()) {
				//Changer le vainqueur
				gagnant = joueursRestants.get(i);
			}
		}
		
		System.out.println("※---※---※---※---※---※ CLASSEMENT FINAL ※---※---※---※---※---※\n");
		//Affichage des joueurs
		for (Joueur j: this.joueurs){
			if(!j.estEnFaillite()) {
				PartieDeMonopoly.affichageMessageDelai(15,"\n - "+j.getNom() +" : "+ j.getMontantTotalFinDePartie() + " ୩");
			}
			else {
				PartieDeMonopoly.affichageMessageDelai(15,"\n - "+j.getNom() +" : EN FAILLITE ");		
			}
		}
		
		//Retourner le gagnant
		System.out.println("\n================================================");
		System.out.println("|**********************************************|");
		System.out.println("\n                    "+gagnant.getNom().toUpperCase()+ " A GAGNE !\n");
		System.out.println("|**********************************************|");
		System.out.println("================================================");
	}
	
	


	// -------- Méthodes utilitaires ---------------------------------
		
		
	public void lancerDesJoueur(Joueur j) throws InterruptedException {
		this.des.lancerLesDes();
		affichageMessageDelai(15,">>> " +j.getNom()+ " lance les dés . . .");
		this.des.afficherLeLancher();
		this.afficherLancerDes();
        //Changer le lancer courant
        PartieDeMonopoly.lancerCourant = this.des.getLancerTotal();

	}
	
	public void afficherLancerDes() {
		System.out.println(this.des);
	}


    /**
     * @param repetitionDeLaQuestion
     * @return
     * genere les questions pour le choix des pions
     */
    private String poserQuestionChoixPion(int repetitionDeLaQuestion) {
        String question;
        if (repetitionDeLaQuestion == 0) {
            question = MessagesJeu.questionChoixPion1;
        } else if (repetitionDeLaQuestion <= 4) {
            question = MessagesJeu.questionChoixPionERR;
        } else {
            question = MessagesJeu.texteSiTropDerreurs;
        }
        return question;
    }
	
	// ---------- Methodes de dialogue avec l'utilisateur -------------
		
	/**
	 * @param question
	 * @return recupere la reponse pour une question donnee sous forme de chaine
	 */
	public static String poserQuestionJoueurChaine(String question) {
		String reponse = "";
		System.out.println(question + "\n");
		@SuppressWarnings("resource") //Non fonctionnel si fermé...
		Scanner scanner = new Scanner(System.in);
		reponse = scanner.nextLine();
		return reponse;
	}

	/**
	 * @param question
	 * @return recupere la reponse pour une question donnee sous forme d'entier
	 */
	  public static int poserQuestionJoueurInt(String question) {
	        System.out.println(question + "\n");
	        @SuppressWarnings("resource")//Non fonctionnel si scanner fermé
			Scanner scannerInt = new Scanner(System.in);
	        int reponse = -1;
	        try {
	            reponse = scannerInt.nextInt();
	        } catch (InputMismatchException e) {
	            throw new IllegalArgumentException("Merci de saisir un nombre !");
	        }
	        return reponse;
	    }
	  
	  
	
	  
	  /**
	   * Pose une question et attend une reponse de la forme "oui" ou "non" (majuscules autorisées)
	 * @param question
	 * @return
	 */
	public static String poserQuestionReponseOuiOuNon(String question) {
		  Scanner scanner = new Scanner(System.in);
		  String rep;
		  System.out.println(question);
		  rep = scanner.nextLine();

		  int compteurReponsesFausses = 0;
		  while(!rep.toUpperCase().equals("OUI")&& !rep.toUpperCase().equals("NON")){
			  compteurReponsesFausses++;
			  if (compteurReponsesFausses > 4) {
				  System.out.println(MessagesJeu.texteSiTropDerreurs);
				  rep = scanner.nextLine();
			  }
			  else {
				  System.out.println("Veuillez répondre par oui ou par non. :");
				  rep = scanner.nextLine();
			  }

		  }

		  return rep;
	  }
	  
	 
	// ---------- Methodes d'affichage -------------
	
	/**
	 * @throws InterruptedException
	 * Affichage convivial d'un chargement: Source : Stack Overflow
	 */
	public static void afficherBarreChargement() throws InterruptedException {
		PartieDeMonopoly.affichageMessageDelai(100, ". . . . .");
	}
	
	public static void affichageMessageDelai(int delai, String s) {
	    try {
	        for (char c : s.toCharArray()) {
	            System.out.print(c); 
	            Thread.sleep(delai);  
	        }
	    } catch (InterruptedException e) {
	    }
	    System.out.println(); 
	}
	
	/**
	 *affiche les joueurs et leur pion associe avec leur position
	 * @throws InterruptedException 
	 */
	private void afficherJoueursEtPions() throws InterruptedException {
		// Ecrire les messages destinés aux joueurs
		System.out.println("--- JOUEURS : ---\n");
		for (Joueur j : this.joueurs) {
			System.out.println("- " + j.toString()+ " - Pion : "+j.getPion().getTypePion().afficherPion() +"\n"); 
		}
		Thread.sleep(1000);
	}
	
	/**
	 * @param pionsDispos
	 * Affiche les pions selon leur disponibilite
	 */
	private void afficherLesPions(ArrayList<Pion> pionsDispos) {
		System.out.println(">>> Pions disponibles :\n");
		for (int i = 0; i < pionsDispos.size(); i++) {
			System.out.println((i + 1) + " - " + pionsDispos.get(i).getTypePion().afficherPion());
		}
		System.out.println("\n\n");
	}

}
