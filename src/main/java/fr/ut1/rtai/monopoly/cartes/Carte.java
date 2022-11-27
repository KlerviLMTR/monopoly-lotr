package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public abstract class Carte {

	private String titre;
	private String description;
	private Plateau p;

	public Carte(String titre, String description) {
		this.titre = titre;
		this.description = description;
	}
	
	public abstract void actionCarte(Joueur j, Plateau p);

	public String getTitre() {
		return this.titre;
	}

	public String getDesc() {
		return this.description;
	}


	@Override
	public String toString() {
		return "Carte [titre=" + titre + ", description=" + description + "]";
	}
}
