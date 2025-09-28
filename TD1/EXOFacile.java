import java.util.Scanner;

public class EXOFacile {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n; 
        int p; 
        int q; 
        int r;
        n = sc.nextInt();
        p = sc.nextInt();

        if( n <= 0 || p <= 0) {
            System.out.println("Erreur Saisie");
        } else {
            q = n / p;
            r = n % p;
            System.out.println("Quotient : " + q);
            System.out.println("Reste : " + r);

        };
    };
}
