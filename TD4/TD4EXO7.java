public class TD4EXO7 {
    public static void main(String[] args){
        char[] tab = {'R', 'R', 'A' , 'R', 'R', 'R', 'R', 'R', 'Z', 'Z'};
        int[] result = TD4EXO7.plateau(tab);
        for(int elt:result) {
            System.out.print(elt + " ");
        }

    }

    public static int[] plateau(char[] tab){
        int[] tabReturn = new int[2];

        char carac = tab[0];
        int total = 0;
        int indiceStart = 0;

        int i = 0;
        do { 
            int totalTemp = 0;
            int indiceTemp = i;
            while (i < tab.length-1 && tab[i] == carac) {
                i++;
                totalTemp ++;
            }

            if (totalTemp > total) {
                total = totalTemp;
                indiceStart = indiceTemp;
            }

            carac = tab[i];


        } while (i < tab.length-1);

        tabReturn[0] = indiceStart; 
        tabReturn[1] = total;

        return tabReturn;
    }
}
