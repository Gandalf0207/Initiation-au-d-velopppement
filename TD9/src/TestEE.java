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

        // EE elt1 = new EE(5, new int[]{1, 2, 3, 4, 5});
        // EE elt2 = new EE(4, new int[]{4, 5, 6, 7});
//
        // System.out.println("Intersection : ");
        // System.out.println(elt1.intersection(elt2));
        // System.out.println("Difference : ");
        // System.out.println(elt1.difference(elt2));
        // System.out.println("Reunion : ");
        // System.out.println(elt1.reunion(elt2));
    }

    public static void afficher(String s, EE elt) {
        System.out.println(s);
        System.out.println(elt);
    }

}
