package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;
import fr.ut1.rtai.monopoly.Plateau;

public abstract class Carte {

	private String titre;
	private String description;
	private Plateau p;
	private PartieDeMonopoly partie;
	

	/**
	 * Construire une carte (non instanciable)
	 * @param titre
	 * @param description
	 */
	public Carte(String titre, String description) {
		this.titre = titre;
		this.description = description;
	}
	
	
	
	/**
	 * Définit l'action de la carte. Implémentée dans chacun des types de carte.
	 * @param j
	 * @throws InterruptedException
	 */
	public abstract void actionCarte(Joueur j) throws InterruptedException;
	
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
	
	public void setPartieDeMonopoly(PartieDeMonopoly p) {
		this.partie=p;
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
	
	//-----------------  Methodes d'affichage des cartes ---------------------------

	public void afficherCarte() {
		System.out.println(this);
		PartieDeMonopoly.affichageMessageDelai(15, "\" "+ description+" \"\n");
	}
	
	@Override
	public String toString() {
		String aff= "\n"+MessagesJeu.affichageSepCarte;
			
		if (this.titre.equals("Carte Peuple")) {
			aff+= " Ⰴ 🧍 "+ this.titre + " 🧍 Ⰴ "; 
		}
		else {
			aff+= " Ⰴ ⚔ "+ this.titre + " ⚔ Ⰴ "; 
		}
		aff+=MessagesJeu.affichageSepCarte+"\n\n";
		return aff;
	}
}
