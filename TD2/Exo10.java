import java.util.Scanner;

public class Exo10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisir 2 entier a et b");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Choisir l'opérateur");
        char text = sc.next().charAt(0);

        switch (text) {
            case '+':
                System.out.println(a+b);
            case '-':
                System.out.println(a-b);
            case '*':
                System.out.println(a*b);
            case '/': {
                if(b ==0) {
                    System.out.println("Erreur");
                } else {
                    System.out.println(a/b);
                }
            }

            default:
                System.out.println("Erreur");
        }
    }
}
