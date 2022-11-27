package fr.ut1.rtai.monopoly;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PartieDeMonopoly {
	private Plateau p;
	private ArrayList<Joueur> joueurs;
	private int nbJoueurs;

	public PartieDeMonopoly() throws InterruptedException {
		// Ecrire les messages destinés aux joueurs
		System.out.println("\n--- CREATION DE LA PARTIE DE MONOPOLY ---\n\n");
		this.afficherBarreChargement();
		// Creer le plateau
		this.p = new Plateau();
	}

	// ---------- Getters et setters utiles --------------

	public int getNbJoueurs() {
		return this.nbJoueurs;
	}

	public ArrayList<Joueur> getJoueurs() {
		return this.joueurs;
	}

	// ---------- Fonctions relatives à la creation des joueurs --------------

	/**
	 *definit le nb de joueurs particpant a la partie. Utilise traiterReponseQuestionNbJoueurs() et verifierNbJoueurs 
	 * @throws InterruptedException 
	 */
	public void definirNbJoueurs() throws InterruptedException {
		// Ecrire les messages destinés aux joueurs
		System.out.println("\n--- INSCRIPTION DES JOUEURS ---\n\n");
		this.afficherBarreChargement();
		boolean inputOk = false;
		int cptErr = 0;
		String questionCasNominal = "Combien de joueurs participeront à la partie ? (Saisissez votre réponse , 2 à 6 joueurs autorisés) :";
		String questionSiErreur = "Le nombre de joueurs doit être un chiffre compris entre 2 et 6. Veuillez le saisir à nouveau : ";
		String texteSiTropDerreurs = "Bon allez...Un petit effort...";
		while (!inputOk) {	
			try {
				
				int nb = this.traiterReponseQuestionChiffreAttendu(questionCasNominal,questionSiErreur, texteSiTropDerreurs, cptErr);
				this.verifierNbJoueurs(nb);	
				this.nbJoueurs= nb;
				inputOk=true;
			} catch (IllegalArgumentException e1){
				cptErr++;
				inputOk=false;
			} catch(InputMismatchException e2) {
				cptErr++;
				inputOk=false;
				
			}
		}
	}
	
	/**
	 * @param questionCasNominal
	 * @param questionSiErreur
	 * @param msgTropdErreurs
	 * @param cptErr
	 * @return
	 * Methode generique pour recuperer la saisie de l'utilisateur sous forme d'entier
	 */
	private int traiterReponseQuestionChiffreAttendu(String questionCasNominal, String questionSiErreur, String msgTropdErreurs, int cptErr) {
		int nb=0;
		//Si l'utilisateur s'est trompe trop de fois, afficher un message
		if (cptErr==0) {
			nb=this.poserQuestionJoueurInt(questionCasNominal);
		}
		else {
			if(cptErr>4) {
				System.out.println(msgTropdErreurs);
			}
			nb=this.poserQuestionJoueurInt(questionSiErreur);
		}
		return nb;
	}
	

	/**
	 * @param nb
	 * @throws IllegalArgumentException genere une exception si l'utilisateur saisit un nb de joueurs invalide
	 */
	protected void verifierNbJoueurs(int nb) throws IllegalArgumentException {
		if (nb < 2 || nb > 6) {
			throw new IllegalArgumentException("Format de reponse invalide");
		}
		this.nbJoueurs = nb;
	}

	/**
	 * Demande aux joueurs leurs noms d'usage et les genere en consequence
	 */
	public void creerLesJoueurs() {
		// Pour chaque joueur, lui demander son nom
		String[] nomsJoueurs = new String[this.nbJoueurs];
		for (int i = 0; i < this.nbJoueurs; i++) {
			String nomJ = this.poserQuestionJoueurChaine(">>> Quel sera le nom du joueur " + (i + 1) + " ? :");
			String validation = this.poserQuestionJoueurChaine(">>> " + nomJ + ", c'est bien ça ? (oui/non) :");
			while (!validation.toUpperCase().equals("OUI")) {
				if (!validation.toUpperCase().equals("NON")) {
					validation = this.poserQuestionJoueurChaine("Veuillez répondre par oui ou par non. :");
				} else {
					nomJ = this.poserQuestionJoueurChaine(
							">>> OK, quel  nom préférez vous pour le joueur " + (i + 1) + " ? :");
					validation = this.poserQuestionJoueurChaine(nomJ + ", c'est bien ça ? (oui/non) :");
				}
			}
			nomsJoueurs[i] = nomJ;
			this.genererJoueurs(this.nbJoueurs, nomsJoueurs);
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


	

	/**
	 * @param question
	 * @return recupere la reponse pour une question donnee sous forme de chaine
	 */
	public String poserQuestionJoueurChaine(String question) {
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
	public int poserQuestionJoueurInt(String question) {
		int reponse;
		System.out.println(question + "\n");
		Scanner scannerInt = new Scanner(System.in);
		reponse = scannerInt.nextInt();
		// scanner.close();
		return reponse;
	}

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
			int numPion;
			int cptErr = 0;
			String questionCasNominal =">>> "+ j.getNom()+ ", veuillez choisir votre pion : (saisir le chiffre correspondant)";
			String questionSiErreur = ">>> Saisie incorrecte. Veuillez saisir le chiffre correspondant à votre choix de personnage. : ";
			String texteSiTropDerreurs = "Bon allez...Un petit effort...";
			boolean inputOk = false;
			
			while(!inputOk) {
				try {
					numPion = this.traiterReponseQuestionChiffreAttendu(questionCasNominal, questionSiErreur, texteSiTropDerreurs, cptErr)-1;
					this.verifierNumPionOK(numPion, pionsDispo);
					System.out.println("OK ! \n");
					Thread.sleep(1000);
					j.setPion(pionsDispo.get(numPion));
					pionsDispo.remove(numPion);
					inputOk = true;
				} catch (Exception e) {
					inputOk = false;
					cptErr ++;
				}
			}

		}

		Thread.sleep(1000);
		System.out.println("... Creation des joueurs ...");
		this.afficherBarreChargement();
		this.afficherJoueursEtPions();
	}



	private void verifierNumPionOK(int numeroPionChoisi, ArrayList<Pion> pionsDispo) throws IllegalArgumentException {
		if (numeroPionChoisi < 0 || numeroPionChoisi >= pionsDispo.size()) {
			throw new IllegalArgumentException("Format de reponse invalide.");
		}
	}


	private void afficherLesPions(ArrayList<Pion> pionsDispos) {
		System.out.println(">>> Pions disponibles :\n");
		for (int i = 0; i < pionsDispos.size(); i++) {
			System.out.println((i + 1) + " - " + pionsDispos.get(i).getTypePion().afficherPion());
		}
		System.out.println("\n\n");
	}

	private void afficherJoueursEtPions() {
		// Ecrire les messages destinés aux joueurs
		System.out.println("--- LISTE DES JOUEURS ---\n\n");
		for (Joueur j : this.joueurs) {
			System.out.println("- " + j.toString());
		}
	}

	private EPion pionSelonChiffreChoisi(int chiffre) {
		EPion p = EPion.Gandalf;// Valeur par defaut
		switch (chiffre) {
		case 1:
			p = EPion.Gandalf;
			break;
		case 2:
			p = EPion.Frodon;
			break;
		case 3:
			p = EPion.Aragorn;
			break;
		case 4:
			p = EPion.Legolas;
			break;
		case 5:
			p = EPion.Gimli;
			break;
		case 6:
			p = EPion.Galadriel;
		}
		return p;
	}
	
	// ---------- Methodes d'affichage -------------
	
	public void afficherBarreChargement() throws InterruptedException {
		System.out.print(". ");
		Thread.sleep(100);
		System.out.print(". ");
		Thread.sleep(100);
		System.out.print(". ");
		Thread.sleep(100);
		System.out.print(". ");
		Thread.sleep(100);
		System.out.print(". ");
		Thread.sleep(100);
		System.out.print(". \n\n");
		Thread.sleep(100);



		
	}

	public String afficherJoueurs() {
		String aff = "--- Liste des joueurs ---\n\n";
		for (Joueur j : this.joueurs) {
			aff += j.toString() + "\n";
		}
		return aff;
	}

}
