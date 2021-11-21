# CC1 Architecture Logiciel

##Les Classes
Le projet se décompose en **4 "parties"**:

Une partie User qui permet de créer et gérer les users qui souhaite devenir contractors:
- `Class User`
- `Class UserService`
- `Class UserRepository`

Une partie Connection qui permet de gérer la connexion des users.
- `Class UserConnectionService`
- `Class UserConnectionRepository`

Une partie Payment qui permet de gérer et enregistrer le processus de paiement.
- `Class PaymentService`
- `Class PaymentRepository`

Une partie Contractor qui permet de valider un user en tant que contractor.
- `Class ContractorService`
- `Class ContractorRepository`
 
 #Patterns
Les Patterns qui ont été utilisé au sein du projet sont:

* Entity 
* Value Object 
* Repository

CC1 4AL2 - Christophe Yalap
