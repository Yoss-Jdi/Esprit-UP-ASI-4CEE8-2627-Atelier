 A. Endpoints

| Contrôleur            | Verbe et route                | Service appelé                 | Succès | Erreurs  |
|-----------------------|-------------------------------|--------------------------------|--------|----------|
| AgenceController      | GET /api/agences              | IAgenceService.findAll         | 200    | —        |
| AgenceController      | GET /api/agences/{id}         | IAgenceService.findById        | 200    | 404      |
| AgenceController      | POST /api/agences             | IAgenceService.create          | 201    | 400      |
| AgenceController      | PUT /api/agences/{id}         | IAgenceService.update          | 200    | 404, 400 |
| AgenceController      | DELETE /api/agences/{id}      | IAgenceService.deleteById      | 204    | 404      |
| EmployeController     | GET /api/employes             | IEmployeService.findAll        | 200    | —        |
| EmployeController     | GET /api/employes/{id}        | IEmployeService.findById       | 200    | 404      |
| EmployeController     | POST /api/employes            | IEmployeService.create         | 201    | 400      |
| EmployeController     | PUT /api/employes/{id}        | IEmployeService.update         | 200    | 404, 400 |
| EmployeController     | DELETE /api/employes/{id}     | IEmployeService.deleteById     | 204    | 404      |
| VehiculeController    | GET /api/vehicules            | IVehiculeService.findAll       | 200    | —        |
| VehiculeController    | GET /api/vehicules/{id}       | IVehiculeService.findById      | 200    | 404      |
| VehiculeController    | POST /api/vehicules           | IVehiculeService.create        | 201    | 400      |
| VehiculeController    | PUT /api/vehicules/{id}       | IVehiculeService.update        | 200    | 404, 400 |
| VehiculeController    | DELETE /api/vehicules/{id}    | IVehiculeService.deleteById    | 204    | 404      |
| EquipementController  | GET /api/equipements          | IEquipementService.findAll     | 200    | —        |
| EquipementController  | GET /api/equipements/{id}     | IEquipementService.findById    | 200    | 404      |
| EquipementController  | POST /api/equipements         | IEquipementService.create      | 201    | 400      |
| EquipementController  | PUT /api/equipements/{id}     | IEquipementService.update      | 200    | 404, 400 |
| EquipementController  | DELETE /api/equipements/{id}  | IEquipementService.deleteById  | 204    | 404      |
| ClientController      | GET /api/clients              | IClientService.findAll         | 200    | —        |
| ClientController      | GET /api/clients/{id}         | IClientService.findById        | 200    | 404      |
| ClientController      | POST /api/clients             | IClientService.create          | 201    | 400      |
| ClientController      | PUT /api/clients/{id}         | IClientService.update          | 200    | 404, 400 |
| ClientController      | DELETE /api/clients/{id}      | IClientService.deleteById      | 204    | 404      |
| ReservationController | GET /api/reservations         | IReservationService.findAll    | 200    | —        |
| ReservationController | GET /api/reservations/{id}    | IReservationService.findById   | 200    | 404      |
| ReservationController | POST /api/reservations        | IReservationService.create     | 201    | 400      |
| ReservationController | PUT /api/reservations/{id}    | IReservationService.update     | 200    | 404, 400 |
| ReservationController | DELETE /api/reservations/{id} | IReservationService.deleteById | 204    | 404      |
| ContratController     | GET /api/contrats             | IContratService.findAll        | 200    | —        |
| ContratController     | GET /api/contrats/{id}        | IContratService.findById       | 200    | 404      |
| ContratController     | POST /api/contrats            | IContratService.create         | 201    | 400      |
| ContratController     | PUT /api/contrats/{id}        | IContratService.update         | 200    | 404, 400 |
| ContratController     | DELETE /api/contrats/{id}     | IContratService.deleteById     | 204    | 404      |
| MaintenanceController | GET /api/maintenances         | IMaintenanceService.findAll    | 200    | —        |
| MaintenanceController | GET /api/maintenances/{id}    | IMaintenanceService.findById   | 200    | 404      |
| MaintenanceController | POST /api/maintenances        | IMaintenanceService.create     | 201    | 400      |
| MaintenanceController | PUT /api/maintenances/{id}    | IMaintenanceService.update     | 200    | 404, 400 |
| MaintenanceController | DELETE /api/maintenances/{id} | IMaintenanceService.deleteById | 204    | 404      |
| PaiementController    | GET /api/paiements            | IPaiementService.findAll       | 200    | —        |
| PaiementController    | GET /api/paiements/{id}       | IPaiementService.findById      | 200    | 404      |
| PaiementController    | POST /api/paiements           | (aucun)                        | —      | 405      |

 B. Annotations Jackson

| Association                          | Annotation                                                                                                     | Justification                                                                           |
|--------------------------------------|----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| Contrat.paiements / Paiement.contrat | `@JsonManagedReference("contrat-paiements")` côté liste, `@JsonBackReference("contrat-paiements")` côté parent | Composition : le paiement se crée dans le JSON de son contrat ; évite la boucle infinie |
| à compléter (ex. Agence.vehicules)   | `@JsonIgnore`                                                                                                  | Enfant créé seul qui désigne son parent par un identifiant                              |
| à compléter                          | à compléter                                                                                                    | à compléter                                                                             |

Différence : `@JsonBackReference` n'est jamais sérialisé, et il est ignoré aussi à la lecture du JSON entrant (le lien vers le parent est reconstruit grâce à `@JsonManagedReference`). `@JsonIgnore` ignore simplement la propriété dans les deux sens, sans notion de paire ; c'est pourquoi on garde l'attribut propriétaire, utilisé pour désigner le parent par un identifiant.

C. Postman et Swagger
testes effectuer
D. Anomalies SonarQube for IDE

Analyse du package `Controllers` : 50 anomalies dans 10 fichiers, de trois types.

| Anomalie                                                                                                                                                | Règle / explication                                                                                                                                                          | Correction apportée                                                                                                                                                                         |
|---------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `@ApiResponses(Ellipsis)` dans les 9 contrôleurs (33 occurrences) : *Remove the 'ApiResponses' wrapper from this annotation group*                      | `java:S1710` (numéro à vérifier dans le panneau) : `@ApiResponse` est une annotation répétable, l'enveloppe `@ApiResponses` est donc superflue et alourdit le code           | Enveloppe supprimée, les `@ApiResponse` sont placés directement les uns sous les autres sur la méthode                                                                                      |
| `LocalDateTime.now()` dans `GlobalExceptionHandler` : *Explicitly specify the time zone*                                                                | Règle sur les fuseaux horaires (numéro à noter depuis le panneau) : sans fuseau, le résultat dépend de la configuration de la machine, ce qui rend l'horodatage imprévisible | `LocalDateTime.now(ZoneId.of("Africa/Tunis"))`                                                                                                                                              |
| Entité JPA utilisée en paramètre ou en retour dans les contrôleurs (16 occurrences) : *Replace this persistent entity with a simple POJO or DTO object* | `java:S4684` : exposer une entité persistante couple l'API à la base, révèle des champs internes et expose à des attaques par affectation de masse (mass assignment)         | **Non corrigée volontairement** : choix provisoire de l'atelier (entités exposées directement, avec annotations Jackson pour éviter les boucles). Sera remplacée par des DTO au Chapitre 10 |




E. Questions de compréhension

1. La DispatcherServlet reçoit toutes les requêtes. Elle interroge le `HandlerMapping`, qui retrouve la méthode du contrôleur à partir du verbe HTTP et de l'URL.
2. Le contrôleur ne doit pas contourner la couche métier (pas de repository) et dépend d'une abstraction (interface) plutôt que de l'implémentation : couplage faible, remplacement et tests faciles.
3. 201 : une ressource a été créée ; 204 : succès sans corps à renvoyer. Une ressource absente donne 404 car `ResourceNotFoundException` est traduite par le `GlobalExceptionHandler` ; un 500 signalerait une erreur du serveur, alors que l'absence est une erreur du client.
4. Un paiement est en composition avec un contrat : il se crée et se supprime à travers lui. `PaiementController` n'a donc que des GET ; un POST /api/paiements reçoit 405 Method Not Allowed.
5. Risques : couplage entre l'API et la base, champs internes exposés, boucles de sérialisation, proxys LAZY. `Contrat.paiements` utilise `@JsonManagedReference` car les paiements se créent dans le JSON de leur parent (composition) ; `Agence.vehicules` utilise `@JsonIgnore` car un véhicule est créé seul et désigne son agence par un identifiant.
