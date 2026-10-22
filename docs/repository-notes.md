 
Choix d'interface

| Interface              | Étend                            | Justification                                                                    |
|------------------------|----------------------------------|----------------------------------------------------------------------------------|
| IAgenceRepository      | JpaRepository<Agence, Long>      | CRUD complet, findAll renvoie une List, tri, pagination, saveAndFlush disponible |
| IEmployeRepository     | JpaRepository<Employe, Long>     | CRUD complet, findAll renvoie une List, tri, pagination, saveAndFlush disponible |
| IVehiculeRepository    | JpaRepository<Vehicule, Long>    | CRUD complet, findAll renvoie une List, tri, pagination, saveAndFlush disponible |
| IEquipementRepository  | JpaRepository<Equipement, Long>  | CRUD complet, findAll renvoie une List, tri, pagination, saveAndFlush disponible |
| IClientRepository      | JpaRepository<Client, Long>      | CRUD complet, findAll renvoie une List, tri, pagination, saveAndFlush disponible |
| IReservationRepository | JpaRepository<Reservation, Long> | CRUD complet, findAll renvoie une List, tri, pagination, saveAndFlush disponible |
| IContratRepository     | JpaRepository<Contrat, Long>     | CRUD complet, findAll renvoie une List, tri, pagination, saveAndFlush disponible |
| IPaiementRepository    | JpaRepository<Paiement, Long>    | CRUD complet, findAll renvoie une List, tri, pagination, saveAndFlush disponible |
| IMaintenanceRepository | JpaRepository<Maintenance, Long> | CRUD complet, findAll renvoie une List, tri, pagination, saveAndFlush disponible |



| Anomalie                                                                                                                                                | Règle / explication                                                                                                                                              | Correction apportée                                                          |
|---------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------|
| Import inutilisé `org.springframework.data.repository.CrudRepository` dans `IContratRepository` (reste de l'étape 1 après le passage à `JpaRepository`) | `java:S1128` : *Remove this unused import*. Un import jamais utilisé alourdit le code et prête à confusion.                                                      | Import supprimé.                                                             |
| Ligne de code commentée (`// contratRepository.deleteAll();`)                                                                                           | `java:S125` : *Remove this commented out code*. Le code mis en commentaire est du code mort, l'historique Git suffit pour le retrouver.                          | Ligne supprimée.                                                             |
| `System.out.println(...)` utilisé pour afficher un résultat                                                                                             | `java:S106` : *Replace this use of System.out by a logger*. Un logger permet de régler les niveaux et le format des messages, ce que `System.out` ne permet pas. | Remplacé par un logger (`@Slf4j` de Lombok et `log.info(...)`), ou supprimé. |