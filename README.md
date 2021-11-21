# CC1 Architecture Logiciel

##Introduction

Ce projet est un petit logiciel représentant la gestion des inscriptions d’une solution e-commerce,
comportant une fonction d’ajout d’un membre voulant devenir un commerçant.

- Gestion des Users ==> creation, recuperation des users, changement du mot de passe,...


- Gestion de la connexion ==> Un utilisateur doit forcément être connecté pour effectuer un paiement et devenir contractor.


- Gestion du paiement de l'utilisateur ==> L'utilisateur ne pourras pas effectuer de paiement si il n'est pas connecté ou bien si son moyen de paiement n'est pas valide.


- Gestion du contractor ==> Une fois que l'utilisateur a été créer, qu'il est connecté et qu'il a validé son paiement, il seras considéré et ajouter au sein de la base en tant que contractor et identifiable grâce a son Id.

##Les Classes
Comme évoqué précedement, le projet se décompose en **4 "parties"**:

Une partie User qui permet de créer et gérer les users qui souhaite devenir contractors:
- `Class User => L'entité de l'utilisateur`
- `Class UserService => Services pour l'entité utilisateur`
- `Class InMemoryUserRepository => Repository de l'entioté utilisateur (en mode InMemory, donc pas de Base de donnée)`

Une partie Connection qui permet de gérer la connexion des users.
- `Class UserConnectionService => Service de connexion/deconnexion de l'utilisateur`
- `Class InMemoryUserConnectionRepository => Repository contenant la liste des Id des utilisateurs connectés ainsi que la date de connexion`

Une partie Payment qui permet de gérer et enregistrer le paiement indispensable pour devenir contractor.
- `Class PaymentService => Service de paiement de l'utilisateur`
- `Class InMemoryPaymentRepository => Repository contenant la liste des Id des utilisateurs ayant payés `

Une partie Contractor qui permet de valider un user en tant que contractor.
- `Class ContractorService => Service permettant de valider un utilisateur en tant que contractor`
- `Class InMemoryContractorRepository => Repository contenant la liste des Id des utilisateurs devenues contractors `
 
##Les Patterns
Les Patterns de développement qui ont été utilisés au sein du projet sont:

* **Pattern Entity :** Le pattern Entity a été utilisé pour l'entité User.


* **Pattern Value Object :** Utilisation du pattern Value Object pour l'adresse mail dans la classe User.


* **Pattern Repository :** InMemoryContractorRepository, InMemoryPaymentRepository, InMemoryUserConnectionRepository, InMemoryUserRepository.


* **Injection de Dépendances :** L'injection de dépendance à été utilisé dans ces classes au sein du constructeur => ContractorService, PaymentService, UserConnectionService, UserService.


CC1 4AL2 - Christophe Yalap
