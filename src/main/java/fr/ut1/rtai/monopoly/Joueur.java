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
	private Set<Monture> monturesPossedees; //Choix d'un set car l'ordre des montures possedees n'a pas d'importance
	private Set<Territoire> territoiresPossedes;//idem
	
	
	public Joueur(String nom) {
		this.nom=nom;
		this.pion=Pion.Gandalf;//valeur par defaut
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setPion(Pion p) {
		this.pion=p;
		
	}
	
	public String toString() {
		return this.nom + " dans le rôle de "+ this.pion.afficherPion();
	}

	public String getNomPion() {
		return this.pion.name();
	}

	public Pion getPion() {
		return this.pion;
	}
	
}
