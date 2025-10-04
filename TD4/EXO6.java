public class EXO6 {

    public static void main(String[] args) {
        int[] tab = {4, 0, 5, 2, 0, 0, 2, 4, 0, 4};
        EXO6.compactage(tab);
        
    }

    public static void compactage(int[] t){
        for(int i = 0, j = t.length-1; i < j; i++) {
            while(t[j] ==0) {
                j--;
            }

            if (t[i] == 0){
                t[i] = t[j];
                t[j] = 0;
            }
        }

        for(int elt:t){
            System.out.print(elt + " ");
        }
    }
}
