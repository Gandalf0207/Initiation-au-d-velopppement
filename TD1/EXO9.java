import java.util.Scanner;

public class EXO9 {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int nombre; int pow_3 = 1;
        nombre = sc.nextInt();
        for(int i =0; i < nombre; i++) {
            System.out.println(pow_3);
            pow_3 *= 3;
        }
    }
}
