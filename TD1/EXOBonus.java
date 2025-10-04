import java.util.Scanner;

public class EXOBonus {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n = 0; int Uo = 0; double U; 
        while(n <= 0 || Uo <= 0) {
            n = sc.nextInt();
            Uo = sc.nextInt();
        }
        U = Uo;

        for(int i = 0; i < n; i++) {
            if(U%2 == 0) {
                U = U/2.0;
            } else {
                U = 3*U + 1;
            }
        }

        System.out.println(U);
        sc.close();
    }
}
