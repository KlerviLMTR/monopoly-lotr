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

//		Plateau p = new Plateau();
//	p.getCartesEvenement().get(3).afficherCarte();
//		p.getCartesEvenement().get(4).afficherCarte();

//		Joueur j = new Joueur("toto");
//		j.setPion(new Pion(EPion.Galadriel));
//		System.out.println(j.getSolde());
//		p.getCaseNumero(2).actionCase(j);
//		p.getCaseNumero(4).actionCase(j);
//		Joueur j2 = new Joueur("titi");
//		j2.setPion(new Pion(EPion.Legolas));
//
//		System.out.println(j.getSolde());
//		p.getCaseNumero(2).actionCase(j2);
//		System.out.println(j.getSolde());


// Tester vite fait les cartes :
		Joueur j = new Joueur("toto");
		Plateau p = new Plateau();
		System.out.println(j.getSolde());
		j.setPion(new Pion(EPion.Aragorn));
		j.setPartie(new PartieDeMonopoly());
		j.setPlateau(p);
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		j.piocherUneCartePeuple();
		System.out.println(j.estEnPrison());

		j.piocherUneCartePeuple();
		System.out.println(j.estEnPrison());
		j.sejournerEnPrison();
		j.sejournerEnPrison();
		j.sejournerEnPrison();
		j.sejournerEnPrison();

		System.out.println(j.estEnPrison());


		
	}

}
