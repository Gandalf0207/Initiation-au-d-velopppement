import java.util.Scanner;

public class Exo11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int annee = sc.nextInt();

        if(annee%400 == 0) {
            System.out.println("Annee Bisextile");
        } else if (annee%4 == 0 && annee % 100 != 0) {
            System.out.println("Annee Bisextile");
        } else {
            System.out.println("Annee non Bisextile");
        }
    }
}
