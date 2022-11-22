package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.*;

public class CaseParcGratuit extends Case {

	public CaseParcGratuit(int valeur) {
		super("Case parc gratuit", valeur);

	}

	/**
	 * Méthode permettant a un joueur de récupérer l'argent de la case Parc Gratuit,
	 * réinitialisant ensuite celle-ci a 0
	 * 
	 */
	public void actionCase(Joueur joueur, Plateau plateau) {

		System.out.println(" > " + joueur.getNom() + " ramasse " + this.getPrix() + " du Parc Gratuit !");

		joueur.ajouterArgent(this.getPrix());
		this.setPrix(0);
	}

	public static void main(String[] args) {

		System.out.println("TEST DE LA CLASSE : CaseParcGratuit");
		Joueur j = new Joueur("Yann", 1000);
		Plateau p = new Plateau();

		CaseParcGratuit c = (CaseParcGratuit) p.getCase(20);

		c.setPrix(300);
		System.out.println("Initialisation de la case Parc Gratuit  : " + c.toString());
		System.out.println("Joueur avant le parc gratuit : " + j.toString());
		j.setPosition(20);
		c.actionCase(j, p);

		System.out.println("Case Parc Gratuit aprés le passage du joueur : " + c.toString());
		System.out.println("Joueur aprés le parc gratuit : " + j.toString());
	}

	@Override
	public String getCouleur() {
		return null;
	}

	@Override
	public int getLoyer() {
		return 0;
	}

	@Override
	public int getPrixPlaceForte() {
		return 0;
	}

	@Override
	public void setProprietaire(Joueur j) {
	}

	@Override
	public String toString() {
		return "CaseParcGratuit [" + super.toString() + "]";
	}

	@Override
	public boolean getReponseQuestion() {
		// TODO Auto-generated method stub
		return false;
	}

}
