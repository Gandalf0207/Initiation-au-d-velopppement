package TD3;

import java.util.Scanner;

public class TD3EXO1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        char c = sc.next().charAt(0);

        //call procédures
        TD3EXO1.pyramideSimple(h, c);
        sc.close();
    }

    public static void repeteCarac(int nb, char car) {
        if (nb >= 0) {
            for (int i = 0; i < nb; i++) {
                System.out.print(car);
            }
        }
    }

    public static void pyramideSimple(int h, char c) {
        if (h >= 0) {
            for (int it = 0; it <= h; it++) {

                // espace devant les lignes pour le décalage
                TD3EXO1.repeteCarac(h-it, ' ');

                //call des lignes
                TD3EXO1.repeteCarac(it*2-1, c);
                System.out.println();
            }
        }
    }
}
