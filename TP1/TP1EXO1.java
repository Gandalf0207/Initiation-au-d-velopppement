
import java.util.Scanner;

public class TP1EXO1 {
    public static void main(String[] args) {
        TP1EXO1.menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        boolean valid = true;

        do  {
            int num = sc.nextInt();
            switch (num) {
                case 1: {
                    int n = sc.nextInt();
                    TP1EXO1.suiteOrOrdre(n);
                };
    
                case 2: {
                    double epsi = sc.nextDouble();
                    TP1EXO1.suiteOrEpsilon(epsi);
                };
                case 3: {
                    valid = false;
                };
                case 4: {
                    int n = sc.nextInt();
                    double espi = sc.nextDouble();
                    TP1EXO1.comparaison(n, espi);
                }

                default: {;}
            }
        } while (valid);
        sc.close();
    }

    public static double Fibo(int n) {

        int a = 1;
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
                double Vi = TP1EXO1.Fibo(i) / TP1EXO1.Fibo(i - 1);
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
        double phi = (1 + Math.sqrt(5)) / 2;

        do {
            Vi = TP1EXO1.Fibo(i) / TP1EXO1.Fibo(i - 1);
            PVi = Vi * Vi - Vi - 1;

            System.out.println("Valeur de i : " + i);
            System.out.println("Valeur de Vi : " + Vi);
            System.out.println("Valeur de P(Vi) : " + PVi);

            i++;
        } while (Math.abs(Vi - phi) > epsi);
    }

    public static void comparaison(int n, double epsi) {

        System.out.println("-------------------------------");
        System.out.println("Avec n : " +n);

        for (int i = 2; i <= n; i++) {
            double Vi = TP1EXO1.Fibo(i) / TP1EXO1.Fibo(i - 1);
            double Vi_1 = TP1EXO1.Fibo(i-1) / TP1EXO1.Fibo(i - 2);
            double Wi = (Vi + Vi_1) / 2;

            System.out.println("Valeur de i : " + i);
            System.out.println("Valeur de Vi : " + Vi);
            System.out.println("Valeur de Wi : " + Wi);

        } 

        // --------------- //

        System.out.println("-------------------------------");
        System.out.println("Avec epsi : " + epsi);

        int i = 2;
        double Vi;
        double phi = (1 + Math.sqrt(5)) / 2;

        do {
            Vi = TP1EXO1.Fibo(i) / TP1EXO1.Fibo(i - 1);
            double Vi_1 = TP1EXO1.Fibo(i-1) / TP1EXO1.Fibo(i - 2);
            double Wi = (Vi + Vi_1) / 2;

            System.out.println("Valeur de i : " + i);
            System.out.println("Valeur de Vi : " + Vi);
            System.out.println("Valeur de Wi : " + Wi);

            i++;
        } while (Math.abs(Vi - phi) > epsi);
    }
}
