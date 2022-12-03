package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;

public abstract class CasePropriete extends Case {
	
	private int coutAchat;
	private int valeurHypotheque;
	private int loyerActuel;
	private Joueur proprietaire;
	private boolean estHypothequee;

	
    public CasePropriete(String nom, int coutAchat, int valeurHypotheque) {
        super(nom);
        this.coutAchat=coutAchat;
        this.valeurHypotheque=valeurHypotheque;
        this.loyerActuel=this.coutAchat;
        this.estHypothequee=false;
    }
    
    
    // -------- GETTERS ET SETTERS UTILES --------
  
    public boolean estEnHypotheque() {
    	return this.estHypothequee;
    }
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
    
	public void declencherPaiement(Joueur j) {
		// TODO Auto-generated method stub
		
	}
	
	protected void mettreEnHypotheque(Joueur j) {
		System.out.println("Vous mettez "+this.getNomCase()+ " en hypothèque pour "+ this.getValeurHypothequee()+" ୩.\n");
		this.estHypothequee=true;
		j.gagnerduPouvoir(this.valeurHypotheque);
	}
	
    protected String poserQuestionChoixMenus(int repetitionDeLaQuestion, boolean premierAff) {
        String question;
        if (repetitionDeLaQuestion == 0) {
            question = MessagesJeu.questionMenu1;
        } else if (repetitionDeLaQuestion <= 4) {
            question = MessagesJeu.questionMenuErr;
        } else {
            question = MessagesJeu.texteSiTropDerreurs;
        }
        return question;
    }
    
    
    // --------------- Methodes d'affichage des cases propriété ---------
    public abstract void afficherTabLoyers(); 
    

}
