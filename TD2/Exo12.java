public class Exo12 {
    public static void main(String[] args) {

    }

    public static boolean estBisextile(int annee) {
        if(annee%400 == 0) {
            return true;
        } else if (annee%4 == 0 && annee % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
