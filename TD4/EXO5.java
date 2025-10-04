public class EXO5 {
    public static void main(String[] args) {
        int[] tab = {4, 0, 5, 2, 0, 0, 2, 4, 0, 4};
        EXO5.triSelection(tab);
    }

    public static void triSelection(int[] tab){
        for(int i = 0; i < tab.length; i++) {
            int minValueIndice = i;

            for(int j= i+1; j< tab.length; j++) {
                if (tab[j] < tab[minValueIndice]) {
                    minValueIndice = j;
                }
            }
            int valueTemp = tab[i];
            tab[i] = tab[minValueIndice];
            tab[minValueIndice] = valueTemp;
        }

        for(int elt:tab){
            System.out.print(elt + " ");
        }
    }
}
