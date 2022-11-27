package fr.ut1.rtai.monopoly;


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
	private boolean possedeCarteSortiePrison;
	
	public Joueur(String nom) {
		this.nom=nom;
		this.pion=new Pion(EPion.Gandalf);//valeur par defaut
		this.possedeCarteSortiePrison=false;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setPion(Pion pion) {
		this.pion=pion;
		
	}
	
	public String toString() {
		return this.nom + " dans le rôle de "+ this.pion.getTypePion().afficherPion();
	}

	public String getNomPion() {
		return this.pion.getTypePion().name();
	}
	
	public boolean isEstEnPrison() {
		return this.estEnPrison;
	}

	public Pion getPion() {
		return this.pion;
	}
	
	
	
	
}
