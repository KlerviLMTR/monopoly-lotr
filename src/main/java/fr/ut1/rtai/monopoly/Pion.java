package fr.ut1.rtai.monopoly;

public class Pion {
	private EPion typePion;
	
	public Pion(EPion typeP) {
		this.typePion=typeP;
	}
	
	// ---------- Getters et setters utiles --------------
	
	public EPion getTypePion() {
		return this.typePion;
	}
}
