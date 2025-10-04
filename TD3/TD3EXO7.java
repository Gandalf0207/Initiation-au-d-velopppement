
import java.util.Scanner;

public class TD3EXO7 {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int nb = sc.nextInt();
        int nbMax = sc.nextInt();
        System.out.print(TD3EXO7.estSyracusieEnNbMawOp(nb, nbMax));
    }

    public static boolean estSyracusieEnNbMawOp(int n, int nbMaxOp){
        for(int i = 0; i < nbMaxOp;  i++ ){

            if(n == 1) {
                return true;
            }else {
                if(n%2 == 0){
                    n/= 2;
                } else {
                    n = 3*n + 1;
                }
            }
        }
        return false;
    }
}


// si un nombre est = à une puissance de de 2 alors il est syracusien. 
// en fonction du nombre d'opération on peut déterminer si un nombre est syracusien. 
// un nombre peut etre syracusien meme s'il est annoncé à l'inverse, c'est le nombre que calcul qui peut limiter
