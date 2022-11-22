package fr.ut1.rtai.monopoly;

import java.util.Map;
import java.util.Set;

import fr.ut1.rtai.monopoly.cases.Monture;
import fr.ut1.rtai.monopoly.cases.Territoire;

public class Joueur {

	private String nom;
	private Pion pion;
	private int solde;
	private boolean estEnPrison;
	private Plateau plateau;
	private Set<Monture> monturesPossedees; // Choix d'un set car l'ordre des montures possedees n'a pas d'importance
	private Set<Territoire> territoiresPossedes;// idem
	private int position = 0;

	public Joueur(String nom) {
		this.nom = nom;

	}

	public Joueur(String nom, int solde) {
		this.nom = nom;
		this.solde = 1500;
		this.pion = Pion.Gandalf;// valeur par defaut
	}

	public String getNom() {
		return this.nom;
	}

	public void setPion(Pion pion2) {
		this.pion = pion2;

	}

	public String getNomPion() {
		return this.pion.name();
	}

	public Pion getPion() {
		return this.pion;
	}

	public String toString() {
		return this.nom + " dans le rôle de " + this.pion.afficherPion();
	}

	public void retirerArgent(int prix) {
	}

	public void ajouterArgent(int i) {
	}

	public String getArgent() {
		return null;
	}

	public void setEstPrison(boolean b) {
	}

	public void setCarteSortiePrison(boolean b) {
	}

	public boolean getCarteSortiePrison() {
		return false;
	}

	public boolean getEstPrison() {
		return false;
	}

	public void setToursEnPrison(int i) {
	}

	public int getToursEnPrison() {
		return 0;
	}

	public void setPosition(int i) {
	}

	public void deplacerPion(Joueur joueur) {
	}

	public void getPartie() {
	}

	public int getPosition() {
		return this.position;
	}

}
