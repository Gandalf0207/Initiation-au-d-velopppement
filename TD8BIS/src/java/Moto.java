package TD8BIS.src.java;


import java.util.Random;

public class Moto implements vehicule {
    private String nom;
    private int vitesseBase;
    private int position;
    private double probaCaler;

    /**
     * Action : crée une moto de nom nom et de vitesse de base vitesseBase
     * le couple moteur vaut coupleMoteur et le nombre de cylindres vaut nbCylindres
     * La moto a une probabilité de caler égale à probaCaler
     * Placée à l’origine
     */
    public Moto(int nbCylindres, String nom, double coupleMoteur, int vitesseBase, double probaCaler) {
        this.nom = nom;
        this.vitesseBase = (int) (vitesseBase + coupleMoteur / 50 + nbCylindres);
        this.probaCaler = probaCaler;
        this.position = 0;
    }

    /**
     * La moto a une probabilité égale à probaCaler de caler (dans ce cas elle n'avance pas),
     * sinon elle avance d'une vitesse dont la formule de calcul est vitesse = vitesseBase + couple/50 + nbCylindres
     */
    public void avance() {
        Random makeRandom = new Random();
        double value = makeRandom.nextDouble();
        if (this.probaCaler < value) {
            this.position += this.vitesseBase;
        }
    }

    /**
     * Résultat : retourne une chaîne de caractères formée d’une suite d’espaces
     * suivie de l'emoticone "🏍️" puis de la première lettre du nom de this, suivie d’un retour
     * à la ligne, le nombre d’espaces étant égal à la position de this.
     */
    public String affiche() {
        String s = "";
        for (int i = 0; i < this.position; i++) {
            s += " ";
        }
        s += "🏍️" + String.format("%s\n", this.nom.charAt(0));
        return s;
    }


    /**
     * Résultat : retourne vrai si et seulement si la position de this est
     * supérieure ou égale à limite
     */
    public boolean depasse(int limite) {
        return this.position >= limite;
    }

    /**
     * Résultat : retourne une chaîne de caractères contenant les caractéristiques
     * de this (sous la forme de votre choix)
     */
    public String toString() {
        return String.format("nom : %s \nprobaCaler : %d \nposition : %d \nvitesseBase %d", this.nom, this.probaCaler, this.position, this.vitesseBase);
    }
}
