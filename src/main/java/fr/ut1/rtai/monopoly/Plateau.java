package fr.ut1.rtai.monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import fr.ut1.rtai.monopoly.cartes.Carte;
import fr.ut1.rtai.monopoly.cartes.CarteAllerEnPrison;
import fr.ut1.rtai.monopoly.cartes.CarteDeplacement;
import fr.ut1.rtai.monopoly.cartes.CarteGagnerDuPouvoir;
import fr.ut1.rtai.monopoly.cartes.CartePerdreDuPouvoir;
import fr.ut1.rtai.monopoly.cartes.CarteSortirDePrison;
import fr.ut1.rtai.monopoly.cases.*;

public class Plateau {
	
	public static final Map<ECouleurCase, Integer> NBLOTPARCOULEUR ;
	static {
		HashMap<ECouleurCase, Integer> tmpHash = new HashMap<ECouleurCase, Integer>();
		tmpHash.put(ECouleurCase.violet, 2);
		tmpHash.put(ECouleurCase.blanc, 3);
		tmpHash.put(ECouleurCase.rose, 3);
		tmpHash.put(ECouleurCase.orange, 3);
		tmpHash.put(ECouleurCase.jaune, 3);
		tmpHash.put(ECouleurCase.rouge, 3);
		tmpHash.put(ECouleurCase.vert, 3);
		tmpHash.put(ECouleurCase.bleu, 2);
		NBLOTPARCOULEUR = Collections.unmodifiableMap(tmpHash);
	
	}
	private PartieDeMonopoly partie;
	private ArrayList<Case> cases; //choix d'une ArrayList car suite de cases ordonnees
	private ArrayList<Carte> cartesPeuple;
	private ArrayList<Carte> cartesEvenement;
	private ArrayList<Territoire> territoires; // servira pour la gestion de l'anneau unique
	

	public Plateau() {

		this.genererCasesPlateau();
		this.territoires = new ArrayList<Territoire>();
		for(Case c: this.cases) {
			if(c instanceof Territoire) {
				this.territoires.add((Territoire) c);
			}
		}
		
		this.genererCartesPeuple();
		this.genererCartesEvenement();
		for (Carte c : this.cartesEvenement) {
			c.setPlateau(this);
		}
		for (Carte c : this.cartesPeuple) {
			c.setPlateau(this);
		}

		
		// positionner l'anneau sur le plateau
		this.territoires.get(0).positionnerAnneauUnique();
		
		
	}

	private void genererCartesPeuple() {
		  // Creation du paquet
        this.cartesPeuple = new ArrayList<Carte>();
        // Cr??ation des cartes
        Carte c1 = new CarteGagnerDuPouvoir("Carte Peuple","Vous vendez votre vieille ??p??e rouill??e. Vous gagnez 10 de pouvoir.",10);
        Carte c2 = new CarteGagnerDuPouvoir("Carte Peuple","Vous vous endormez paisiblement aupr??s du Vieux Saule. Vous gagnez 10 de pouvoir.",10);
        Carte c3 = new CarteGagnerDuPouvoir("Carte Peuple","Lors d'une promenade dans les bois, vous entendez le chant des elfes. Vous gagnez 25 de pouvoir.",25);
        Carte c4 = new CarteGagnerDuPouvoir("Carte Peuple","Vous tombez sur le garde-manger de Saroumane ! Vous gagnez 50 de pouvoir.",50);
        Carte c5 = new CarteGagnerDuPouvoir("Carte Peuple","Lors d'une exp??dition dans les mines de la Moria, vous tombez sur un filon de Mithril. Vous gagnez 100 de pouvoir.",100);
        Carte c6 = new CartePerdreDuPouvoir("Carte Peuple","Lors d'une exp??dition dans les mines de la Moria, vous r??veillez un Balrog de Morgoth! Vous perdez 100 de pouvoir. (Fuyez, pauvre fou!)",100);
        Carte c7 = new CarteGagnerDuPouvoir("Carte Peuple","La r??colte d'herbe a pipe de la Comt?? a ??t?? bonne cette ann??e. Vous gagnez 100 de pouvoir.",100);
        Carte c8 = new CarteGagnerDuPouvoir("Carte Peuple","Vos exp??ditions dans les terres d??sol??es du Mordor vous rapportent. Vous gagnez 200 de pouvoir.",200);
        Carte c9 = new CarteGagnerDuPouvoir("Carte Peuple","Un sage Hobbit vous apprend le secret de la meilleure bi??re de la Comt??! Vous gagnez 200 de pouvoir.",200);
        Carte c10 = new CarteDeplacement("Carte Peuple","Avancez jusqu????? la case D??part (Recevez 200 de pouvoir).", this.getCaseNumero(1));
        Carte c11 = new CartePerdreDuPouvoir("Carte Peuple","Vous tombez sur une hordre d'Uruk-hai m??contents. Vous perdez 50 de pouvoir.",50);
        Carte c12 = new CartePerdreDuPouvoir("Carte Peuple","Votre derni??re soir??e au Poney Fringant a ??t?? un peu trop arros??e... Vous perdez 50 de pouvoir.",50);
        Carte c13 = new CartePerdreDuPouvoir("Carte Peuple","Oh non ! Vous vous faites pourchasser par une horde de Nazguls! Vous perdez 100 de pouvoir.",100);
        Carte c14 = new CartePerdreDuPouvoir("Carte Peuple","Vous tombez du haut du pont de Khazad-D??m! Vous perdez 100 de pouvoir.",100);
        Carte c15 = new CarteAllerEnPrison("Carte Peuple","Les cavaliers noirs vous ont attrap??.e. Vous ??tes amen??.e en prison pour 3 tours");
        Carte c16 = new CarteSortirDePrison("Carte Peuple", "Vous vous ??vadez de prison. Vous pouvez conserver cette carte et vous en servir ?? tout moment.");

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
        this.cartesPeuple.add(c16);
	}
	

	
	private void genererCartesEvenement() {
        this.cartesEvenement = new ArrayList<Carte>();
        // Cr??ation des cartes
        Carte c1 = new CarteGagnerDuPouvoir("Carte Evenement","En exp??dition dans les montagnes brumeuses, vous trouvez un pr??cieux tr??sor. Vous gagnez 50 de pouvoir.",50);
        Carte c2 = new CarteGagnerDuPouvoir("Carte Evenement","Votre petite auberge ?? Edoras fait le bonheur de ses habitu??s. Vous gagnez 50 de pouvoir.",50);
        Carte c3 = new CarteDeplacement("Carte Evenement","Avancez jusqu????? la case D??part (Recevez 200 de pouvoir).", this.getCaseNumero(1));
        Carte c4 = new CarteDeplacement("Carte Evenement","Aventurez vous jusqu???au Gu?? de Bruinen. Si vous passez par la case D??part, recevez 200 de pouvoir.", this.getCaseNumero(12));
        Carte c5 = new CarteDeplacement("Carte Evenement","Galopez jusqu'?? Edoras. Si vous passez par la case D??part, recevez 200 de pouvoir.", this.getCaseNumero(25));
        Carte c6 = new CarteDeplacement("Carte Evenement","Connaissez-vous Asfaloth ? Rendez-vous sur la case Asfaloth pour rencontrer cette brave monture. Si vous passez par la case D??part, recevez 200 de pouvoir.", this.getCaseNumero(16));
        Carte c7 = new CarteGagnerDuPouvoir("Carte Evenement","Vous vendez votre r??colte de champignons ?? deux hobbits enthousiastes. Vous gagnez 15 de pouvoir.",15);
        Carte c8 = new CartePerdreDuPouvoir("Carte Evenement","Vous avez fum?? trop d'herbe ?? pipe ! Vous perdes 25 de pouvoir.",25);
        Carte c9 = new CartePerdreDuPouvoir("Carte Evenement","Vous avez ??t?? ??lu Grand Intendant du Gondor. Vous donnez 150 de pouvoir ?? la ville par charit??.",150);
        Carte c10 = new CarteDeplacement("Carte Evenement","Allez ?? la rencontre des elfes de la Lorien. Si vous passez par la case d??part, recevez 200 de pouvoir.", this.getCaseNumero(19));
        Carte c11 = new CarteGagnerDuPouvoir("Carte Evenement","Vous profitez du mauvais temps pour lire les vieux parchemins des archives de Minas Tirith. Vous gagnez 50 de pouvoir.",50);
        Carte c12 = new CarteDeplacement("Carte Evenement","Allez qu??rir le conseil de Gandalf. Si vous passez par la case D??part, recevez 200 de pouvoir.",this.getCaseNumero(13));
        Carte c13 = new CartePerdreDuPouvoir("Carte Evenement","Vous avez trop mang?? de pain elfique ! Vous faites une sieste digestive et perdez 100 de pouvoir.",100);
        Carte c14 = new CarteDeplacement("Carte Evenement","Rendez-vous ?? la Montagne du Destin.", this.getCaseNumero(40));
        Carte c15 = new CarteAllerEnPrison("Carte Evenement","Une horde de loups Wargs vous pourchasse jusque dans les ge??les de l'Isengard. Vous croupissez en prison pendant 3 tours.");
        Carte c16 = new CarteSortirDePrison("Carte Evenement", "Vous vous ??vadez de prison. Vous pouvez conserver cette carte et vous en servir ?? tout moment.");
         
        // Ajout des cartes dans le paquet
        this.cartesEvenement.add(c1);
        this.cartesEvenement.add(c2);
        this.cartesEvenement.add(c3);
        this.cartesEvenement.add(c4);
        this.cartesEvenement.add(c5);
        this.cartesEvenement.add(c6);
        this.cartesEvenement.add(c7);
        this.cartesEvenement.add(c8);
        this.cartesEvenement.add(c9);
        this.cartesEvenement.add(c10);
        this.cartesEvenement.add(c11);
        this.cartesEvenement.add(c12);
        this.cartesEvenement.add(c13);
        this.cartesEvenement.add(c14);
        this.cartesEvenement.add(c15);
        this.cartesEvenement.add(c16);
        


	}
	
	public void melangerLesPaquets(){
		//M??langer les paquets
		Collections.shuffle(this.cartesEvenement);
		Collections.shuffle(this.cartesPeuple);
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
		Territoire c4 = new Territoire("La Ferme du P??re Magotte", ECouleurCase.violet ,60,30,50, new int[] {4,20,60,180,320,450} );
		this.cases.add(c4);
		CaseImpots c5 = new CaseImpots("Vu par le Palantir");
		this.cases.add(c5);
		Monture c6 = new Monture("Bill le Poney");
		this.cases.add(c6);
		Territoire c7 = new Territoire("Le Bac de Brandebouc",ECouleurCase.blanc, 100,50,50, new int[]{6,30,90,270,400,550});
		this.cases.add(c7);
		CasePeuple c8 = new CasePeuple();
		this.cases.add(c8);
		Territoire c9 = new Territoire("Brie", ECouleurCase.blanc,100,50,50,new int[] {6,30,90,270,400,550} );
		this.cases.add(c9);
		Territoire c10 = new Territoire("Amon S??l", ECouleurCase.blanc,120,60,50,new int[] {8,40,100,300,450,600});
		this.cases.add(c10);
		CasePrison c11 = new CasePrison();
		this.cases.add(c11);
		Territoire c12 = new Territoire("Le Gu?? de Bruinen", ECouleurCase.rose,140,70,100,new int[] {10,50,150,450,625,750});
		this.cases.add(c12);
		BatonDeMagicien c13 = new BatonDeMagicien("Le B??ton de Gandalf");
		this.cases.add(c13);
		Territoire c14 = new Territoire("Fondcombe", ECouleurCase.rose,140,70,100, new int[] {10,50,150,450,625,750});
		this.cases.add(c14);
		Territoire c15 = new Territoire("Le Col de Caradhras", ECouleurCase.rose, 160,80,100, new int[] {12,60,180,500,700,900});
		this.cases.add(c15);
		Monture c16 = new Monture("Asfaloth");
		this.cases.add(c16);
		Territoire c17 = new Territoire("Les Mines de la Moria",ECouleurCase.orange, 150,90,100,new int[] {14,70,200,550,750,950});
		this.cases.add(c17);
		CaseEvenement c18 = new CaseEvenement();
		this.cases.add(c18);
		Territoire c19 = new Territoire("La For??t de La Lorien",ECouleurCase.orange, 180,90,100,new int[] {14,70,200,550,750,950});
		this.cases.add(c19);
		Territoire c20 = new Territoire("Les Chutes de Rauros",ECouleurCase.orange,200,100,100, new int[] {16,80,220,600,800,1000});
		this.cases.add(c20);
		CaseParcGratuit c21 = new CaseParcGratuit();
		this.cases.add(c21);
		Territoire c22 = new Territoire("La Trou??e du Rohan", ECouleurCase.rouge, 220,110,150, new int[] {18,90,250,700,875,1050});
		this.cases.add(c22);
		CasePeuple c23 = new CasePeuple();
		this.cases.add(c23);
		Territoire c24 = new Territoire("Le Gouffre de Helm", ECouleurCase.rouge, 220,110,150, new int[] {18,90,250,700,875,1050});
		this.cases.add(c24);
		Territoire c25 = new Territoire("Edoras", ECouleurCase.rouge, 240,120,150, new int[] {20,100,300,750,925,1100});
		this.cases.add(c25);
		Monture c26 = new Monture("Arod");
		this.cases.add(c26);
		Territoire c27 = new Territoire("La For??t de Fangorn", ECouleurCase.jaune,260,130,150, new int[] {22,110,330,800,975,1150});
		this.cases.add(c27);
		Territoire c28 = new Territoire("L'Ouestfolde", ECouleurCase.jaune,260,130,150, new int[] {22,110,330,800,975,1150});
		this.cases.add(c28);
		BatonDeMagicien c29 = new BatonDeMagicien("Le B??ton de Saroumane");
		this.cases.add(c29);
		Territoire c30 = new Territoire("Isengard", ECouleurCase.jaune,280,140,150, new int[] {24,120,360,850,1025,1200});
		this.cases.add(c30);
		CaseAllerPrison c31 = new CaseAllerPrison();
		this.cases.add(c31);
		Territoire c32 = new Territoire("Osgiliath", ECouleurCase.vert,300,150,200, new int[] {26,130,390,900,1100,1275});
		this.cases.add(c32);
		Territoire c33 = new Territoire("Les Champs de Pelennor", ECouleurCase.vert,300,150,200, new int[] {26,130,390,900,1100,1275});
		this.cases.add(c33);
		CaseEvenement c34 = new CaseEvenement();
		this.cases.add(c34);
		Territoire c35 = new Territoire("Minas Tirith", ECouleurCase.vert,320,160,200, new int[] {28,150,450,1000,1200,1400});
		this.cases.add(c35);
		Monture c36 = new Monture("Gripoil");
		this.cases.add(c36);
		CasePeuple c37 = new CasePeuple();
		this.cases.add(c37);
		Territoire c38 = new Territoire("Barad D??r", ECouleurCase.bleu,350,175,200, new int[] {35,175,500,1100,1300,1500});
		this.cases.add(c38);
		CaseImpots c39 = new CaseImpots("L'Antre d'Arachn??e");
		this.cases.add(c39);
		Territoire c40 = new Territoire("La Montagne du Destin", ECouleurCase.bleu,400,200,200, new int[] {50,200,600,1400,1700,2000});
		this.cases.add(c40);

		//ajouter les positions des cases sur le plateau
		for(Case c:cases) {
			int numCase = cases.indexOf(c);
			c.setNumCase(numCase);
		}

	}
	
	// -------- Getters et setters utiles ----------
	public ArrayList<Carte> getCartesPeuple(){
		return this.cartesPeuple;
	}
	
	public ArrayList<Carte> getCartesEvenement(){
		return this.cartesEvenement;
	}

	public void setPartieDeMonopoly(PartieDeMonopoly p) {
		this.partie=p;
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
	
	// ------- M??thodes d'affichage --------
	//Utiles aux tests uniquement
	public void afficherCartesEvenement() {
		for(Carte c : this.cartesEvenement) {
			System.out.println(c);
		}
	}
	
	public void afficherCartesPeuple() {
		for(Carte c : this.cartesPeuple) {
			System.out.println(c);
		}
	}






}
