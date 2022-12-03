package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;

public abstract class CasePropriete extends Case {
	
	private int coutAchat;
	private int valeurHypotheque;
	private Joueur proprietaire;
	private int loyerActuel;
	private boolean estHypothequee;

	
    public CasePropriete(String nom, int coutAchat, int valeurHypotheque) {
        super(nom);
        this.coutAchat=coutAchat;
        this.valeurHypotheque=valeurHypotheque;
        this.estHypothequee=false;
    }
    
    
    // -------- GETTERS ET SETTERS UTILES --------

  
    public boolean estEnHypotheque() {
    	return this.estHypothequee;
    }
    public void setProprietaire(Joueur j) {
    	this.proprietaire = j;
    }
        
    public void setLoyerActuel(int loyer) {
    	this.loyerActuel=loyer;
    }
    
    public int getLoyerActuel(){
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
    
    //TODO : faire mieux ...
	public void declencherPaiement(Joueur j) {
		// --> pour l'instant : on considere que si le joueur n'a plus assez d'argent pour payer, il est en faillite 
		if (j.getSolde()< this.getLoyerActuel()) {
			System.out.println("Vous n'avez pas assez pour payer !");
			j.estMisFaillite(this.loyerActuel);
		}
		else {
			j.payerJoueur(this.proprietaire, this.loyerActuel);
			System.out.println("Vous payez un loyer de "+ this.loyerActuel + " à "+ this.getProprietaire()+".");
		}
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


	public void leverLHypotheque(Joueur j) {
		double montantAPayer = this.valeurHypotheque*1.1;
		System.out.println("Vous levez l'hypothèque sur "+ this.getNomCase()+ " pour "+ (int)montantAPayer+" ୩.\n");
		j.perdreDuPouvoir(montantAPayer);
		this.estHypothequee=false;
	} 
    

}
