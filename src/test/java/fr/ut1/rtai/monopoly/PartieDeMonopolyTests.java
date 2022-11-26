package fr.ut1.rtai.monopoly;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartieDeMonopolyTests {

	private PartieDeMonopoly p;
	@BeforeEach
	public void setUp() throws Exception {
		this.p = new PartieDeMonopoly();
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.p=null;
	}

	@Test
	public void testCreationJoueursNbJoueursEntre2et6() {
		this.p.verifierNbJoueurs(3);
		assertEquals(this.p.getNbJoueurs(),3);
	}
	
	@Test
	public void testCreationJoueursNbJoueursIncorrect() {
		assertThrows(IllegalArgumentException.class,() -> {
			this.p.verifierNbJoueurs(1);
		});
	}
	
	@Test
	public void testCreationJoueursNomsEtPionParDefaut() {
		this.p.genererJoueurs(3,new String[]{"Toto","Titi","Tutu"});
		assertEquals(this.p.getJoueurs().get(1).getNom(),"Titi");
		assertEquals(this.p.getJoueurs().get(1).getNomPion(),"Gandalf");

	}
	
	
	

}
