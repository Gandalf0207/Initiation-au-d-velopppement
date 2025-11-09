package TD7.Fichier;

public class Fraction {
    private int num;
    private int denom;

    public Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    public Fraction(Fraction frac) {
        this.num = frac.num;
        this.denom = frac.denom;
    }

    public String toString() {
        return this.num + "/" + this.denom;
    }

    public void reduire() {

    }

    public Fraction fractionReduite() {
        throw new RuntimeException("Méthode non implémentée ! Effacez cette ligne et écrivez le code nécessaire");
    }

    public Fraction multiplication(Fraction f) {
        throw new RuntimeException("Méthode non implémentée ! Effacez cette ligne et écrivez le code nécessaire");
    }

    public Fraction puissance(int n) {
        throw new RuntimeException("Méthode non implémentée ! Effacez cette ligne et écrivez le code nécessaire");
    }

    public Fraction inverse() {
        throw new RuntimeException("Méthode non implémentée ! Effacez cette ligne et écrivez le code nécessaire");
    }

    public Fraction division(Fraction f) {
        throw new RuntimeException("Méthode non implémentée ! Effacez cette ligne et écrivez le code nécessaire");
    }

}

/**
 * Question 1 :
 * 1. Les attributs de Fraction sont : num et denom, ils sont de type int
 *
 * 2. Ce qui permet de cronstruire Fraction se nomme un constructeur : public Fraction(),
 * il a le meme role dans tous les objects de manière générale, il permet d'initialiser les
 * valeurs données en parametre au sein de l'object pour qu'elles soient utilisables.
 *
 * 3. Ce qui permet d'afficher Fraction est la méthode toSring() qui est un override
 * (car elle existe déjà de base), elle est réécrite. On surcharge la méthode et on formate le
 * texte qu'elle va nous retourner.
 *
 * */
