# TD 11 : Listes chaînées

Le squelette de code des classe `Liste` ainsi que le code complet de la classe `Maillon` sont disponnibles dans le dossier `src`.

La classe `Liste` permet de créer des listes chaînées d'éléments de type **entier** à l'aide des **maillons** qui contiennent tous un entier et un autre **maillon** (celui suivant). Le fait qu'un maillon ne possède pas de suite est représenté par une valeur `null` pour le maillon suivant. Une liste est donc composée d'un maillon qui référence la "tête" (premier élément) de la liste. On accède ensuite au autre élément en parcourant la **chaîne** de maillons. Si le maillon en tête de liste est `null`, alors la liste est considérée comme vide.

Votre objectif est des les compléter avec les méthodes décrites dans la documentation de la classe `Liste`.

## Méthodes et algorithmes de base sur les listes

Complétez les méthodes du squelette de code de `Liste`, à l'aide de leur spécifications. 
Pour chaque méthode, vérifier bien que vous traitez **tous les cas de figure** : liste vide, liste à un seul élément, etc.

Vous disposez d'une classe `MainListe` qui vous permet de tester votre programme au fur et à mesure que vous implémentez des fonctions.

**Attention** : à propos de la méthode `longueur` : cette méthode parcourt tous les maillons de la liste. Pour des raisons d'efficacité (et de pédagogie), sauf mention contraire, il sera donc **interdit** de faire appel à la méthode `longueur` pour compléter le code d'autres méthodes.

## Bonus : Des listes plus performantes

Créer une classe `Liste2` (testée par une nouvelle classe `MainListe2` que vous devez créer) qui a des spécifications très proches de
`Liste`, mais qui contient deux autres attributs pour améliorer les performances en temps de calcul CPU :

* Un attribut `longueur` de type entier qui stocke la longueur de la liste `this`.

* Un attribut `dernier` qui est une référence sur le dernier maillon de la liste `this`. Cet attribut permet d'améliorer les performances des méthodes travaillant en fin de liste.