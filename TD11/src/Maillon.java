package TD11.src;

public class Maillon {

    //Valeur (entier) contenue dans le maillon
    private int valeur;

    //Maillon qui suit "this" (possiblement à null si "this" n'a pas de suivant)
    private Maillon suivant;

    /**
     * Action : construit un Maillon avec une valeur
     */
    public Maillon(int n) {
        valeur = n;
        suivant = null;
    }

    /**
     * Résultat : la valeur (entier) contenue dans le Maillon "this"
     */
    public int getVal() {
        return this.valeur;
    }

    /**
     * Action : modifie la valeur contenue dans le Maillon "this"
     */
    public void setVal(int v) {
        this.valeur = v;
    }

    /**
     * Résultat : le maillon qui suit "this" (possiblement null si "this" n'a pas de suivant)
     */
    public Maillon getSuiv() {
        return this.suivant;
    }

    /**
     * Action : Modifie le maillon qui suit "this" (on peut préciser "null" si on ne veut que "this" ne
     * soit suivi par aucun maillon).
     */
    public void setSuiv(Maillon m) {
        this.suivant = m;
    }

    /**
     * Résultat : représentation de "this" en chaîne de caractères.
     * On retourne la chaîne représentant la valeur (entier) contenu dans le maillon
     */
    public String toString() {
        return Integer.toString(this.valeur);
    }
}
