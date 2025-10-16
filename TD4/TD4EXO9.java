import java.util.ArrayList;

public class TD4EXO9 {
    public static void main(String[] args) {
        int[] tab = {4,4,4,2,2,3,4,4};
        int[] newTb = TD4EXO9.compresser(tab);

        for(int elt:newTb){
            System.out.print(elt + " ");
        }
    }

    public static int[] compresser(int[] tab) {

        int cpt = 0;
        int lastNum = tab[0];
        for(int i = 1; i<tab.length; i++) {
            if (tab[i] == lastNum) {
                cpt ++;
            } else {
                lastNum = tab[i];
            }
        }

        int[] newTab = new int[tab.length-cpt];
        newTab[0] = tab[0];
        cpt = 1;
        lastNum = tab[0];
        for(int i = 1; i < tab.length; i++) {
            if(tab[i] != lastNum) {
                newTab[cpt] = tab[i];
                lastNum = tab[i];
                cpt ++;
            }
        }

        return newTab;
    }
}
