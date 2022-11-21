package fr.ut1.rtai.monopoly;
public class Application {

	public static void main(String[] args) {
	
		Plateau p = new Plateau();
		System.out.println(p.afficherJoueurs());
		System.out.println(p.afficherPositionJoueurs());

		
	}

}
