

# Sujet 10 : Objets et classes : combat d'Orques

## Introduction

Nous allons développer un programme de jeu qui consiste à gérer des **Orques**
(créatures fantastiques ou animaux marins, comme votre imaginaire le préfère)
qui s'affrontent dans des **Arènes**.

![image orque](orquesCombat.png )


## Préambule

En plus des classes codant le jeu, nous utiliserons la classe `Ut`
(que vous devez importer).
Vous devrez également coder une classe `EO` (ensemble d'orques),
une variante de la classe `EE` qui gère des **Orques à la place des entiers**.

1. Codez et testez la classe `EO` qui contient essentiellement les méthodes
2. `contient`, `deborde`, `contientPratique`, `ajoutElt`, `ajoutPratique` et `retraitPratique`
3. (présentes dans `EE` au TD précédent mais cette fois-ci avec des **Orques à la place des entiers**),
4. ainsi que les méthodes suivantes qui seront utiles et que vous devez ajouter à `EO` :

```java
/** Pré-requis : ensemble this est non vide
 *  Résultat/action : enlève un élément de this (aléatoirement) et le renvoie
 */
public Orque retraitEltAleatoirement() {
    int i = Ut.randomMinMax(0, this.cardinal - 1);
    Orque select = retraitPratique(i);
    return select;
}

/** Pré-requis : ensemble this est non vide
 *  Résultat : un élément quelconque de this choisi aléatoirement
 */
public Orque selectionEltAleatoirement() {
    int i = Ut.randomMinMax(0, this.cardinal - 1);
    return this.ensTab[i];
}
```

Il est plus que conseillé de supprimer`selectElt()` et `selectEltAleatoirement()` (présentes dans `EE`)
pour éviter les confusions dans ce TD.
Vous pouvez également supprimer les autres méthodes (`union`, `intersection`, `estDisjoint`...)
si vous le souhaitez.

### Remarque

N'est-ce pas dommage de devoir réécrire cette classe `EO` en remplaçant un peu partout
dans le code le type `int` par le type `Orque` ?

C'est effectivement (très) sale comme pratique !

Vous étudierez au second semestre le principe de **généricité** qui permettra d'obtenir
un code unique (générique) pouvant prendre en compte n'importe quel type d'éléments.
Vous serez ainsi en mesure de créer un ensemble d'un type générique
et de préciser ensuite s'il s'agit d'entiers, d'orques, de poneys...

# Version de base du jeu

Le jeu comprend trois classes principales : `Orque`, `Arene` et `MainCombat`.

## La classe Orque

Dans sa version de base, la classe `Orque` comprend seulement deux **variables d'instance** :

* un numéro d'identification `id`
* un `score` entier qui indique le **nombre de duels gagnés** (0 initialement)

La classe comprend également deux **variables de classe** :

* un entier `nextId` donnant le **prochain numéro d'orque** créé dans la partie.
  Cette variable permettra d'attribuer **automatiquement** un **identifiant unique** à chacun des orques créés.
  Le premier créé porte le numéro 0.
* un attribut `legende` qui est (une référence sur) un objet de type `Orque` :
  `legende` référence l'orque qui a été **tué au combat** et qui a **gagné le plus de duels**
  (c.-à-d. l'orque mort ayant le **plus grand score** et, en cas d'égalité de score,
  on conserve le premier orque décédé ayant atteint ce score).

1. Définir les **variables d'instance** et les **variables de classe**
2. Définir un **constructeur** qui initialise les variables d'instance et met à jour
   les variables de classe
3. Définir une méthode `duel` permettant de réaliser un duel entre deux `Orque`: `this` et `autre`
   et **retournant l'orque gagnant** du duel.
   Dans cette première version naïve, le **gagnant sera choisi au hasard**.
   Il ne faut pas oublier de **mettre à jour la `legende`** si besoin
   (vous pouvez ajouter une méthode `miseAJourLegende` si vous le jugez nécessaire pour plus de lisibilité).

Pour l'aléatoire, vous pouvez (au choix) utiliser :
* `Ut.randomMinMax(int min, int max)`
  qui retourne un nombre entier pseudo-aléatoire compris entre `min` et `max`,
* `Random random = new Random(); random.nextBoolean()` qui retourne un boolean aléatoire.

4. Définir une méthode `toString()` permettant de représenter un `Orque`
   sous la forme de votre choix.

## La classe Arene

5. Écrire tout le code nécessaire à la classe `Arene` afin de respecter
   les informations ci-dessous :

* Dans cette première version, la classe `Arene` est définie par un **ensemble d'orques** `ensOrques`
  (de type `EO`) contenant les orques encore **vivants** de l'arène.
* Le **constructeur** de `Arene` prend en paramètre un nombre d'orques `nbo`
  qui correspond au **nombre d'orques maximum** possible dans l'arène
  (c.-à-d. au nombre d'orques initialement présents à la création de l'arène).
  Ce constructeur **crée (construit) `nbo` orques** qui combattront dans cette arène.
* La méthode `bataille` **gère les duels** entre les orques de l'ensemble `this.ensOrques` :

    * Elle procède itérativement à des **duels à mort** entre deux orques
      jusqu'à ce qu'il n'en reste plus qu'un (vivant).
    * Pour réaliser un duel, deux éléments de `this.ensOrques`
      sont sélectionnés au **hasard** et **retirés** de l'ensemble.
    * Après le duel, le **gagnant est remis** dans l'`Arene`,
      c'est-à-dire dans `this.ensOrques`.
    * Le **dernier survivant** de l'`Arene` est **retourné** par cette méthode.

## Le programme principal : la classe MainCombat

6. Écrire dans la classe `MainCombat` une procédure principale (`void main(String[] args)`) qui :

* **construit plusieurs arènes** (au moins deux) qui créent elles-mêmes des ensembles d'orques combattants
* appelle la méthode `bataille` sur ces arènes
* **affiche l'orque vainqueur** de chaque arène, ainsi que la **légende**

Remarque : Comme les combattants sont sélectionnés aléatoirement, la légende n'est pas forcément un des vainqueurs d'une bataille.

# Extensions

Nous allons désormais améliorer cette version très basique afin de rendre
les combats un peu plus réalistes.
Reprendre les classes déjà créées et les ajouter dans le package Extension 1.

## Extension 1 : Ajouter des points de vie et des armes

7) Ajouter des **points de vie** à un `Orque` (initialement 100 quand il est créé et 0 quand il meurt).

8) Ajouter une classe `Arme` afin de rendre un `duel` plus réaliste.

Une `Arme` est définie par un `Type` (hache, épée, lance ou marteau) et une `Couleur` (bleu, jaune, rouge ou vert),
qui sont des **énumérations**.

### Une énumération : quésaco ?

Une **énumération¨¨ ou liste énumérative est un **ensemble de valeurs constantes**.
En Java, on utilise le mot clé **enum**.

Par exemple, voici une énumération des civilités usuelles en Java :

```java
public enum Civilite {
    MONSIEUR,
    MADAME,
    MADEMOISELLE;
}
```

Il est possible d'accéder aux **valeurs de cette énumération** depuis une autre classe en utilisant `Civilite.values();`
qui retourne un tableau de `Civilite`.

De plus, ces valeurs sont **ordonnées** par l'ordre d'énumération donné dans la définition.
Il est possible de connaître leur **"rang"** avec l'expression
suivante (où `c` est de type `Civilite`) : `c.ordinal();` Par exemple,
`MADEMOISELLE.ordinal();` retourne 2.

Il est également possible d'enrichir une énumération comme dans l'exemple suivant :

```java
public enum Civilite {

    MONSIEUR("M."),
    MADAME("MME"),
    MADEMOISELLE("MLLE");  
      
    private String abreviation;  
      
    private Civilite(String a) {  
        this.abreviation = a;  
    }   
    public String getAbreviation() {  
        return this.abreviation;  
    }  
}
```
Dans cet exemple, on peut associer une chaîne de caractères à chaque
valeur de `Civilite` et y accéder grâce à la méthode
`getAbreviation()`.

Vous allez définir les deux énumérations suivantes pour votre combat
d'orques.

### Enumération Type

`Type` permet de définir les dégâts infligés à l'autre joueur,
c'est-à-dire le nombre de points de vie qu'il va perdre.

Dégâts infligés pour chaque `Type` :

MARTEAU → 15,

HACHE → 12,

LANCE → 8,

EPEE → 10

9) Définir l'énumeration `Type`.

### Enumération Couleur

`Couleur` permet de définir la probabilité en % (entre 1 et 99)
de toucher le joueur adverse.

Probabilités de toucher le joueur adverse pour chaque `Couleur` :

ROUGE → 90,

JAUNE → 80,

BLEU → 70,

VERT → 60

10) Définir l'énumeration `Couleur`.

### Arme

Une `Arme` est définie par un `Type`  et une `Couleur` qui sont choisies de manière aléatoire.

`Arme a = new Arme();`permettra (par exemple, vu que c'est aléatoire) de créer une Arme
qui inflige un dégât (c.-à-d. une perte de points de vie) de 15 au joueur adverse
avec une probabilité de le toucher de 70 % (autrement dit `a` est un `MARTEAU BLEU`).

Indication : vous pouvez générer un tableau contenant tous les Types
et un autre contenant toutes les Couleurs,
puis choisir aléatoirement une case de ces tableaux
(voir paragraphe précédent mini cours sur énumérations).

11) Compléter `Arme` pour obtenir le comportement souhaité.

### Retour à la classe Orque

12) Modifier la classe `Orque` afin que :
* Un `Orque` possède désormais une `Arme`
  (rappel : le `Type` et la `Couleur` sont générés aléatoirement à la construction de l'Arme, ce n'est pas l'Orque qui choisit son Arme).
* Les orques combattent en `duel`jusqu'à la **mort**, c'est-à-dire jusqu'à **épuisement des points de vie**.
  Le choix de l'orque attaquant est toujours aléatoire, mais les dégâts infligés ainsi que la probabilité de les infliger dépendent désormais de l'`Arme`.

### Un affichage en couleur sur le terminal (bonus non obligatoire)

Il n'est pas question de proposer une interface graphique (c'est au programme du S2), cependant cela ne nous interdit pas d'avoir une expérience avec le terminal qui soit agréable à l'utilisateur.

Il est possible de colorer du texte affiché dans un terminal avec le code suivant :

```java
String texteColore = "\u001B[31mCoucou!";
System.out.println(texteColore); // Affiche le texte ("Coucou!") en rouge    
```

Vous pouvez par exemple afficher le `toString` d'un Orque dans la couleur de son arme.

Indication : en plus de la probabilité vous pouvez ajouter le code de la couleur dans `Couleur`.

## Extension 2 : Ajouter des lieux différents pour les batailles

Dans cette extension, on se propose de réaliser des `batailles` dans des lieux différents :
`Foret`, `MontagneOrageuse`, `Desert`...

Reprendre les classes déjà créées dans Extension 1 et les ajouter dans le package Extension 2.

Avant d'implémenter ces nouveaux lieux, on souhaite modifier un peu `Arene`
pour qu'au cours d'une `bataille` (c-a-d avant chaque `duel`) un des deux combattants perde 5 PDV (minimum 1 PDV)
(50% de chance pour chaque `Orque` d'être sélectionné)
et que l'`Orque` gagnant de chaque `duel` puisse se régénérer de +5 PDV (maximum 100 PDV).

13) Modifier le code déjà écrit pour prendre en compte ces deux nouvelles modifications.

Les batailles dans les `Forets` sont sensiblement les mêmes que celles d'une `Arene`
(combat 1 contre 1 jusqu'à la mort, -5 PDV au début pour un des deux...)
à la différence que l'Orque qui **gagne un duel** voit ses **points de vie régénérés de +20 PDV** (maximum 100PDV)
(il a le temps de se cacher pour regagner plus d'énergie pour le prochain duel).

Les batailles dans les `MontagnesOrageuses` sont sensiblement les mêmes que celles d'une `Arene`,
(combat 1 contre 1 jusqu'à la mort, +5 PDV à la fin pour le gagnant...)
à la différence qu'**avant chaque duel** il y a une **probabilité de 60 % qu’un éclair frappe au hasard un des deux orques** (toujours 50% de malchance pour chaque `Orque` d'être sélectionné),
lui infligeant ainsi une **perte de 20 PDV** sans le tuer (minimum 1 PDV)

Tous les **lieux de combat** (`LieuCombat`) doivent proposer la possibilité de réaliser une `bataille`
dans les conditions qui lui sont spécifiques ainsi que d'afficher une `presentationDuLieu`
(simple affichage pour indiquer où se déroule la bataille).

13) Définir une ? `LieuCombat` (? est à remplacer par classe ou interface)
    et ajouter les classes `Foret` et `MontagneOrageuse` afin d'implémenter le comportement souhaité.

Vous avez certainement fait le choix suivant :

* Version 1 :  `LieuCombat` impose une méthode `bataille` à toutes les classes qui l'implémentent
  et la méthode `bataille` est définie dans chaque lieu en prenant en compte les spécificités décrites.


Par défaut, tous les lieux réalisent la même `bataille`;
certains lieux peuvent avoir un comportement spécifique avant ou après un duel
en ajoutant ou en retirant des PDV.

L'effet réalisé **avant le duel touche toujours un des deux Orques** du duel
(chacun a 50 % de chance d'être choisi).

L'effet réalisé **après le duel touche toujours l'Orque gagnant** du duel.

Nous proposons une autre possibilité d'implémentation:

* Version 2 : Le code de `bataille` est défini **uniquement** dans `LieuCombat`,
  mais `bataille` fait appel aux effets avant/après qui sont spécifiques aux lieux.

Nous choisirons d'implémenter la **Version 2**, ce qui permet d'**éviter la duplication** du code de `bataille`.
En effet, une `bataille` suit toujours le scénario suivant :

* On prend 2 combattants
* Ils font un duel
* Le gagnant revient dans la liste
* On boucle jusqu'à ce qu'il ne reste plus qu'un orque

Il est important de comprendre que : moins de code → moins de bugs → plus lisible.

Si l'on souhaite **modifier** le comportement d'une **bataille** un jour,
il n'y a qu'**une méthode à modifier**.

Chaque lieu a juste besoin de définir un **comportement par défaut** avant et/ou après le duel si nécessaire.
Par **defaut** ces comportements permettent de faire -5 PDV (`Arene`et `Foret`) avant le duel
pour un `Orque` et +5 PDV (`Arene`et `MontagneOrageuse`) après le duel pour le gagnant.

14) Modifier `LieuCombat` `Foret` et `MontagneOrageuse` en conséquence.
    Normalement à ce stade vous ne devriez plus avoir de `bataille` ni aucun "effet" dans `Arène`.

En plus de respecter le principe **DRY** nous respectons un des principes **SOLID**
(programme du S3) qui explique que notre code doit être **ouvert aux extensions** mais **fermé aux modifications**.

En effet, désormais **ajouter un nouveau lieu** devient très **facile** (très peu de code à ajouter et peu de redondance)

On souhaite ajouter un lieu `Desert`.

Combattre dans le `Desert` est vraiment très difficile : il y fait très chaud,
il peut y avoir des tempêtes de sable ; on peut croire voir une oasis
et essayer de la rejoindre, mais celle-ci n'existe pas...

Dans le `Desert`, **avant un duel**, un `Orque` (toujours une chance 1/2 d'être choisi) perd 10 PDV (min PDV à 1) à cause de la tempête de sable.

Dans le `Desert`, **après un duel**, l'`Orque` gagnant (épuisé par le combat) croit voir une oasis (qui n'existe pas) et se fatigue pour rien : il perd 15 PDV (min PDV à 1).

15) Définir `Desert` afin d'obtenir le comportement souhaité.

Remarque : Il reste encore un peu de duplication de code puisque les constructeurs de `Foret`, `Arene`, `Desert`
et `MontagneOrageuse`sont les mêmes et le getter `getEnsOrques` aussi mais vous apprendrez à éviter cette duplication au S2.



Voci un exemple de code à mettre dans `MainCombat`:

```java
 public static void main (String[] args) {
  LieuCombat l = new Arene(2);
  Orque winner = l.bataille();
  System.out.println("\n=====WINNER ARENE : " +  winner);

  l = new Foret(3);
  winner= l.bataille();
  System.out.println("\n=====WINNER FORET: " +  winner);

  l = new MontagneOrageuse(3);
  winner =l.bataille();
  System.out.println("\n=====WINNER MONTAGNE: " +  winner);

  l = new Desert(3);
  winner =l.bataille();
  System.out.println("\n=====WINNER DESERT" + winner);

  Orque o = Orque.getLegende();
  System.out.println("\n=====ORQUE LEGENDE " +o);
}
 ```

Voici un exemple de trace (init des PDV à 20 pour limiter la taille de la trace)
associée à ce main (vous pouvez choisir d'autres affichages au choix)
```
===== COMBAT EN ARENE =====


=====COMPORTEMENT PAR DEFAUT -5PDV pour Orque{id=1, score=0, pointsDeVie=15, arme=Arme{type=MARTEAU, couleur=BLEU}}

===== DEBUT DU DUEL : ORQUE 1 vs ORQUE 0 =====

Arme{type=MARTEAU, couleur=BLEU}L'Orque 1 attaque avec cette arme !
ORQUE 1 inflige 15 dégâts à ORQUE 0
ORQUE 0 possede 5PDV
Arme{type=MARTEAU, couleur=BLEU}L'Orque 1 attaque avec cette arme !
ORQUE 1 inflige 15 dégâts à ORQUE 0
ORQUE 0 possede -10PDV
💀 ORQUE 0 est mort !

=====COMPORTEMENT PAR DEFAUT +5PDV pour Orque{id=1, score=1, pointsDeVie=20, arme=Arme{type=MARTEAU, couleur=BLEU}}

=====WINNER ARENE : Orque{id=1, score=1, pointsDeVie=20, arme=Arme{type=MARTEAU, couleur=BLEU}}

===== COMBAT EN FORET =====


=====COMPORTEMENT PAR DEFAUT -5PDV pour Orque{id=4, score=0, pointsDeVie=15, arme=Arme{type=MARTEAU, couleur=JAUNE}}

===== DEBUT DU DUEL : ORQUE 4 vs ORQUE 3 =====

Arme{type=EPEE, couleur=VERT}L'Orque 3 attaque avec cette arme !
ORQUE 3 inflige 10 dégâts à ORQUE 4
ORQUE 4 possede 5PDV
Arme{type=MARTEAU, couleur=JAUNE}L'Orque 4 attaque avec cette arme !
ORQUE 4 rate son attaque.
Arme{type=EPEE, couleur=VERT}L'Orque 3 attaque avec cette arme !
ORQUE 3 inflige 10 dégâts à ORQUE 4
ORQUE 4 possede -5PDV
💀 ORQUE 4 est mort !

=====CACHETTE EN FORET POUR REGENERER DE 20 PDV pour Orque{id=3, score=1, pointsDeVie=40, arme=Arme{type=EPEE, couleur=VERT}}

=====COMPORTEMENT PAR DEFAUT -5PDV pour Orque{id=3, score=1, pointsDeVie=35, arme=Arme{type=EPEE, couleur=VERT}}

===== DEBUT DU DUEL : ORQUE 2 vs ORQUE 3 =====

Arme{type=EPEE, couleur=VERT}L'Orque 3 attaque avec cette arme !
ORQUE 3 rate son attaque.
Arme{type=EPEE, couleur=VERT}L'Orque 3 attaque avec cette arme !
ORQUE 3 inflige 10 dégâts à ORQUE 2
ORQUE 2 possede 10PDV
Arme{type=EPEE, couleur=VERT}L'Orque 3 attaque avec cette arme !
ORQUE 3 rate son attaque.
Arme{type=HACHE, couleur=ROUGE}L'Orque 2 attaque avec cette arme !
ORQUE 2 inflige 12 dégâts à ORQUE 3
ORQUE 3 possede 23PDV
Arme{type=HACHE, couleur=ROUGE}L'Orque 2 attaque avec cette arme !
ORQUE 2 inflige 12 dégâts à ORQUE 3
ORQUE 3 possede 11PDV
Arme{type=HACHE, couleur=ROUGE}L'Orque 2 attaque avec cette arme !
ORQUE 2 inflige 12 dégâts à ORQUE 3
ORQUE 3 possede -1PDV
💀 ORQUE 3 est mort !

=====CACHETTE EN FORET POUR REGENERER DE 20 PDV pour Orque{id=2, score=1, pointsDeVie=30, arme=Arme{type=HACHE, couleur=ROUGE}}

=====WINNER FORET: Orque{id=2, score=1, pointsDeVie=30, arme=Arme{type=HACHE, couleur=ROUGE}}

===== COMBAT EN MONTAGNE ORAGEUSE =====

CIBLE DE LA FOUDRE Orque{id=5, score=0, pointsDeVie=1, arme=Arme{type=HACHE, couleur=BLEU}}

===== DEBUT DU DUEL : ORQUE 5 vs ORQUE 6 =====

Arme{type=HACHE, couleur=BLEU}L'Orque 5 attaque avec cette arme !
ORQUE 5 rate son attaque.
Arme{type=HACHE, couleur=BLEU}L'Orque 5 attaque avec cette arme !
ORQUE 5 inflige 12 dégâts à ORQUE 6
ORQUE 6 possede 8PDV
Arme{type=HACHE, couleur=BLEU}L'Orque 5 attaque avec cette arme !
ORQUE 5 inflige 12 dégâts à ORQUE 6
ORQUE 6 possede -4PDV
💀 ORQUE 6 est mort !

=====COMPORTEMENT PAR DEFAUT +5PDV pour Orque{id=5, score=1, pointsDeVie=6, arme=Arme{type=HACHE, couleur=BLEU}}

===== DEBUT DU DUEL : ORQUE 7 vs ORQUE 5 =====

Arme{type=HACHE, couleur=BLEU}L'Orque 5 attaque avec cette arme !
ORQUE 5 inflige 12 dégâts à ORQUE 7
ORQUE 7 possede 8PDV
Arme{type=MARTEAU, couleur=ROUGE}L'Orque 7 attaque avec cette arme !
ORQUE 7 inflige 15 dégâts à ORQUE 5
ORQUE 5 possede -9PDV
💀 ORQUE 5 est mort !

=====COMPORTEMENT PAR DEFAUT +5PDV pour Orque{id=7, score=1, pointsDeVie=13, arme=Arme{type=MARTEAU, couleur=ROUGE}}

=====WINNER MONTAGNE: Orque{id=7, score=1, pointsDeVie=13, arme=Arme{type=MARTEAU, couleur=ROUGE}}

===== COMBAT DANS LE DESERT =====


=====TEMPETE DE SABLE perte de 10 PDV pour Orque{id=8, score=0, pointsDeVie=10, arme=Arme{type=MARTEAU, couleur=BLEU}}

===== DEBUT DU DUEL : ORQUE 9 vs ORQUE 8 =====

Arme{type=LANCE, couleur=ROUGE}L'Orque 9 attaque avec cette arme !
ORQUE 9 inflige 8 dégâts à ORQUE 8
ORQUE 8 possede 2PDV
Arme{type=MARTEAU, couleur=BLEU}L'Orque 8 attaque avec cette arme !
ORQUE 8 rate son attaque.
Arme{type=LANCE, couleur=ROUGE}L'Orque 9 attaque avec cette arme !
ORQUE 9 inflige 8 dégâts à ORQUE 8
ORQUE 8 possede -6PDV
💀 ORQUE 8 est mort !

=====OASIS INEXISTANTE perte de 15 PDV pour Orque{id=9, score=1, pointsDeVie=5, arme=Arme{type=LANCE, couleur=ROUGE}}

=====TEMPETE DE SABLE perte de 10 PDV pour Orque{id=9, score=1, pointsDeVie=1, arme=Arme{type=LANCE, couleur=ROUGE}}

===== DEBUT DU DUEL : ORQUE 10 vs ORQUE 9 =====

Arme{type=EPEE, couleur=VERT}L'Orque 10 attaque avec cette arme !
ORQUE 10 rate son attaque.
Arme{type=LANCE, couleur=ROUGE}L'Orque 9 attaque avec cette arme !
ORQUE 9 inflige 8 dégâts à ORQUE 10
ORQUE 10 possede 12PDV
Arme{type=EPEE, couleur=VERT}L'Orque 10 attaque avec cette arme !
ORQUE 10 rate son attaque.
Arme{type=LANCE, couleur=ROUGE}L'Orque 9 attaque avec cette arme !
ORQUE 9 rate son attaque.
Arme{type=LANCE, couleur=ROUGE}L'Orque 9 attaque avec cette arme !
ORQUE 9 inflige 8 dégâts à ORQUE 10
ORQUE 10 possede 4PDV
Arme{type=LANCE, couleur=ROUGE}L'Orque 9 attaque avec cette arme !
ORQUE 9 inflige 8 dégâts à ORQUE 10
ORQUE 10 possede -4PDV
💀 ORQUE 10 est mort !

=====OASIS INEXISTANTE perte de 15 PDV pour Orque{id=9, score=2, pointsDeVie=1, arme=Arme{type=LANCE, couleur=ROUGE}}

=====WINNER DESERT Orque{id=9, score=2, pointsDeVie=1, arme=Arme{type=LANCE, couleur=ROUGE}}

=====ORQUE LEGENDE Orque{id=3, score=1, pointsDeVie=-1, arme=Arme{type=EPEE, couleur=VERT}}
```

## Extension 3 (bonus)

Idees :

Position pour un orque x,y

Arme avec une portee random entre 1 et 30

possibilite de toucher son adversaire que si diatnce <= portee de l'arme

Affichage du lieu et des orques avant le duel

Arene : carré de 20x20 bordure en # et interieur avec . (impossible de placer un orque sur bordure)
Désert : carré de 20x20 bordure en # et interieur avec . jaune + zone oasis (taille et position de votre choix) en tild bleu + quelques palmiers (Y) verts
Foret :  carré de 20x20 bordure en # et interieur avec . marron +  des arbres (T) verts random
Montagne :  carré de 20x20 bordure en # et interieur avec . + zone motagneuse rectangulaire (taille et position de votre choix) avec ^

Pendant le duel a chaque tour celui qui vient de jouer se deplace random mais en se rapprochant

affichage lieu a la fin du duel
En cours de construction ... 
