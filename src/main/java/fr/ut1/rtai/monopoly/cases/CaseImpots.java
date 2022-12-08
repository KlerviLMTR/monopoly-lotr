package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.MessagesJeu;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CaseImpots extends Case {
	private String description;
	public CaseImpots(String description ) {
		super("Case Impôts");
		this.description=description;

	}

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		
		int position = this.getNumCase()+1;
		PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive sur la case n°"+ position+ ": \""+this.getNomCase()+"\"");
		Thread.sleep(1000);
		this.afficherCase();
		if (this.description.equals("L'Antre d'Arachnée")) {

			PartieDeMonopoly.affichageMessageDelai(15, "Oh non ! Vous êtes pris au piège dans la toile d'Arachnée ! Vous utilisez 75 ୩ pour vous en sortir.");
			if (j.getSolde()<75) {
				PartieDeMonopoly.affichageMessageDelai(15, "... Mais vous n'avez pas assez de pouvoir. Vous êtes mis en faillite.");			
				j.estMisEnFaillite();
			}
			else {
				j.perdreDuPouvoir(75);
			}
		}
		else {
			PartieDeMonopoly.affichageMessageDelai(15, "Oh non ! Vous avez été vu par un Palantir ! Vous utilisez 200 ୩ pour éviter de vous faire prendre.");
			if (j.getSolde()<75) {
				PartieDeMonopoly.affichageMessageDelai(15, "... Mais vous n'avez pas assez de pouvoir. Vous êtes mis en faillite.");			
				j.estMisEnFaillite();
			}
			else {
				j.perdreDuPouvoir(200);
			}
		}
	}

	@Override
	public void afficherCase() throws InterruptedException {
		String aff = MessagesJeu.affichageSepCase+"\nCase n°"+Integer.valueOf(getNumCase()+1);
		aff +=  "                                 👑 Impôts 👑  \n"+ MessagesJeu.affichageSepCase;		
		System.out.println(aff);
		
	}

}
