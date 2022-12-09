package fr.ut1.rtai.monopoly;

public class MessagesJeu {
	public static String descriptionCasePeuple = "Case de type \"peuple\" : piochez une carte dans le paquet de cartes \"peuple\".";
	public static String descriptionCaseEvenement = "             Case de type \"évènement\" : piochez une carte dans le paquet de cartes \"évènement\".";
	
	public static String questionNbJoueurs1 = "Combien de joueurs participeront à la partie ? (Saisissez votre réponse , 2 à 6 joueurs autorisés) :";
    public static String questionNbJoueursERR = "Le nombre de joueurs doit être un chiffre compris entre 2 et 6. Veuillez le saisir à nouveau : ";
    public static String texteSiTropDerreurs = "Bon allez...Un petit effort...";
	public static String questionChoixPion1="Veuillez choisir votre pion. (saisir le chiffre correspondant)";
	public static String questionChoixPionERR="Vous avez saisi une valeur incorrecte. Veuillez saisir le chiffre correspondant au personnage souhaité. :";
	public static String constructionPF="Vous construisez une place forte.";
	public static String descCaseMontureHyp ="Cette monture vous appartient mais est hypothéquée. Vous n'en percevrez donc pas les loyers.\n";
	public static String descCaseBatHyp ="Ce bâton de Magicien vous appartient mais est hypothéqué. Vous n'en percevrez donc pas les loyers.\n";
	public static String descCaseTerrHyp ="Ce territoire vous appartient mais est hypothéqué. Vous n'en percevrez donc pas les loyers.\n";

	public static String descriptionCaseMonture = "             Case propriété de type Monture, achetable.\n";
	public static String descriptionCaseBatons = "             Case propriété de type Bâton de Magicien, achetable.";
	public static String descriptionCaseTerritoire = "             Case propriété de type Territoire, achetable.";
	
	public static String questionTerrainAPersonne="\nCe territoire n'a encore été revendiqué par personne. Voulez-vous l'acheter pour ";
	public static String questionMontureAPersonne="\nCette monture n'a encore été apprivoisée par personne. Voulez-vous l'apprivoiser pour  ";
	public static String questionBatonAPersonne="\nCe bâton n'a encore été revendiqué par personne. Voulez-vous l'obtenir pour ";
	
	public static String caseMonturePropOK = ">>> Cette Monture vous appartient. Que voulez vous faire ?.\n";
	public static String caseBatonPropOK = ">>> Ce bâton vous appartient. Que voulez vous faire ?.";
	public static String caseTerritoirePropOK = ">>> Ces terres vous appartiennent. Que voulez vous faire ?.";
	
	public static String afficherMenuMontureLibre="\n                    1 - Apprivoiser la monture\n                    2 - Consulter la table des loyers\n                    3 - Ne rien faire\n";
	public static String afficherMenuBatonLibre="\n                    1 - Obtenir le bâton\n                    2 - Consulter la table des loyers\n                    3 - Ne rien faire\n";
	public static String afficherMenuTerritoireLibre="\n                    1 - Revendiquer les terres\n                    2 - Consulter la table des loyers\n                    3 - Ne rien faire\n";

	public static String afficherMenuMontureAJoueur="\n                    1 - Hypothéquer la monture\n                    2 - Consulter la table des loyers\n                    3 - Ne rien faire\n";
	public static String afficherMenuPropHypo="\n                    1 - Lever l'hypothèque\n                    2 - Ne rien faire\n";
	public static String afficherMenuBatonAJoueur="\n                    1 - Hypothéquer le bâton\n                    2 - Consulter la table des loyers\n                    3 - Ne rien faire\n";

	public static String questionMenu1 = "Votre choix :";
	public static String questionMenu2 = "Que voulez vous faire ensuite ? :";
	public static String questionMenuErr = "Vous avez saisi un nombre invalide. Veuillez le saisir à nouveau :";
	
	public static String tabLoyerMontures= "                    - 1 monture possédée : 25 ୩\n                    - 2 montures possédées : 50 ୩\n                    - 3 montures possédées: 100 ୩\n                    - 4 montures possédées : 200 ୩ ";
	public static String tabLoyerMagiciens= "                       - 1 bâton possédé : Le loyer à payer est de 4x le montant des dés\n                         - 2 bâtons possédés : Le loyer à payer est de 10x le montant des dés";

	public static String constructionF="Vous construisez une forteresse.";
	public static String choixNeRienFaire="Vous décidez de ne rien faire.";
	public static String affichageSepCase="\n※---※---※---※---※---※---※---※---※---※---※---※---※---※---※---※---※---※---※---※---※---※---※---※---※\n";
	public static String affichageSepCarte=" ჻ ჻ ჻ ჻ ჻ ჻ ჻ ჻ ჻ ჻ ჻ ჻ ჻ ჻";

	public static String menuJoueurDebutTour = "\nQue souhaitez-vous faire ?\n\n 1 - Lancer les dés\n 2 - Abandonner la partie";
	public static String  menuDebutTour = ">>> Continuer la partie ? (oui/non)";
	public static String lancerDeDesDoubleCasNom = ">>> Vous avez fait un double ! Vous rejouez au prochain tour.";
	public static String  lancerDeDes3fois = ">>> Oh non ! Vous avez fait un double 3 fois d'affilée ! Vous êtes amené.e en prison...";


}
