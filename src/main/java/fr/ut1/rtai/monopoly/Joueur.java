package fr.ut1.rtai.monopoly;


import java.util.HashSet;
import java.util.Set;

import fr.ut1.rtai.monopoly.cases.BatonDeMagicien;
import fr.ut1.rtai.monopoly.cases.Case;
import fr.ut1.rtai.monopoly.cases.CasePropriete;
import fr.ut1.rtai.monopoly.cases.Monture;
import fr.ut1.rtai.monopoly.cases.Territoire;

public class Joueur {

	private String nom;
	private Pion pion;
	private int solde;
	private boolean estEnPrison;
	private Set<Monture> monturesPossedees; //Choix d'un set car l'ordre des montures possedees n'a pas d'importance
	private Set<Territoire> territoiresPossedes;//idem
	private Set<BatonDeMagicien> batonsDeMagicienPossedes;//idem
	private boolean possedeCarteSortiePrison;
	private int nbCartesSortiePrison;
	private int nbToursPrison;
	private boolean estEnFaillite;
	
	public Joueur(String nom) {
		this.nom=nom;
		this.possedeCarteSortiePrison=false;
		this.estEnPrison=false;
		this.nbCartesSortiePrison=0;
		this.estEnFaillite=false;
		this.monturesPossedees = new HashSet<Monture>();
		this.territoiresPossedes = new HashSet<Territoire>();
		this.batonsDeMagicienPossedes = new HashSet<BatonDeMagicien>();
	}
	
	
	// -------- Getters et setters utiles ----------

	public int getSolde() {
		return solde;
	}
	
	public int getNbToursEnPrison() {
		return this.nbToursPrison;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setPion(Pion pion) {
		this.pion=pion;
		
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
	
	public int getNbCartesSortiePrison() {
		return this.nbCartesSortiePrison;
	}

	public void setNbCartesSortiePrison(int nombre) {
		this.nbCartesSortiePrison = nombre;
	}
	
	//  --------  Méthodes du joueur ----------
	
	
	public void gagnerduPouvoir(int pouvoir) {
		this.solde += pouvoir;
	}

	public void perdrePouvoir(int pouvoir) {
		this.solde -= pouvoir;

	}
	
	public int getNbMonturesPossedees() {
		return this.monturesPossedees.size();
	}
	
	public int getNbBatonsDeMagicienPossedes() {
		return this.batonsDeMagicienPossedes.size();
	}
	
	
	/**
	 * @param c
	 * @return
	 * Verifie si le joueur est proprietaire de tous les terrains d'une couleur donnee
	 */
	public boolean possedeTousLesTerrainsSurLotCouleur(ECouleurCase c) {
		int nbApparitionCoul = 0;
		for(Territoire t: this.territoiresPossedes) {
			if(t.getCouleurCase() == c ) {
				nbApparitionCoul++;
			}
		}
		return (nbApparitionCoul == Plateau.NBLOTPARCOULEUR.get(c)) ;
		
	}
	
	/**
	 * @param c
	 * Permet au joueur d'acheter une case donnee.
	 */
	public void acheterCase(CasePropriete c) {
		c.setProprietaire(this);
		if (c instanceof Monture) {
			this.monturesPossedees.add((Monture) c);
		}
		else if (c instanceof Territoire) {
			this.territoiresPossedes.add((Territoire) c);
		}
		else {
			this.batonsDeMagicienPossedes.add((BatonDeMagicien) c);
		}
	}
	

	
	public void estMisEnPrison() {
		this.nbToursPrison = 0;
		this.estEnPrison = true;
	}

	public boolean getEstEmprisonne() {
		return this.estEnPrison;
	}
	
	public String toString() {
		return this.nom + " dans le rôle de "+ this.pion.getTypePion().afficherPion();
	}


	
	
	
	
}
