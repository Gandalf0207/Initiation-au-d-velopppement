package TD8BIS.src.java;

public class Velo
{

    /**
     * Action : crée un vélo de nom nom et de vitesse de base vitesseBase
     * Placé à l’origine
     * Initialement l'endurance est maximale, c-a-d égale à 100
     */
    public Velo(String nom, int vitesseBase) {

    }


    /**
     * Pré-requis : (à compléter)
     * Action : fait avancer this d’une distance égale à une proportion de sa vitesse (selon l'endurance), puis met à jour son endurance qui diminue de 10 en 10 (au moins 0)
     * Si l'endurance est élevée (>=70), la vitesse reste inchangée.
     * Si l'endurance est moyenne (>=30 et <70), la vitesse de base est réduite de 25%.
     * Si l'endurance est faible (<30), la vitesse de base est réduite de moitié (au moins 1).
     */

    public void avance() {

    }

    /**
     * Résultat : retourne une chaîne de caractères formée d’une suite d’espaces
     * suivie de l'emoticone "🚴" puis de la première lettre du nom de this, suivie d’un retour
     * à la ligne, le nombre d’espaces étant égal à la position de this.
     */
    public String affiche() {
        throw new RuntimeException("Méthode non implémentée ! Effacez cette ligne et écrivez le code nécessaire");
    }

    /**
     * Résultat : retourne vrai si et seulement si la position de this est
     * supérieure ou égale à limite
     */
    public boolean depasse(int limite) {
        throw new RuntimeException("Méthode non implémentée ! Effacez cette ligne et écrivez le code nécessaire");
    }

    /**
     * Résultat : retourne une chaîne de caractères contenant les caractéristiques
     * de this (sous la forme de votre choix)
     */
    public String toString() {
        throw new RuntimeException("Méthode non implémentée ! Effacez cette ligne et écrivez le code nécessaire");
    }

}
