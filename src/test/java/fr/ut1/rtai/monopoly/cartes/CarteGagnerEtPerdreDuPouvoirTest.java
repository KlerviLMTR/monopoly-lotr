package fr.ut1.rtai.monopoly.cartes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ut1.rtai.monopoly.Joueur;
import fr.ut1.rtai.monopoly.Plateau;

class CarteGagnerEtPerdreDuPouvoirTest {
	private Plateau p;
	private Joueur j;
	
	@BeforeEach
	void setUp() throws Exception {
		this.j=new Joueur("Toto");
		this.p=new Plateau();
		this.j.setPlateau(p);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.j=null;
		this.p=null;
	}

	//Tests des cartes gagnerPouvoir nominal
	@Test
	void testGagneDuPouvoirNominal() {
		j.piocherUneCartePeuple();
		assertEquals(1510,this.j.getSolde());
		j.piocherUneCarteEvenement();
		assertEquals(1560,this.j.getSolde());

	}
	
	//Tests des cartes gagnerPouvoir speciales (c1 peuple)

	

	//Tests des cartes perdrePouvoir speciales (c14 peuple,c8evenement)
	@Test
	public void testPerdreDuPouvoirNominal() {
	}


}
