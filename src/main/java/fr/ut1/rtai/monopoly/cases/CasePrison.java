package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.*;

public class CasePrison extends Case {

	private boolean reponseQuestion = false;

	public CasePrison(String nom) {
		super("Simple Visite", 0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param joueur
	 * @param plateau
	 * @param des
	 */
	public void actionCase(Joueur joueur, Plateau plateau, Des des) {

		int lance = plateau.des.lancerDes();
		int d1 = plateau.des.getChiffreDe1();
		int d2 = plateau.des.getChiffreDe2();

		if (joueur.getEstPrison() == true) {

			System.out.println("Voulez vous payer 50 euro pour sortir de prison ? ");

			if (getReponseQuestion()) {
				System.out.println("OUI : " + joueur.getNom() + " décide de payer 50 euro pour sortir de prison.");
				joueur.retirerArgent(50);
				reponseQuestion = false;
				joueur.setEstPrison(false);
				joueur.setToursEnPrison(1);
				plateau.deplacerJoueur(joueur, lance);
				System.out.println("" + joueur.getNom() + " lance les des... [" + d1 + "][" + d2 + "]... et obtient un "
						+ lance + " !");
				System.out.println("" + joueur.getNom() + " avance de " + lance + " cases et atterit sur "
						+ plateau.getCaseActive().getNom());

			} else {
				if (joueur.getToursEnPrison() > 2) {
					System.out.println(
							"NON : " + joueur.getNom() + " est a son 3e tour en prison, il sort et paye 50  euro.");
					joueur.retirerArgent(50);
					joueur.setEstPrison(false);
					joueur.setToursEnPrison(1);
					plateau.deplacerJoueur(joueur, lance);
					System.out.println("" + joueur.getNom() + " lance les des... [" + d1 + "][" + d2
							+ "]... et obtient un " + lance + " !");
					System.out.println("" + joueur.getNom() + " avance de " + lance + " cases et atterit sur "
							+ plateau.getCaseActive().getNom());

				} else {
					System.out.println("NON : " + joueur.getNom() + " (tour " + joueur.getToursEnPrison()
							+ ") décide de ne pas payer et lance ses d�s...");
					if (d1 == d2) {
						System.out.println(
								"  [" + d1 + "][" + d2 + "] Gagn�! " + joueur.getNom() + " sort de prison sans payer!");
						joueur.setEstPrison(false);
						joueur.setToursEnPrison(1);
						plateau.deplacerJoueur(joueur, lance);
						System.out.println("" + joueur.getNom() + " avance de " + lance + " cases et atterit sur "
								+ plateau.getCaseActive().getNom());

					} else {
						System.out.println("  [" + d1 + "][" + d2 + "] Perdu!");
						joueur.setToursEnPrison(joueur.getToursEnPrison() + 1);
					}
				}
			}
		} else {
			System.out.println(" > Le joueur observe les criminels...");

		}

	}

	@SuppressWarnings("static-access")
	public void actionSortiePrison(Joueur joueur, Plateau plateau) {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		plateau.getCase(joueur.getPosition());
		joueur.deplacerPion(joueur);
		plateau.getCase(joueur.getPosition()).actionCase(joueur, plateau);
	}

	public static void main(String[] args) {

		System.out.println("TEST DE LA CLASSE : CasePrison \n");
		Joueur j = new Joueur("Yann", 1000);
		Plateau p = new Plateau();

		CasePrison c = (CasePrison) p.getCase(10);

		j.setPosition(10);
		j.setEstPrison(true);
		System.out.println("Joueur en prison mais ne veut pas sortir : " + j.toString() + "\n");
		System.out.println(c.toString() + "\n");
		c.actionCase(j, p, null);

		j.setEstPrison(true);
		System.out.println("\nJoueur en prison veut sortir : " + j.toString() + "\n");
		c.setReponseQuestion(true);
		System.out.println(c.toString() + "\n");
		c.actionCase(j, p, null);

		System.out.println("\nJoueur en simple visite : " + j.toString() + "\n");
		System.out.println(c.toString() + "\n");
		c.actionCase(j, p, null);

		System.out.println("\nJoueur apr�s la prison : " + j.toString());
	}

	private void setReponseQuestion(boolean b) {
	}

	@Override
	public boolean getReponseQuestion() {
		return reponseQuestion;
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

}