package fr.ut1.rtai.monopoly.cases;

public abstract class CasePropriete extends Case {
	
	private int coutAchat;
	private int valeurHypotheque;
	//TODO: Dans le constructeur du plateau, creer l'ensemble des cases en suivant ce qui est indique sur l'image du plateau de jeu
    public CasePropriete(String nom, int coutAchat, int valeurHypotheque) {
        super(nom);
        this.coutAchat=coutAchat;
        this.valeurHypotheque=valeurHypotheque;
    }
    
    public int getCoutAchat() {
    	return this.coutAchat;
    }
    
    public int getValeurHypothequee() {
    	return this.valeurHypotheque;
    }

}
