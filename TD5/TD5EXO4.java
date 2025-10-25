package TD5;

import UseFul.Tableau;

public class TD5EXO4 {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        int[] tab = sousMatriceCarre(mat,3);
        Tableau.afficherTableau(tab);

    }

    public static int[] sousMatriceCarre (int [][] mat , int k) {

        int indexJStrat = -1;
        int nbIStrick = 0;
        int nbJStrick = 0;
        int[] indexDebut = {-1, -1};

        for(int i = 0; i < mat.length; i++) {
            nbJStrick=0;
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j] == 1) {


                    // fonctionne
                    if(indexJStrat == -1 ){
                        if((mat.length-j-k >= 0)) { // pour éviter de calculer por un truc qui sera trop petit
                            indexJStrat = j;
                            nbJStrick ++;
                        }

                    } else {
                        if (nbJStrick < k && j >= indexJStrat) {
                            if(k-1 == nbJStrick) {
                                nbIStrick++;
                            }
                            nbJStrick++;
                        }

                        if(nbIStrick == k ){
                            indexDebut[0] = i+1-k;
                            indexDebut[1] = j+1-k;
                            return indexDebut;
                        }
                    }

                } else {
                    indexJStrat = -1;

                    nbJStrick = 0;
                    nbIStrick = 0;
                    indexDebut[0] = -1;
                    indexDebut[1] = -1;
                }
            }
        }

        return indexDebut;
    }
}
