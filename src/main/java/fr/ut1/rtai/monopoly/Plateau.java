package fr.ut1.rtai.monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.ut1.rtai.monopoly.cases.*;

public class Plateau {
	private ArrayList<Joueur> joueurs;
	private HashMap<Pion, Joueur> correspondancePionJoueurs;
	private HashMap<Pion, Case> positionsJoueurs;// implementation a discuter
	private ArrayList<Case> cases; // choix d'une ArrayList car suite de cases ordonnees
	private int nbJoueurs;
	public Des des = new Des();

	/**
	 * 
	 */
	public Plateau() {

		// Ecrire les messages destinés aux joueurs
		System.out.println("--- Création de la partie de Monopoly ---\n\n");

		// Creer les cases
		this.cases = new ArrayList<Case>();

		// TODO: completer/modifier le bloc qui suit avec les vraies cases
		// v1test avec quelques cases:
		for (int i = 0; i < 5; i++) {
			this.cases.add(new CaseDepart("Case Départ", 0));
			this.cases.add(new Territoire("Cul de Sac", 100, new int[] { 50, 70, 80, 100, 150, 200 }));
			this.cases.add(new CaseEvenement("Aller en prison"));
			this.cases.add(new Territoire("Ferme du père Magotte", 100, new int[] { 70, 90, 100, 120, 170, 250 }));
		}

		// ajouter les positions des cases sur le plateau
		for (Case c : cases) {
			int numCase = cases.indexOf(c);
			c.setValeur(numCase);
		}

		// Creer les joueurs
		this.joueurs = new ArrayList<Joueur>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Combien de joueurs participent à la partie ?");
		this.nbJoueurs = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < nbJoueurs; i++) {
			System.out.println("Saisissez le prénom du joueur " + (i + 1) + " :");
			String prenom = scanner.nextLine();
			this.joueurs.add(new Joueur(prenom));
		}

		// TODO: changer le bloc qui suit par la methode affecterPions qui demande aux
		// joueurs a tour de rôle quel pion ils prennent (eviter les doublons
		System.out.println("--- Choix des pions ---\n");
		Pion[] listePions = Pion.values();
		for (int i = 0; i < 5; i++) {
			System.out.println((i + 1) + " - " + listePions[i].afficherPion());

		}

		for (Joueur j : this.joueurs) {
			System.out.println(
					"\n" + j.getNom() + ", veuillez choisir votre personnage : (entrer le chiffre correspondant)");
			int choixPion = scanner.nextInt();
			// affecter le pion au joueur
			j.setPion(this.pionSelonChiffreChoisi(choixPion));
		}

		// Creation de la table de correspondance pion/joueur
		this.correspondancePionJoueurs = new HashMap<Pion, Joueur>();
		for (Joueur j : this.joueurs) {
			this.correspondancePionJoueurs.put(j.getPion(), j);
		}

		// Creer le mapping des joueurs et de leurs positions: initialiser la position a
		// la premiere case
		this.positionsJoueurs = new HashMap<Pion, Case>();
		for (int i = 0; i < this.nbJoueurs; i++) {
			this.positionsJoueurs.put(this.joueurs.get(i).getPion(), this.cases.get(0));
		}
		scanner.close();
	}

	private Pion pionSelonChiffreChoisi(int chiffre) {
		Pion p = Pion.Gandalf;// Valeur par defaut
		switch (chiffre) {
			case 1:
				p = Pion.Gandalf;
				break;
			case 2:
				p = Pion.Frodon;
				break;
			case 3:
				p = Pion.Aragorn;
				break;
			case 4:
				p = Pion.Legolas;
				break;
			case 5:
				p = Pion.Gimli;
				break;
			case 6:
				p = Pion.Galadriel;
		}
		return p;
	}

	// public Joueur getJoueurParPion(Pion p) {
	//
	// }

	public String afficherPositionJoueurs() {
		String aff = "--- Position des joueurs ---\n\n";
		for (int i = 0; i < this.joueurs.size(); i++) {
			Joueur jCourant = this.joueurs.get(i);
			aff += "[ " + this.joueurs.get(i).getNomPion() + " : case n° "
					+ this.positionsJoueurs.get(jCourant.getPion()).getValeur() + " ]\n";
		}
		return aff;
	}

	public String afficherJoueurs() {
		String aff = "--- Liste des joueurs ---\n\n";
		for (Joueur j : this.joueurs) {
			aff += j.toString() + "\n";
		}
		return aff;
	}

	public Case getCase(int i) {
		return this.getCase(i);
	}

	public void deplacerJoueur(Joueur j, int i) {
	}

	public void remettreCarteSortiePrisonDansPaquet() {
	}

	public Case getCaseActive() {
		return null;
	}

	public Joueur getJoueur(int i) {
		return null;
	}

	public int getNbJoueurs() {
		return 0;
	}
}
