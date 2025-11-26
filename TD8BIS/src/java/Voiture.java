package TD8BIS.src.java;


public class Voiture implements vehicule {

    private String nom;
    private int position;
    private int vitesse;

    /**
     * Pré-requis : (à compléter)
     * Action : crée une voiture de nom unNom et de vitesse uneVitesse
     * placée à l’origine
     */
    public Voiture(String unNom, int uneVitesse) {
        this.nom = unNom;
        this.vitesse = uneVitesse;
    }

    /**
     * Résultat : retourne une chaîne de caractères contenant les caractéristiques
     * de this (sous la forme de votre choix)
     */
    public String toString() {
        return "Voiture " + this.nom + " ayant une vitesse de " + this.vitesse;
    }

    /**
     * Résultat : retourne une chaîne de caractères formée d’une suite d’espaces
     * suivie de l'emoticone "🚗" puis de la première lettre du nom de this, suivie d’un retour
     * à la ligne, le nombre d’espaces étant égal à la position de this.
     */
    public String affiche() {
        String s = "";
        for (int i = 0; i < position; i++) {
            s += " ";
        }
        s += "🚗" + this.nom.charAt(0);
        return s;
    }

    /**
     * Pré-requis : (à compléter)
     * Action : fait avancer this d’une distance égale à sa vitesse
     */
    public void avance() {
        this.position += this.vitesse;
    }


    /**
     * Résultat : retourne vrai si et seulement si la position de this est
     * supérieure ou égale à limite
     */
    public boolean depasse(int limite) {
        return this.position >= limite;
    }
}

