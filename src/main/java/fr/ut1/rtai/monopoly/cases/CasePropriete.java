package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;

public abstract class CasePropriete extends Case {
	
	private int coutAchat;
	private int valeurHypotheque;
	private Joueur proprietaire;

	
    public CasePropriete(String nom, int coutAchat, int valeurHypotheque) {
        super(nom);
        this.coutAchat=coutAchat;
        this.valeurHypotheque=valeurHypotheque;
    }
    
    
    // -------- GETTERS ET SETTERS UTILES --------
  
    
    public void setProprietaire(Joueur j) {
    	this.proprietaire = j;
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


    
    // --------------- Methodes utilitaires des 
}
