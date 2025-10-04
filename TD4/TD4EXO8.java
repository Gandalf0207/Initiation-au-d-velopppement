public class TD4EXO8 {
    public static void main(String[] args) {
        int[] tab = {1, 4, 2, 5, 6, 8};
        int[] pattern = {5, 6};
        boolean res = contientSousSequence(tab, pattern);
        System.out.println(res);

        tab = new int[]{1, 4, 2, 5, 6, 8};
        pattern = new int[]{6, 5};
        res = contientSousSequence(tab, pattern);
        System.out.println(res);

        tab = new int[]{1, 2, 3};
        pattern = new int[]{1, 2, 3};
        res = contientSousSequence(tab, pattern);
        System.out.println(res);

    }

    public static boolean contientSousSequence(int[] tab, int[] parttern){
        for(int i = 0; i < tab.length; i++){
          if(tab[i] == parttern[0]) {
              int j = 0;
              while(j +1< parttern.length && (i+j+1) < tab.length && tab[i+j+1] == parttern[j+1]){
                  j++;
              }
              if( j == parttern.length -1) {
                  return true;

              }
          }
        }
        return false;
    }
}
