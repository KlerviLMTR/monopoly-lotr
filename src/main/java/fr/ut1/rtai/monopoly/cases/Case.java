package fr.ut1.rtai.monopoly.cases;


public class Case {
	private String intitule;
	private int numCase;
	
	public Case(String intitule) {
		this.intitule=intitule;
		this.numCase=-1;//valeur par defaut choisie avant definition du numero de case par le plateau
	}
	
	public void setNumCase(int numero) {
		this.numCase=numero;
	}
	
	public int getNumCase() {
		return this.numCase;
	}
	
	public String toString() {
		return "Case n°"+this.numCase+1 +" : "+ this.intitule;
	}
	

}