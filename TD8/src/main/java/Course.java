package TD8.src.main.java;

import TD8.src.main.java.utile.Ut;

import java.util.Random;

public class Course {
    private Voiture voit1;
    private Voiture voit2;
    private int longueur;

    /**
     * Pré-requis : (à compléter)
     * Action : (à compléter)
     */
    public Course(Voiture uneVoit1, Voiture uneVoit2, int longueur) {
        this.voit1 = uneVoit1;
        this.voit2 = uneVoit2;
        this.longueur = longueur;
    }

    /**
     * Résultat : retourne une chaîne de caractères contenant les caractéristiques
     * de this (sous la forme de votre choix)
     */
    public String toString() {
        return String.format("La voiture %s et la voiture %s sont en compétition sur une piste de longueur %d mètres.", this.voit1.getNom(), this.voit2.getNom(), this.longueur);
    }

    /**
     * Action : Simule le déroulement d’une course entre this.voit1 et this.voit2
     * sur une piste de longueur this.longueurPiste.
     * this.voit1 et this.voit2 sont d’abord placées sur la ligne de départ.
     * <p>
     * Ensuite, jusqu’à ce qu’une voiture franchisse la ligne d’arrivée, l’une
     * des deux voitures est itérativement sélectionnée aléatoirement et avance.
     * Un affichage des deux voitures (représentées par la première lettre de leur
     * nom) à leur position respective à chaque étape permet de suivre la course.
     * <p>
     * Résultat : la voiture gagnante.
     */
    public Voiture deroulement() {
        Random randomNumbers  = new Random(2);
        Voiture[] listVoit = {this.voit1, this.voit2};
        do {
            //avance voiture
            int value = randomNumbers.nextInt(1);
            listVoit[value].avance();

            // affichage
            Ut.clearConsole();
            System.out.print(this.voit1.affiche());
            System.out.println();
            System.out.print(this.voit2.affiche());
            Ut.pause(250);

        } while(!(this.voit1.depasse(this.longueur) || this.voit1.depasse(this.longueur)));





        return this.voit1.depasse(this.longueur) ? this.voit1:this.voit2;
    }
}
