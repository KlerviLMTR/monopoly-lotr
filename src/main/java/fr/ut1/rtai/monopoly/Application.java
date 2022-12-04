package fr.ut1.rtai.monopoly;

import fr.ut1.rtai.monopoly.cartes.CarteAllerEnPrison;
import fr.ut1.rtai.monopoly.cases.CasePropriete;
import fr.ut1.rtai.monopoly.cases.Monture;
import fr.ut1.rtai.monopoly.cases.Territoire;

public class Application {

	public static void main(String[] args) throws InterruptedException {
	
		//tester la generation des joueurs
//		PartieDeMonopoly partie = new PartieDeMonopoly();
//		partie.definirNbJoueurs();
//		System.out.println(partie.getNbJoueurs());
//		partie.creerLesJoueurs();
//		partie.genererPions();	
		
		
		
		//tester la gestion des cases : (construs territoires pas encore gérés)

		Plateau p = new Plateau();
		Joueur j = new Joueur("toto");
		j.setPion(new Pion(EPion.Galadriel));
		System.out.println(j.getSolde());
		p.getCaseNumero(6).actionCase(j);
		p.getCaseNumero(16).actionCase(j);
		Joueur j2 = new Joueur("titi");
		j2.setPion(new Pion(EPion.Legolas));

		System.out.println(j.getSolde());
		p.getCaseNumero(6).actionCase(j2);
		System.out.println(j.getSolde());


// Tester vite fait les cartes :
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
