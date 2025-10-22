package TP3.devinit.Taquin;
import java.util.Scanner;
import UseFul.Matrice;
import UseFul.Calcul;


public class Taquin {
    
    public static void main (String [] args) {

        int[][] grille1 = { {0,1,2,3},
                {4,5,6,7},
                {8,9,10,11},
                {12,13,15,14}
        };

        int[][] grille2 = { {1,0,2},
                {4,5,3},
                {7,8,6}
        };

        int [][] grille3 = { {1,2,3},
                {4,5,6},
                {7,8,0}
        };

        System.out.print(grille1);
        System.out.println("---------------------------");

        System.out.print(grille2);
        System.out.println("---------------------------");


        //======= Tests de sontDansLOrdre(i1,j1,i2,j2)

        boolean res;
        res = sontDansLOrdre(3,2,4,0);
        System.out.println("Le carreau en position (3,2) est-il inférieur à celui en position (4,0) ? " + res);

        //======= Tests de positionTrou

        int[] trou1;
        trou1 = positionTrou(grille1);
        System.out.println("Les coordonnées du trou sont x=" + trou1[0] + " ; y=" + trou1[1]);

        //======= Tests de estGagnant

        boolean res2;
        res2 = estGagnant(grille1);
        System.out.println("Le taquin 1 (grille1) est solution ? " + res2);

        //======= Tests de genererGrille

        int[][] grilleAlea;
        grilleAlea = genererGrille(4);
        System.out.println("Grille valide générée aléatoirement de taille 4 :");
        Matrice.afficherMatrice(grilleAlea);


        jouer();
    }

    /** Résultat : vrai si les carreaux (i1,j1) et (i2,j2) sont dans l'ordre, et faux sinon.
     L'ordre est lexicographique, selon la ligne, puis la colonne.
     */
    public static boolean sontDansLOrdre(int i1, int j1, int i2, int j2) {

        if(i1 != i2) {
            return i1 < i2;
        } else {
            return j1 < j2;
        }
    }

    /** Résultat : un tableau de deux cases contenant les coordonnées du trou dans la grille 
     */
    public static int[] positionTrou(int[][] grille) {
        int [] trou;       // Déclaration d'un tableau
        trou = new int[2]; // Allocation mémoire d'un tableau (vide) de deux cases de type entier

        for(int i =0; i < grille.length; i++) {
            for(int j = 0; j < grille[i].length; j++) {
                if (grille[i][j] == 0) {
                    trou[0] = i;
                    trou[1] = j;
                    break;
                }
            }
        }
        return trou;
    }

    /** Résultat : vrai si la grille contient les nombres dans l'ordre, et le trou en bas à droite ; faux sinon 
     */
    public static boolean estGagnant(int[][] grille) {
        int[] posTrou = positionTrou(grille);
        if( posTrou[0] == (grille.length-1) && posTrou[1] == (grille.length-1)) {
            int cpt = 0;
            for(int i = 0; i < grille.length; i++) {
                for (int j = 0; j < grille.length; j++) {
                    if(grille[i][j] > cpt) {
                        cpt++;
                    } else if((i == (grille.length-1)) && (j == (grille.length-1))) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static char saisirDeplacement() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veillez saisir un mouvement n/s/e/o :");
        char carac = sc.next().charAt(0);
        return carac;
    }

    public static void deplacerTrou(int[][] grille, int[] posTrou) {

        boolean DeplacementPossible = false;

        do {
            char deplacement = saisirDeplacement();

            if (deplacement == 'n' && posTrou[0] > 0 ) {
                int value = grille[posTrou[0] -1][posTrou[1]];
                grille[posTrou[0]][posTrou[1]] = value;
                grille[posTrou[0] -1][posTrou[1]] = 0;
                DeplacementPossible = true;
            } else if (deplacement == 's' && posTrou[0] < grille.length -1) {
                int value = grille[posTrou[0] + 1][posTrou[1]];
                grille[posTrou[0]][posTrou[1]] = value;
                grille[posTrou[0] + 1][posTrou[1]] = 0;
                DeplacementPossible = true;
            } else if( deplacement == 'e' && posTrou[1] < grille.length -1) {
                int value = grille[posTrou[0]][posTrou[1] +1];
                grille[posTrou[0]][posTrou[1]] = value;
                grille[posTrou[0]][posTrou[1] +1] = 0;
                DeplacementPossible = true;
            } else if(deplacement == 'o' && posTrou[1] > 0) {
                int value = grille[posTrou[0]][posTrou[1] -1];
                grille[posTrou[0]][posTrou[1]] = value;
                grille[posTrou[0]][posTrou[1] -1] = 0;
                DeplacementPossible = true;
            }
        } while (!DeplacementPossible);
    }

    /** Résultat : une grille générée aléatoirement mais valide, c'est-à-dire qui contient tous les nombres
     entre 0 et n^2 - 1
     */
    public static int[][] genererGrille(int n){
        int[][] g = new int[n][n];

        // Affection toutes les valeurs dans un tableau de tempo
        int[] tab = new int[n*n];
        for(int i = 0; i< n*n; i++) {
            tab[i] = i;
        }

        // Randomisation du tableau
        Calcul.schuffleTab(tab);

        // Affectation des valeurs dans la grille
        for(int i = 0; i < n; i++) {
            for (int j = 0; j< n; j++) {
                g[i][j] = tab[i*n + j];
            }
        }

        return g;
    }

    public static void parties() {

        // calcul note joueur
        int valide = 0;

        // nombre parties à jouer
        Scanner sc = new Scanner(System.in);
        System.out.print("Nb de parties : ");
        int nbGame = sc.nextInt();

        for(int i = 0; i < nbGame; i++) {
            int[][] grille = genererGrille(4);

            // nb max / game
            System.out.print("Nb max de coup, k pour la parties actuelle : ");
            int nbMax = sc.nextInt();

            // jeu
            int k = 0;
            while (!estGagnant(grille) && (k+1)<= nbMax) {
                Matrice.afficherMatrice(grille);
                deplacerTrou(grille, positionTrou(grille));
                k++;
            }

            // affection de la note
            if(estGagnant(grille)) {
                valide++;
            }
        }

        // note finale
        System.out.println("Note : " + valide + " / " + nbGame);

    }

    public static void jouer() {
        parties();
    }







}
