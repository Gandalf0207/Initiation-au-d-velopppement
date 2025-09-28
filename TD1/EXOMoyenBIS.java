import java.util.Scanner;

public class EXOMoyenBIS {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n; int U = 1; int U1 = 1; int U2 = 1;
        n = sc.nextInt();
        while(n < 1) {
            n = sc.nextInt();
        };

        for(int i = 2; i < n; i++) {
            U = U1 + U2;
            U2 = U1;
            U1 = U;
        };

        System.out.println(U);
        
    };
};
