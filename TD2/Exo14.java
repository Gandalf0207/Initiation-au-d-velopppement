import java.util.Scanner;

public class Exo14 {
    public static void main(String[] args) {

    }

    public static int nbJoursMois(int mois, int annee) {
        int[] jMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(mois == 2 && Exo12.estBisextile(annee)) {
            return 29;
        } else {
            return jMois[mois-1];
        }
    }

    public static boolean estDateValide(int j, int m, int a) {
        if(a > 0 && 1 <= m && m <= 12 && 1 <= j && j <=Exo14.nbJoursMois(m, a)) {
            return true;
        } else {
            return false;
        }
    }
}
