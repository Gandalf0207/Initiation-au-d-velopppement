package TD10.src.main.java.Base;


import java.util.Random;

public class MainCombat {
    private static Random r = new Random();

    public static void main(String[] args) {

        // création arene
        int nbArene = 6;
        for (int i = 0; i < nbArene; i++) {
            Arene arene = new Arene(r.nextInt(30) + 1);
            Orque vainqueur = arene.bataille();
            System.out.println(String.format("%s est vrainquer de l'arene n° %s. La légend de cette arene est %s", vainqueur, i + 1, vainqueur.getLegend()));
        }
    }


}