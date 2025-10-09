package TP2;

import java.util.Random;

public class TP2Main {
    public static void main(String[] args) {
        // TP2Main.TestProbaGenerationAleatoire();
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

    public static boolean arivobato(int [] plancheTaille) {

    }



}
