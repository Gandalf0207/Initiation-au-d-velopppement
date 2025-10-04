import java.util.Scanner;

public class EXO8 {
    public static void main() {
        int userNombre = -1; 
        int somme = 0;
        Scanner sc = new Scanner(System.in);
        while(userNombre <= 0) {
            userNombre = sc.nextInt();
        };
        while(userNombre > 0) {
            somme += userNombre %10;
            userNombre /= 10;
        };
        System.out.println(somme);
        sc.close();
    }
}