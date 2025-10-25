package TD5;

import UseFul.Matrice;

import java.util.Scanner;

public class TD5EXO5 {
    public static void main(String[] args) {
        initialiserTerrain();
    }

    public static void initialiserTerrain() {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] terrain = new int[n][m];

        for(int i = 0; i < terrain.length; i++) {
            for(int j = 0; j < terrain.length; j++){
                System.out.println("On met quoi ? 0 : terrain vide \n1 : obstacle \n2 : mine");
                int nb = sc.nextInt();
                terrain[i][j] = nb;
            }
        }

        Matrice.afficherMatrice(terrain);
    }

    public static boolean estValide(int x, int y, int[][] terrain) {
        if (y > -1 && y < terrain.length && x > -1 && x < terrain[0].length) {
            return (terrain[y][x] == 0) ? true:false;
        }
        return  false;
    }

    public static boolean estSecurise(int[][] terrain) {

    }
}
