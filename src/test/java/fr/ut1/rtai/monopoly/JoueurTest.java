package fr.ut1.rtai.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.ut1.rtai.monopoly.cases.CasePropriete;

public class JoueurTest {
	private Plateau p;
	private Pion pion;
	private Joueur j;

	
	@Before
	public void setUp() throws Exception {
		this.j = new Joueur("Toto");
		this.pion = new Pion(EPion.Galadriel);
		this.p = new Plateau();
	}

	@After
	public void tearDown() throws Exception {
		this.j = null;
		this.p = null;
		this.pion = null;
	}

	@Test
	public void testNomJoueur() {
		assertTrue(this.j.getNom().equals("Toto"));
	}
	
	@Test
	public void testSetPion() {
		this.j.setPion(this.pion);
		assertSame(this.pion,this.j.getPion());
	}
	
	@Test
	public void testPasEmprisonneInitialisation() {
		assertFalse(this.j.estEnPrison());
		assertEquals(0, this.j.getNbToursEnPrison());
	}
	
	@Test
	public void testSoldeInitialisation1500() {
		assertEquals(1500, this.j.getSolde());
	}
	
	@Test 
	public void testAucuneCarteSortiePrisonInitialisation() {
		assertFalse(j.possedeUneCarteSortiePrison());
	}
	
	@Test
	public void testNestPasEnPrisonInit() {
		assertFalse(this.j.estEnPrison());
	}
	@Test
	public void testSetCarteSortiePrisonPeuple() {
		this.j.setPossedeCartesSortiePrisonPeuple(true);
		assertFalse(j.getPossedeCartesSortiePrisonEvenement());
		assertTrue(j.getPossedeCartesSortiePrisonPeuple());
		assertTrue(j.possedeUneCarteSortiePrison());
	}
	
	@Test
	public void testSetCarteSortiePrisonEvenement() {
		this.j.setPossedeCartesSortiePrisonEvenement(true);
		assertTrue(j.getPossedeCartesSortiePrisonEvenement());
		assertFalse(j.getPossedeCartesSortiePrisonPeuple());
		assertTrue(j.possedeUneCarteSortiePrison());
	}
	
	@Test
	public void testGagnerDuPouvoir() {
		this.j.gagnerduPouvoir(100);
		assertEquals(1600, this.j.getSolde());
	}
	
	@Test
	public void testPerdreDuPouvoir() {
		this.j.perdreDuPouvoir(100);
		assertEquals(1400, this.j.getSolde());
	}
	
	@Test
	public void testEstMisEnPrison() {
		this.j.estMisEnPrison();
		assertTrue(this.j.estEnPrison());
		assertEquals(this.j.getNbToursEnPrison(),0);
	}
	

	
	@Test
	public void testAcheterBreeTailleSetTerritoire() {
		this.j.acheterCase((CasePropriete) this.p.getCaseNumero(9));
		assertEquals(this.j.getNbBatonsDeMagicienPossedes(),0);
		assertEquals(this.j.getNbMonturesPossedees(),0);
		assertEquals(this.j.getNbTerritoiresPossedes(),1);
	}
	
	@Test
	public void testAcheterBillTailleSetMonture() {
		this.j.acheterCase((CasePropriete) this.p.getCaseNumero(6));
		assertEquals(this.j.getNbBatonsDeMagicienPossedes(),0);
		assertEquals(this.j.getNbMonturesPossedees(),1);
		assertEquals(this.j.getNbTerritoiresPossedes(),0);
	}
	
	@Test
	public void testAcheterBatonGandalfTailleSetBatons() {
		this.j.acheterCase((CasePropriete) this.p.getCaseNumero(13));
		assertEquals(this.j.getNbBatonsDeMagicienPossedes(),1);
		assertEquals(this.j.getNbMonturesPossedees(),0);
		assertEquals(this.j.getNbTerritoiresPossedes(),0);
	}
	

	@Test
	public void testPossedeCaseGripoil() {
		this.j.acheterCase((CasePropriete)this.p.getCaseNumero(36));
		assertTrue(this.j.possedeCase(this.p.getCaseNumero(36)));
		assertFalse(this.j.possedeCase(this.p.getCaseNumero(2)));

	}
	
}
