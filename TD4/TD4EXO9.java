import java.util.ArrayList;

public class TD4EXO9 {
    public static void main(String[] args) {
        int[] tab = {4,4,4,2,2,3,4,4};
        ArrayList<Integer> newTb = TD4EXO9.compresser(tab);

        for(int elt:newTb){
            System.out.print(elt + " ");
        }
    }

    public static ArrayList<Integer> compresser(int[] tab) {
        ArrayList<Integer> newTab = new ArrayList<>();
        newTab.add(tab[0]);


        for (int i = 1; i < tab.length; i++) {
            if (tab[i] != newTab.get(newTab.size() - 1)) {
                newTab.add(tab[i]);
            }
        }

        return newTab;
    }
}
