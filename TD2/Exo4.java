import java.util.Scanner;

public class Exo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if(age >= 65) {
            System.out.println("6€");
        } else if(age >= 26) {
            System.out.println("12€");
        } else if(age >= 12) {
            System.out.println("8€");
        } else {
            System.out.println("5€");
        }
    }
}