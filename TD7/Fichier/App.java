package TD7.Fichier;

public class App {
    public static  void main(String args[]) {
        Fraction f1, f2;
        f1 = new Fraction(24, 36);
        f2 = new Fraction(13, 26);
        System.out.println("f1=" + f1.toString());
        System.out.println("f2=" + f2);

        // test q3
        f1.reduire();
        System.out.println("f1=" + f1.toString());

        // test q4
        System.out.println("f2=" + f2.fractionReduite());

        //test q5
        System.out.println("inverse f1=" + f1.inverse());

        // test q6
        System.out.println("f1*f2=" + f1.multiplication(f2));
        System.out.println("f1/f2=" + f1.division(f2));
        System.out.println("f1+f2=" + f1.addition(f2));


    }
}