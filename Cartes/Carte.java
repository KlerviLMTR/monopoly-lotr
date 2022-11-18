package Cartes;

import MonopolyJoueur.*;
import MonopolyPlateau.*;

public abstract class Carte {

	private String titre;
	private String description;

	public Carte(String titre, String description) {
		this.titre = titre;
		this.description = description;
	}

	public String getNom() {
		return this.titre;
	}

	public String getDesc() {
		return this.description;
	}

	public abstract void actionCarte(MonopolyJoueur Joueurs,MonopolyPlateau plateau, /*FenetrePrincipale fp*/);

	@Override
	public String toString() {
		return "Carte [titre=" + titre + ", description=" + description + "]";
	}
}
