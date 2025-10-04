import java.util.Scanner;

public class Exo5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt(); int num;
        for(int i = 0; i < 19; i++) {
            num = sc.nextInt();
            if(num > max) {
            max = num;
            }
        }
        System.out.println(max);
        sc.close();
    }
}
