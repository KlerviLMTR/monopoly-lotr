package fr.ut1.rtai.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public class CarteGagnerDuPouvoir extends Carte {

    private int montantGagne;

    public CarteGagnerDuPouvoir(String titre, String description, int montant) {
        super(titre, description);
        this.montantGagne = montant;
    }

    @Override
    public void actionCarte(Joueur joueur, Plateau plateau) {

        if (getTitre().equals("Anniversaire")) {
            for (int i = 0; i < plateau.getNbJoueurs(); i++) {
                if (plateau.getJoueur(i) != joueur && !plateau.getJoueur(i).getEstBanqueroute()) {
                    plateau.getJoueur(i).retirerArgent(10);
                    joueur.ajouterArgent(10);
                }
            }
            System.out.println(" > " + joueur.getNom() + " reçoit 10  euro de chaque joueur.");

        }

        else {
            joueur.ajouterArgent(montantGagne);
            System.out.println(" > " + joueur.getNom() + " reéoit " + montantGagne + "a de la Banque");
        }
    }

    @Override
    public String toString() {
        return "CarteRecevoirArgent [" + super.toString() + " montant= " + montantGagne + "]";
    }

}
