import java.util.Scanner;

public class EXO7 {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n; 
        int somme = 0;
        n = sc.nextInt();
        for(int i = 0; i<n; i++) {
            somme += sc.nextInt();
        }
        System.out.print(somme);     
        sc.close();  
    }
};

