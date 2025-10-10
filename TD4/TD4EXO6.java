public class TD4EXO6 {

    public static void main(String[] args) {
        int[] tab = {4, 0, 5, 2, 0, 0, 2, 4, 0, 4};
        TD4EXO6.compactage(tab);
        
    }

    public static void compactage(int[] t){
        int k = t.length;
        for(int i = 0; i < t.length; i++) {

            while (t[i] == 0 && i < k) {
                for (int j = i; j < t.length-1; j++) {
                    t[j] = t[j+1];
                }
                k--;
                t[t.length-1] = 0;
            }
        }

        for(int elt:t){
            System.out.print(elt + " ");
        }
    }
}
