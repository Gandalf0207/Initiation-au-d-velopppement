package TD5;

import UseFul.Tableau;

public class TD5EXO4 {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1}
        };

        int[] tab = sousMatriceCarre(mat, 2);
        Tableau.afficherTableau(tab);

    }

    public static int[] sousMatriceCarre(int[][] mat, int k) {

        int[] coo = new int[2];
        coo[0] = -1;
        coo[1] = -1;
        for (int i = 0; i < mat.length - k; i++) {
            for (int j = 0; j < mat[0].length - k; j++) {
                if (ssMathUn(mat, i, j, k)) {
                    coo[0] = i;
                    coo[1] = j;
                    return coo;
                }
            }
        }
        return coo;
    }

    public static boolean ssMathUn(int[][] mat, int i0, int j0, int k) {
        boolean b = true;
        if (k > mat.length) {
            return false;
        }
        ;

        for (int i = i0; i < i0 + k; i++) {
            for (int j = j0; j < j0 + k; j++) {
                b = b && (mat[i][j] == 1);
            }
        }
        return b;
    }
}
