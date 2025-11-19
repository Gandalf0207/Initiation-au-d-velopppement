package TD8.src.main.java;

import java.util.Random;

public class ExtensionReflexion {
    Random eltRandom = new Random();

    public void Extension1() {
        int lenPist = 10; // longueur de la poste
        int nbVoiture = 5; // nombre de voiture

        // pour les vitesses, il faut qu'elles soient choisie aléatoirement entre 1 et la
        // longeur de la piste
        int vitesse = eltRandom.nextInt(lenPist)+1;

        // la somme des probabilités de toutes les voitures d'etre choisie doit etre égale à 1


        // get puissance

        int[] listeProba = new int[nbVoiture];
        int total = 0;
        for(int i = 0; i < nbVoiture; i++) {
            // pour chaque voiture on sélectionne

            while
        }



    }
}
