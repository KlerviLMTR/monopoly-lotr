package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.cartes.Carte;
import fr.ut1.rtai.monopoly.*;

public class CasePeuple extends Case {

    public CasePeuple(int valeur) {
        super("Communaute", 0);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void actionCase(Joueur joueur, Plateau plateau) {
        // TODO Auto-generated method stub
        final Carte carte = joueur.getPartie().tirerCarteCommunaute();
        System.out
                .println(" > " + joueur.getPartie().getJoueurActif().getTitre() + " tire la carte " + carte.getTitre());
        joueur.afficherMessage(joueur.getPartie().getJoueurActif().getTitre() + " tire la carte " + carte.getTitre());

        carte.actionCarte(joueur.getPartie().getJoueurActif(), joueur.getPartie());

        if (joueur.getPartie())
            joueur.getPartie().reprendrePartie();
        else
            joueur.afficherCarteCommunaute(carte.getTitre(), carte.getDesc());

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
    public String toString() {
        return "CaseCommunaute [" + super.toString() + "]";
    }

    @Override
    public boolean getReponseQuestion() {
        // TODO Auto-generated method stub
        return false;
    }

}
