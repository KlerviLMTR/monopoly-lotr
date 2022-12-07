package fr.ut1.rtai.monopoly.cartes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.ut1.rtai.monopoly.EPion;
import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Pion;
import fr.ut1.rtai.monopoly.Plateau;

public class CarteAllerEnPrisonTest {
	private Plateau p;
	private Joueur j;
	private CarteAllerEnPrison c;
	
	@Before
	public void setUp() throws Exception {
		this.p = new Plateau();
		this.c = new CarteAllerEnPrison("Carte prison", "Allez en prison");
		this.c.setPlateau(p);
		this.j = new Joueur("Toto");
		this.j.setPion(new Pion(EPion.Aragorn));
	}

	@After
	public void tearDown() throws Exception {
		this.p = null;
		this.c = null;
		this.j = null;
		
	}
	
	@Test
	public void testPositionPionJoueurMisEnPrison() throws InterruptedException {
		c.actionCarte(j);
		assertEquals(11,j.getPion().getNumCase());
	}
	
	@Test
	public void testEstEnPrisonAvant() {
		assertFalse(j.estEnPrison());
	}
	
	@Test
	public void testEstEnPrisonApres() throws InterruptedException {
		c.actionCarte(j);
		assertTrue(j.estEnPrison());
	}
	
	@Test
	public void verifNbToursPrisonInit() throws InterruptedException {
		c.actionCarte(j);
		assertEquals(0, j.getNbToursEnPrison());
	}

}
