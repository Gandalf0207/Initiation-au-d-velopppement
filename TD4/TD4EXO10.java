import java.lang.reflect.Array;
import java.util.ArrayList;

public class TD4EXO10 {
    public static void main(String[] args) {
        int[] t1 = {3, 5, 8};
        int[] t2 = {5, 7, 3, 9};
        ArrayList<Integer> newTab = TD4EXO10.fusionSansDoublon(t1, t2);

        for(Integer elt:newTab) {
            System.out.print(elt + " ");
        }
    }

    public static ArrayList<Integer> fusionSansDoublon(int[] t1, int[] t2) {
        int[] newTab = new int[t1.length + t2.length];
        for(int i = 0; i < t1.length; i++){
            newTab[i] = t1[i];
        }

        for(int i = 0; i < t2.length; i++){
            newTab[t1.length +i] = t2[i];
        }


        newTab = TD4EXO5.triSelection(newTab);
        ArrayList<Integer> newTab2 = TD4EXO9.compresser(newTab);

        return  newTab2;
    }
}
