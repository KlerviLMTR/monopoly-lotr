package fr.ut1.rtai.monopoly;

import java.util.ArrayList;
import java.util.Scanner;

public class PartieDeMonopoly {
	private Plateau p;
	private ArrayList <Joueur> joueurs;
	private int nbJoueurs;
	
	public PartieDeMonopoly() {
		//Ecrire les messages destinés aux joueurs
		System.out.println("--- Création de la partie de Monopoly ---\n\n");
		
		//Creer le plateau
		this.p = new Plateau(); 
	}

	
	// ---------- Getters et setters utiles --------------

	
	public int getNbJoueurs() {
		return this.nbJoueurs;
	}
	
	public ArrayList<Joueur> getJoueurs(){
		return this.joueurs;
	}
	
	// ---------- Fonctions relatives à la creation des joueurs --------------
	
	public void definirNbJoueurs() {
		try {	
			int nbJoueurs= this.poserQuestionJoueurInt("Combien de joueurs participeront à la partie ? (Saisissez votre réponse , 2 à 6 joueurs autorisés) :");
			this.verifierNbJoueurs(nbJoueurs);
		}catch(Exception e){
			int nb = 0;
			this.traiterReponseQuestionNbJoueurs(nb);
		}
	}
	
	/**
	 *Demande aux joueurs leurs noms d'usage et les genere en consequence 
	 */
	public void creerLesJoueurs() {
		//Pour chaque joueur, lui demander son nom
		String[] nomsJoueurs = new String[this.nbJoueurs];
		for (int i = 0; i < this.nbJoueurs; i++) {
			String nomJ = this.poserQuestionJoueurChaine(">>> Quel sera le nom du joueur "+(i+1)+ " ? :");
			String validation = this.poserQuestionJoueurChaine(">>> " + nomJ + ", c'est bien ça ? (oui/non) :");
			while(!validation.toUpperCase().equals("OUI")) {
				if (!validation.toUpperCase().equals("NON")) {
					validation = this.poserQuestionJoueurChaine("Veuillez répondre par oui ou par non. :");
				}
				else {
					nomJ = this.poserQuestionJoueurChaine(">>> OK, quel  nom préférez vous pour le joueur "+(i+1) + " ? :");
					validation = this.poserQuestionJoueurChaine(nomJ + ", c'est bien ça ? (oui/non) :");
				}
			}
			nomsJoueurs[i]=nomJ;
			this.genererJoueurs(this.nbJoueurs, nomsJoueurs);
		}
	}
	
	/**
	 * @param nbJoueurs
	 * @param nomsJoueurs
	 * Cree la liste des joueurs participant a la partie. Appelee par la methode creerLesJoueurs.
	 */
	protected void genererJoueurs(int nbJoueurs, String[] nomsJoueurs) {
		this.joueurs=new ArrayList<Joueur>();
		for(int i = 0; i<nomsJoueurs.length;i++) {
			this.joueurs.add(new Joueur(nomsJoueurs[i]));
		}
	}
	

	/**
	 * @param nb
	 * @return
	 * fonction utilitaire si l'utilisateur ne saisit pas le nb joueurs selon les paramètres requis
	 */
	protected void traiterReponseQuestionNbJoueurs(int nb) {

		while (nb < 2 || nb > 6) {
			nb = this.poserQuestionJoueurInt("Le nombre de joueurs doit être un chiffre compris entre 2 et 6. Veuillez le saisir à nouveau : ");		
		}
		this.nbJoueurs=nb;
	}
	
	/**
	 * @param nb
	 * @throws IllegalArgumentException
	 * genere une exception si 
	 */
	protected void verifierNbJoueurs(int nb) throws IllegalArgumentException{
		if (nb < 2 || nb > 6) {
			throw new IllegalArgumentException("Format de reponse invalide");
		}
		this.nbJoueurs=nb;
	}



	/**
	 * @param question
	 * @return
	 * recupere la reponse pour une question donnee
	 */
	public String poserQuestionJoueurChaine(String question) {
		String reponse ="";
		System.out.println(question+"\n");
		Scanner scanner = new Scanner(System.in);
		reponse=scanner.nextLine();
		return reponse;
	}
	
	 
		public int poserQuestionJoueurInt(String question) {
			int reponse ;
			System.out.println(question+"\n");
			Scanner scannerInt = new Scanner(System.in);
			reponse=scannerInt.nextInt();
			//scanner.close();
			return reponse;
		}
		

		
		private EPion pionSelonChiffreChoisi(int chiffre) {
			EPion p =EPion.Gandalf;//Valeur par defaut
			switch(chiffre) {	
				case 1:
					p=EPion.Gandalf;
					break;
				case 2:
					p=EPion.Frodon;
					break;
				case 3:
					p=EPion.Aragorn;
					break;
				case 4:
					p=EPion.Legolas;
					break;
				case 5: 
					p=EPion.Gimli;
					break;
				case 6:
					p=EPion.Galadriel;
			}
			return p;
		}
		
		public String afficherJoueurs() {
			String aff="--- Liste des joueurs ---\n\n";
			for (Joueur j : this.joueurs) {
				aff+= j.toString()+"\n";
			}
			return aff;
		}
	
	
	
}
