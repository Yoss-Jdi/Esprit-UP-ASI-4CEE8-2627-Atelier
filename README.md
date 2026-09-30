# AutoLoc

Plateforme back-end de gestion de location de véhicules multi-agences, développée avec Spring Boot dans le cadre du cours ASI 26-27 (UP ASI, Architecture des Systèmes d'Information).

## Contexte

AutoLoc est une entreprise de location de véhicules présente dans plusieurs villes. Chaque agence gère sa flotte ; les clients réservent un véhicule, un contrat est établi à la validation, et des paiements y sont rattachés. Le projet est enrichi à chaque atelier du cours.

## Stack technique

- Java, Spring Boot, Maven
- Spring Data JPA / Hibernate
- MySQL
- Lombok

## Modèle de données

Entités JPA : `Vehicule`, `Agence`, `Client`, `Employe`, `Equipement`, `Reservation`, `Contrat`, `Paiement`, `Maintenance`.

Énumérations : `CategorieVehicule`, `StatutVehicule`, `RoleEmploye`, `StatutReservation`, `ModePaiement`.

## Avancement

- [x] Atelier 1 : génération du projet, entité `Vehicule`, entités restantes (sans associations)
- [ ] Atelier 2 : associations, cascade et fetch

## Lancer le projet

1. Créer une base MySQL pour AutoLoc.
2. Renseigner l'URL et l'utilisateur dans `src/main/resources/application.properties`.
3. Définir le mot de passe via une variable d'environnement (recommandé) :

   ```properties
   spring.datasource.password=${DB_PASSWORD}
   ```

4. Démarrer l'application :

   ```bash
   ./mvnw spring-boot:run
   ```

Les tables sont générées automatiquement au démarrage par Hibernate.

## Structure

```
src/main/java/com/esprit/autoloc/
├── domain/         # entités JPA et énumérations
├── repositories/
├── services/
└── controllers/
```
