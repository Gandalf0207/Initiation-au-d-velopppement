public class EXO1 {

    public static void main(String[] args) {

        int[] tab1 = new int[3];
        int[] tab2 = new int[3];
        boolean[] tab3 = new boolean[3];
        tab1[0] = 3;
        tab1[1] = 2;
        tab1[2] = 1;
        tab2 = tab1;
        // if (tab1 < tab2) { // comparaison de longueur mal faite
        //     System.out.println("tableau 1 petit");
        // };
        if (tab2 == tab1) {
            System.out.println("tableaux identiques");
        };
        tab3[1] = false;
        tab3[tab1[1]] = true;
        tab3[1] = tab1[1] == tab2[2];
        for (int i = 0; i < 3; i++) {
            tab3[i] = tab1[i] == tab2[i];
        }
        System.out.println("tab3 = ");
        for (boolean b : tab3) {
            System.out.println(b + " ");
        }

    }
}

// initialisation tab1 d'entier de 3 éléments
// initialisation tab2 d'entier de 3 éléments
// initialisation tab3 de boolean de 3 éléments

// tab 1 affectation des valeur 3, 2, 1 dans cet ordre
// tab2 prend la valeur de tab1 (case mémoire) mais quand on modif tab1 cela modifie aussi tab2 | la variable fait référence à la meme adresse mémoire | tab1 égal à tab2

//bloc avec erreur (on doit utiliser un .length pour calculer la longueur et déterminer qui est plus grand que l'autre)
// comparaison entre le meme élément
// affichage de texte 

//tab3 à l'indice 1 prend la valeur de false
// tab3 à l'indice de la valeur de tab1 à l'indice 1, prend la valeur de true
// tab3 à l'indice 1 prend la veleur de l'égalité entre la valeur de tab1 à l'indice 1 et tab2 à l'indice 2 (valeur sera false)

//boucle for qui réafecte toutes les valeur de tab3 avec le résiltat des égalité de comparaison de tab1 et tab2 à l'indice i de la boucle for
// boucle for pour afficher tab3 avec la valeur de chacun des indices du tableau
