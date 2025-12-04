package TD9.src;

public class TestEE {

    public static void main(String[] args) {
        //Effectuez vos tests ici

        //premier constructeur
        EE elt1constructeur = new EE(10);
        afficher("Premier constructeur", elt1constructeur);

        // deuxième constructeur
        EE elt2constructeur = new EE(10, new int[]{1, 2, 3, 4, 5});
        afficher("Second constructeur", elt2constructeur);

        // troisième constructeur
        EE elt3constructeur = new EE(elt2constructeur);
        afficher("Troisième constructeur", elt3constructeur);

        // quatrième constructeur
        EE elt4constructeur = new EE(6, "1 2 3 4 5 6");
        afficher("Quatrième constructeur", elt4constructeur);


        // /// ///
        // elt de base
        EE eltBase = new EE(6, "1 2 3");

        // Méthode public :


        // méthode toString
        EE methodeToStringElt = new EE(eltBase);
        afficher("Méthode toString", methodeToStringElt);

        // méthode get cardinal
        EE methideGetCardinal = new EE(eltBase);
        afficher(String.format("Méthode Get Cardinal \nCarinal est de : %s", methideGetCardinal.getCardinal()), methideGetCardinal);

        // méthode contient
        EE methodeContient = new EE(eltBase);
        afficher(String.format("Méthode contient \nValeur boolean : %s", methodeContient.contient(4)), methodeContient);

        //méthode est vide
        EE methodeEstvide = new EE(eltBase);
        afficher(String.format("Méthode est vide \nEst vide ? : %s", methodeEstvide.estVide()), methodeEstvide);

        //méthode déborde
        EE methodeDéborde = new EE(2, "1 2");
        afficher(String.format("Méthode déborde \nDéborde ? : %s", methodeDéborde.deborde()), methodeDéborde);


        // arrété à retraitElt(int x);


        // ////////
        // Méthode privé :

        eltBase.testFonction(eltBase);


    }

    public static void afficher(String s, EE elt) {
        System.out.println(s);
        System.out.println(elt);
    }

}
