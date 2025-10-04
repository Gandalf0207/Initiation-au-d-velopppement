import java.util.Scanner;

public class EXODifficile {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        float U; double lastiteration; double epsilon;
        epsilon = sc.nextDouble();
        while(epsilon <= 0) {
            epsilon = sc.nextDouble();
        };
        int n = 1; int cptExpo = -1;
        U = 1;
        lastiteration = -1/3.0; // lastIteration ne prend pas sa valeur
        while(epsilon < Math.abs(lastiteration)) {
            U += lastiteration;
            n+= 1;
            cptExpo *= -1;
            lastiteration = cptExpo * -1 * (-1/(1+2*n));
        };
        System.out.println(U);
        sc.close();
    };
};


// marche pas sur le calcul de U