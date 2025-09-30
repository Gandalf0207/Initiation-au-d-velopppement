
import java.util.Scanner;

public class EXO1 {
    public static void main(String[] args) {
        EXO1.menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        switch (num) {
            case 1: {
                int n = sc.nextInt();
                EXO1.suiteOrOrdre(n);
            };

            case 2: {
                double epsi = sc.nextDouble();
                EXO1.suiteOrEpsilon(epsi);
            };
            case 3: {;}
            default: {;}
        }
    }

    public static double Fibo(int n) {

        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return a;
    }

    public static void suiteOrOrdre(int n) {
        if (n > 2) {
            for (int i = 2; i <= n; i++) {
                double Vi = EXO1.Fibo(i) / EXO1.Fibo(i - 1);
                double PVi = Vi * Vi - Vi - 1;

                System.out.println("Valeur de i : " + i);
                System.out.println("Valeur de Vi : " + Vi);
                System.out.println("Valeur de P(Vi) : " + PVi);
            }
        }
    }

    public static void suiteOrEpsilon(double epsi) {
        int i = 2;
        double Vi;
        double PVi;

        do {
            Vi = EXO1.Fibo(i) / EXO1.Fibo(i - 1);
            PVi = Vi * Vi - Vi - 1;

            System.out.println("Valeur de i : " + i);
            System.out.println("Valeur de Vi : " + Vi);
            System.out.println("Valeur de P(Vi) : " + PVi);

            i++;
        } while (Math.abs(Vi - PVi) > epsi); // marche pas
    }
}
