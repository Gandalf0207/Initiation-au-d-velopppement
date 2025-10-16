import java.lang.reflect.Array;
import java.util.ArrayList;

public class TD4EXO10 {
    public static void main(String[] args) {
        int[] t1 = {3, 5, 8};
        int[] t2 = {5, 7, 3, 9};
        int[] newTab = TD4EXO10.fusionSansDoublon(t1, t2);

        for(Integer elt:newTab) {
            System.out.print(elt + " ");
        }
    }

    public static int[] fusionSansDoublon(int[] t1, int[] t2) {

        //concaténation dans un nouveau tableau de T1 et T2
        int[]fullTab = new int[t1.length + t2.length];
        for(int i = 0; i< t1.length; i++) {
            fullTab[i] = t1[i];
        }
        for(int i = t1.length; i<(t1.length + t2.length); i++) {
            fullTab[i] = t2[i- t1.length];
        }

        // calcul nombre :
        int nb = 0;
        int dixPuissance = 1;
        for(int i = fullTab.length-1; i > -1; i--) {
            nb += fullTab[i]*dixPuissance;
            dixPuissance*= 10;
        }

        // get fréquence des chiffres
        int[] freq = EXO3.frequencesChiffres(nb);

        // calcul nouvelle longueur tableau final
        int cpt = 0;
        for(int elt:freq) {
            if(elt > 1) {
                cpt += elt-1;
            }
        }

        int[] finalTab = new int[fullTab.length-cpt];
        cpt = finalTab.length-1;
        for(int i = fullTab.length-1; i> -1; i--) {
            if(freq[fullTab[i]] > 1) {
                freq[fullTab[i]] --;
            } else {
                finalTab[cpt] = fullTab[i];
                cpt --;
            }
        }

        return  finalTab;
    }
}
