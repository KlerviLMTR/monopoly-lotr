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
	
	
	
	public abstract void actionCarte(Joueur j);
	
	public void estPiocheeEtRemiseAuFondDuPaquet() {
		if (this.getTitre().equals("Carte Peuple")){
			//On la remet au fond du paquet car ce n'est pas une carte que le joueur va garder
			p.getCartesPeuple().add(p.getCartesPeuple().remove(0));
		}
		else {
			p.getCartesEvenement().add(p.getCartesEvenement().remove(0));

		}
	}
	

	// ------ Getters et setters utiles -----
	public void setPlateau(Plateau p ) {
		this.p=p;
	}
	
	public Plateau getPlateau() {
		return this.p;
	}

	public String getTitre() {
		return this.titre;
	}

	public String getDesc() {
		return this.description;
	}
	
	//--------------------------------------------


	@Override
	public String toString() {
		return "Carte [titre=" + titre + ", description=" + description + "]";
	}
}
