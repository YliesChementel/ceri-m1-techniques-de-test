# Technique de Test

## Nom et Prénom
#### **Chementel Ylies**

## Groupe
#### **ILSEN G1 CLA**

## Badges

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/YliesChementel/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/YliesChementel/ceri-m1-techniques-de-test/tree/master)
[![codecov](https://codecov.io/gh/YliesChementel/ceri-m1-techniques-de-test/graph/badge.svg?token=9HBZX9SS95)](https://codecov.io/gh/YliesChementel/ceri-m1-techniques-de-test)
![Checkstyle](badges/checkstyle-result.svg)
![Javadoc](https://img.shields.io/badge/Javadoc-Link-green?url=https%3A%2F%2Fylieschementel.github.io%2Fceri-m1-techniques-de-test%2Ffr%2Funivavignon%2Fpokedex%2Fapi%2Fpackage-summary.html)


## Projet Pokedex

Un projet qui permet de gérer et stocké des Pokémons, leurs statistiques et faire des opérations sur ceux-ci.

## Table of Contents

- [TP](#TP)
- [Technologies utilisées](#technologies-utilisées)
- [Classes](#Classes)

## TP

### TP4

Pour l'implémentation, le plus gros problème aura été d'implémenter la classe `PokemonMetadataProvider` car je ne savais pas vraiment comment gérer cette classe.  
Dans mes implémentations, je suis resté simple : si ce n'est pas dans l'interface ou si ce n'est pas utile au reste, alors je n'implémente rien de plus pour ne pas me perdre.

J'ai implémenté les classes suivantes :

### PokemonMetadataProvider

Cette classe implémente l'interface `IPokemonMetadataProvider` qui ne possède qu'une seule méthode, `getPokemonMetadata`. J'ai donc implémenté cette méthode dans la classe. Cette classe étant un provider de `PokemonMetadata`, j'ai choisi de stocker des `PokemonMetadata` dans cette classe pour les récupérer si demandés. J'ai stocké ces métadonnées via la variable static `INDEXTOMETADATA`. Grâce à cette méthode de stockage, j'ai pu implémenter la méthode `getPokemonMetadata` pour récupérer les métadonnées d'un Pokémon en fonction de son index. La méthode aura seulement à chercher dans la variable Map statique pour récupérer les métadonnées d'un Pokémon donné, et si elle ne les trouve pas, elle renverra une erreur.

### PokemonFactory

Cette classe implémente l'interface `IPokemonFactory` qui ne possède qu'une seule méthode, `createPokemon`. J'ai donc implémenté cette méthode dans la classe.

Dans la méthode `createPokemon`, j'utilise un `PokemonMetadataProvider` pour récupérer les métadonnées du Pokémon en fonction de son index. Une fois ces métadonnées obtenues, je génère des valeurs aléatoires pour l'attaque, la défense et l'IV en utilisant la classe `Random`. Ensuite, je calcule l'IV total à partir de ces valeurs aléatoires.

Enfin, j'utilise le tout pour créer une nouvelle instance de `Pokemon`, en initialisant ses attributs avec l'index, le nom, l'attaque, la défense, l'endurance, le CP, les HP, la quantité de dust, de bonbons et les IV calculés.

### PokedexFactory

Cette classe implémente l'interface `IPokedexFactory` qui possède une seule méthode, `createPokedex`. J'ai donc implémenté cette méthode dans la classe. Sa méthode `createPokedex` renvoie tout simplement une nouvelle instance de `Pokedex` avec en paramètres les objets `IPokemonMetadataProvider` et `IPokemonFactory` qui lui sont donnés, et ce, uniquement s'ils ne sont pas null. Sinon, l'instance retournée est null.

### PokemonTrainerFactory

Cette classe implémente l'interface `IPokemonTrainerFactory` qui possède une seule méthode, `createTrainer`, mais j'ai rajouté plusieurs éléments nécessaires au bon fonctionnement de la classe, tels que des variables de classe et un constructeur.

Dans la méthode `createTrainer`, je vérifie d'abord que les arguments ne sont pas null. Sinon, je renvoie une instance null de `PokemonTrainer`. Le problème est qu'un objet de type `PokemonTrainer` a besoin d'un objet de type `Pokedex`, d'où le `pokedexFactory`. 

J'ai donc utilisé ce `pokedexFactory` pour créer un objet de type `Pokedex`, mais pour cela, il me faut des objets de type `PokemonMetadataProvider` et `PokemonFactory`. J'ai donc dû intégrer ces objets en tant que variables de classe et donc dans le constructeur, afin que cette méthode fonctionne et crée un objet de type `Pokedex` pour pouvoir ensuite créer une instance de `PokemonTrainer`.

### Pokedex

Cette classe implémente l'interface `IPokedex` qui regroupe plusieurs méthodes permettant de gérer une collection de Pokémon, d'ajouter des Pokémon, de récupérer leurs métadonnées et d'accéder à différentes vues de la liste des Pokémon.

Dans le constructeur de la classe `Pokedex`, je passe les objets `IPokemonMetadataProvider` et `IPokemonFactory` qui sont utilisés pour récupérer les métadonnées des Pokémon et créer des instances de Pokémon respectivement. Ces objets sont stockés comme des variables de classe.

La méthode `size` renvoie simplement le nombre de Pokémon dans le Pokédex. La méthode `addPokemon` permet d'ajouter un Pokémon à la liste et renvoie son index unique. Dans `getPokemon`, je vérifie que l'ID demandé est valide, sinon une exception `PokedexException` est lancée. La méthode `getPokemons` renvoie une vue non modifiable de la liste de tous les Pokémon, tandis que `getPokemons(Comparator<Pokemon> order)` permet de récupérer une vue triée des Pokémon selon un ordre donné.

La méthode `createPokemon` utilise le `pokemonFactory` pour créer un Pokémon avec les attributs fournis. Enfin, la méthode `getPokemonMetadata` permet de récupérer les métadonnées d'un Pokémon en fonction de son index, en utilisant le `metadataProvider`.


### TP5

Pour le style, j'ai choisi d'utiliser un fichier de configuration, `checktyle.xml` pour choisir moi-même le style de mon code.
J'ai donc utilisé les modules suivants :

**FileTabCharacter** : Cette règle permet de vérifier que l'indentation du code est cohérente et respecte la configuration attendue (tabulation ou espace).

**AvoidStarImport** : Cette règle empêche l'utilisation d'importations avec un astérisque qui peuvent rendre difficile la lecture du code.

**EmptyBlock** : Cette règle détecte les blocs vides dans le code qui peuvent être inutiles ou être le signe d'un oubli ou d'une erreur dans le code.

**CommentsIndentation** : Cette règle vérifie que les commentaires sont correctement indentés.

**RegexpSingleline** : Cette règle applique une vérification à chaque ligne du code pour s'assurer que les noms des variables respectent une convention.

**NewlineAtEndOfFile** : Cette règle vérifie qu'il y a bien une nouvelle ligne à la fin des fichiers sources.

**JavadocType** : Cette règle impose que toutes les classes, interfaces et énumérations soient correctement documentées avec un commentaire Javadoc.

**JavadocMethod** : Cette règle assure que toutes les méthodes sont correctement documentées avec des commentaires Javadoc.

**JavadocVariable** : Cette règle s'applique aux variables, exigeant qu'elles soient documentées avec des commentaires Javadoc.

**JavadocPackage** : Cette règle impose d'ajouter un commentaire Javadoc pour le package.

Je n'ai pas utilisé davantage de modules, car cela m'aurait demandé trop de temps pour les implémenter et corriger l'ensemble du code, ce qui était déjà long avec ceux que j'ai utilisés.

### TP6

#### Rapport de Conclusions sur le code RocketPokemonFactory

Tout d'abord, à vue d'œil, il y a plusieurs problèmes avec le code fourni :

- **La variable `index2name`** n'a pas de raison d'être, car ce n'est pas au rôle de `RocketPokemonFactory` de stocker les noms des pokémons, mais à `PokemonMetadataProvider`. En effet, grâce à l'index d'un pokémon, on peut obtenir son nom dans `PokemonMetadataProvider`, donc cette variable ne sert à rien.

- **La méthode `generateRandomStat()`** est tout aussi inutile puisqu'elle n'a aucun sens. Dans cette méthode, la variable `total` est initialisée à 0, puis elle passe dans une boucle où elle sera incrémentée par une valeur entre 0 et 1. Cette itération se produit un million de fois, puis la variable sera divisée par 1000. Cette fonction aurait pu être remplacée par une seule ligne : `r = rn.nextInt(1001)` pour obtenir le même résultat.

- **La méthode `createPokemon()`** ne fonctionne pas comme elle le devrait, car :
    - Premièrement, les stats des pokémons ne devraient pas être aléatoires, car elles sont déjà stockées dans `PokemonMetadataProvider`.
    - Et enfin, les IV ne sont pas calculés correctement et de manière aléatoire. Actuellement, ils ne sont pas censés être initialisés à 0 ou 1.

Ensuite, concernant les tests :

Les tests de `PokemonFactoryTest` ont été copiés dans la nouvelle classe `RocketPokemonFactoryTest`, puis ont été lancés pour être mis en échec.

- **Le test `shouldCreatePokemonInstance()`** échoue, car la méthode `createPokemon` de `RocketPokemonFactory` prend le nom de ses pokémons directement dans sa propre variable `Map`, et non dans `PokemonMetadataProvider`. Ainsi, au lieu de récupérer "Bulbizarre", elle récupère "Bulbasaur". De plus, si un index inconnu est fourni à `createPokemon`, `RocketPokemonFactory` ne renverra pas une erreur, mais renverra `MISSINGNO` puisqu'il se trouve dans sa `Map`, alors que `PokemonMetadataProvider` renverrait une exception.


## Technologies utilisées

- **Java 11**: Le langage principal utilisé pour développer l’application.
- **Maven**: Utilisé pour la gestion des dépendances et la construction du projet.
- **JUnit**: Framework de tests pour tester les fonctionnalités de l’application.
- **CircleCI**: Outil d'intégration continue pour automatiser les builds et les tests.
- **Mockito**: Framework de mock utilisé pour simuler des objets et tester des parties spécifiques du code sans dépendre de l'implémentation réelle des autres composants.
- **Jacoco**: Outil de mesure de la couverture de tests. Permet de générer des rapports sur le pourcentage de code testé par les tests unitaires.
- **Checkstyle**: Outil de vérification des règles de style de code. Assure que le code respecte les bonnes pratiques et conventions de style définies dans le projet.
- **Javadoc**: Outil de documentation intégré à Java permettant de générer la documentation de l'API en format HTML à partir des commentaires dans le code source.


## Classes

Voici une liste des principales classes et modules présents dans ce projet avec une courte description pour chacune :

### 1. `Interfaces`

#### 1. `IPokedex`
Interface définissant les méthodes pour gérer un Pokedex (ajouter, chercher, etc.).

#### 2. `IPokedexFactory`
Interface pour la création d'une instance de `Pokedex`.

#### 3. `IPokemonFactory`
Interface qui définit les méthodes nécessaires pour créer un Pokémon.

#### 4. `IPokemonMetadataProvider`
Interface pour fournir des métadonnées sur les Pokémon.

#### 5. `IPokemonTrainerFactory`
Interface pour créer des instances de Pokémon Trainers.

---

### 2. `Classes java`

#### 1. `Pokedex`
Implémentation de l'interface `IPokedex`, permettant de gérer un ensemble de Pokémon et leurs opérations.

#### 2. `PokedexFactory`
Implémentation de l'interface `IPokedexFactory`, responsable de la création d'un Pokedex.

#### 3. `Pokemon`
Classe représentant un Pokémon avec ses attributs comme le nom, les stats, etc...

#### 4. `PokemonFactory`
Classe pour la création d'instances de `Pokemon` à partir de données brutes ou de métadonnées.

#### 5. `PokemonMetadata`
Classe contenant des informations supplémentaires sur les Pokémon, comme leurs statistiques.

#### 6. `PokemonMetadataProvider`
Implémentation de l'interface `IPokemonMetadataProvider` pour fournir les métadonnées des Pokémon.

#### 7. `PokemonTrainer`
Classe représentant un dresseur de Pokémon, capable de gérer une équipe de Pokémon.

#### 8. `PokemonTrainerFactory`
Implémentation de l'interface `IPokemonTrainerFactory`, servant à créer un dresseur de Pokémon.

---

### 3. `Classes enumeration`

#### 1. `PokemonComparators`
Classe utilitaire contenant des comparateurs pour trier les Pokémon selon divers critères (nom, stats, etc.).

#### 2. `Team`
Classe représentant une équipe de Pokémon, souvent associée à un dresseur de Pokémon.

---

### 4. `Classes exception`

#### 1. `PokedexException`
Exception personnalisée pour gérer les erreurs liées au Pokedex.





