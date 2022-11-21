package fr.ut1.rtai.monopoly;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Klervi
 *
 */
public class DesTest {
	
	private Des des;

	@Before
	public void setUp() throws Exception {
		this.des=new Des();
	}

	@After
	public void tearDown() throws Exception {
		this.des=null;
	}

	
	/**
	 *Teste si les chiffres des deux des sont bien initialises a 0 avant un lancer 
	 */
	@Test
	public void testInitialisationDesAvantLancer() {
		assertEquals(7,this.des.getChiffreDe1());
		assertEquals(7,this.des.getChiffreDe2());
	}
	
	/**
	 * Teste si les chiffres des deux des sont bien compris entre 1 et 6 apres un lancer 
	 */
	@Test
	public void testChiffresDesComprisEntreUnEtSixApresLancer() {
		this.des.lancerLesDes();
		assertTrue(this.des.getChiffreDe1()>=1 && this.des.getChiffreDe1()<=6);
		assertTrue(this.des.getChiffreDe2()>=1 && this.des.getChiffreDe2()<=6);
	}
	
	/**
	 *Teste si le compteur "oeil de Sauron" est bien initialise a 7
	 */
	@Test
	public void testNbOeilSauronAvantLancer() {
		assertEquals(this.des.getNbOeilDeSauron(),7);
	}
	
	/**
	 *Teste si le compteur "oeil de Sauron" vaut 1 apres un lancer 1 - *
	 */
	@Test
	public void testNbOeilSauronApresLance1etAutre() {
		this.des.lancerLesDes();
		this.des.traiterResultatLancerDes(1, 3);
		assertEquals(this.des.getNbOeilDeSauron(),1);
	}
	
	/**
	 *Teste si le compteur "oeil de Sauron" vaut 1 apres un lancer * - 1
	 */
	@Test
	public void testNbOeilSauronApresLanceAutreEtUn() {
		this.des.lancerLesDes();
		this.des.traiterResultatLancerDes(4, 1);
		assertEquals(this.des.getNbOeilDeSauron(),1);
	}
	
	/**
	 *Teste si le compteur "oeil de Sauron" vaut 0 apres un lancer * - *
	 */
	@Test
	public void testNbOeilSauronApresLanceAutreEtAutre() {
		this.des.lancerLesDes();
		this.des.traiterResultatLancerDes(2, 5);
		assertEquals(this.des.getNbOeilDeSauron(),0);
	}
	
	/**
	 *Teste si le compteur "oeil de Sauron" vaut 2 apres un lancer 1 - 1
	 */
	@Test
	public void testNbOeilSauronApresLanceUnEtUn() {
		this.des.lancerLesDes();
		this.des.traiterResultatLancerDes(1, 1);
		assertEquals(this.des.getNbOeilDeSauron(),2);
	}
	
	/**
	 *Teste si le boolean du double est bien vrai pour un double
	 */
	@Test
	public void testEstUnDoubleVrai() {
		this.des.lancerLesDes();
		this.des.traiterResultatLancerDes(2, 2);
		assertTrue(this.des.isEstUnDouble());
	}
	
	/**
	 *Teste si le boolean du double est bien Faux pour un lancer simple
	 */
	@Test
	public void testEstUnDoubleFaux() {
		this.des.lancerLesDes();
		this.des.traiterResultatLancerDes(3, 2);
		assertFalse(this.des.isEstUnDouble());
	}
	

	/**
	 *Teste l'affichage des des 
	 */
	@Test
	public void testToString() {
		this.des.lancerLesDes();
		assertTrue(this.des.toString().equals("Lancer : "+this.des.getChiffreDe1() +" + "+this.des.getChiffreDe2()));
	}
	

}
