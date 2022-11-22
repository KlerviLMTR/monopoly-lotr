package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.cartes.CarteGagnerDuPouvoir;
import fr.ut1.rtai.cartes.CarteSortirDePrison;
import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public class BatonDeMagicien extends CasePropriete {

	public BatonDeMagicien(String nom, int valeur) {
		super("evenement", 0);
	}

	@Override
	public void actionCase(Joueur joueur, Plateau plateau) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCouleur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoyer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPrixPlaceForte() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setProprietaire(Joueur j) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getReponseQuestion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "evenement [" + super.toString() + "]";
	}

	public static void main(String[] args) {

		System.out.println("TEST DE LA CLASSE : CaseChance");
		Joueur j = new Joueur("Yann", 1000);
		Plateau p = new Plateau();
		CarteGagnerDuPouvoir payer = new CarteGagnerDuPouvoir("Amende", "Amende pour : 20 e.", 20);
		System.out.println(payer.toString());
		payer.actionCarte(j, p);
		System.out.println(j.toString()); // Le joueur Yann perd 15 e
		System.out.println(p.getCase(20).toString());

		CarteSortirDePrison prison = new CarteSortirDePrison("Sortie",
				"Vous étes librée de prison. \n(Cette carte doit étre conservée)");
		System.out.println(prison.toString());
		prison.actionCarte(j, p);
		System.out.println(j.toString()); // Le joueur Yann possede la carte de sortie de prison
	}

}
