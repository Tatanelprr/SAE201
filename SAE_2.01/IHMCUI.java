public class IHMCUI {
    public static void main(String[] args) 
    {
        // Crée une instance de Plateau
        
        Plateau plateau = new Plateau();
        Pioche pioche = new Pioche();
        
        // Affiche l'état initial du plateau
       
        System.out.println("Etat initial du plateau : \n");
        System.out.println(plateau.toString() + "\n");

        System.out.println(plateau.getNbPiece() + " pièce\n");

        System.out.println("Ajout des ressources à partir des jetons de la pioche\n");

        for (int i = 0; i <= 15; i++)
        {
            String sRet;
            Jeton j = pioche.tirerJeton();

            sRet = j.toString();
            if (plateau.ajouterRessource(j))
		    {
			    sRet += "true";
		    }
		    else
		    {
			    sRet += "false";
		    }
            System.out.println(sRet);
        }

        System.out.println("\n\nEtat final du Plateau");
        System.out.println(plateau.toString() + "\n");

        System.out.println(plateau.getNbPiece() + " pièces");



    }
}