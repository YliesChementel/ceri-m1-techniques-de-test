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






## Badges

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/YliesChementel/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/YliesChementel/ceri-m1-techniques-de-test/tree/master)
[![codecov](https://codecov.io/gh/YliesChementel/ceri-m1-techniques-de-test/graph/badge.svg?token=9HBZX9SS95)](https://codecov.io/gh/YliesChementel/ceri-m1-techniques-de-test)

![Checkstyle](https://img.shields.io/badge/checkstyle-90%25-green)