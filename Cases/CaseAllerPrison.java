package Cases;

import MonoployJeue.JoueurMonopoly;
import MonopolyPlateau.PlateauMonopoly;

public class CaseAllerPrison extends Case {

	public CaseAllerPrison(String nom, int valeur) {
		super(nom, valeur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public JoueurMonopoly getProprietaire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCouleur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoyer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPrixMaison() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbMaison() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getReponseQuestion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPeutMettreMaison() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setProprietaire(JoueurMonopoly j) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setReponseQuestion(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionCase(JoueurMonopoly joueur, PlateauMonopoly plateau) {
		// TODO Auto-generated method stub

	}

}
