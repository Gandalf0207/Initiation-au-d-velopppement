
import java.util.Scanner;

public class EXO1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        EXO1.suiteOrdre(n);
    }

    public static double  Fibo(int n) {
        if(n == 1 || n == 2) {
            return 1 ; 
        } else {
            return EXO1.Fibo(n-1) + EXO1.Fibo(n-2);
        }
    }


    public static void suiteOrdre(int n) {
        if(n > 2) {
            for(int i = 2; i <= n; i++) {
                double Vi = EXO1.Fibo(i) / EXO1.Fibo(i-1);
                double PVi = Vi*Vi - Vi -1;

                System.out.println("Valeur de i : " + i);
                System.out.println("Valeur de Vi : " + Vi);
                System.out.println("Valeur de P(Vi) : " + PVi);
            }
        }
    }
}