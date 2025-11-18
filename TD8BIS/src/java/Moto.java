package TD8BIS.src.java;


public class Moto {


    /**
     * Action : crée une moto de nom nom et de vitesse de base vitesseBase
     * le couple moteur vaut coupleMoteur et le nombre de cylindres vaut nbCylindres
     * La moto a une probabilité de caler égale à probaCaler
     * Placée à l’origine
     */
    public Moto(int nbCylindres, String nom, double coupleMoteur, int vitesseBase, double probaCaler) {

    }

    /**
     * La moto a une probabilité égale à probaCaler de caler (dans ce cas elle n'avance pas),
     * sinon elle avance d'une vitesse dont la formule de calcul est vitesse = vitesseBase + couple/50 + nbCylindres
     */
    public void avance() {

    }

    /**
     * Résultat : retourne une chaîne de caractères formée d’une suite d’espaces
     * suivie de l'emoticone "🏍️" puis de la première lettre du nom de this, suivie d’un retour
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
