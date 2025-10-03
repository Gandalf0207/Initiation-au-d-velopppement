
import java.util.Scanner;

public class EXO2 {
    public static void main(String[] args) {
        EXO2.traiterTabEntier();
    }

    public static void afficherTabEntiers(int[] t) {
        for(int element : t){
            System.out.println(element);
        }
    }

    public static int[] saisirTabEntiers(int taille) {
        int[] tab = new int[taille];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < taille; i++) {
            tab[i] = sc.nextInt();
        }

        sc.close();
        return tab;
    }

    public static float moyenne(int[] t){
        int total = 0;
        int cpt = 0;

        for(int element : t){
            cpt ++;
            total += element;
        }
        return total / cpt;
    }

    public static void plusUnParis(int[] t) {
        for(int i = 0 ; i < t.length; i++) {
            if(t[i] %2 == 0) {
                t[i] += 1;
            }
        }
    }

    public static void traiterTabEntier() {
        int tab100[] = new int[100];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i< 100; i++) {
            tab100[i] = sc.nextInt();
        }
        sc.close();

        EXO2.afficherTabEntiers(tab100);
        System.out.println(EXO2.moyenne(tab100));
        EXO2.plusUnParis(tab100);
        EXO2.afficherTabEntiers(tab100);

    }

}
