import java.util.Map;
import java.util.Scanner;

public class Exo13 {
    public static void main(String[] args) {

    }

    public static void q1() {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double delta = b*b - 4*a*c;

        if(delta > 0) {
            double x1 = (-b- Math.sqrt(delta)) / (2*a);
            double x2 = (-b+ Math.sqrt(delta)) / (2*a);

            System.out.println(x1 + " " + x2);
        } else if (delta ==0) {
            double x = -b/2*a;
            System.out.println(x);
        } else {
            System.out.println("Il n'y a pas de sollutions réelles possibles");
        }
    }

    public static void q2() {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        for(int i = -100; i < 101; i++) {
            if((3*i*i*i + b*i*i + c*i + d) == 0) {
                System.out.println(i);
            }
        }
    }


}
