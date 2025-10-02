
public class EXO1 {

    public static void main(String[] args) {

        int[] tab1 = new int[3];
        int[] tab2 = new int[3];
        boolean[] tab3 = new boolean[3];
        tab1[0] = 3;
        tab1[1] = 2;
        tab1[2] = 1;
        tab2 = tab1;
        if (tab1 < tab2) { // comparaison de longueur mal faite
            System.out.println("tableau 1 petit");
        }
        if (tab2 == tab1) {
            System.out.println("tableaux identiques");
        }
        tab3[1] = false;
        tab3[tab1[1]] = true;
        tab3[1] = tab1[1] == tab2[2];
        for (int i = 0; i < 3; i++) {
            tab3[i] = tab1[i] == tab2[i];
        }
        System.out.println("tab3 = ");
        for (boolean b : tab3) {
            System.out.println(b + " ");
        }

    }
}
