# Technique de Test

## Nom et Prénom
[Chementel] [Ylies]

## Groupe
[ILSEN G1 CLA]

## Projet Pokedex

Un projet qui permet de gérer et stocké des Pokémons, leurs statistiques et faire des opérations sur ceux-ci.

## Table of Contents

- [Choix techniques](#choix-techniques)
- [Technologies utilisées](#technologies-utilisées)
- [Classes](#Classes)


## Choix techniques

J'ai implémenté les classes suivantes :
### Pokedex
### PokedexFactory
### PokemonFactory
### PokemonMetadataProvider
### PokemonTrainerFactory

Ces classes sont les implémentations des 5 interfaces données comme base dans le TP


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


## TP

### TP1

### TP2

### TP3

### TP4

### TP5

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




## Badges

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/YliesChementel/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/YliesChementel/ceri-m1-techniques-de-test/tree/master)
[![codecov](https://codecov.io/gh/YliesChementel/ceri-m1-techniques-de-test/graph/badge.svg?token=9HBZX9SS95)](https://codecov.io/gh/YliesChementel/ceri-m1-techniques-de-test)

![Checkstyle](https://img.shields.io/badge/checkstyle-90%25-green)