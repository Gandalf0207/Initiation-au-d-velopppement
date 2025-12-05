package TD10.src.main.java.Base;

public class Arme {
    private String type;
    private String couleur;

    public enum type {
        MARTEUR,
        HACHE,
        LANCE,
        EPEE;
    }

    public enum couleur {
        ROUGE,
        JAUNE,
        BLEU,
        VERT
    }
}
