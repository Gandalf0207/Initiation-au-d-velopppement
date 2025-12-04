package TD9.src;

import java.util.Random;
import java.util.Scanner;

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
    public EE(int max) {
        this.cardinal = 0;
        this.ensTab = new int[max];
    }

    public EE(int max, int[] tab) {
        this.cardinal = tab.length;
        this.ensTab = new int[max];
        for (int i = 0; i < tab.length; i++) {
            this.ensTab[i] = tab[i];
        }
    }

    public EE(EE ens) {
        this.cardinal = ens.cardinal;
        this.ensTab = new int[ens.ensTab.length];
        for (int i = 0; i < ens.cardinal; i++) {
            this.ensTab[i] = ens.ensTab[i];
        }
    }

    public EE(int max, String num) {
        this.ensTab = new int[max];
        int[] tab = new int[num.length()];
        Scanner sc = new Scanner(num);

        int iaux = 0;
        while (sc.hasNext()) {
            tab[iaux] = sc.nextInt();
            iaux++;
        }

        this.cardinal = iaux;
        for (int i = 0; i < iaux; i++) {
            this.ensTab[i] = tab[i];
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
        String s = "";
        for (int i = 0; i < this.cardinal - 1; i++) {
            if (this.ensTab[i] != 0) {
                s += this.ensTab[i] + ", ";
            }
        }
        s += this.cardinal > 0 ? this.ensTab[this.cardinal - 1] : " ";
        return s;
    }

    /**
     * @return le cardinal de l’ensemble
     */
    public int getCardinal() {
        return this.cardinal;
    }

    /**
     * @param x est l'élément à chercher dans l'ensemble
     * @return -1 si l’entier x passé en paramètre n’appartient pas à l’ensemble et sinon retourne
     * l’indice du tableau this.ensTab où se trouve l’élément.
     */
    private int contientPratique(int x) {
        for (int i = 0; i < this.cardinal; i++) {
            if (x == this.ensTab[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param x est l'élément à chercher dans l'ensemble
     * @return true si l'élément x appartient à l'ensemble, false dans le cas contraire.
     */
    public boolean contient(int x) {
        for (int i = 0; i < this.cardinal; i++) {
            if (x == this.ensTab[i]) {
                return true;
            }
        }
        return false;
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
        if (!this.contient(x) && !this.deborde()) {
            this.ensTab[this.cardinal] = x;
            this.cardinal++;
        }
    }

    /**
     * @param i est l'indice de l'element du tableau this.ensTab à retirer de l'ensemble
     *          Pré-requis : 0 <= i < this.cardinal
     *          Action : retire l'élément this.ensTab[i] de l'ensemble courant et le retourne
     * @return l'élément retiré
     * Note : Cette méthode privée est un outil de base utilisable dans les méthodes qui suivent.
     */
    private int retraitPratique(int i) {
        if (0 <= i && i < this.cardinal) {
            int value = this.ensTab[i];

            for (int j = i; j < this.cardinal - 1; j++) {
                this.ensTab[j] = this.ensTab[j + 1];
            }
            this.cardinal--;
            return value;
        }
        return 0;
    }

    /**
     * @return true si l'ensemble est vide, false dans le cas contraire
     */
    public boolean estVide() {
        return this.cardinal == 0;
    }

    /**
     * @return true si le tableau this.ensTab est plein, false dans le cas contraire
     */
    public boolean deborde() {
        return this.cardinal == this.ensTab.length;
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
        if (this.contient(x)) {
            this.retraitPratique(this.contientPratique(x));
            return true;
        }
        return false;
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
        if (this.deborde()) {
            return -1;
        } else if (this.contient(x)) {
            return 0;
        } else {
            this.ajoutPratique(x);
            return 1;
        }
    }

    /**
     * Pre-requis : l'ensemble "this" n'est pas vide
     * Action : retire le dernier element de this et le retourne
     *
     * @return l'élément retiré
     */
    public int selectDernierElt() {
        if (!this.estVide()) {
            return this.retraitPratique(this.cardinal - 1);
        }
        return 0;
    }

    /**
     * Pre-requis : l'ensemble "this" n'est pas vide
     * Action : sélectionne aléatoirement un element de this, le retire et le retourne
     *
     * @return l'élément retiré
     */
    public int selectEltAleatoirement() {
        if (!this.estVide()) {
            Random rd = new Random();
            int value = rd.nextInt(this.cardinal);
            return this.retraitPratique(value);
        }
        return 0;
    }

    /**
     * @param e est un ensemble
     * @return true si this est inclus dans (ou à égal à) l'ensemble e
     * (c'est-à-dire que tous les éléments de this sont inclus dans e), false dans le cas contraire
     */
    public boolean estInclus(EE e) {
        for (int i = 0; i < this.cardinal; i++) {
            if (!e.contient(this.ensTab[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param e est un ensemble
     * @return true si this est égal à l'ensemble e
     * (c'est-à-dire qu'ils contiennent exactement les mêmes éléments), false dans le cas contraire.
     */
    public boolean estEgal(EE e) {
        return e.getCardinal() == this.cardinal && this.estInclus(e);
    }

    /**
     * @param e est un ensemble
     * @return true si this est disjoint de l'ensemble e (c'est-à-dire qu'ils n'ont aucun éléments en commun)
     */
    public boolean estDisjoint(EE e) {
        for (int i = 0; i < this.cardinal; i++) {
            if (e.contient(this.ensTab[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param e est un ensemble
     * @return un ensemble représentant l'intersection entre l'ensemble this et l'ensemble e
     */
    public EE intersection(EE e) {
        String s = "";
        int cpt = 0;

        if (this.estDisjoint(e)) {
            return new EE(0);
        } else {
            for (int i = 0; i < this.cardinal; i++) {
                int value = this.ensTab[i];
                if (e.contient(value)) {
                    s += value + " ";
                    cpt++;
                }
            }
            return new EE(cpt, s);
        }
    }

    /**
     * @param e est un ensemble
     * @return un ensemble représentant l'union entre l'ensemble this et l'ensemble e
     */
    public EE reunion(EE e) {
        if (this.estVide() || e.estVide()) {
            return this.estVide() ? e : new EE(this.cardinal, this.ensTab);
        } else {
            int len = e.getCardinal() + this.cardinal;
            EE elt = new EE(len);

            // ajout
            for (int i = 0; i < this.cardinal; i++) {
                elt.ajoutElt(this.ensTab[i]);
            }
            for (int i = 0; i < e.getCardinal(); i++) {
                elt.ajoutElt(e.ensTab[i]);
            }

            return elt;
        }
    }

    /**
     * @param e est un ensemble
     * @return un ensemble représentant la difference (ensembliste) entre l'ensemble this et l'ensemble e
     */
    public EE difference(EE e) {
        EE union = this.reunion(e);

        for (int i = 0; i < this.cardinal; i++) {
            if (union.contient(this.ensTab[i])) {
                union.retraitPratique(i);
            }
        }
        return union;
    }


    // méthodes en plus pour les tests

    public void testFonction(EE eltBase) {
        // methode contient pratique
        EE methodeContientPratique = new EE(eltBase);
        afficher(String.format("Méthode contientPratique \n indice élément contenu : %s", methodeContientPratique.contientPratique(2)), methodeContientPratique);

        // méthode ajoutPratique
        EE methodeAjoutPratique = new EE(eltBase);
        methodeAjoutPratique.ajoutPratique(4);
        afficher("Méthode ajoutPratique", methodeAjoutPratique);

        // méthode retraitPratique
        EE methodeRetraitPratique = new EE(eltBase);

        afficher(String.format("Méthode retraitPratique \nValeur retiré : %s ", methodeRetraitPratique.retraitPratique(0)), methodeRetraitPratique);
    }

    public void afficher(String s, EE elt) {
        System.out.println(s);
        System.out.println(elt);
    }

}
