package UseFul;

import java.util.Random;

public class Calcul {
    public static void main(String[] args) {

    }

    public static int pgcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a%b;
            a = temp;
        }
        return Math.abs(a);
    }

    public static int randomMinMax(int min, int max) {
        Random rnd = new Random();
        int nb = rnd.nextInt(max-min +1) + min;
        return nb;
    }

    public static void schuffleTab(int[] tab) {
        int l = tab.length;
        for(int i = 0; i< l*2; i++) {
            int indice1 = Calcul.randomMinMax(0, l-1);
            int indice2 = Calcul.randomMinMax(0, l-1);

            int tempo = tab[indice1];
            tab[indice1] = tab[indice2];
            tab[indice2] = tempo;
        }
    }
}
