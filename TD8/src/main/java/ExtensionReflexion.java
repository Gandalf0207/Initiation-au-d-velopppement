package TD8.src.main.java;

import java.util.Random;

public class ExtensionReflexion {
    Random eltRandom = new Random();
    public int vitesse;
    public int position;
    public int sens;
    public int nbLongPiste;

    public void Extension1() {
        int lenPist = 10; // longueur de la poste
        int nbVoiture = 5; // nombre de voiture

        // pour les vitesses, il faut qu'elles soient choisie aléatoirement entre 1 et la
        // longeur de la piste
        int vitesse = eltRandom.nextInt(lenPist)+1;

        // la somme des probabilités de toutes les voitures d'etre choisie doit etre égale à 1


        // get puissance

        int[] liste = new int[nbVoiture];
        double[] listeProba = new double[nbVoiture];
        double total = 0.0;
        for(int i = 0; i < nbVoiture; i++) {
            // pour chaque voiture on sélectionne une valeur aléatoire en 1 et le nb de voiture
            // on calcule la somme et on en déduit la probabilité
            int value = eltRandom.nextInt(nbVoiture) +1;
            liste[i] = value;
            total += value;
        }

        for(int i = 0; i < nbVoiture ; i++) {
            listeProba[i] = liste[i] / total; // c'est un double car total est un double
        }


        // on sélectionne la voiture en fonction de sa proba
        // ...
        // ...
        // ...

        // on fait avancer la voiture



    }

    public void Extension2() {
        // il faut ajouter une méthode adaptation qui va permettre d'accelerer ou de décélérer
        // si l'écrat entre la voiture 1 et 2 est suppérieur à une valeur donnée

        // ajouter une méthode compter qui permet de calculer le nombre total d'unité parcourur

        //code de compter :
        int longueur = 56; // valeur donnée dans compter

        // en fonction du sens, le nimbre d'unité parcourue se calcul differement
        int total =  this.sens == 1 ? this.nbLongPiste * longueur + this.position: this.nbLongPiste * longueur + (longueur-this.position);

        // code de adapter
        int maxEcart = 45;
        Voiture voit2 = new Voiture("A", 12); // elt voiture passé en parametre
        // comparaison pour accelerer ou non.

        //if(this.compter < voit2.compter - maxEcart) {
            // on accelère 1 fois (on avance à 2 fois la vitesse
            //this.avancer();
        //}

        //le code de adapter doit etre appeler dans avancer ou bien dans la gestion de la course pour chaque voiture

    }

    public void Extension3() {
        // on crée x voiture dans un tableau, on get une voiture aléatoire dans le tableau, on la fait avancer.
        // meme princice que pour deux voiture mais on en crée n voiture
    }
}

