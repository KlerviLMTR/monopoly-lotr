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
		Joueur j2 = new Joueur("toto");
		
		j2.setPion(new Pion(EPion.Aragorn));
		j.setPion(new Pion (EPion.Frodon));
		p.getCaseNumero(14).actionCase(j);
		p.getCaseNumero(14).actionCase(j);

		p.getCaseNumero(15).actionCase(j);
		p.getCaseNumero(15).actionCase(j);

		System.out.println(j.getSolde());
		p.getCaseNumero(15).actionCase(j2);
		System.out.println(j.getSolde());

		System.out.println(j2.getSolde());

//		p.getCaseNumero(13).actionCase(j);

//		j.setPion(new Pion(EPion.Galadriel));
//		System.out.println(j.getSolde());
//		p.getCaseNumero(13).actionCase(j);
//		System.out.println(j.getSolde());
//
//		p.getCaseNumero(28).actionCase(j);
//		p.getCaseNumero(28).actionCase(j);
//
//		System.out.println(j.getSolde());
//
//		Joueur j2 = new Joueur("titi");
//		j2.setPion(new Pion(EPion.Legolas));
//
//		System.out.println(j.getSolde());
//		p.getCaseNumero(28).actionCase(j2);
//		System.out.println(j.getSolde());


// Tester vite fait les cartes :
//		Joueur j = new Joueur("toto");
//		Plateau p = new Plateau();
//		System.out.println(j.getSolde());
//		j.setPion(new Pion(EPion.Aragorn));
//		j.setPartie(new PartieDeMonopoly());
//		j.setPlateau(p);
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
//		System.out.println(j.estEnPrison());
//
//		j.piocherUneCartePeuple();
//		System.out.println(j.estEnPrison());
//		j.sejournerEnPrison();
//		j.sejournerEnPrison();
//		j.sejournerEnPrison();
//		j.sejournerEnPrison();
//
//		System.out.println(j.estEnPrison());


		
	}

}
