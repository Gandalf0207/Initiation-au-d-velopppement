package TD5;

import UseFul.Matrice;

import java.time.chrono.MinguoDate;

public class TD5EXO3 {
    public static void main(String[] args) {
        Matrice.afficherMatrice(rangee(4));
        Matrice.afficherMatrice(serpentin(4));
        Matrice.afficherMatrice((diagonale(4)));
        Matrice.afficherMatrice(spirale(4));
    }

    public static int[][] rangee(int n) {
        int[][] mat = new int[n][n];

        int index = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = index;
                index++;
            }
        }
        return mat;
    }

    public static int[][] serpentin(int n) {
        int[][] mat = new int[n][n];

        int index = 1;
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0, k = mat.length - 1; j < mat.length; j++, k--) {
                if (i % 2 == 0) {
                        mat[i][j] = index;
                } else {
                        mat[i][k] = index;
                }
                index++;
            }
        }

        return  mat;
    }

    public static int[][] diagonale(int n) {
        int[][] mat = new int[n][n];

        int index = 1;
        int xmin = 0;
        int y = 0;
        for(int i = 0; i <= y; i++) {
            for(int j = xmin; j <= y-xmin; j++) {

                // comparaison pour la seconde partie du tableau
                System.out.println(i-j);
                if(j >= xmin) {
                    mat[i-j][j] = index;
                    index++;
                }
            }
            // je ne sais plus l'expliquer mais ça fonctionne
            if(y < n-1) {
                y++;
            } else if(y < n*2+1) {
                y ++;
                xmin ++;
            }
        }

        return mat;
    }

    public static int[][] spirale(int n) {
        int[][] mat = new int[n][n];
        return mat;


    }
}
