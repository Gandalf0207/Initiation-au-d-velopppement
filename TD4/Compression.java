public class Compression {
    public static void main(String[] args) {
        int[] tab = {4,4,4,2,2,3,4,4} ;
        AfficherTabEntier(compresser(tab));
    }
    public static void AfficherTabEntier(int[] tab) {
        for (int i : tab) {
            System.out.print(i+" ; ");
        }
    }

    public static int[] compresser(int[] tab) {
        int compteur = 0 ;
        int tempCompteur ;
        for(int i = 0; i<tab.length;i++) {
            tempCompteur = 0;
            while (((i + tempCompteur+1 ) < tab.length) && (tab[i+tempCompteur] == tab[i+tempCompteur+1])) {
                tempCompteur++;
            }
            compteur+=tempCompteur;
            i+=tempCompteur;
        }
        int[] compressedTab = new int[tab.length-compteur] ;
        compteur = 0;
        for(int i = 0; i<tab.length;i++) {
            tempCompteur=0;
            while (((i + tempCompteur+1 ) < tab.length) && (tab[i+tempCompteur] == tab[i+tempCompteur+1]))  {
                tempCompteur++;
            }
            i+=tempCompteur;
            compressedTab[compteur] = tab[i] ;
            compteur ++;
        }
        return compressedTab ;
    }
}
