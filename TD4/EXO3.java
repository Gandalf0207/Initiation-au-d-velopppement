public class EXO3 {
    public static void main(String[] args) {
        int[]tab = EXO3.frequencesChiffres(15121);
        for(int elt:tab){
            System.out.println(elt);
        }

        EXO3.aChiffresTousDifferents(15121);
    }

    public static int[] frequencesChiffres(int n) {
        int[] tabIndiceOccurences = new int[10];
        for(int i = 0; i < 10; i++) {
            tabIndiceOccurences[i] = 0;
        }

        do { 
            int value = n%10;
            n = n/ 10;
            tabIndiceOccurences[value] += 1;      
        } while (n%10 != 0);
    
        return tabIndiceOccurences;
    }

    public static void aChiffresTousDifferents(int n) {
        // version lente 
        long start = System.nanoTime();
        System.out.println(EXO3.lente(n));
        long end = System.nanoTime();
        System.out.println(end-start);

        //version courte
        start = System.nanoTime();
        System.out.println(EXO3.rapide(n));
        end = System.nanoTime();
        System.out.println(end-start);


    }  

    public static boolean lente(int n){
        int[] tab = EXO3.frequencesChiffres(n);
        for(int elt:tab){
            if(elt>1){
                return false;
            }
        }
        return true;
    }

    public static boolean rapide(int n){
        int[] tabIndice = new int[10];
        int value = 0;
        do { 
            value = n%10;
            n = n/ 10;
            tabIndice[value] += 1;      
        } while (tabIndice[value] < 2 && n%10 != 0);
        return (tabIndice[value] > 1) ? false:true;
    }

}
