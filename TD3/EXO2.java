
package TD3;

import java.util.Scanner;

public class EXO2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nb1 = sc.nextInt();
        int nb2 = sc.nextInt();
        int h = sc.nextInt();

        if( nb1 <= nb2 ){
            EXO2.afficheNombresCroissants(nb1, nb2);
        } else {
            EXO2.afficheNombresDecroissants(nb1, nb2);
        }
        System.out.println();

        EXO2.pyramideElaboree(h);
    }

    public static void afficheNombresCroissants (int nb1, int nb2){
        int i = 0;
        while(nb1 + i <= nb2) {
            System.out.print(" " + (nb1 + i)%10);
            i++;
        }
    }

    public static void afficheNombresDecroissants (int nb1, int nb2){
        int i = 0;
        while(nb1 - i >= nb2) {
            System.out.print(" " + (nb1 - i)%10);
            i++;
        }
    }

    public static void pyramideElaboree(int h) {
        int cptMax = 1; // ref mid
        for(int i = 1; i <= h ; i++){

            // espace avant les caractères
            EXO1.repeteCarac(2*h-i*2+1,  ' ');

            EXO2.afficheNombresCroissants(i, cptMax); // monté gauche
            EXO2.afficheNombresDecroissants(cptMax-1, i); // monté droite
            cptMax += 2;

            System.out.println();

        }
    }
}
