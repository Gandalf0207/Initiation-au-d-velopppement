import java.util.Scanner;

public class EXOMoyen {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n; int U = 1;
        n = sc.nextInt();
        while(n < 1) {
            n = sc.nextInt();
        };
        for(int i = 1; i <= n; i++) {
            U += i;
        };

        System.out.println(U);
        sc.close();
    } ;  
};
