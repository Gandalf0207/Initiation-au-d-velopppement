package TD11.src;

public class MainListe {

    public static void main(String[] args) {

        Liste L1 = new Liste(3);
        L1.ajoutTete(2);
        L1.ajoutTete(6);

        int[] tab = {-3, -8, 5, 6, 8, 2, 6};
        Liste L2 = new Liste(tab);

        System.out.println("L1 = " + L1);
        System.out.println("L2 = " + L2);

        // Décommenter au fur et à mesure pour tester les méthodes

        //Liste Lvide = new Liste();
        //Liste L2copie = new Liste(L2);

        //System.out.println("Lvide = " + Lvide);
        //System.out.println("L2copie = " + L2copie);

        //System.out.println("2 appartient L1 ? " + L1.contient(2));
        //System.out.println("1 appartient Lvide ? " + Lvide.contient(1));

        //System.out.println("Longueur de L1 = " + L1.longueur());

        //System.out.println("Somme de L1 = " + L1.somme());
        //System.out.println("Somme de L2 = " + L2.somme());

        //System.out.println("Max L1 = " + L1.maximum());
        //System.out.println("Max L2 = " + L2.maximum());

        //System.out.println("Nb d'occurrences de 3 dans L1 = " + L1.nbOcc(3));
        //System.out.println("Nb d'occurrences de 6 dans L2 = " + L2.nbOcc(6));

        //int[] tab4 = {1, 2, 3, 4};
        //Liste L4 = new Liste (tab4);

        //int[] tab5 = {0, 1, 2, 3, 4};
        //Liste L5 = new Liste (tab5);

        //System.out.println("L4 = " + L4 + " L5 = " + L5);
        //System.out.println("L4 clone de L5 = " + L4.estClone(L5));
        //Liste L4clone = new Liste(L4);
        //System.out.println("L4clone clone de L4 = " + L4.estClone(L4clone));

        //System.out.println("Longueur L1 >= 2 ? = " + L1.estSupK(2));
        //System.out.println("Longueur L1 >= 3 ? = " + L1.estSupK(3));
        //System.out.println("Longueur L1 >= 4 ? = " + L1.estSupK(4));

        //System.out.println("Dernier de L1 = " + L1.dernierElt());

        //L1.ajoutFin(-7);
        //System.out.println("Ajout de -7 en fin de L1 = " + L1);

        //L1.ajoutFinSiAbsent(4);
        //System.out.println("Ajout de 4 dans L1 car absent = " + L1);
        //L1.ajoutFinSiAbsent(4);
        //System.out.println("Non ajout de 4 dans L1 car present = " + L1);
        //L2.ajoutFinSiAbsent(2);
        //System.out.println("Non ajout de 2 dans L2 car present " + L2);
        //Lvide.ajoutFinSiAbsent(1);
        //System.out.println("Ajout de 1 a une liste vide = " + Lvide);

        //System.out.println("Extraire impairs tete de L1 = " + L1.extraireImpairsTete());
        //System.out.println("Extraire impairs queue de L2 = " + L2.extraireImpairsQueue());

        //L2copie.tronquerK(2);
        //System.out.println("Tronque L2 (copie) à l'indice 2 = " + L2copie);

        //System.out.print("Suppr first 3 de L1 : L1 avant = " + L1);
        //boolean res = L1.supprOcc(3);
        //System.out.println(" ; L1 après = " + L1 + " ; res = " + res);

        //System.out.print("Suppr first 6 de L2 : L2 avant = " + L2);
        //res = L2.supprOcc(6);
        //System.out.println(" ; L2 après = " + L2 + " ; res = " + res);

        //System.out.print("Suppr first 6 de L2 : L2 avant = " + L2);
        //res = L2.supprOcc(6);
        //System.out.println(" ; L2 après = " + L2 + " ; res = " + res);

        //System.out.print("Suppr first 6 de L2 : L2 avant = " + L2);
        //res = L2.supprOcc(6);
        //System.out.println(" ; L2 après = " + L2 + " ; res = " + res);

        //System.out.print("Suppr first -3 de L2 : L2 avant = " + L2);
        //res = L2.supprOcc(-3);
        //System.out.println(" ; L2 après = " + L2 + " ; res = " + res);

        //System.out.println("L4 a l'envers = " + L4.inverse());

        //System.out.print("Inversion en place de L4 = ");
        //L4.inverseRec();
        //System.out.println(L4);

        //int[] tab3 = {-3, -3, -8, -3, -3, 6, -3, 5, -3, 8, -3};
        //Liste L3 = new Liste (tab3);
        //System.out.println("L3 = " + L3);
        //L3.suppToutesOcc(-3);
        //System.out.println("SuppToutesOcc de -3 dans L3 = " + L3);

        //int[] tab6 = {8, 8, 6};
        //Liste L6 = new Liste (tab6);
        //int[] tab7 = {1, 5, 8, 8, 4, 6, 8, 6, 4};
        //Liste L7 = new Liste (tab7);
        //System.out.println("L6 = " + L6 + " L7 = " + L7 + " Sous Liste ? " + L6.sousListe(L7));

        //int[] tab8 = {8, 8, 6};
        //Liste L8 = new Liste (tab8);
        //int[] tab9 = {1, 5, 8, 8, 4, 6, 8, 8, 6, 4};
        //Liste L9 = new Liste (tab9);
        //System.out.println("L8 = " + L8 + " L9 = " + L9 + " Sous Liste ? " + L8.sousListe(L9));
    }
}
