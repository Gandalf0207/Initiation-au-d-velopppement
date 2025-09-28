import java.util.Scanner;

public class Exo7 {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        double L1 = 0; double L2 = 0; double L3 = 0; double saisie = 0;
        do { 
            saisie = sc.nextDouble();
            if (saisie > 0) {
                if (saisie >= L1) {
                    if (saisie >= L2) {
                        L3 = saisie;
                    } else {
                        L2 = saisie;
                    }
                } else {
                    L1 = saisie;
                }
            }
        } while (L3 == 0);

        if((L1 + L2 ) > L3) {
            System.out.print("C'est un triangle");
            if((L1 == L2) || (L1 == L3) || (L2 == L3)) {
                System.out.print("Isocèle");
            } else if (L1 == L2 && L1 == L3) {
                System.out.print("Equilatéral");
            } else {
                System.out.print("Quelconque");
            }
        } else {
                System.out.print("Ce n'est pas un triangle");
        }
    }

}