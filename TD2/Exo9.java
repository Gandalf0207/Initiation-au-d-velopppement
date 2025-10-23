import java.util.Scanner;

public class Exo9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nb;
        do {
            nb = sc.nextInt();
        } while (nb <= 0);

        int i = 0;
        int total = 0;
        int ecartsup = 0;
        int ecartinf = 0;

        while(total <= nb) {
            i++;
            total += i;
        }

        ecartsup = total +i+1 -nb;
        ecartinf = nb - total;

        if(total == nb) {
            System.out.println(total);
        } else if(ecartsup == ecartinf) {
            System.out.println(total);
        } else if (ecartsup < ecartinf) {
            System.out.println(total + i +1);
        } else {
            System.out.println(total);
        }
    }
}
