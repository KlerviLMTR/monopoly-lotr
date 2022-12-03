package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;

public abstract class CasePropriete extends Case {
	
	private int coutAchat;
	private int valeurHypotheque;
	private int loyerActuel;
	private Joueur proprietaire;

	
    public CasePropriete(String nom, int coutAchat, int valeurHypotheque) {
        super(nom);
        this.coutAchat=coutAchat;
        this.valeurHypotheque=valeurHypotheque;
        this.loyerActuel=this.coutAchat;
    }
    
    
    // -------- GETTERS ET SETTERS UTILES --------
  
    
    public void setProprietaire(Joueur j) {
    	this.proprietaire = j;
    }
    
    public int getLoyerActuel() {
    	return this.loyerActuel;
    }
    
    public int getCoutAchat() {
    	return this.coutAchat;
    }
    
    public int getValeurHypothequee() {
    	return this.valeurHypotheque;
    }
    
    public Joueur getProprietaire() {
    	return this.proprietaire;
    }


    
    // --------------- Methodes utilitaires des cases propriété --------
    
    public void proposerAchatCase(String message) {
    	System.out.println(message);
    	
    }
    
    // --------------- Methodes d'affichage des cases propriété ---------
    public abstract String afficherTabLoyers(); 
    

}
