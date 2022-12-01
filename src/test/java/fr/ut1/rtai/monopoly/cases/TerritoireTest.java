package fr.ut1.rtai.monopoly.cases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import fr.ut1.rtai.monopoly.ECouleurCase;
import fr.ut1.rtai.monopoly.Joueur;

public class TerritoireTest {
	private Territoire fanghorn ;
	private Joueur j1 ;
	private Joueur j2 ;
	
	@Before
	public void setUp() throws Exception {
		this.fanghorn = new Territoire("Forêt de Fangorn", ECouleurCase.jaune,260,130,150, new int[] {22,110,330,800,975,1150});
		this.j1=new Joueur("Sylvebarbe");
		this.j2=new Joueur("Merry");
	}

	@After
	public void tearDown() throws Exception {
		this.fanghorn=null;
		this.j1=null;
		this.j2=null;
	}

	@Test
	public void testNbConstruEtatInitial() {
		assertEquals(0, this.fanghorn.getNbPlacesFortes());
		assertFalse(this.fanghorn.getPossedeForteresse());
	}
	
	@Test
	public void testNbPFApresConstruUnePF() {
		this.fanghorn.construirePlaceForte();
		assertEquals(1,this.fanghorn.getNbPlacesFortes());
		assertFalse(this.fanghorn.getPossedeForteresse());
	}
	
	@Test
	public void testConstruForteresse() {
		this.fanghorn.construireForteresse();
		assertEquals(0, this.fanghorn.getNbPlacesFortes());
		assertTrue(this.fanghorn.getPossedeForteresse());
	}
	
	@Test
	public void testEstTerrainVideInit() {
		assertTrue(this.fanghorn.estTerrainVide());
	}
	
	@Test
	public void testEstTerrainNonVideApresConstruPF() {
		this.fanghorn.construirePlaceForte();
		assertFalse(this.fanghorn.estTerrainVide());
	}
	@Test
	public void testEstTerrainNonVideApresConstruForteresse() {
		this.fanghorn.construireForteresse();
		assertFalse(this.fanghorn.estTerrainVide());
	}
	
	
	@Test
	public void testcasePasDeProprietaireAvantAchat() {
		assertTrue(this.fanghorn.getProprietaire()==null);
	}
	
	@Test
	public void testProprietairej1() {
		this.fanghorn.setProprietaire(this.j1);
		assertSame(this.j1, this.fanghorn.getProprietaire());
		assertNotSame(this.j2, this.fanghorn.getProprietaire());
	}
	
}
