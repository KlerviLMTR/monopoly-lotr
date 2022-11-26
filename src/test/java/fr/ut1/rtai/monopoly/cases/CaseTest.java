package fr.ut1.rtai.monopoly.cases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.ut1.rtai.monopoly.Plateau;


public class CaseTest {

	private Plateau p;
	@Before
	public void setUp() throws Exception {
		this.p = new Plateau();
	}

	@After
	public void tearDown() throws Exception {
		this.p=null;
	}

	@Test
	public void testNbCasesDansPlateau() {
		assertEquals(40,this.p.getCases().size());
	}
	
	
	/**
	 *Verification que la case numero 20 appelee par la methode correspond bien a la numero 4 dans la liste
	 *case souhaitee : 16 , Asfaloth 
	 */
	@Test 
	public void testMethodeGetCaseAvecNumero() {
		assertTrue(this.p.getCaseNumero(16).getNomCase().equals("Asfaloth"));
	}
	
	/**
	 *Verifications instanciation d'une case territoire 
	 */
	@Test
	public void testCaracteristiquesMontagneDuDestin() {
		assertEquals(39, this.p.getCaseNumero(40).getNumCase());
		assertTrue(this.p.getCaseNumero(40).getNomCase().equals("Montagne du Destin"));
		assertEquals(400, ( (Territoire)(this.p.getCaseNumero(40))).getCoutAchat());
		assertEquals(200, ( (Territoire)(this.p.getCaseNumero(40))).getCoutConstruction());
		assertEquals(200, ( (CasePropriete)(this.p.getCaseNumero(40))).getValeurHypothequee());
		//test loyer nu
		assertEquals(50, ((Territoire)(this.p.getCaseNumero(40))).getTableDesLoyers()[0]);
		//test 1 pf
		assertEquals(200, ((Territoire)(this.p.getCaseNumero(40))).getTableDesLoyers()[1]);
		//test 2pf
		assertEquals(600, ((Territoire)(this.p.getCaseNumero(40))).getTableDesLoyers()[2]);
		//test 3pf
		assertEquals(1400, ((Territoire)(this.p.getCaseNumero(40))).getTableDesLoyers()[3]);
		//test 4pf
		assertEquals(1700, ((Territoire)(this.p.getCaseNumero(40))).getTableDesLoyers()[4]);
		//test forteresse
		assertEquals(2000, ((Territoire)(this.p.getCaseNumero(40))).getTableDesLoyers()[5]);

	}

}
