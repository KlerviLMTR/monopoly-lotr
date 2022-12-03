package fr.ut1.rtai.monopoly.cartes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

class CarteTest {
	
	private Plateau p ;
	private Joueur j;
	
	@BeforeEach
	void setUp() throws Exception {
		this.p= new Plateau();
		this.j=new Joueur("Toto");
		this.j.setPlateau(p);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.p=null;
	}

	@Test
	void test() {
		this.j=null;
	}
	
	@Test
	public void testNbCartesInit() {
		assertEquals(16,this.p.getCartesEvenement().size());
		assertEquals(16,this.p.getCartesPeuple().size());
		assertEquals("Vous vendez votre vieille épée rouillée. Vous gagnez 10 de pouvoir.", this.p.getCartesPeuple().get(0).getDesc());
		assertEquals("En expédition dans les montagne brumeuses, vous trouvez un précieux trésor. Vous gagnez 50 de pouvoir.", this.p.getCartesEvenement().get(0).getDesc());

	}
	
	@Test
	public void testJoueurPiocheCartePeuple() {
		this.j.piocherUneCartePeuple();
		assertEquals(16,this.p.getCartesEvenement().size());
		assertEquals(16,this.p.getCartesPeuple().size());
		assertEquals("C’est votre anniversaire : chaque joueur vous donne 10 de pouvoir.", this.p.getCartesPeuple().get(0).getDesc());
		assertEquals("En expédition dans les montagne brumeuses, vous trouvez un précieux trésor. Vous gagnez 50 de pouvoir.", this.p.getCartesEvenement().get(0).getDesc());
		assertEquals("Vous vendez votre vieille épée rouillée. Vous gagnez 10 de pouvoir.", this.p.getCartesPeuple().get(15).getDesc());

		
	}
	@Test
	public void testJoueurPiocheCarteEvenement() {
		this.j.piocherUneCarteEvenement();
		assertEquals(16,this.p.getCartesEvenement().size());
		assertEquals(16,this.p.getCartesPeuple().size());
		assertEquals("Vous vendez votre vieille épée rouillée. Vous gagnez 10 de pouvoir.", this.p.getCartesPeuple().get(0).getDesc());
		assertEquals("Votre petite auberge à Edoras fait le bonheur de ses habitués. Vous gagnez 50 de pouvoir.", this.p.getCartesEvenement().get(0).getDesc());
		assertEquals("En expédition dans les montagne brumeuses, vous trouvez un précieux trésor. Vous gagnez 50 de pouvoir.", this.p.getCartesEvenement().get(15).getDesc());

		
	}
}
