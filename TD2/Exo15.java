public class Exo15 {
    public static void main(String[] args) {

    }

    public static void nbJoursEcoule(int[] d) {
        int j = d[0];
        int m = d[1];
        int a = d[2];
        int total = 0;

        for(int i = 1; i < m; i++) {
            total += Exo14.nbJoursMois(i, a);
        }
        total += j;
        System.out.println(total);
    }

}
