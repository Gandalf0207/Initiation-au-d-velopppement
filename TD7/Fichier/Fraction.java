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


        int n = this.num;
        int d = this.denom;

        if ((n < 0 && d < 0) || (d < 0)) {
            n = -n;
            d = -d;
        }

        return n + "/" + d;
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
        return new Fraction(
                this.num * f.denom + this.denom * f.num,
                this.denom * f.denom
        );
    }

    public Fraction multiplication(Fraction f) {
        return new Fraction(
                this.num * f.num,
                this.denom * f.denom
        );
    }

    public Fraction division(Fraction f) {
        return this.multiplication(f.inverse());
    }

    public Fraction inverse() {
        // NE PAS RÉDUIRE → les tests l’exigent !
        return new Fraction(this.denom, this.num);
    }

    public Fraction puissance(int n) {
        if (n < 0) {
            Fraction pos = this.puissance(-n);
            return new Fraction(pos.denom, pos.num);
        }

        if (n == 0) return new Fraction(1, 1);

        Fraction result = new Fraction(1, 1);
        for (int i = 0; i < n; i++) {
            result = result.multiplication(this);
        }

        return result;
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
