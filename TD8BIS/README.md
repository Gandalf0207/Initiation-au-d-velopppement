---
lang: fr
---

# TD8 Bis - Objets et classes : course de véhicules

Ce TD est la suite du  TD8 - Course simple (une seule longueur de piste) pour lequel une correction est donnée.



Actuellement une `Course`concerne uniquement deux `Voiture`.
Dans ce TD l'objectif est de pouvoir réaliser une `Course` entre deux `Vehicules`.
Par exemple, nous souhaitons pouvoir faire une `Course` entre une `Voiture` et une `Moto` ou entre une `Voiture` et un `Velo`, ou entre deux `Moto' ou entre deux `Velo' ...

Question 1 : Le chapitre dénombrement en maths est terminé ... Combien de courses différentes est il possible d'organiser avec ces trois classes ?

Question 2 : Combien de courses différentes est il possible d'organiser avec `n` classes ?


Une `Voiture` est un `Véhicule` stable et constant : il avance toujours de la même vitesse.

Une `Moto` est un `Véhicule` instable et rapide : elle avance en fonction de ses caracteristiques (vitesse = vitesseBase + couple/50 + nbCylindres) mais peut parfois caler avec une certaine probabilité.

Un `Vélo` est un `Véhicule` stable et lent : il avance toujours d'une certaine vitesse de base mais (avec la fatigue) celle-ci diminue petit à petit. Cette "fatigue" est appellée endurance (egale à 100 quand elle est pleine et 0 quand est elle est vide).


## Moto
Consultez le squelette de code de la classe `Moto` et complétez le code. Il faudra définir les **attributs** et complétez les différentes **méthodes**.

## Vélo

Consultez le squelette de code de la classe `Vélo` et complétez le code. Il faudra définir les **attributs** et complétez les différentes **méthodes**.

## Véhicule

Question 3 : Quelle solution pouvez vous mettre en place afin de réaliser une `Course` entre une `Voiture` et une `Moto` ?

Question 4 : Quelle solution pouvez vous mettre en place afin de réaliser une `Course` entre une `Moto` et une `Vélo` ?

La première idée consiste a créer une classe `CourseVoitureMoto` puis une autre classe `CourseMotoVelo`en adaptant les attributs.

Question 5 : Que se passe-t-il si on décide d'ajouter des `Skate`s, des `Trotinette`s... ?

Vous avez vu en Question 2 que le nombre de `Course` réalisables augmente très vite.
Il n'est donc pas possible de définir une nouvelle classe `CourseXY` pour chaque `Course` entre `X` et `Y`.

Faire une interface `Vehicule` permettant de définir le contrat à remplir par tous les `Véhicules`.

Vous adapterez la classe `Course` afin qu'elle gère desormais deux `Véhicule`s et non plus deux `Voiture`s.

Vous devriez rencontrer une difficulté pour afficher les `Vehicule`s au fur et à mesure de l'avancée de la `Course`.

`Course` gère désormais deux `Vehicule`s dont vous ignorez le type exact (`Voiture`, `Moto`, `Velo`) vous ne pouvez donc plus faire appel à la méthode affiche qui est propre à `Voiture`, `Moto` et `Velo`.

Vous pouvez essayer de transferer le code d'une des méthodes `affiche()` dans `Vehicule`, que se passe-t-il ?

Impossible car la méthode `affiche()` a besoin de connaitre la `position` ainsi que le `nom` or ces attributs sont contenus dans les classes `Voiture`, `Moto`, `Velo`.
Que se passe-t-il si vous essayez de déplacer `position`  et `nom` dans `Vehicule`?

Impossible également : une interface ne peut pas déclarer d'attribut.

La solution la plus adaptée consiste à conserver les attributs ainsi que le code de `affiche()` dans les classes `Voiture`, `Moto`, `Velo` mais d'ajouter une **méthode par défaut**  `default void printPosition()` dans `Vehicule` (qui pourra être utilisée dans `Course`) et c'est celle-ci qui fera appel à `affiche()`.



## Pour aller plus loin

Pour ceux qui se posent des question concernant la méthode dépasse qui est exactement la même dans les trois classes implémentées, la méthode affiche (qui ne diffère que d'un emoji), ou encore des attributs nom et position qui sont également en commun : il existe bien sur une autre solution permettant d'éviter la duplication de code et de regrouper les comportements communs, celle-ci sera vue au semestre 2: il s'agit de la notion d'héritage et de celle de classes abstraites.



