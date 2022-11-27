package fr.ut1.rtai.monopoly;

import fr.ut1.rtai.monopoly.cartes.CarteAllerEnPrison;
import fr.ut1.rtai.monopoly.cases.CasePropriete;

public class Application {

	public static void main(String[] args) throws InterruptedException {
	
		PartieDeMonopoly partie = new PartieDeMonopoly();
		partie.definirNbJoueurs();
		System.out.println(partie.getNbJoueurs());
		partie.creerLesJoueurs();
		partie.genererPions();		
		
//		Joueur j = new Joueur("toto");
//		Plateau p = new Plateau();
//		j.setPion(new Pion(EPion.Aragorn));
//		j.setPlateau(p);
//		p.afficherCartesPeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//		System.out.println(j.isEstEnPrison());
//
//		j.piocherUneCartePeuple();
//
//		j.piocherUneCartePeuple();
//		j.piocherUneCartePeuple();
//
//		j.piocherUneCartePeuple();
//
//		p.afficherCartesPeuple();
//		System.out.println(j.isEstEnPrison());
//		j.utiliserCarteSortiePrison();
//		p.afficherCartesPeuple();
		
	}

}
