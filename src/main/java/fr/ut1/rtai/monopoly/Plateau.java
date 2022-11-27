package fr.ut1.rtai.monopoly;

import java.util.ArrayList;

import fr.ut1.rtai.monopoly.cartes.Carte;
import fr.ut1.rtai.monopoly.cartes.CarteAllerEnPrison;
import fr.ut1.rtai.monopoly.cartes.CarteDeplacement;
import fr.ut1.rtai.monopoly.cartes.CarteGagnerDuPouvoir;
import fr.ut1.rtai.monopoly.cases.*;

public class Plateau {

	private ArrayList<Case> cases; //choix d'une ArrayList car suite de cases ordonnees
	private ArrayList<Carte> cartesPeuple;
	private ArrayList<Carte> cartesEvenement;


	public Plateau() {
		this.genererCasesPlateau();
		this.genererCartesPeuple();
		this.genererCartesEvenement();
	}

	private void genererCartesPeuple() {
		  // Creation du paquet
        this.cartesPeuple = new ArrayList<Carte>();
        // Création des cartes
        Carte c1 = new CarteGagnerDuPouvoir("Carte Peuple","Vous avez gagné le deuxième prix de beauté. Recevez 10€.",10);
        Carte c2 = new CarteGagnerDuPouvoir("Carte Peuple","C’est votre anniversaire : chaque joueur doit vous donner 10€.",10);
        Carte c3 = new CarteGagnerDuPouvoir("Carte Peuple","Commission d’expert immobilier. Recevez 25€.",25);
        Carte c4 = new CarteGagnerDuPouvoir("Carte Peuple","La vente de vos stocks vous rapporte. Recevez 50€.",50);
        Carte c5 = new CarteGagnerDuPouvoir("Carte Peuple","Vous héritez de 100€.",100);
        Carte c6 = new CarteGagnerDuPouvoir("Carte Peuple","Votre placement vous rapporte. Recevez 100€.",100);
        Carte c7 = new CarteGagnerDuPouvoir("Carte Peuple","Votre assurance vie cous rapporte. Recevez 100€.",100);
        Carte c8 = new CarteGagnerDuPouvoir("Carte Peuple","Les impôts vous remboursent. Recevez 200€.",200);
        Carte c9 = new CarteGagnerDuPouvoir("Carte Peuple","Erreur de la Banque en votre faveur. Recevez 200€.",200);
        Carte c10 = new CarteDeplacement("Carte Peuple","Avancez jusqu’à la case Départ (Recevez 200€).", this.getCaseNumero(1));
        Carte c11 = new CarteGagnerDuPouvoir("Carte Peuple","Frais de scolarité. Payez 50€.",50);
        Carte c12 = new CarteGagnerDuPouvoir("Carte Peuple","Visite chez le Médecin. Payez 50€.",50);
        Carte c13 = new CarteGagnerDuPouvoir("Carte Peuple","Frais d’hospitalisation. Payez 100€.",100);
        Carte c14 = new CarteGagnerDuPouvoir("Carte Peuple","Vous devez faire des travaux sur vos propriétés : versez 40€ pour chaque maison et 115€ pour chaque hôtel que vous possédez.",40);
        Carte c15 = new CarteAllerEnPrison("Carte Peuple","Allez en Prison. Avancez tout droit en Prison. Ne passez pas par la case Départ. Ne recevez pas 200€.");

        // Ajout des cartes dans le paquet
        this.cartesPeuple.add(c1);
        this.cartesPeuple.add(c2);
        this.cartesPeuple.add(c3);
        this.cartesPeuple.add(c4);
        this.cartesPeuple.add(c5);
        this.cartesPeuple.add(c6);
        this.cartesPeuple.add(c7);
        this.cartesPeuple.add(c8);
        this.cartesPeuple.add(c9);
        this.cartesPeuple.add(c10);
        this.cartesPeuple.add(c11);
        this.cartesPeuple.add(c12);
        this.cartesPeuple.add(c13);
        this.cartesPeuple.add(c14);
        this.cartesPeuple.add(c15);
	}

	private void genererCartesEvenement() {
		// TODO Auto-generated method stub

	}



	/**
	 *Genere l'ensemble des cases du plateau avec leurs specificites propres
	 *
	 */
	private void genererCasesPlateau() {
		//Creation de la liste pour stocker les cases
		this.cases = new ArrayList<Case>();
		//Instanciation d'une case
		CaseDepart c1 = new CaseDepart();
		//Ajout de la case a la liste de cases du plateau
		this.cases.add(c1);
		Territoire c2 = new Territoire("Cul-De-Sac", ECouleurCase.violet ,60,30,50,new int[] {2,10,30,90,160,250});
		this.cases.add(c2);
		CaseEvenement c3 = new CaseEvenement();
		this.cases.add(c3);
		Territoire c4 = new Territoire("La Ferme du Père Magotte", ECouleurCase.violet ,60,30,50, new int[] {4,20,60,180,320,450} );
		this.cases.add(c4);
		CaseImpots c5 = new CaseImpots("Vu par le Palantir");
		this.cases.add(c5);
		Monture c6 = new Monture("Bill le Poney");
		this.cases.add(c6);
		Territoire c7 = new Territoire("Bac de Brandebouc",ECouleurCase.blanc, 100,50,50, new int[]{6,30,90,270,400,550});
		this.cases.add(c7);
		CasePeuple c8 = new CasePeuple();
		this.cases.add(c8);
		Territoire c9 = new Territoire("Brie", ECouleurCase.blanc,100,50,50,new int[] {6,30,90,270,400,550} );
		this.cases.add(c9);
		Territoire c10 = new Territoire("Amon Sûl", ECouleurCase.blanc,120,60,50,new int[] {8,40,100,300,450,600});
		this.cases.add(c10);
		CasePrison c11 = new CasePrison();
		this.cases.add(c11);
		Territoire c12 = new Territoire("Gué de Bruinen", ECouleurCase.rose,140,70,100,new int[] {10,50,150,450,625,750});
		this.cases.add(c12);
		BatonDeMagicien c13 = new BatonDeMagicien("Bâton de Gandalf");
		this.cases.add(c13);
		Territoire c14 = new Territoire("Fondcombe", ECouleurCase.rose,140,70,100, new int[] {10,50,150,450,625,750});
		this.cases.add(c14);
		Territoire c15 = new Territoire("Col de Caradhras", ECouleurCase.rose, 160,80,100, new int[] {12,60,180,500,700,900});
		this.cases.add(c15);
		Monture c16 = new Monture("Asfaloth");
		this.cases.add(c16);
		Territoire c17 = new Territoire("Mines de la Moria",ECouleurCase.orange, 150,90,100,new int[] {14,70,200,550,750,950});
		this.cases.add(c17);
		CaseEvenement c18 = new CaseEvenement();
		this.cases.add(c18);
		Territoire c19 = new Territoire("Forêt de La Lorien",ECouleurCase.orange, 180,90,100,new int[] {14,70,200,550,750,950});
		this.cases.add(c19);
		Territoire c20 = new Territoire("Chutes de Rauros",ECouleurCase.orange,200,100,100, new int[] {16,80,220,600,800,1000});
		this.cases.add(c20);
		CaseParcGratuit c21 = new CaseParcGratuit();
		this.cases.add(c21);
		Territoire c22 = new Territoire("Trouée du Rohan", ECouleurCase.rouge, 220,110,150, new int[] {18,90,250,700,875,1050});
		this.cases.add(c22);
		CasePeuple c23 = new CasePeuple();
		this.cases.add(c23);
		Territoire c24 = new Territoire("Gouffre de Helm", ECouleurCase.rouge, 220,110,150, new int[] {18,90,250,700,875,1050});
		this.cases.add(c24);
		Territoire c25 = new Territoire("Edoras", ECouleurCase.rouge, 240,120,150, new int[] {20,100,300,750,925,1100});
		this.cases.add(c25);
		Monture c26 = new Monture("Arod");
		this.cases.add(c26);
		Territoire c27 = new Territoire("Forêt de Fangorn", ECouleurCase.jaune,260,130,150, new int[] {22,110,330,800,975,1150});
		this.cases.add(c27);
		Territoire c28 = new Territoire("Ouestfolde", ECouleurCase.jaune,260,130,150, new int[] {22,110,330,800,975,1150});
		this.cases.add(c28);
		BatonDeMagicien c29 = new BatonDeMagicien("Bâton de Saroumane");
		this.cases.add(c29);
		Territoire c30 = new Territoire("Isengard", ECouleurCase.jaune,280,140,150, new int[] {24,120,360,850,1025,1200});
		this.cases.add(c30);
		CaseAllerPrison c31 = new CaseAllerPrison();
		this.cases.add(c31);
		Territoire c32 = new Territoire("Osgiliath", ECouleurCase.vert,300,150,200, new int[] {26,130,390,900,1100,1275});
		this.cases.add(c32);
		Territoire c33 = new Territoire("Champs de Pelennor", ECouleurCase.vert,300,150,200, new int[] {26,130,390,900,1100,1275});
		this.cases.add(c33);
		CaseEvenement c34 = new CaseEvenement();
		this.cases.add(c34);
		Territoire c35 = new Territoire("Minas Tirith", ECouleurCase.vert,320,160,200, new int[] {28,150,450,1000,1200,1400});
		this.cases.add(c35);
		Monture c36 = new Monture("Gripoil");
		this.cases.add(c36);
		CasePeuple c37 = new CasePeuple();
		this.cases.add(c37);
		Territoire c38 = new Territoire("Barad Dûr", ECouleurCase.bleu,350,175,200, new int[] {35,175,500,1100,1300,1500});
		this.cases.add(c38);
		CaseImpots c39 = new CaseImpots("Antre d'Arachnée");
		this.cases.add(c39);
		Territoire c40 = new Territoire("Montagne du Destin", ECouleurCase.bleu,400,200,200, new int[] {50,200,600,1400,1700,2000});
		this.cases.add(c40);

		//ajouter les positions des cases sur le plateau
		for(Case c:cases) {
			int numCase = cases.indexOf(c);
			c.setNumCase(numCase);
		}

	}



	/**
	 * @param numero
	 * @return 
	 * @return
	 * Methode permettant d'acceder plus simplement a une case donnee du plateau. 
	 */
	public Case getCaseNumero(int numero){
		return this.cases.get(numero-1);
	}

	public ArrayList<Case>getCases(){
		return this.cases;
	}












	//	public String afficherPositionJoueurs() {
	//		String aff = "--- Position des joueurs ---\n\n";
	//		for(int i=0;i<this.joueurs.size();i++) {
	//			Joueur jCourant = this.joueurs.get(i);
	//			aff+= "[ " + this.joueurs.get(i).getNomPion() + " : case n° "+ this.positionsJoueurs.get(jCourant.getPion()).getNumCase()+" ]\n";
	//		}
	//		return aff;
	//	}



}
