package fr.ut1.rtai.monopoly;

import java.util.ArrayList;


import fr.ut1.rtai.monopoly.cases.*;

public class Plateau {
	
	private ArrayList<Case> cases; //choix d'une ArrayList car suite de cases ordonnees

	public Plateau() {
		//1 - Creer les cases du plateau
		this.genererCasesPlateau();
		
		
		
		
		//this.genererJoueurs(this.nbJoueurs, null);


		//Creer les joueurs
//		this.joueurs=new ArrayList<Joueur>();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Combien de joueurs participent à la partie ?");
//		this.nbJoueurs = scanner.nextInt();
//		scanner.nextLine();
//		for (int i=0; i<nbJoueurs;i++) {
//			System.out.println("Saisissez le prénom du joueur "+(i+1)+" :");
//			String prenom = scanner.nextLine();
//			this.joueurs.add(new Joueur(prenom));
//		}

		//TODO: changer le bloc qui suit par la methode affecterPions qui demande aux joueurs a tour de rôle quel pion ils prennent (eviter les doublons
//		System.out.println("--- Choix des pions ---\n");
//		EPion[] listePions = EPion.values();
//		for (int i = 0; i < 5; i++) {
//			System.out.println((i+1)+ " - "+ listePions[i].afficherPion());
//
//		}
//
//		for (Joueur j : this.joueurs) {		
//			System.out.println("\n"+j.getNom()+ ", veuillez choisir votre personnage : (entrer le chiffre correspondant)" );
//			int choixPion = scanner.nextInt();
//			//affecter le pion au joueur
//			j.setPion(this.pionSelonChiffreChoisi(choixPion));
//		}
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
		CaseImpots c5 = new CaseImpots("Vous avez été vu par le Palantir! Vous perdez 200 de pouvoir. ");
		this.cases.add(c5);
		Monture c6 = new Monture("Bill le Poney",200,100);
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
		BatonDeMagicien c13 = new BatonDeMagicien("Bâton de Gandalf", 150, 75);
		this.cases.add(c13);
		Territoire c14 = new Territoire("Fondcombe", ECouleurCase.rose,140,70,100, new int[] {10,50,150,450,625,750});
		this.cases.add(c14);
		Territoire c15 = new Territoire("Col de Caradhras", ECouleurCase.rose, 160,80,100, new int[] {12,60,180,500,700,900});
		this.cases.add(c15);
		Monture c16 = new Monture("Asfaloth",200,100);
		this.cases.add(c16);
		Territoire c17 = new Territoire("Mines de la Moria",ECouleurCase.orange, 150,90,100,new int[] {14,70,200,550,750,950});
		this.cases.add(c17);
		CaseEvenement c18 = new CaseEvenement();
		this.cases.add(c18);
		Territoire c19 = new Territoire("Forêt de La Lorien",ECouleurCase.orange, 180,90,100,new int[] {14,70,200,550,750,950});
		this.cases.add(c19);
		Territoire c20 = new Territoire("Les chutes de Rauros",ECouleurCase.orange,200,100,100, new int[] {16,80,220,600,800,1000});
		this.cases.add(c20);
		CaseParcGratuit c21 = new CaseParcGratuit();
		this.cases.add(c21);
		Territoire c22 = new Territoire("La trouée du Rohan", ECouleurCase.rouge, 220,110,150, new int[] {18,90,250,700,875,1050});
		this.cases.add(c22);
		CasePeuple c23 = new CasePeuple();
		this.cases.add(c23);
		Territoire c24 = new Territoire("Le Gouffre de Helm", ECouleurCase.rouge, 220,110,150, new int[] {18,90,250,700,875,1050});
		this.cases.add(c24);
		Territoire c25 = new Territoire("Edoras", ECouleurCase.rouge, 240,120,150, new int[] {20,100,300,750,925,1100});
		this.cases.add(c25);
		Monture c26 = new Monture("Arod",200,100);
		this.cases.add(c26);
		Territoire c27 = new Territoire("Forêt de Fangorn", ECouleurCase.jaune,260,130,150, new int[] {22,110,330,800,975,1150});
		this.cases.add(c27);
		Territoire c28 = new Territoire("Ouestfolde", ECouleurCase.jaune,260,130,150, new int[] {22,110,330,800,975,1150});
		this.cases.add(c28);
		BatonDeMagicien c29 = new BatonDeMagicien("Bâton de Saroumane",150,75);
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
		Monture c36 = new Monture("Gripoil",200,100);
		this.cases.add(c36);
		CasePeuple c37 = new CasePeuple();
		this.cases.add(c37);
		Territoire c38 = new Territoire("Barad Dûr", ECouleurCase.bleu,350,175,200, new int[] {35,175,500,1100,1300,1500});
		this.cases.add(c38);
		CaseImpots c39 = new CaseImpots("Vous tombez dans l'antre d'Arachnée ! Vous perdez 75 de pouvoir.");
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