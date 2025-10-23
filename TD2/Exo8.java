import java.util.Scanner;

public class Exo8 {
    public static void main(String[] args) {

    }

    public static void q1() {
        Scanner sc = new Scanner(System.in);

        int m = 0;
        char text = sc.next().charAt(0);

        do {
            if(text == 'm') {
                m++;
                text = sc.next().charAt(0);
            }
        } while(text != '.');
    }

    public static void q2() {
        Scanner sc = new Scanner(System.in);

        int mot = 1;
        char text = sc.next().charAt(0);

        if(text == ':' || text =='.' ) {
            mot++;
            text = sc.next().charAt(0);

        } while(text !='.');
    }

    public static void q3() {
        Scanner sc = new Scanner(System.in);

        int total = 0;
        char text = sc.next().charAt(0);
        boolean check = false;

        while(text != '.') {
            if(text == 'l' || text == 'e') {
                if(text == 'e' && check) {
                    total++;
                } else if (text == 'l') {
                    check = true;
                }
            } else {
                check = false;
            }
            text = sc.next().charAt(0);
        }

        System.out.println(total);
    }

    public static void q4() {
        Scanner sc = new Scanner(System.in);

        int L= 0;
        char text = sc.next().charAt(0);

        do {
            if(text != ':') {
                L++;
            } else {
                L = 0;
            }

            text = sc.next().charAt(0);
        } while(text != '.');
    System.out.println(L);
    }

    public static void q5() {
        Scanner sc = new Scanner(System.in);

        int L = 0;
        char text = sc.next().charAt(0);
        int max = 0;

        do {
            if(text != ':') {
                L++;
            } else {
                if(L > max) {
                    max = L;
                }
                L = 0;
            }
            text = sc.next().charAt(0);
        } while(text != '.');
    System.out.println(max);
    }


}
