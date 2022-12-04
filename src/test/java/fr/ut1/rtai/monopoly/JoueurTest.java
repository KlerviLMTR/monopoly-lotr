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
	

	//TODO Commentées à cause des sleep, mais fonctionnelles , à décommenter pour tests de non régression 
//	@Test
//	public void testAcheterBreeTailleSetTerritoire() throws InterruptedException {
//		this.j.acheterCase((CasePropriete) this.p.getCaseNumero(9));
//		assertEquals(this.j.getNbBatonsDeMagicienPossedes(),0);
//		assertEquals(this.j.getNbMonturesPossedees(),0);
//		assertEquals(this.j.getNbTerritoiresPossedes(),1);
//	}
//	
//	@Test
//	public void testAcheterBillTailleSetMonture() throws InterruptedException {
//		this.j.acheterCase((CasePropriete) this.p.getCaseNumero(6));
//		assertEquals(this.j.getNbBatonsDeMagicienPossedes(),0);
//		assertEquals(this.j.getNbMonturesPossedees(),1);
//		assertEquals(this.j.getNbTerritoiresPossedes(),0);
//	}
//	
//	@Test
//	public void testAcheterBatonGandalfTailleSetBatons() throws InterruptedException {
//		this.j.acheterCase((CasePropriete) this.p.getCaseNumero(13));
//		assertEquals(this.j.getNbBatonsDeMagicienPossedes(),1);
//		assertEquals(this.j.getNbMonturesPossedees(),0);
//		assertEquals(this.j.getNbTerritoiresPossedes(),0);
//	}
//	
//
//	@Test
//	public void testPossedeCaseGripoil() throws InterruptedException {
//		this.j.acheterCase((CasePropriete)this.p.getCaseNumero(36));
//		assertTrue(this.j.possedeCase(this.p.getCaseNumero(36)));
//		assertFalse(this.j.possedeCase(this.p.getCaseNumero(2)));
//
//	}
	
	@Test
	public void testPayerJoueurMontant25() {
		Joueur j2 = new Joueur("titi");
		this.j.payerJoueur(j2,25);
		assertEquals(1475,this.j.getSolde());
		assertEquals(1525,j2.getSolde());

		
	}
	
	@Test
	public void testCompterMonturesPossedeesAvantAchat() {	
		assertEquals(0,this.j.estPropDeNbMontures());
	}
	
//	@Test 
//	public void testCompterDeuxMontures() throws InterruptedException {
//		j.acheterCase(this.p.getCaseNumero(6));// Bill
//		j.acheterCase(this.p.getCaseNumero(16));//Asfaloth
//		assertEquals(2, this.j.estPropDeNbMontures());
//	}
	
	@Test
	public void testCompterBatonsPossedeesAvantAchat() {
		assertEquals(0,this.j.estPropdeNbBatons());
	}
	
//	@Test 
//	public void testCompterDeuxBatons() throws InterruptedException {
//		j.acheterCase(this.p.getCaseNumero(13));// Bill
//		j.acheterCase(this.p.getCaseNumero(29));//Asfaloth
//		assertEquals(2, this.j.estPropdeNbBatons());
//	}
	
	@Test
	public void testCompterTerrainsSurLotPossedesAvantAchat() {
		assertEquals(0,j.compterLotParCouleur(ECouleurCase.blanc));
	}
	@Test
	public void testCompterPasPropDeToutLeLotAvantAchat() {
		assertFalse(j.estPropDeTousLesLotsCoul(ECouleurCase.blanc));
	}
	
//	@Test
//	public void testCompterTerrainsSurLotPossede1Achat() throws InterruptedException {
//		j.acheterCase(this.p.getCaseNumero(7));// Bac de brandebouc
//		assertEquals(1,j.compterLotParCouleur(ECouleurCase.blanc));
//	}
	
//	@Test
//	public void testCompterPasPropDeToutLeLotAvantTousLesAchats() throws InterruptedException {
//		j.acheterCase(this.p.getCaseNumero(7));// Bac de brandebouc
//		assertFalse(j.estPropDeTousLesLotsCoul(ECouleurCase.blanc));
//	}
	
	@Test
	public void estPropdeTousLesTerrains() throws InterruptedException {
		j.acheterCase(this.p.getCaseNumero(7));// Bac de brandebouc
		j.acheterCase(this.p.getCaseNumero(9));// Bac de brandebouc
		j.acheterCase(this.p.getCaseNumero(10));// Bac de brandebouc
		assertEquals(3,j.compterLotParCouleur(ECouleurCase.blanc));
		assertTrue(j.estPropDeTousLesLotsCoul(ECouleurCase.blanc));
	}
	
	
	
	

}
