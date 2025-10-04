import java.util.Scanner;

public class EXO10 {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n; int somme = 0; int age; 
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            age = sc.nextInt();
            while(age < 0 || age > 100) {
                age = sc.nextInt();
            };
            somme += age;
        };
        System.out.println(somme/n);
        sc.close();
    };
};
