import java.util.Scanner;

public class EXO3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(EXO3.max2(a, b));
        System.out.println(EXO3.max3(a, b, c));
    }

    public static int max2(int a, int b){
        return (a>b) ? a:b; // ternaire java
    }

    public static int max3(int a, int b, int c){
        return max2(max2(a,b), c);
    }
}
