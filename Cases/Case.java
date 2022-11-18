package Cases;

import java.util.ArrayList;

import MonoployJeue.*;
import MonopolyPlateau.PlateauMonopoly;

/*import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;*/

import java.awt.*;

public abstract class Case {

	// les varaibles de case

	private String nom;
	private int id = 0;
	private int valeur = 0;
	// Polygob est une fonction de librairie java
	private Polygon marqueur = new Polygon();
	public ArrayList<Polygon> maisons = new ArrayList<Polygon>();

	// constrcuteur
	public Case(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;

		/*
		 * Ajouter maison
		 */
		for (int i = 0; i < 6; i++) {
			Polygon maison = new Polygon();
			maisons.add(maison);
		}
	}

	public String getNom() {
		return nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrix() {
		return valeur;
	}

	public void setPrix(int valeur) {
		this.valeur = valeur;
	}

	public Polygon getMarqueur() {
		return this.marqueur;
	}

	public void setMarqueur(Polygon r) {
		this.marqueur = r;
	}

	/* PARTIE ABSTRAITE */

	public abstract JoueurMonopoly getProprietaire();

	public abstract String getCouleur();

	public abstract int getLoyer();

	public abstract int getPrixMaison();

	public abstract int getNbMaison();

	public abstract boolean getReponseQuestion();

	public abstract boolean getPeutMettreMaison();

	public abstract void setProprietaire(JoueurMonopoly j);

	public abstract void setReponseQuestion(boolean b);

	public abstract void actionCase(JoueurMonopoly joueur, PlateauMonopoly plateau);

	@Override
	public String toString() {
		return "Case [nom=" + nom + ", id=" + id + ", valeur=" + valeur + "]";
	}

}
