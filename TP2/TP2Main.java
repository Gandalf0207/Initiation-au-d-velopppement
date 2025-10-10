package TP2;
import java.util.Random;

public class TP2Main {
    public static void main(String[] args) {
        int [] planche = {10, 3};
        int lMin = TP2Main.largeurMin(20, 100, 0.02);
        System.out.println(lMin);
//        TP2Main.afficherProbas(3, 5, 25, 10000);
//        double proba = TP2Main.probaEmpirique(planche, 100);
//        System.out.println(proba);
//        boolean estArrive = TP2Main.arivobato(planche, true);
//        System.out.println(estArrive);
        // TP2Main.TestProbaGenerationAleatoire();
    }

    public static void menuMarin() {

    }

    public static int GenerationAleatoire() {
        Random randomNumbers = new Random();
        return randomNumbers.nextInt(100)+1;
    }

    public static void TestProbaGenerationAleatoire() {
        int s1 = 0; int s2 = 0; int s3 = 0; int s4 = 0;
        for(int i =0; i<1000; i++) {
            int value = TP2Main.GenerationAleatoire();
            if (value < 51) {
                s1 ++;
            } else if (value < 71) {
                s2 ++;
            } else if (value < 91) {
                s3 ++;
            } else {
                s4 ++;
            }
        }

        System.out.println("environ " + (s4*100.0)/1000 + "% de ces nombres sont compris entre 91 et 100");
        System.out.println("environ " + (s1*100.0)/1000 + "% de ces nombres sont compris entre 1 et 50");
        System.out.println("environ " + (s2*100.0)/1000 + "% de ces nombres sont compris entre 51 et 70");
        System.out.println("environ " + (s3*100.0)/1000 + "% de ces nombres sont compris entre 71 et 90");
    }

    public static boolean arivobato(int [] plancheTaille, boolean trace) {
        int longueur = plancheTaille[0];
        int largeur = plancheTaille[1];
        int x = 1; int y = 0;

        while ((y != longueur) && (-1 < x)  && (x < largeur)) {
            int value = TP2Main.GenerationAleatoire();
            if (value < 51) {
                y ++;
            } else if (value < 71) {
                x++;
            } else if (value < 91) {
                x--;
            } else {
                y--;
            }

            if( y < 0 ){
                y = 0;
            }
            if (trace) {
                TP2Main.affichePlanche(longueur, largeur, x, y);
            }
        }

        return y==longueur;
    }

    public static void affichePlanche(int longueur, int largeur, int x, int y){
        System.out.print("\n\n\n");

        for(int i=0; i< largeur; i++) {
            for (int j=0; j < longueur; j++) {
                String c = (i==x && j ==y) ? "O":"-";
                System.out.print(c + " ");
            }
            System.out.println();
        }
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double probaEmpirique(int[] plancheTaille, int nbMarins) {
        int oui = 0;
        for(int i = 0; i < nbMarins; i++) {
            if (TP2Main.arivobato(plancheTaille, false)) {
                oui++;
            }
        }
        return oui / (nbMarins*1.0);
    }

    public static void afficherProbas(int largeur, int longMin, int longMax, int nbMarins) {
        int taille = longMax-longMin +1;
        double[] tableauProbas = new double [taille];
        for (int i = longMin; i < longMax + 1; i++) {
            int [] planche= {i, largeur};
            double value = TP2Main.probaEmpirique(planche, nbMarins);
            tableauProbas[i-longMin] = value;
        }

        for(int i = longMin; i < longMax +1; i++) {
            System.out.println("Longueur : " + i + ", largeur : " + largeur + ", probaEmpirique : " + tableauProbas[i-longMin]);
        }
    }

    public static int largeurMin(int longueur, int nbMarins, double probasMarin) {
        int largeur = 3;
        double proba;
        do {
            int [] planche = {longueur, largeur};
            proba = TP2Main.probaEmpirique(planche, nbMarins);
            largeur++;
        } while (proba < probasMarin);
        return largeur;
    }
}
