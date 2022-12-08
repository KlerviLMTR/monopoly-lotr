package fr.ut1.rtai.monopoly.cartes;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

public class CarteAllerEnPrison extends Carte {

	public CarteAllerEnPrison(String titre, String description) {
		super(titre, description);
	}

	@Override
	public void actionCarte(Joueur j) throws InterruptedException {
		this.afficherCarte();
		j.estMisEnPrison();
		j.getPion().seDeplacerNumCase(11);
		super.estPiocheeEtRemiseAuFondDuPaquet();
	}


}
