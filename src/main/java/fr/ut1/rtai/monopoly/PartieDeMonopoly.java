package fr.ut1.rtai.monopoly;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PartieDeMonopoly {
	private Plateau p;
	private static ArrayList<Joueur> joueurs;
	private int nbJoueurs;
	private Des des;
	
	
	public PartieDeMonopoly() throws InterruptedException {
		// Ecrire les messages destinés aux joueurs
		System.out.println("\n--- CREATION DE LA PARTIE DE MONOPOLY ---\n\n");
		PartieDeMonopoly.afficherBarreChargement();
		// Creer le plateau
		this.p = new Plateau();
		this.des = new Des();
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

	// ---------- Methodes relatives à la creation des joueurs --------------

	/**
	 *definit le nb de joueurs particpant a la partie. Utilise traiterReponseQuestionNbJoueurs() et verifierNbJoueurs 
	 * @throws InterruptedException 
	 */
    public void definirNbJoueurs() {
        // Ecrire les messages destinés aux joueurs
        System.out.println("--- Inscription des joueurs ---\n\n");
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
			//donner le plateau et la partie courant.e aux joueurs
			for (Joueur j : this.joueurs) {
				j.setPlateau(this.p);
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
		this.afficherBarreChargement();

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
			
			while(!inputOk) {
				try {
	                String question = poserQuestionChoixPion(cptErr);
	                int choixPion = PartieDeMonopoly.poserQuestionJoueurInt(">>> "+ j.getNom()+", "+question)-1;
	                if (this.verifierNumPionOK(choixPion, pionsDispo)) {
	                	System.out.println("OK ! \n");
						Thread.sleep(1000);
						j.setPion(pionsDispo.get(choixPion));
						j.getPion().setNumeroCase(0);
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
		this.afficherBarreChargement();
		this.afficherJoueursEtPions();
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
	

	// -------- Méthodes utilitaires ---------------------------------
	public void lancerDesJoueur(Joueur j) throws InterruptedException {
		this.des.lancerLesDes();
		affichageMessageDelai(15,">>> " +j.getNom()+ " lance les dés . . .");
		this.des.afficherLeLancher();
		this.afficherLancerDes();



	}
	
	public void afficherLancerDes() {
		System.out.println(this.des);
	}


	
	// ---------- Methodes de dialogue avec l'utilisateur -------------
		
	/**
	 * @param question
	 * @return recupere la reponse pour une question donnee sous forme de chaine
	 */
	public static String poserQuestionJoueurChaine(String question) {
		String reponse = "";
		System.out.println(question + "\n");
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
	        Scanner scannerInt = new Scanner(System.in);
	        int reponse = -1;
	        try {
	            reponse = scannerInt.nextInt();
	        } catch (InputMismatchException e) {
	            throw new IllegalArgumentException("Merci de saisir un nombre !");
	        }
	        // scanner.close();
	        return reponse;
	    }
	  
	  
	
	  
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
	 * Affichage convivial d'un chargement
	 */
	public static void afficherBarreChargement() throws InterruptedException {
		PartieDeMonopoly.affichageMessageDelai(100, ". . . . .");
	}
	
	public static void affichageMessageDelai(int delai, String s) {
	    try {
	        for (char c : s.toCharArray()) {
	            System.out.print(c);  // print characters without newline
	            Thread.sleep(delai);  // wait for some milli seconds
	        }
	    } catch (InterruptedException e) {
	    }
	    System.out.println(); // finally, add a line break
	}
	
	/**
	 *affiche les joueurs et leur pion associe avec leur position
	 */
	private void afficherJoueursEtPions() {
		// Ecrire les messages destinés aux joueurs
		System.out.println("--- LISTE DES JOUEURS ---\n\n");
		for (Joueur j : this.joueurs) {
			System.out.println("- " + j.toString()+ this.p.getCaseNumero(j.getPion().getNumCase()+1));
		}
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
