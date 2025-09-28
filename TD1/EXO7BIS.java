import java.util.Scanner;

public class EXO7BIS {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int somme = 0; 
        int cpt = 0;
        int numberUser;
        numberUser = sc.nextInt();
        while(numberUser!= 0){
            cpt ++;
            somme += numberUser;
            numberUser = sc.nextInt();
        };
        System.out.println("nb entier : " + cpt);
        System.out.println("somme : " + somme);
    };
};
