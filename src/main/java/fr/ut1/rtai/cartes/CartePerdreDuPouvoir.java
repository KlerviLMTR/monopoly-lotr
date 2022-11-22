package fr.ut1.rtai.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public class CartePerdreDuPouvoir extends Carte {

	private int montantAPayer;

	public CartePerdreDuPouvoir(String titre, String description, int montant) {
		super(titre, description);
		this.montantAPayer = montant;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionCarte(Joueur joueur, Plateau plateau) {

		if (getTitre().equals("Président du conseil d'administration")) {
			for (int i = 0; i < plateau.getNbJoueurs(); i++) {
				if (plateau.getJoueur(i) != joueur && !plateau.getJoueur(i).getEstBanqueroute()) {
					plateau.getJoueur(i).ajouterArgent(50);
					joueur.retirerArgent(50);
				}
			}
			System.out.println(" > " + joueur.getNom() + " verse 50 chaque joueur.");

		} else {
			joueur.retirerArgent(montantAPayer);
			plateau.getCase(20).setPrix(plateau.getCase(20).getPrix() + montantAPayer);
			System.out.println(" > " + joueur.getNom() + " dépose " + montantAPayer + "a au parc gratuit");

		}
	}

	public int getMontant() {
		return this.montantAPayer;
	}

	@Override
	public String toString() {
		return "CartePayerArgent [" + super.toString() + ", montant= " + montantAPayer + "]";
	}
}