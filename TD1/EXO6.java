import java.util.Scanner;

public class EXO6 {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Saisir un entier pair");
        n = sc.nextInt();
        if(n%2 == 0) {
            for(int i = n+2; i <= n+20; i+= 2) {
                System.out.println(i);
            };
        };
        sc.close();
    };
}
