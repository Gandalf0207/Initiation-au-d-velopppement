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

        type = Type.values()[r.nextInt(4)];
        couleur = Couleur.values()[r.nextInt(4)];
        
    }

    public Type getType() {
        return type;
    }

    public Couleur getCouleur() {
        return couleur;
    }
}
