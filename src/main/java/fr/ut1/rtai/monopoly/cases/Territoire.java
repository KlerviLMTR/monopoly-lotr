package fr.ut1.rtai.monopoly.cases;


import fr.ut1.rtai.monopoly.ECouleurCase;
import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class Territoire extends CasePropriete {
	
	private int [] tableDesLoyers;
	private int coutConstruction;
	private ECouleurCase couleur;
	private int nbPlacesFortes;
	private boolean possedeForteresse;
	private int loyerActuel;
	private int prixConstruVendue;
	private boolean possedeAnneauUnique;
	
	
	public Territoire(String nom,ECouleurCase coul,int coutAchat,int valHyp, int coutConstru, int[] loyers) {
		super(nom,coutAchat, valHyp);
		this.coutConstruction=coutConstru;
		this.tableDesLoyers=loyers;
		this.couleur=coul;
		this.nbPlacesFortes=0;
		this.possedeForteresse=false;
		this.possedeAnneauUnique=false;
		this.prixConstruVendue=this.coutConstruction/2;
		this.loyerActuel=this.tableDesLoyers[0];
	}
	
	// --------- Getters et setters utiles --------
	
	public ECouleurCase getCouleurCase() {
		return this.couleur;
	}

	public int[] getTableDesLoyers() {
		return this.tableDesLoyers;
	}

	public int getCoutConstruction() {
		return this.coutConstruction;
	}
	
	@Override
	public int getLoyerActuel() {
		return this.loyerActuel;
	}
	
	
	@Override
	public void setLoyerActuel(int loy) {
		this.loyerActuel = loy;
	}


	
    public boolean getPossedeForteresse() {
    	return this.possedeForteresse;
    }
    
    public int getNbPlacesFortes() {
    	return this.nbPlacesFortes;
    }
    
    
    public Joueur getProprietaire() {
    	return super.getProprietaire();
    }
    
	public void setNbPlacesFortes(int i) {
		this.nbPlacesFortes=0;
	}
    
	public void setPossedeForteresse(boolean b) {
		this.possedeForteresse=false;
	}
    // -------------------------
    
    public void positionnerAnneauUnique() {
    	this.possedeAnneauUnique=true;
    }
    
    public void enleverAnneauUnique() {
    	this.possedeAnneauUnique=false;
    }
    
    public boolean estProprietaire(Joueur j) {
    	return  super.getProprietaire()==j;
    }
    
    // ------------- Methodes relatives ?? la constructions de b??timents ------------------
    
    /**
     * V??rifie qu'un joueur a le droit de construire une construction quelconque. Aucun de ses terrains de m??me couleur ne doit ??tre hypoth??qu??.
     * @return
     */
    public boolean peutConstruireConstru() {
    	return !this.getProprietaire().estTerrainHypothequeSurLot(this.couleur);
    }
    
    public boolean peutConstruireForteresse() {
    	return this.getProprietaire().estPropDeTousLesLotsCoul(this.couleur) ;
    }
    
    
	public void construireForteresse() { 
		if(this.peutConstruireForteresse()) {
			if(this.nbPlacesFortes<4) {
	    		PartieDeMonopoly.affichageMessageDelai(15, ". . . Il vous faut 4 places fortes pour pouvoir construire une forteresse.");		
			}
			else if(this.getProprietaire().getSolde() < this.coutConstruction) {
	    		PartieDeMonopoly.affichageMessageDelai(15, ". . . Mais vous n'avez pas assez de pouvoir.");		

			}
			else {
				this.nbPlacesFortes=0;
				this.getProprietaire().perdreDuPouvoir(this.coutConstruction);
	        	System.out.println("Vous remplacez vos places fortes par une forteresse pour "+this.coutConstruction+" ???.");
	        	this.setLoyerActuel(this.tableDesLoyers[5]);
				this.possedeForteresse=true;
			}
		}
		else {
    		PartieDeMonopoly.affichageMessageDelai(15, ". . . Vous devez ??tre propri??taire de tous les lots de couleur "+ this.couleur + " pour pouvoir construire une forteresse.");					
		}
		
	}
    
    public void construirePlaceForte() {
    	if (this.nbPlacesFortes>=4) {
    		PartieDeMonopoly.affichageMessageDelai(15, ". . . Il y a d??j?? 4 places fortes sur ce terrain. Vous ne pouvez pas en construire davantage.");		  		
    	}
    	else if (this.getProprietaire().getSolde()<this.coutConstruction) {
    		PartieDeMonopoly.affichageMessageDelai(15, ". . . Mais vous n'avez pas assez de pouvoir.");		  		
    	}
    	else {
        	this.nbPlacesFortes+=1;
        	this.setLoyerActuelSelonNbPF();
        	this.getProprietaire().perdreDuPouvoir(this.coutConstruction);
        	System.out.println("Vous construisez une place forte pour "+this.coutConstruction+" ???.");
    	}
    }
    
    public void vendrePlaceForte() {
    	if (this.nbPlacesFortes==0) {
    		PartieDeMonopoly.affichageMessageDelai(15, ". . . Mais vous n'avez aucune place forte ?? d??truire.");		  		
    	}
    	else {
    		this.nbPlacesFortes--;
        	this.setLoyerActuelSelonNbPF();
    		this.getProprietaire().gagnerduPouvoir(this.prixConstruVendue);
        	System.out.println("Vous vendez une place forte pour "+this.prixConstruVendue+" ???.");
    	}
    	
    }
    
    public void vendreForteresse() {
    	if (!this.possedeForteresse) {
    		PartieDeMonopoly.affichageMessageDelai(15, ". . . Mais vous n'avez pas de forteresse ?? d??truire.");
    	}
    	else {
    		this.possedeForteresse=false;
    		this.getProprietaire().gagnerduPouvoir(this.prixConstruVendue);
        	System.out.println("Vous vendez une forteresse pour "+this.prixConstruVendue+" ???.");
        	this.setLoyerActuel(this.tableDesLoyers[0]);

    	}
    }
    
    public boolean estTerrainVide() {
    	return !this.possedeForteresse && this.nbPlacesFortes==0;
    }
    
    
    //utile si le terrain est nu. Sinon, loyer g??r?? par l'achat/vente de constructions
    public void calculerLeLoyerActuel() {
    	if (this.estTerrainVide()) {
    		if (this.getProprietaire().possedeTousLesTerrainsSurLotCouleur(this.couleur)) {
    			System.out.println(loyerActuel);
    			int nouveauLoy = loyerActuel*2;
    			System.out.println(nouveauLoy);
    			this.setLoyerActuel(nouveauLoy);
    		}
    	}
    	
    }
    
    public void setLoyerActuelSelonNbPF() {
    	switch(this.nbPlacesFortes) {
    		case 0:
    			this.setLoyerActuel(this.tableDesLoyers[0]);
    			break;
    		case 1:
    			this.setLoyerActuel(this.tableDesLoyers[1]);
    			break;
    		case 2:
    			this.setLoyerActuel(this.tableDesLoyers[2]);
    			break;
    		case 3:
    			this.setLoyerActuel(this.tableDesLoyers[3]);
    			break;
    		case 4:
    			this.setLoyerActuel(this.tableDesLoyers[4]);			
    	}
    }

    // -------------------- M??thodes d'affichage des territoires ----------------------
    
    


	@Override
	public void afficherTabLoyers() {
		System.out.println("                              --- Loyers --- \n\n" );
		System.out.println("                         Loyer actuel :"+ this.loyerActuel+" ???\n" );
		PartieDeMonopoly.affichageMessageDelai(15, ">>> Obtenez toutes les terrains du lot de la m??me couleur pour voir les loyers de terrains nus augmenter !\n");
		System.out.println("                    - terrain nu : "+ this.tableDesLoyers[0] +" ???\n                    - 1 place forte : "+this.tableDesLoyers[1]+" ???\n                    - 2 places fortes : "+this.tableDesLoyers[2]+" ???\n                    - 3 places fortes : "+this.tableDesLoyers[3]+" ???\n                    - 4 places fortes : "+this.tableDesLoyers[4]+" ???\n                    - 1 forteresse : "+ this.tableDesLoyers[5]+ " ???\n");

	}
	
	
	public void afficherMenuPropAJoueur() {
		String menu="\n                       ??? Loyer actuel :"+this.loyerActuel+ " ??? ???\n\n                    1 - Hypoth??quer le terrain\n                    2 - Consulter la table des loyers\n                    3 - Construire une place forte pour "+this.coutConstruction+" ???\n                    4 - Construire une forteresse pour "+this.coutConstruction+" ??? + 4 places fortes\n                    5 - D??truire une place forte pour "+this.prixConstruVendue +" ???\n                    6 - D??truire la forteresse pour "+this.prixConstruVendue+" ???\n                    7 - Ne rien faire\n";
		System.out.println(menu);
	}
	
	@Override
	public boolean verifierNumMenuPropNonLibre(int numChoisi) throws IllegalArgumentException {
		if (!this.estEnHypotheque()) {
			if (numChoisi < 1 || numChoisi > 7) {
				throw new IllegalArgumentException("Num??ro choisi invalide.");
			}
		}
		else {
			if (numChoisi < 1 || numChoisi > 2) {
				throw new IllegalArgumentException("Num??ro choisi invalide.");
			}
		}
		return true;
	}
	
	
	@Override
	protected void mettreEnHypotheque(Joueur j) {
		if(this.possedeForteresse || this.nbPlacesFortes>0) {
			System.out.println("Vous devez d'abord vendre vos constructions avant de mettre ce terrain en hypoth??que !");
		}
		else {
			super.mettreEnHypotheque(j);
		}
	}
	
	
	@Override
	public boolean traiterChoixMenuPropAuJoueur(Joueur j, int choixMenu, boolean tourFini) throws InterruptedException {
		if (this.estEnHypotheque()) {
			switch(choixMenu){
				case 1:
					this.leverLHypotheque(j);
					break;
				case 2:
					System.out.println(MessagesJeu.choixNeRienFaire);
					tourFini=true;
			}
		}
		else {
			switch(choixMenu){
			case 1:
				this.mettreEnHypotheque(j);
				if (this.estEnHypotheque()) {
					tourFini=true;
				}
				break;
			case 2:
				this.afficherTabLoyers();
				break;
			case 3:
				if (this.peutConstruireConstru()) {
					this.construirePlaceForte();
				}
				else {
					System.out.println("Vous ne pouvez construire sur ce terrain car des terrains de m??me couleur vous appartenant sont hypoth??qu??s.");
				}
				break;
			case 4:
				if (this.peutConstruireConstru()) {
					this.construireForteresse();
				}
				else {
					System.out.println("Vous ne pouvez construire sur ce terrain car des terrains de m??me couleur vous appartenant sont hypoth??qu??s.");
				}
				break;
			case 5:
				this.vendrePlaceForte();
				break;
			case 6: 
				this.vendreForteresse();
				break;
			case 7:
				System.out.println(MessagesJeu.choixNeRienFaire);
				tourFini=true;
			}
		}
		return tourFini;

	}
	
	@Override
    public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n??"+Integer.valueOf(getNumCase()+1);
		if (this.getProprietaire()==null) {
			aff +=  "                           ???? "+this.getNomCase()+" ???? - LIBRE                         "+this.couleur+"\n" + MessagesJeu.affichageSepCase +"\n          "+ MessagesJeu.descriptionCaseTerritoire+"\n                                   Prix : "+this.getCoutAchat()+ " ???\n\n                         ----------------------------\n";
		}
	
		else {
				if (this.estEnHypotheque()) {
					aff +="                ???? "+this.getNomCase()+" ???? - EN HYPOTHEQUE                  "+this.couleur+"\n" + MessagesJeu.affichageSepCase + "\n                                   Propri??taire : "+this.getProprietaire().getNomPion()+"\n";
				}
				else {
						aff +="                    ???? "+this.getNomCase()+" ???? - "+ this.getProprietaire().getNomPion().toUpperCase()+"                      "+ this.couleur+"\n" + MessagesJeu.affichageSepCase + "\n                                    Propri??taire : "+this.getProprietaire()+"\n";			
					}

				if (this.nbPlacesFortes==1) {
						aff +="\n                                          ????              \n                                     ------------\n";
				}
				else if(this.nbPlacesFortes==2) {
					aff +="\n                                         ???? ????             \n                                     ------------\n";
				}
				else if(this.nbPlacesFortes==3) {
					aff +="\n                                        ???? ???? ????           \n-                                     -----------\n";
				}
				else if(this.nbPlacesFortes==4) {
					aff +="\n                                       ???? ???? ???? ????            \n                                     ------------\n";
				}
				else if(this.possedeForteresse) {
					aff +="\n                                       ????            \n                                     ------------\n";
				}
				if (!this.estEnHypotheque()) {
					aff += "                                   Loyer actuel : "+this.loyerActuel+" ???.\n";
				}

				else {
					aff +="                      Loyer : 0 ???.\n";      
				}
				if(this.getProprietaire().estPropDeTousLesLotsCoul(this.couleur)){
					aff +="\n??? Tous les lots de cette couleur sont poss??d??s par "+this.getProprietaire()+". Les loyers des terrains nus sont doubl??s. ???\n";
				}
				
			}
		System.out.println(aff);
		}

    

    
    

}