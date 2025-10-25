package TD5;

import UseFul.Matrice;

public class TD5EXO1 {
    public static void main(String[] args) {
        int[][] mat1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] mat2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] add = addition(mat1,mat2);
        Matrice.afficherMatrice(add);

        System.out.println(sommeDiagos(mat1));
    }

    public static int[][] addition(int[][] m1, int[][] m2) {

        //on crée une nouvelle matrice pour ne pas modifier les anciennes

        int[][] m = new int[m1.length][m1.length];
        for(int i = 0; i < m1.length; i++) {
            for (int j= 0; j < m1.length; j++) {
                m[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m;
    }

    public static int sommeDiagos(int[][] mat) {
        int somme = 0;
        for(int i = 0; i < mat.length; i++) {
            for (int j= 0; j < mat.length; j++) {
                if(i==j) {
                    somme += mat[i][j] + mat[i][mat.length-i-1];
                }
            }
        }
        return somme;
    }

    public static int nbElemNuls(int[][] t) {
        int nbEltNuls = 0;

        for(int i = 0; i < t.length; i++) {
            for (int j= 0; j < t.length; j++) {
                if( t[i][j] == 0 ){
                    nbEltNuls++;
                }
            }
        }

        return nbEltNuls;
    }

    public static boolean existeValeurNulle(int[][] t) {
        return (nbElemNuls(t) != 0) ? true:false;
    }

    public static void existeValeurNulleBis(int[][] t) {
        if (nbElemNuls(t) != 0) {
            System.out.println("vrai");
        } else {
            System.out.println("faux");
        }
    }

    public static int ligneAvecPlusDeValNulles(int[][] t) {
        int idMax = 0;
        int nbValNuls = 0;

        for(int i = 0; i < t.length; i++) {
            int sommeTemps = 0;
            for (int j= 0; j < t.length; j++) {
                if( t[i][j] == 0 ){
                    sommeTemps++;
                }
            }

            if(sommeTemps > nbValNuls) {
                idMax = i;
                nbValNuls = sommeTemps;
            }
        }

        return  idMax;
    }

    public static boolean ligneAvecPlusieursValNulles(int[][] t) {
        for(int i = 0; i < t.length; i++) {
            int sommeTemps = 0;
            for (int j= 0; j < t.length; j++) {
                if( t[i][j] == 0 ){
                    sommeTemps++;
                }
            }
            if(sommeTemps > 1) {
                return true;
            }
        }
        return false;
    }
}
