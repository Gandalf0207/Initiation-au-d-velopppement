package TD7.Fichier;

import static UseFul.Calcul.pgcd;

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
        int value = pgcd(this.num, this.denom);
        this.num /= value;
        this.denom /= value;
    }

    public Fraction fractionReduite() {
        int value = pgcd(this.num, this.denom);
        return new Fraction(this.num / value, this.denom / value);
    }

    public Fraction addition(Fraction f) {
        return new Fraction(this.num*f.denom + this.denom*f.num, this.denom*f.denom);
    }

    public Fraction multiplication(Fraction f) {
        return new Fraction(this.num*f.num, this.denom*f.denom);
    }

    public Fraction division(Fraction f) {
        if(f.num != 0 && f.denom != 0) {
            return this.multiplication(f.inverse());
        }

        return new Fraction(0, 0);
    }

    public Fraction puissance(int n) {
        throw new RuntimeException("Méthode non implémentée ! Effacez cette ligne et écrivez le code nécessaire");
    }

    public Fraction inverse() {
        return new Fraction(this.denom, this.num);
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
