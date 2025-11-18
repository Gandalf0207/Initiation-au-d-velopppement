---
lang: fr
---

# TD8 - Objets et classes : course de voitures

## Course simple

Nous allons d’abord écrire un programme qui organise une course entre deux voitures, en ligne
droite d’un point de départ à un point d’arrivée.

### La classe Voiture

Une voiture est caractérisée par son **nom** (chaîne de caractères), sa **position** sur un axe à partir d’un point origine (entier positif ou nul) et sa **vitesse** (entier positif ou nul). Pour la simulation à l’écran, l’axe sera horizontal et le point origine tout à fait à gauche de l’écran.

La classe `Voiture` a donc **trois attributs** : nom, position et vitesse.

Consultez le squelette de code de la classe `Voiture` et complétez le code. Il faudra définir les **attributs** et complétez les différentes **méthodes**.

**Conseil** : La méthode `charAt(int i)` invoquée par un objet de la classe `String` renvoie le ième caractère de la chaîne (en commençant à l'indice 0, comme pour un tableau).

### La classe Course

Une **course** (entre 2 **voitures**) est caractérisée par les **2 voitures** en compétition, qui sont des instances de la classe Voiture, ainsi que par la **longueur** de la piste, qui est un entier strictement positif.

Le déroulement d’une course se passe de la façon suivante :

* Au début, les 2 voitures sont placées sur la ligne de départ. 

* A chaque étape, l’une des 2 voitures, choisie aléatoirement, avance.

* Une fois que la voiture a avancé, on affiche la position des voitures sur la piste (à l'aide la méthode dédiée qui affiche un nombre d'espaces qui correspondent à la position de la voiture puis la première lettre de son nom).

* La course s’arrête dès qu’une voiture a franchi la ligne d’arrivée.

Consultez le squelette de code de la classe `Course` et complétez le code. Il faudra définir les **attributs** et complétez les différentes **méthodes**.

**Conseils** :

* La méthode de classe `Ut.randomMinMax(int min, int max)` permet de renvoyer un nombre entier pseudo-aléatoire compris entre min et max.
* Dans la console, pour simuler l’évolution des voitures, vous pouvez utiliser les procédures `Ut.clearConsole()` et `Ut.pause(int timeMilli)` entre deux étapes de la course.


### La classe MainCourse

La classe `MainCourse` permet d’exécuter des courses entre des voitures. 

La procédure principale (`main`) doit créer deux instances **v1** et **v2** de la classe `Voiture` et une instance de la classe `Course` mettant en compétition **v1** et **v2**. La procédure déclenche ensuite le déroulement de la **course** entre **v1** et **v2** et affiche finalement **le nom de la voiture gagnante**.

Tester votre programme en implémentant ce comportement.

## Course sur plusieurs longueurs de piste

On considère maintenant une **course de voitures** qui se déroule non pas sur une, mais sur **k** longueurs de piste, où **k** est un entier **strictement positif**, en effectuant des **aller-retours**. Ainsi, la version de base est le cas particulier où **k** est égal à 1, et pour k égal à 2, le trajet est un aller-retour de la piste. Le **point d’arrivée** est l’origine si k est **pair** et le bout de la piste sinon.

### Première version : aller-retours simples

Nous allons commencer par implémenter la course avec plusieurs **allers-retours** sur la piste .

Dans cette version, une voiture commence en se déplaçant de gauche à droite (comme précédemment). Quand elle atteint l'extrémité droite de la piste, elle change de sens de déplacement et va donc de droite à gauche. Quand elle atteint l'origine (0), elle change encore de sens et se déplace de gauche à droite, et ainsi de suite. La voiture gagne la course quand elle a parcouru `k` fois la piste. Donc, si $k = 3$, cela correspond à un aller-retour et un aller. Si $k=4$, cela correspond à deux allers-retours.

* Commencez par ajouter à la classe `Course` un attribut **k** indiquant le **nombre de longueurs de piste à parcourir**. Il faudra adapter le **constructeur** en conséquence.

* Ajouter à la classe `Voiture` les deux attributs suivants :

    * Un attribut entier **sens** qui représente le **sens** de déplacement sur l’axe : il vaut **1** si la voiture va de gauche à droite (du début de la piste à la fin) et **-1** si elle va de droite à gauche (de la fin de la piste au début). Il faut attribuer une valeur par défaut à cet attribut lors de la création de l'objet. Par défaut, la voiture se déplacera de gauche à droite.

    * Un attribut **nbLongPiste** qui contient **le nombre de longueurs de piste déjà parcourues**. Cet attribut doit être initialisé à 0 lors de la construction de l'objet.

Il faut maintenant adapter le code de `Voiture` afin d'effectuer le changement de sens quand nécessaire :

* Ajoutez à la classe `Voiture` une méthode `private void faireDemiTour()` qui permet à la voiture d'inverser son sens de déplacement.

* Ajoutez à la classe `Voiture` une méthode qui permet de savoir si elle a parcouru un certain nombre de longueurs de piste passé en paramètre. Choisissez judicieusement la visibilité, le nom, le type de retour et les paramètres de cette méthode.

* Modifiez la méthode `avance` de la classe `Voiture` afin de faire en sorte que :

    * La voiture avance selon son sens de direction : si elle va de gauche à droite, on ajoute la vitesse à sa position (comme précédemment), sinon, on lui retire. Il y a moyen de mettre à profit un des attributs de `Voiture` pour gérer ça sans avoir besoin de `if`.

    * Si la voiture atteint ou dépasse une des extrémités (fin de la piste ou origine), elle doit faire demi-tour, et le nombre de pistes qu'elle a parcourue (**nbLongPiste**) doit être incrémenté.

    * Pour le moment, si la voiture dépasse l'extrémité droite, elle sera replacée à la fin de la piste, et si elle dépasse l'origine, elle sera replacée à la position 0.

    Vous devriez vous rendre compte qu'il manque quelque-chose pour implémenter ce nouveau fonctionnement... sans doute un certain paramètre à ajouter dans la signature de `avance`...?

* Ajoutez à la classe `Course` une méthode permettant d'afficher le symbole `-` en console **longueur piste + 1** fois (sans sauter de lignes). C'est-à-dire que si la piste a une taille de 10, le caractère `-` sera affiché **11 fois**.

* Enfin, adaptez la méthode `deroulement` de la classe `Course` afin que la voiture **gagnante** soit celle qui a parcourue **k** longueurs de pistes. Il faudra donc revoir votre boucle. Normalement, un appel à la méthode `avance` sur une voiture ne compile plus (si vous avez bien correctement réalisé le point précédent). Réglez ce problème adéquatement. Vous utilisez la méthode implémentée à l'étape précédente afin d'afficher la bordure de la piste avant et après l'affichage de l'état des voitures après avancement.

* Vous pouvez maintenant tester d'effectuer une nouvelle course entre vos deux voitures. Attention, il faut maintenant fournir à `Course` la valeur `k` du nombre de longueurs pistes à parcourir pour gagner.

### Deuxième version : prise en charge du rebondissement

On souhaite maintenant prendre en charge les **rebondissements**. On suppose que quand une voiture arrive à l’une des deux extrémités de la piste, elle « rebondit » et termine son déplacement dans l’autre sens pour parcourir en tout une distance égale à sa **vitesse**. Par exemple, si la voiture a une **vitesse** de 10, est à la **position** 7 et se dirige vers l’origine, elle rebondit et s’arrête à la position 3 puisque 7 + 3 = 10. On pourrait schématiser ici : la voiture souhaitait avancer de 10 cases vers l'origine, mais a seulement avancé de sept cases et s'est "cognée" contre le mur de gauche, et a rebondie dans l'autre sens sur les trois cases qu'il restait à parcourir.

On suppose que la vitesse d’une voiture est toujours inférieure à la longueur de la piste, de sorte qu’une voiture rebondit au plus une fois lors d’un déplacement.

* Modifiez la fonction `avance` de la classe `Voiture` afin de faire en sorte que si la voiture dépasse l'extrémité droite (fin de la piste) ou gauche (origine, début de la piste) on applique la logique de rebondissements. Par conséquent, on effacera donc la logique mise en place précédemment où la voiture était simplement replacée au début ou à la fin de la piste.

* Effectuez une nouvelle course et vérifiez que la logique de rebondissement s'applique bien dans les deux sens et sans problème. 

## Extensions possibles

Voici différentes extensions possibles que vous pouvez implémenter afin d'améliorer votre programme :

1. Donner aux 2 **voitures** des **vitesses différentes** et des **probabilités différentes** d’être choisies pour avancer (en équilibrant les chances pour une course équitable !).

2. **Défavoriser une voiture au départ**, mais pour équilibrer les chances, permettre à une voiture d’accélérer quand son écart avec la voiture de tête devient trop important. Pour cela, il vous faudra rajouter des méthodes à la classe `Voiture` pour permettre à une voiture d’accélérer et pour pouvoir évaluer l’écart entre 2 voitures.

3. Simuler une **course** entre **un nombre quelconque de voitures** dans `MainCourse` ou une nouvelle classe dédiée. Pour cela, utilisez un **tableau** d’instances de la classe `Voiture`.

4. Faire évoluer la voiture dans un **plan** : remplacer l’attribut **position** par les coordonnées **x** et **y**, et l’attribut **sens** par une **direction** pouvant avoir 4 valeurs possibles (nord, sud, ouest, est). Pour l’affichage, on peut utiliser une **matrice de caractères** (tableau de tableaux de caractères) ou bien donner accès aux coordonnées des **voitures** en ajoutant des accesseurs `getLigne()` et `getColonne()` (ou `getY()` et `getX()`) dans la classe `Voiture`.