package TD8BIS.src.java;


import TD8BIS.src.java.utile.Ut;

public class Course {

    private Voiture v1;
    private Voiture v2;
    private int longueur;


    public Course(Voiture uneVoit1, Voiture uneVoit2, int longueur) {
       this.v1 = uneVoit1;
       this.v2 = uneVoit2;
       this.longueur = longueur;
    }

    /**
     * Résultat : retourne une chaîne de caractères contenant les caractéristiques
     * de this (sous la forme de votre choix)
     */
    public String toString() {
      return "course entre " + this.v1.toString() + " et " + this.v2.toString() + "sur une piste de longueur " + this.longueur;
    }

    /**
     * Action : Simule le déroulement d’une course entre this.voit1 et this.voit2
     * sur une piste de longueur this.longueurPiste.
     * <p>
     * Jusqu’à ce qu’une voiture franchisse la ligne d’arrivée, l’une
     * des deux voitures est itérativement sélectionnée aléatoirement et avance.
     * Un affichage des deux voitures (représentées par la première lettre de leur
     * nom) à leur position respective à chaque étape permet de suivre la course.
     * <p>
     * Résultat : la voiture gagnante.
     */
    public Voiture deroulement() {
       while( ! this.v1.depasse(longueur) && ! this.v2.depasse(longueur) ) {
           int random = Ut.randomMinMax(1,100);
           if (random <= 50 ){
               this.v1.avance();
           }
           else {

               this.v2.avance();
           }
           afficherEtat();
           Ut.pause(100);

       }
       if (this.v1.depasse(longueur)) {
           return v1;
       }
       return v2;
    }

    private void afficherEtat() {
        System.out.println(v1.affiche());
        System.out.println(v2.affiche());
        for (int i = 0; i <= longueur; i++) {System.out.print("-");}
        System.out.println();
    }

}
