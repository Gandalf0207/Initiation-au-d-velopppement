import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

public class EXO4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(EXO4.isFriends(p, q));

        ArrayList<int[]> list = EXO4.Couple(n);
        for(int[] c:list){
            System.out.println(c[0] + " - " + c[1]);
        }
    }

    public static boolean isFriends(int p, int q) {
        if (p > 0 && q > 0) {
            int totalDivP = 0;
            int totalDivQ = 0;

            for (int i = 1; i < p; i++) {
                if (p % i == 0) {
                    totalDivP += i;
                }
            };

            for (int i = 1; i < q; i++) {
                if (q % i == 0) {
                    totalDivQ += i;
                }
            };

            return (totalDivQ == p && totalDivP == q) ? true : false;
        }
        return false;
    }

    public static ArrayList<int[]> Couple(int n) {
        ArrayList<int[]> couples = new ArrayList<>();
        for(int i= 1; i <= n; i++){
            for(int j = 1; j<=i; j++) {
                if (EXO4.isFriends(i, j)) {
                    int[] item = {i, j};
                    couples.add(item);
                }
            }
        }
        return couples;
    }
}