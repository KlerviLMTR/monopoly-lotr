package fr.ut1.rtai.monopoly;

import fr.ut1.rtai.monopoly.cartes.CarteAllerEnPrison;
import fr.ut1.rtai.monopoly.cases.CasePropriete;
import fr.ut1.rtai.monopoly.cases.Monture;
import fr.ut1.rtai.monopoly.cases.Territoire;

public class Application {

	public static void main(String[] args) throws InterruptedException {
	
//		PartieDeMonopoly partie = new PartieDeMonopoly();
//		partie.definirNbJoueurs();
//		System.out.println(partie.getNbJoueurs());
//		partie.creerLesJoueurs();
//		partie.genererPions();		
//		Joueur j = new Joueur("toto");
//		Territoire c27 = new Territoire("Forêt de Fangorn", ECouleurCase.jaune,260,130,150, new int[] {22,110,330,800,975,1150});
//		j.acheterCase(c27);
//		System.out.println(c27.getProprietaire());
		Plateau p = new Plateau();

		Joueur j = new Joueur("toto");
		System.out.println(j.getSolde());
		p.getCaseNumero(6).actionCase(j);
		Joueur j2 = new Joueur("titi");
		System.out.println(j.getSolde());
		p.getCaseNumero(6).actionCase(j2);
		System.out.println(j.getSolde());
		System.out.println(j2.getSolde());

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
