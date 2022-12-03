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
		System.out.println(((CasePropriete) p.getCaseNumero(6)).estEnHypotheque());
		j.acheterCase((CasePropriete) p.getCaseNumero(6));
		p.getCaseNumero(6).actionCase(j);
		System.out.println(((CasePropriete) p.getCaseNumero(6)).estEnHypotheque());
		System.out.println(j.getSolde());

		
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
