package UseFul;

public class Matrice {
    public static void main(String[] args) {

    }


    // Permet d'afficher une matrice
    public static void afficherMatrice(int[][] matrice) {
        for(int[] ligne:matrice) {
            for(int elt:ligne) {
                System.out.print(elt + " ");
            }
            System.out.println();
        }
            }
}
