package fr.ut1.rtai.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class PionTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	private Pion p;
	private Plateau plateau;
	private Des des;

	@Before
	public void setUp() throws Exception {
		this.p = new Pion(EPion.Aragorn);
		this.plateau = new Plateau();
		this.des = new Des();
	}

	@After
	public void tearDown() throws Exception {
		this.p = null;
		this.plateau = null;
		this.des = null;
	}

	@Test
	public void testPosition0() {
		assertEquals(0, this.p.getNumCase());
	}

	@Test
	public void testAvancerDe3Cases() throws InterruptedException {
		this.des.traiterResultatLancerDes(3, 2);
		this.p.avancerPion(this.des.getLancerTotal());
		assertEquals(4, this.plateau.getCaseNumero(5).getNumCase());
		assertEquals("Bill le Poney",this.plateau.getCases().get(this.p.getNumCase()).getNomCase() );
	}
	
	
	//Oui je sais le lancer de dés est absurde
	@Test
	public void testAvancerDe35Cases() throws InterruptedException {
		this.des.traiterResultatLancerDes(30,5 );
		this.p.avancerPion(this.des.getLancerTotal());
		assertEquals( "Gripoil",this.plateau.getCases().get(this.p.getNumCase()).getNomCase());
	}
	
	public void testAvancerGueBruinen() throws InterruptedException {
		this.des.traiterResultatLancerDes(6,6 );
		this.p.avancerPion(this.des.getLancerTotal());
		assertEquals( "Gué de Bruinen",this.plateau.getCases().get(this.p.getNumCase()).getNomCase());
	}
	
	//Oui je sais le lancer de dés est absurde
	@Test
	public void testAvancerDe35Plus() throws InterruptedException {
		this.des.traiterResultatLancerDes(30,5 );
		this.p.avancerPion(this.des.getLancerTotal());
		this.des.traiterResultatLancerDes(3,3 );
		this.p.avancerPion(this.des.getLancerTotal());
		assertEquals("Cul-De-Sac",this.plateau.getCases().get(this.p.getNumCase()).getNomCase());
	}
}
