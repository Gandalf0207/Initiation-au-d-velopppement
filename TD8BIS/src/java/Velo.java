package TD8BIS.src.java;

public class Velo implements vehicule {
    private String nom;
    private int vitesseBase;
    private int position;
    private int endurance;

    /**
     * Action : crée un vélo de nom nom et de vitesse de base vitesseBase
     * Placé à l’origine
     * Initialement l'endurance est maximale, c-a-d égale à 100
     */
    public Velo(String nom, int vitesseBase) {
        this.nom = nom;
        this.vitesseBase = vitesseBase;
        this.position = 0;
        this.endurance = 100;
    }


    /**
     * Pré-requis : (à compléter)
     * Action : fait avancer this d’une distance égale à une proportion de sa vitesse (selon l'endurance), puis met à jour son endurance qui diminue de 10 en 10 (au moins 0)
     * Si l'endurance est élevée (>=70), la vitesse reste inchangée.
     * Si l'endurance est moyenne (>=30 et <70), la vitesse de base est réduite de 25%.
     * Si l'endurance est faible (<30), la vitesse de base est réduite de moitié (au moins 1).
     */

    public void avance() {
        if (endurance >= 70) {
            this.position += this.vitesseBase;
            this.endurance -= 10;
        } else if (this.endurance >= 30) {
            this.position += (int) (this.vitesseBase * 0.75);
            this.endurance -= 10;
        } else {
            this.position += this.vitesseBase / 2 >= 1 ? this.vitesseBase / 2 : 1;
            this.endurance -= this.endurance - 10 > 0 ? 10 : 0;
        }
    }

    /**
     * Résultat : retourne une chaîne de caractères formée d’une suite d’espaces
     * suivie de l'emoticone "🚴" puis de la première lettre du nom de this, suivie d’un retour
     * à la ligne, le nombre d’espaces étant égal à la position de this.
     */
    public String affiche() {
        String s = "";
        for (int i = 0; i < this.position; i++) {
            s += " ";
        }
        s += "🚴" + String.format("%s\n", this.nom.charAt(0));
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
        return String.format("nom : %s \nendurance : %d \nposition : %d \nvitesseBase %d", this.nom, this.endurance, this.position, this.vitesseBase);
    }

}
