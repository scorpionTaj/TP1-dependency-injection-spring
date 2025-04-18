# Systèmes Informatiques Distribués et Middlewares - TP1

## Aperçu du Projet

Ce projet illustre l'implémentation d'un système distribué en utilisant le framework Spring pour l'injection de dépendances. L'objectif est de découpler les composants et de gérer dynamiquement les dépendances via une configuration XML et des annotations.

## Structure

Le projet est organisé comme suit :

- **`net.tajeddine.dao`** : Contient les objets d'accès aux données (DAOs) pour récupérer les données.
- **`net.tajeddine.metier`** : Contient les implémentations de la logique métier.
- **`net.tajeddine.ext`** : Contient des implémentations alternatives des DAOs.
- **`net.tajeddine.pres`** : Contient les couches de présentation pour tester et exécuter l'application.
- **`resources/config.xml`** : Fichier de configuration XML de Spring pour l'injection de dépendances.

## Composants Clés

### Couche DAO
- **`DaoImpl`** : Récupère les données depuis une base de données (simulée).
- **`DaoImplV2`** : Récupère les données depuis des capteurs (simulés).

### Couche Métier
- **`MetierImpl`** : Implémente la logique métier principale en utilisant un DAO pour récupérer les données.

### Couche Présentation
- **`PresSpringXML`** : Démonstration de l'injection de dépendances via une configuration XML Spring.
- **`Pres2`** : Démonstration de l'injection de dépendances manuelle via réflexion et fichiers de configuration.

## Configuration

### Configuration XML Spring (`config.xml`)
Définit les beans pour l'injection de dépendances :
```xml
<bean id="d" class="net.tajeddine.ext.DaoImplV2"/>
<bean id="metier" class="net.tajeddine.metier.MetierImpl">
    <constructor-arg ref="d"/>
</bean>
```

### Dépendances Maven
Le projet utilise les dépendances suivantes :
- **Spring Core** : `org.springframework:spring-core:6.2.5`
- **Spring Context** : `org.springframework:spring-context:6.2.5`
- **Spring Beans** : `org.springframework:spring-beans:6.2.5`

## Instructions d'Exécution

1. **Utilisation de Spring XML (`PresSpringXML`)** :
   - Assurez-vous que `config.xml` est correctement configuré.
   - Exécutez la classe `PresSpringXML`.

2. **Injection Manuelle (`Pres2`)** :
   - Créez un fichier `config.txt` avec le contenu suivant :
     ```
     net.tajeddine.dao.DaoImpl
     net.tajeddine.metier.MetierImpl
     ```
   - Exécutez la classe `Pres2`.

## Résultat

L'application calcule un résultat basé sur les données récupérées par le DAO et traitées par la logique métier. Le résultat est affiché dans la console.

## Remarques

- Le projet démontre l'injection de dépendances basée sur XML et annotations.
- Les annotations `@Repository` et `@Service` sont utilisées pour le scan des composants dans Spring.