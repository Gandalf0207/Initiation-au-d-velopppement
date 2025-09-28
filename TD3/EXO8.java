import java.util.Scanner;

public class EXO8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(EXO8.calculE(n));
    }

    public static double calculE(int n){
        double value = 0;
        for(int i = n; i > 0; i--) {
            value = 1 / ((2*i -1) - (1/ (2 + value)));
        }
        return 1 + value;
    }


}
