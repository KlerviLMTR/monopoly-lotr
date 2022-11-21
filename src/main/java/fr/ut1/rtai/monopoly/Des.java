package fr.ut1.rtai.monopoly;
import java.util.Random;

/**
 * @author Klervi
 *
 */
public class Des {
	int chiffreDe1;
	int chiffreDe2;
	/** 
	 * Compte si l'oeil de Sauron a ete tire une ou deux fois lors d'un lancer 
	 */
	private int nbOeilDeSauron; 
	private boolean estUnDouble;
	private enum couleurs {bleu, rouge};
	private couleurs couleurPion;
	
	public boolean isEstUnDouble() {
		return estUnDouble;
	}

	public void setEstUnDouble(boolean estUnDouble) {
		this.estUnDouble = estUnDouble;
	}

	public couleurs getCouleurPion() {
		return couleurPion;
	}

	public void setCouleurPion(couleurs couleurPion) {
		this.couleurPion = couleurPion;
	}

	public void setChiffreDe1(int chiffreDe1) {
		this.chiffreDe1 = chiffreDe1;
	}

	public void setChiffreDe2(int chiffreDe2) {
		this.chiffreDe2 = chiffreDe2;
	}

	public void setNbOeilDeSauron(int nbOeilDeSauron) {
		this.nbOeilDeSauron = nbOeilDeSauron;
	}

	/**
	 * Construit une paire de des.Par défaut, lorsqu'aucun lancer n'est actif, on choisit de les initialiser a 7
	 */
	public Des() {	
		this.chiffreDe1=7;
		this.chiffreDe2=7;
		this.nbOeilDeSauron=7;
		this.estUnDouble=false;
		this.couleurPion=couleurs.bleu;
		
	}
	
	public void lancerLesDes() {
		this.genererLancerDes();
		this.traiterResultatLancerDes(chiffreDe2, chiffreDe1);
		
	}
	
	private void genererLancerDes() {
		Random random=new Random();
		int chiffre1=1+random.nextInt(6);
		this.chiffreDe1=chiffre1;
		int chiffre2=1+random.nextInt(6);
		this.chiffreDe2=chiffre2;
	
	}
	
	
	public void traiterResultatLancerDes(int chiffre1, int chiffre2) {
		if (this.couleurPion==couleurs.bleu) {
			
		}
		if (chiffre1 == 1 && chiffre2 == 1) {
			this.nbOeilDeSauron=2;
		}
		else {
			if (chiffre1==1 && chiffre2!=1 ){
				this.nbOeilDeSauron=1;
			}
			else if (chiffre1!=1 && chiffre2==1 ) {
				this.nbOeilDeSauron=1;
			}
			else {
				this.nbOeilDeSauron=0;
			}
		}

		if (chiffre1==chiffre2) {
			this.estUnDouble=true;
		}
		else {
			this.estUnDouble=false;
		
		}
	}

	
	/**
	 * @return le chiffre donnne par le premier de
	 */
	public int getChiffreDe1() {
		return this.chiffreDe1;
	}
	
	/**
	 * @return le chiffre donnne par le premier de
	 */
	public int getChiffreDe2() {
		return this.chiffreDe2;
	}
	
	/**
	 * @return le chiffre donnne par le deuxieme de
	 */
	public int getNbOeilDeSauron() {
		return this.nbOeilDeSauron;
	}
	

	/**
	 *Affiche la valeur du lancer de des actuel
	 */
	public String toString() {
		return "Lancer : "+ this.chiffreDe1+" + "+this.chiffreDe2;
	}



	
}
