package TD10.src.main.java.Base;

import java.util.Random;

public class Arme {
    private Type type;
    private Couleur couleur;

    public enum Type {
        MARTEAU(15),
        HACHE(12),
        LANCE(8),
        EPEE(10);

        private int value;

        Type(int a) {
            this.value = a;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum Couleur {
        ROUGE(90),
        JAUNE(80),
        BLEU(70),
        VERT(60);

        private int pourcentage;

        Couleur(int a) {
            this.pourcentage = a;
        }

        public int getPourcentage() {
            return this.pourcentage;
        }
    }

    public Arme() {
        Random r = new Random();

        int[] armeType = {15, 12, 8, 10};
        int[] armeCouleur = {90, 80, 70, 60};

        int a = r.nextInt(4);
        int b = r.nextInt(4);
        type = Type.values()[armeType[a]];
        couleur = Couleur.values()[armeCouleur[b]];

        System.out.println(type.getValue());
        System.out.println(couleur.getPourcentage());

    }
}
