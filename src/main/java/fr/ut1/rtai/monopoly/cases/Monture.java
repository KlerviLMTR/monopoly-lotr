package fr.ut1.rtai.monopoly.cases;


import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class Monture extends CasePropriete {
	
	private int[] loyers;
	private int loyerActuel;
	
	public Monture(String nom) {
		super(nom, 200, 100);
		this.loyers= new int[] {25,50,100,200};
		this.loyerActuel=this.loyers[0];
	}
	
	public int getLoyerActuel() {
		return this.loyerActuel;
	}
	
	public int[] getLoyers() {
		return this.loyers;
	}
	
	@Override
	public void setLoyerActuel(int loy) {
		this.loyerActuel = loy;
	}

	
	// --------- Methodes des montures --------------
	

	
	// ------------ Methodes d'affichage des Montures --------------
	



	public void afficherTabLoyers() {
		System.out.println("                              --- Loyers --- \n\n" );
		System.out.println("                          Loyer actuel :"+ this.loyerActuel+" ୩\n" );
 
		PartieDeMonopoly.affichageMessageDelai(15, ">>> Obtenez toutes les montures pour voir les loyers augmenter !\n");
		System.out.println(MessagesJeu.tabLoyerMontures);
	}
	
	
	
	
	@Override
    public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1);
		if (this.getProprietaire()==null) {
			aff +=  "                   🐴 "+this.getNomCase()+" 🐴 - LIBRE \n" + MessagesJeu.affichageSepCase + MessagesJeu.descriptionCaseMonture+"\n                         Prix : "+this.getCoutAchat()+ " ୩\n                         ------------\n";
		}
	
		else {
				if (this.estEnHypotheque()) {
					aff +="        🐴 "+this.getNomCase()+" 🐴 - EN HYPOTHEQUE \n" + MessagesJeu.affichageSepCase + "\n                      Propriétaire : "+this.getProprietaire().getNomPion()+"\n";
				}
				else {
						aff +="            🐴 "+this.getNomCase()+" 🐴 - "+ this.getProprietaire().getNomPion().toUpperCase()+"\n" + MessagesJeu.affichageSepCase + "\n                      Propriétaire : "+this.getProprietaire()+"\n";			
					}
				if (this.getProprietaire().estPropDeNbMontures()==1) {
						aff +="\n                             🐴              \n                        ------------\n";
				}
				else if(this.getProprietaire().estPropDeNbMontures()==2) {
					aff +="\n                            🐴 🐴             \n                        ------------\n";
				}
				else if(this.getProprietaire().estPropDeNbMontures()==3) {
					aff +="\n                           🐴 🐴 🐴           \n-                        -----------\n";
				}
				else if(this.getProprietaire().estPropDeNbMontures()==4) {
					aff +="\n                          🐴 🐴 🐴 🐴            \n                        ------------\n";
				}
				if (!this.estEnHypotheque()) {
					aff +="                         Loyer :"+ this.getLoyerActuel() + " ୩.\n";      
				}
				else {
					aff +="                         Loyer : 0 ୩.\n";      
				}

			}
		System.out.println(aff);
		}

	@Override
	public void afficherMenuPropAJoueur() {
		System.out.println(MessagesJeu.afficherMenuMontureAJoueur);
	}


		
			

		
   
	


}
