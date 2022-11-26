package fr.ut1.rtai.monopoly;

import java.util.Scanner;

public class Monopoly {
	private Plateau p;
	
	
	/**
	 * @param question
	 * @return
	 * recupere la reponse pour une question donnee
	 */
	public String recupererReponseQuestionJoueur(String question) {
		String reponse ="";
		System.out.println(question+"\n");
		Scanner scanner = new Scanner(System.in);
		reponse=scanner.nextLine();
		scanner.close();
		return reponse;
	}
}
