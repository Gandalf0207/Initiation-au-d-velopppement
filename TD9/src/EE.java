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
        for (int i = 0; i < this.getCardinal(); i++) {
            int value = retraitPratique(i);
            if (x == value) {
                return i;
            }
            this.ajoutPratique(value);
        }
        return -1;
    }

    /**
     * @param x est l'élément à chercher dans l'ensemble
     * @return true si l'élément x appartient à l'ensemble, false dans le cas contraire.
     */
    public boolean contient(int x) {
        for (int i = 0; i < this.getCardinal(); i++) {
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
        if (!this.contient(x) && this.ensTab.length != this.cardinal) {
            boolean add = false;
            int i = 0;
            do {
                if (this.ensTab[i] == 0) {
                    this.ensTab[i] = x;
                    this.cardinal++;
                    add = true;
                }
                i++;
            } while (!add);
        }
    }

    /**
     * @param i est l'indice de l'element du tableau this.ensTab à retirer de l'ensemble
     *          Pré-requis : 0 < i < this.cardinal
     *          Action : retire l'élément this.ensTab[i] de l'ensemble courant et le retourne
     * @return l'élément retiré
     * Note : Cette méthode privée est un outil de base utilisable dans les méthodes qui suivent.
     */
    private int retraitPratique(int i) {
        if (0 < i && i < this.cardinal) {
            int value = this.ensTab[i];
            this.ensTab[i] = 0;
            this.cardinal--;
            return value;
        }
        return 0;
    }

    /**
     * @return true si l'ensemble est vide, false dans le cas contraire
     */
    public boolean estVide() {
        for (int i = 0; i < this.cardinal; i++) {
            if (this.ensTab[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return true si le tableau this.ensTab est plein, false dans le cas contraire
     */
    public boolean deborde() {
        return this.getCardinal() == this.ensTab.length;
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
            this.retraitPratique(x);
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
        int lastElt = 0;
        if (!this.estVide()) {
            for (int i = 0; i < this.cardinal; i++) {
                if (this.ensTab[i] != 0) {
                    lastElt = this.ensTab[i];
                }
            }
        }
        return lastElt;
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
            int value;
            do {
                value = rd.nextInt(this.cardinal - 1) + 1;
            } while (this.ensTab[value] != 0);
            return value;
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
        return this.estInclus(e) && e.getCardinal() == this.cardinal;
    }

    /**
     * @param e est un ensemble
     * @return true si this est disjoint de l'ensemble e (c'est-à-dire qu'ils n'ont aucun éléments en commun)
     */
    public boolean estDisjoint(EE e) {
        return !this.estInclus(e);
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
                int value = this.retraitPratique(i);
                if (e.contient(value)) {
                    s += value + " ";
                    cpt++;
                }
                this.ajoutPratique(value);
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
            int cpt = 0;
            for (int i = 0; i < this.cardinal; i++) {
                int value = this.retraitPratique(i);
                if (e.contient(value)) {
                    cpt++;
                }
                this.ajoutPratique(value);
            }

            int lengthMax = e.getCardinal() + this.cardinal - cpt;
            EE elt = new EE(lengthMax);

            // ajout
            for (int i = 0; i < this.cardinal; i++) {
                elt.ajoutElt(this.ensTab[i]);
            }
            for (int i = 0; i < e.getCardinal(); i++) {
                int value = e.retraitPratique(i);
                elt.ajoutElt(value);
                e.ajoutPratique(value);
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
        int cpt = 0;
        String s = "";

        for (int i = 0; i < this.getCardinal(); i++) {
            int value = this.retraitPratique(i);
            if (!union.contient(value)) {
                cpt++;
                s += value;
            }
            this.ajoutPratique(value);
        }

        for (int i = 0; i < e.getCardinal(); i++) {
            int value = e.retraitPratique(i);
            if (!union.contient(value)) {
                cpt++;
                s += value;
            }
            e.ajoutPratique(value);
        }

        return new EE(cpt, s);
    }

}
