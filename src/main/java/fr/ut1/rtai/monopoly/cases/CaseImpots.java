package fr.ut1.rtai.monopoly.cases;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.PartieDeMonopoly;

public class CaseImpots extends Case {
	private String description;
	public CaseImpots(String description ) {
		super("Case Impôts");
		this.description=description;

	}

	@Override
	public void actionCase(Joueur j) throws InterruptedException {
		if (this.description.equals("L'Antre d'Arachnée")) {
			PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " arrive dans l'antre d'Arachnée ...");
			Thread.sleep(500);
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
			PartieDeMonopoly.affichageMessageDelai(15, j.getNomPion() + " se promène tranquillement quand soudain ...");
			Thread.sleep(500);
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
		// TODO Auto-generated method stub
		
	}

}
