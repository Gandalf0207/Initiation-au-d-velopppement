public class EXO4 {
    public static void main(String[] args) {
        System.err.println(EXO4.estPalindrome("KAYAK"));
        System.err.println(EXO4.estPalindrome("saippuakivikauppias"));
        System.err.println(EXO4.estPalindrome("RESTER"));
    }

    public static boolean estPalindrome(String mot){
        int lenMot = mot.length();
        int len = (lenMot%2 == 0) ? lenMot:lenMot+1;

        for(int i = 0, j = lenMot; i < j; i++, j--) {
            if(mot.charAt(i) != mot.charAt(j-1)) {
                return false;
            }
        }

        return true;
    }
}
