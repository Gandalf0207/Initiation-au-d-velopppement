public class EXO7 {
    public static void main(String[] args){
        char[] tab = {'R', 'R', 'A' , 'R', 'R', 'R', 'R', 'R', 'Z', 'Z'};
        EXO7.plateau(tab);
    }

    public static int[] plateau(char[] tab){
        int[] tabReturn = new int[2];

        char carac = tab[0];
        int total = 0;
        int indiceStart = 0;

        int i = 0;
        do { 
            int totalTemp = 0;
            while (i < tab.length && tab[i] == carac) { 
                i++;
                totalTemp ++;
            }

            if (totalTemp > total) {
                total = totalTemp;
                indiceStart = i;
            }

            carac = tab[i];


        } while (i < tab.length);

        tabReturn[0] = indiceStart; 
        tabReturn[1] = total;

        return tabReturn;
    }
}
