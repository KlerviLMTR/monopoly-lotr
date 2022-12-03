package fr.ut1.rtai.monopoly.cases;

import java.util.Scanner;

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
	private boolean possedeAnneauUnique;
	
	public Territoire(String nom,ECouleurCase coul,int coutAchat,int valHyp, int coutConstru, int[] loyers) {
		super(nom,coutAchat, valHyp);
		this.coutConstruction=coutConstru;
		this.tableDesLoyers=loyers;
		this.couleur=coul;
		this.nbPlacesFortes=0;
		this.possedeForteresse=false;
		this.possedeAnneauUnique=false;
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
	public void actionCase(Joueur j) {
		
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
    
    public void gererConstructions(Joueur j) {
    	this.afficherMenuConstructions();
    	
    	
    	
//    	String question ="" ;
//    	if(this.possedeForteresse) {
//    		System.out.println("blabla forteresse");
//    	}
//    	if (this.nbPlacesFortes>=4) {
//    		question = this.getNomCase() + " possède déjà 4 places fortes. Voulez vous bâtir une forteresse à la place ?";
//    		String rep = PartieDeMonopoly.poserQuestionReponseOuiOuNon(question);
//    		System.out.println(question);
//    		if(rep.toUpperCase().equals("OUI")) {
//    			//detruire les places fortes 
//    			this.nbPlacesFortes=0;
//    			//construire la forteresse a la place
//    			this.possedeForteresse=true;	
//    		}
//    		else {
//    			System.out.println(MessagesJeu.choixNeRienFaire);
//    		}
//    	}
//    	else  {
//    		
//    		if (this.nbPlacesFortes>0) {
//    			question = this.getNomCase() + " possède "+ this.nbPlacesFortes + " pour le moment. Voulez vous en bâtir une autre ?";
//        		System.out.println(question);
//
//    		}
//    		else if (this.nbPlacesFortes==0){
//        		question= this.getNomCase() + " ne possède aucune construction pour le moment. Voulez vous bâtir une première place forte ?";
//        		System.out.println(question);
//
//    		}
//    		String rep = PartieDeMonopoly.poserQuestionReponseOuiOuNon(question);
//    		if(rep.toUpperCase().equals("OUI")) {
//    			//construire une place forte
//    			this.nbPlacesFortes+=1;
//    		}
//    		else {
//    			System.out.println(MessagesJeu.choixNeRienFaire);
//    		}
//    	}
//    	

    }

    
    
    
	public void proposerDestructionConstruction() {
		
	}
    
	public void construireForteresse() {
		this.possedeForteresse=true;
	}
    
    public void construirePlaceForte() {
    	this.nbPlacesFortes+=1;
    }
    
    public boolean estTerrainVide() {
    	return !this.possedeForteresse && this.nbPlacesFortes==0;
    }

    // -------------------- Méthodes d'affichage des territoires ----------------------
    
    public String afficherMenuConstructions() {
    	String aff="--- Gestion de la propriété  \""+ this.getNomCase() + "\" --- \n";
    	if (this.estTerrainVide()) {
    		aff+="1 - Construire un bâtiment\n";
	    }
    	else if (this.nbPlacesFortes == 4 || this.possedeForteresse) {
    		aff+= "2 - Détruire un bâtiment";
    	}
    	else {
    		aff+="1 - Construire un bâtiment\n ";
    		aff+="2 - Détruire un bâtiment";

    	}
    	return aff;
    }

	@Override
	public void afficherTabLoyers() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afficherCase() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}
    

    
    

}