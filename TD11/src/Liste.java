package TD11.src;

public class Liste {

    //Maillon en tête de liste (premier maillon de la liste)
    //Possiblement "null" si la liste est vide
    private Maillon tete;

    /**
     * Action : construit une liste vide
     */
    public Liste() {
        this.tete = null;
    }

    /**
     * Action : construit une liste contenant une valeur
     */
    public Liste(int x) {
        this.tete = new Maillon(x);
    }

    /**
     * Action : construit une liste en incluant tous les éléments de tabListe dans la liste créée
     */
    public Liste(int[] tabListe) {
        this();
        if (tabListe.length > 0) {
            this.tete = new Maillon(tabListe[0]);
            Maillon curThis = this.tete;
            for (int i = 1; i < tabListe.length; i++) {
                //Création et accrochage du maillon suivant
                curThis.setSuiv(new Maillon(tabListe[i]));
                curThis = curThis.getSuiv();
            }
        }
    }

    /**
     * Action : construit une liste en recopiant (profondément) les données de la liste l passée en paramètre.
     * Les données copiés doivent être totalement  disjointes de l, c'est-à-dire que la liste 'this' et l
     * ne doivent pas partager les mêmes instances de maillons, mais des instances de maillons distinctes.
     */
    public Liste(Liste l) { // constructeur par recopie profonde
        this();
        if (!l.estVide()) {

            this.tete = new Maillon(l.tete.getVal());
            Maillon curThis = this.tete;
            Maillon curL = l.tete.getSuiv();

            while (curL != null) {
                curThis.setSuiv(new Maillon(curL.getVal())); // creation et accrochage du maillon suivant
                curThis = curThis.getSuiv();
                curL = curL.getSuiv();
            }
        }
    }

    /**
     * Résultat : true si la liste est vide, sinon false.
     */
    public boolean estVide() {
        return (this.tete == null);
    }

    /**
     * Action : ajoute un maillon au début de la liste (en tête de liste)
     */
    public void ajoutTete(int x) {
        Maillon m = new Maillon(x);
        m.setSuiv(this.tete);
        this.tete = m;
    }

    /**
     * Résultat : true si la valeur x est contenue dans la liste 'this', sinon false
     */
    public boolean contient(int x) {
        Maillon courant = this.tete;
        while (courant != null && courant.getVal() != x) {
            courant = courant.getSuiv();
        }
        return courant != null;
    }

    /**
     * Résultat : représentation de la liste 'this' sous forme d'une chaîne de cacractères
     */
    public String toString() {
        String s = "(";
        Maillon courant = this.tete;
        while (courant != null) {
            s = s + (courant.getVal()) + ((courant.getSuiv() != null) ? ", " : "");
            courant = courant.getSuiv();
        }
        return s + ")";
    }

    /**
     * Résultat :le nombre d'éléments de la liste 'this'
     * ATTENTION : cette méthode parcourt tous les maillons de la liste. Pour
     * des raisons d'efficacité (et de pédagogie), sauf mention contraire, il
     * sera donc INTERDIT de faire appel à la méthode longueur pour compléter
     * les méthodes suivantes.
     */
    public int longueur() {

        if (this.estVide()) {
            return 0;
        } else {
            int cpt = 0;
            Maillon curThis = this.tete;
            do {
                cpt++;
                curThis = curThis.getSuiv();
            } while (curThis != null);
            return cpt;
        }
    }

    /**
     * Résultat : la somme des éléments (de leurs valeurs) de la liste 'this'
     */
    public int somme() {
        if (this.estVide()) {
            return 0;
        } else {
            int total = 0;
            Maillon curThis = this.tete;
            do {
                total += curThis.getVal();
                curThis = curThis.getSuiv();
            }
            while (curThis != null);
            return total;
        }
    }

    /**
     * Pré-requis : la liste 'this' n'est pas vide
     * Résultat : la valeur maximum des éléments de la liste 'this'.
     */
    public int maximum() {
        if (this.estVide()) {
            return 0;
        } else {
            int max = this.tete.getVal();
            Maillon curThis = this.tete;
            do {
                if (curThis.getVal() > max) {
                    max = curThis.getVal();
                }
                curThis = curThis.getSuiv();
            } while (curThis != null);
            return max;
        }
    }

    /**
     * Résultat : le nombre d'occurrences de l'entier n dans la liste 'this'.
     */
    public int nbOcc(int n) {
        if (this.estVide()) {
            return 0;
        } else {
            int cpt = 0;
            Maillon curThis = this.tete;
            do {
                cpt += (curThis.getVal() == n) ? 1 : 0;
                curThis = curThis.getSuiv();
            } while (curThis != null);
            return cpt;
        }
    }

    /**
     * Résultat : true si 'this' et l sont clones l'une de l'autre, sinon false.
     * Deux listes sont clones l'une de l'autre si elles ont les mêmes
     * valeurs rangées dans le même ordre.
     */
    public boolean estClone(Liste l) {
        if (this.longueur() != l.longueur()) {
            return false;
        }

        if (!this.estVide()) {
            Maillon curThis = this.tete;
            Maillon curL = l.tete;

            do {
                if (curThis.getVal() != curL.getVal()) {
                    return false;
                }
                curThis = curThis.getSuiv();
                curL = curL.getSuiv();
            } while (curThis != null);
        }

        return true;
    }

    /**
     * Pré-requis : k est un entier positif ou nul
     * Résultat : true ssi la longueur de la liste 'this' est
     * supérieure ou égale à k, sinon false.
     * Contrainte : utilisez un parcours partiel
     */
    public boolean estSupK(int k) {
        if (k >= 0 && !this.estVide()) {
            int cpt = 0;
            Maillon curThis = this.tete;
            do {
                cpt++;
                curThis = curThis.getSuiv();
            } while (curThis != null && cpt < k);
            return cpt >= k;
        }
        return false;

    }

    /**
     * Pré-requis : la liste 'this' n'est pas vide
     * Résultat : le dernier maillon de la liste 'this'
     */
    private Maillon dernierMaillon() {
        if (!this.estVide()) {
            Maillon curThis = this.tete;
            while (curThis.getSuiv() != null) {
                curThis = curThis.getSuiv();
            }
            return curThis;
        }
        return null;
    }

    /**
     * Pré-requis : la liste 'this' n'est pas vide
     * Résultat : la valeur contenue dans le dernier maillon de la liste 'this'
     */
    public int dernierElt() {
        if (!this.estVide()) {
            Maillon lastElt = dernierMaillon();
            return lastElt.getVal();
        }
        return 0;
    }

    /**
     * Action : ajoute un élément de valeur n comme dernier élément de la liste 'this'
     * Astuce : Vous pouvez éventuellement utiliser la méthode dernierMaillon pour
     * écrire cette méthode. Le premier bonus (fin du TD) vous permettra d'écrire
     * une version plus efficace de ajoutFin.
     */
    public void ajoutFin(int n) {
        if (this.estVide()) {
            this.tete = new Maillon(n);
        } else {
            Maillon last = this.dernierMaillon();
            last.setSuiv(new Maillon(n));
        }
    }


    /**
     * Action : ajoute un élément de valeur n comme dernier élément de la liste 'this',
     * seulement si la liste ne possède pas déjà un élément valant n.
     * Contrainte : la méthode parcourt totalement la liste au maximum une fois.
     */
    public void ajoutFinSiAbsent(int n) {

        // liste vide
        if (this.tete == null) {
            this.tete = new Maillon(n);
            return;
        }

        Maillon cur = this.tete;

        // Parcours jusqu'au dernier maillon
        while (cur.getSuiv() != null) {
            if (cur.getVal() == n) {
                return;
            }
            cur = cur.getSuiv();
        }

        //  dernier maillon
        if (cur.getVal() != n) {
            cur.setSuiv(new Maillon(n));
        }
    }


    /**
     * Résultat : une nouvelle liste contenant les éléments de valeur impaire de 'this'
     * Contrainte : l'ordre des éléments de la nouvelle liste n'a pas d'importance
     */
    public Liste extraireImpairsTete() {
        if (this.estVide()) {
            return new Liste();
        }
        Liste newList = new Liste();
        Maillon cur = this.tete;
        while (cur != null) { // accès au dernier maillon
            if (cur.getVal() % 2 != 0) {
                newList.ajoutTete(cur.getVal());
            }
            cur = cur.getSuiv();
        }
        return newList;
    }

    // ici pas check


    /**
     * Résultat : une nouvelle liste contenant les éléments de valeur impaire de 'this'
     * Contrainte : l'ordre des éléments de la nouvelle liste doit être le même que dans 'this'
     */
    public Liste extraireImpairsQueue() {
        if (this.estVide()) {
            return new Liste();
        }
        Liste newList = new Liste();
        Maillon cur = this.tete;
        while (cur != null) { // accès au dernier maillon
            if (cur.getVal() % 2 != 0) {
                newList.ajoutFin(cur.getVal());
            }
            cur = cur.getSuiv();
        }
        return newList;
    }

    /**
     * Résultat : la liste 'this' tronquée après son k ème élément (si un tel élément existe)
     */
    public void tronquerK(int k) {
        if (this.estSupK(k)) {
            int cpt = 0;
            Maillon cur = this.tete;

            while (cpt < k) {
                cpt++;
                cur = cur.getSuiv();
            }
            cur.setSuiv(null);
        }
    }

    /**
     * Action : supprime de la liste 'this' la première occurrence d'un entier n
     * Résultat : true si l'élément n a été trouvé, sinon false
     */
    public boolean supprOcc(int n) {
        if (this.contient(n)) {
            Maillon cur = this.tete;
            while (cur.getSuiv().getVal() != n) {
                cur = cur.getSuiv();
            }
            cur.setSuiv(cur.getSuiv().getSuiv());
        }
        return false;
    }

    /**
     * Résultat : une nouvelle liste contenant les éléments de 'this' dans l'ordre inverse.
     */
    public Liste inverse() {
        Liste newListe = new Liste();

        Maillon cur = this.tete;
        while (cur != null) {
            newListe.ajoutTete(cur.getVal());
            cur = cur.getSuiv();
        }
        return newListe;
    }

    /**
     * Action :  sans créer de nouveau maillon, inverse la liste 'this' à partir du maillon m
     * Résultat : renvoie la reférence du nouveau maillon de tête
     */
    private Maillon inverseRec(Maillon m) {
        throw new RuntimeException("La méthode n'est pas encore implémentée!");
    }

    /**
     * Action :  inverse les éléments de 'this' en faisant appel à la méthode
     * récursive privée "inverseRec (Maillon m)".
     */
    public void inverseRec() {
        throw new RuntimeException("La méthode n'est pas encore implémentée!");
    }

    /**
     * Action : supprime de la liste 'this' toutes les occurrences d'un entier n
     * Contrainte : La version demandée ne parcourt la liste qu'une seule fois !
     * (Une version simple à écrire mais coûteuse fait appel à supprOcc.)
     */
    public void suppToutesOcc(int n) {
        throw new RuntimeException("La méthode n'est pas encore implémentée!");
    }

    /**
     * Résultat : true ssi la suite des éléments de 'this' est égale à la suite des
     * éléments commençant au maillon m, sinon false.
     */
    private boolean estPrefixe(Maillon m) {
        throw new RuntimeException("La méthode n'est pas encore implémentée!");
    }

    /**
     * Résultat : true si 'this' est une sous-liste (éléments consécutifs) de l, sinon false.
     * Conseil : parcouir l et faire appel à chaque itération à la méthode estPrefixe
     * Exemple : (3,3,4) est un préfixe de la liste (1,6,3,3,4,2) à partir du 3ème maillon.
     */
    public boolean sousListe(Liste l) {
        throw new RuntimeException("La méthode n'est pas encore implémentée!");
    }
}
