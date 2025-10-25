package TD5;

import UseFul.Matrice;

public class TD5EXO2 {
    public static void main(String[] args) {
        Matrice.afficherMatrice(carreMag(3));

    }

    public static int[][] carreMag(int n) {
        int[][] mat = new int[n][n];
        int x = n/2;
        int y = 0;

        int newX = x;
        int newY = y;

        // on place le 1
        mat[y][x] = 1;

        for(int i = 2; i < (n*n+1) ; i++) {
            newX = (x+1) % n;
            newY = (y-1 > -1) ? y-1:n-1;

            // on place les éléments au bon endroit
            if(mat[newY][newX] != 0) {
                y++;
            } else {
                x = newX;
                y = newY;
            }

            mat[y][x] = i;
        }

        return mat;
    }
}
