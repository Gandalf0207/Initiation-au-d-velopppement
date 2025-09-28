
import java.util.Scanner;

public class EXO6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(EXO6.potentielTriangleRectangle(c1, c2));
        EXO6.nbTriangleRectangle(p);
    }

    public static int potentielTriangleRectangle(int c1, int c2){
        int c3carre = c1*c1 + c2*c2;
        int c3 = EXO5.racineParfait(c3carre);
        return (c3 != -1) ? c3:-1;
    }

    public static void nbTriangleRectangle(int p){
        int cpt = 0;
        for(int  i = 1; i < p/3 + 1; i++) {
            for (int j = 1; j < p/3 + 1; j++){
                int value  = EXO6.potentielTriangleRectangle(i, j);
                if(value != -1 && (i + j + value) < p ){
                    cpt ++;
                }
            }
        }
        System.out.println(cpt);
    }
}
