package TD3;

import java.util.Scanner;

public class TD3EXO5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        System.out.print(TD3EXO5.estCarreParfait(nb));
    }

    public static int racineParfait(int c){
        int cpt = 0;
        while (cpt*cpt < c) {
            cpt ++;
        }
        return (cpt*cpt == c)? cpt:-1;
    }

    public static boolean estCarreParfait(int n){
        return (TD3EXO5.racineParfait(n) != -1) ? true:false;
    }

}
