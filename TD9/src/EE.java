public class EE {

    /*
    ==================================================
    ATTRIBUTS (section 2 du sujet)
    Attributs à définir : tableau ensTab, cardinal...
    ==================================================
    */

    //Définir les attributs ici.
    private int[] ensTab;
    private int cardinal;

    /*
    ==========================================================
    CONSTRUCTEURS (section 2 du sujet)
    3 (ou 4 si vous faites le bonus) constructeurs à définir !
    ==========================================================
     */

    //Coder les constructeurs ici.
    public void EE(int max) {
        this.cardinal = max;
        this.ensTab = new int[this.cardinal];
    }

    public void EE(int max, int[] tab) {
        this.cardinal = max;
        this.ensTab = tab;
    }

    public void EE(int[] ens) {
        for (int i = 0; i < this.ensTab.length; i++) {
            this.ensTab[i] = ens[i];
        }
    }

    public void EE(int max, String chaine) {
        this.cardinal = max;
        this.ensTab = new int[this.cardinal];
        String[] tabNum = chaine.split(" ");
        for (int i = 0; i < this.cardinal; i++) {
            this.ensTab[i] = Integer.parseInt(tabNum[i]);
        }
    }

    /*
    ====================================
    METHODES UTILES (section 3 du sujet)
    Méthodes à compléter
    ====================================
     */

    /**
     * @return une chaîne de caractères représentant un ensemble du type {n_1, n_2, ..., n_k}
     * (tous les éléments contenus dans l'ensemble).
     */
    public String toString() {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @return le cardinal de l’ensemble
     */
    public int getCardinal() {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @param x est l'élément à chercher dans l'ensemble
     * @return -1 si l’entier x passé en paramètre n’appartient pas à l’ensemble et sinon retourne
     * l’indice du tableau this.ensTab où se trouve l’élément.
     */
    private int contientPratique(int x) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @param x est l'élément à chercher dans l'ensemble
     * @return true si l'élément x appartient à l'ensemble, false dans le cas contraire.
     */
    public boolean contient(int x) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * Pré-requis :
     * - x ne se trouve pas déjà dans l'ensemble
     * - this.ensTab n'est pas plein
     *
     * @param x est un element à ajouter dans l'ensemble
     *          Action : ajoute x a l'ensemble courant
     *          Note : Cette méthode privée est un outil de base utilisable dans les méthodes qui suivent.
     */
    private void ajoutPratique(int x) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @param i est l'indice de l'element du tableau this.ensTab à retirer de l'ensemble
     *          Pré-requis : 0 < i < this.cardinal
     *          Action : retire l'élément this.ensTab[i] de l'ensemble courant et le retourne
     * @return l'élément retiré
     * Note : Cette méthode privée est un outil de base utilisable dans les méthodes qui suivent.
     */
    private int retraitPratique(int i) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @return true si l'ensemble est vide, false dans le cas contraire
     */
    public boolean estVide() {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @return true si le tableau this.ensTab est plein, false dans le cas contraire
     */
    public boolean deborde() {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /*
    =========================================================
    METHODES DE CALCUL SUR LES ENSEMBLES (section 4 du sujet)
    Méthodes à compléter
    =========================================================
     */

    /**
     * @param x est un élément à retirer de l'ensemble
     *          Action : tente de retirer x de l’ensemble courant.
     * @return true si l'élément x appartient à l'ensemble (et a été retiré), false dans le cas contraire
     */
    public boolean retraitElt(int x) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @param x est un élément à ajouter dans l'ensemble
     *          Action : tente d'ajouter x à l’ensemble courant.
     * @return -1 si this.ensTab est plein (déborde)
     * ; 0 si x est déjà contenu dans l'ensemble
     * ; 1 si x a bien été ajouté dans l'ensemble
     * Soyez malins et pensez à ré-utiliser les méthodes définies plus tôt.
     */
    public int ajoutElt(int x) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * Pre-requis : l'ensemble "this" n'est pas vide
     * Action : retire le dernier element de this et le retourne
     *
     * @return l'élément retiré
     */
    public int selectDernierElt() {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * Pre-requis : l'ensemble "this" n'est pas vide
     * Action : sélectionne aléatoirement un element de this, le retire et le retourne
     *
     * @return l'élément retiré
     */
    public int selectEltAleatoirement() {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @param e est un ensemble
     * @return true si this est inclus dans (ou à égal à) l'ensemble e
     * (c'est-à-dire que tous les éléments de this sont inclus dans e), false dans le cas contraire
     */
    public boolean estInclus(EE e) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @param e est un ensemble
     * @return true si this est égal à l'ensemble e
     * (c'est-à-dire qu'ils contiennent exactement les mêmes éléments), false dans le cas contraire.
     */
    public boolean estEgal(EE e) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @param e est un ensemble
     * @return true si this est disjoint de l'ensemble e (c'est-à-dire qu'ils n'ont aucun éléments en commun)
     */
    public boolean estDisjoint(EE e) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @param e est un ensemble
     * @return un ensemble représentant l'intersection entre l'ensemble this et l'ensemble e
     */
    public EE intersection(EE e) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @param e est un ensemble
     * @return un ensemble représentant l'union entre l'ensemble this et l'ensemble e
     */
    public EE reunion(EE e) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

    /**
     * @param e est un ensemble
     * @return un ensemble représentant la difference (ensembliste) entre l'ensemble this et l'ensemble e
     */
    public EE difference(EE e) {
        throw new RuntimeException("Méthode pas encore implémentée !");
    }

}
