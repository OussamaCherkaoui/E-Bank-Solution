# E-Bank-Solution

Cette application eBank est un système bancaire en ligne qui permet aux utilisateurs de gérer leurs comptes bancaires, leurs cartes et leurs transactions. Les principales fonctionnalités sont exposées via des API REST.

## Fonctionnalités

### UserController
Gère les utilisateurs de l'application.

#### POST `/user/signUp`
- **Description**: Crée un nouvel utilisateur dans le système.
- **Request Body**: JSON représentant les détails de l'utilisateur.
- **Response**: ResponseEntity contenant l'utilisateur créé.

#### GET `/user/logIn/{userName}/{passWord}`
- **Description**: Authentifie un utilisateur en recherchant par nom d'utilisateur et mot de passe.
- **URL Parameters**:
    - `userName`: Le nom d'utilisateur.
    - `passWord`: Le mot de passe de l'utilisateur.
- **Response**: ResponseEntity contenant l'utilisateur trouvé ou null.

### CompteController
Gère les comptes bancaires.

#### POST `/compte/signUpCompte`
- **Description**: Crée un nouveau compte bancaire.
- **Request Body**: JSON représentant les détails du compte.
- **Response**: ResponseEntity contenant le compte créé.

#### GET `/compte/logInCompte/{numeroCompte}/{mot_de_pass}`
- **Description**: Authentifie un compte en recherchant par numéro de compte et mot de passe.
- **URL Parameters**:
    - `numeroCompte`: Le numéro du compte.
    - `mot_de_pass`: Le mot de passe du compte.
- **Response**: ResponseEntity contenant le compte trouvé ou null.

#### POST `/compte/fermeCompte/{numeroCompte}/{raison}`
- **Description**: Ferme un compte bancaire spécifié.
- **URL Parameters**:
    - `numeroCompte`: Le numéro du compte à fermer.
    - `raison`: La raison de la fermeture.
- **Response**: ResponseEntity contenant les détails du compte fermé.

#### POST `/compte/ajouterBeneficiaire/{numeroCompte}/{numeroCompteBeneficiaire}`
- **Description**: Ajoute un bénéficiaire à un compte spécifié.
- **URL Parameters**:
    - `numeroCompte`: Le numéro du compte propriétaire.
    - `numeroCompteBeneficiaire`: Le numéro du compte bénéficiaire.
- **Response**: ResponseEntity contenant les détails du bénéficiaire ajouté.

#### DELETE `/compte/supprimerBeneficiaire/{numeroCompte}/{numeroCompteBeneficiaire}`
- **Description**: Supprime un bénéficiaire d'un compte spécifié.
- **URL Parameters**:
    - `numeroCompte`: Le numéro du compte propriétaire.
    - `numeroCompteBeneficiaire`: Le numéro du compte bénéficiaire.
- **Response**: ResponseEntity indiquant le succès ou l'échec de la suppression.

### CartController
Gère les cartes bancaires.

#### POST `/compte/cart/creerCart`
- **Description**: Crée une nouvelle carte bancaire.
- **Request Body**: JSON représentant les détails de la carte.
- **Response**: ResponseEntity contenant la carte créée.

#### POST `/compte/cart/activerCart/{numeroCart}`
- **Description**: Active une carte bancaire spécifiée.
- **URL Parameter**:
    - `numeroCart`: Le numéro de la carte à activer.
- **Response**: ResponseEntity confirmant l'activation de la carte.

#### POST `/compte/cart/desactiverCart/{numeroCart}`
- **Description**: Désactive une carte bancaire spécifiée.
- **URL Parameter**:
    - `numeroCart`: Le numéro de la carte à désactiver.
- **Response**: ResponseEntity confirmant la désactivation de la carte.

#### POST `/compte/cart/bloqueCart/{numeroCart}/{raison}`
- **Description**: Bloque une carte bancaire spécifiée avec une raison donnée.
- **URL Parameters**:
    - `numeroCart`: Le numéro de la carte à bloquer.
    - `raison`: La raison du blocage.
- **Response**: ResponseEntity contenant les détails de la carte bloquée.

#### GET `/compte/cart/getPin/{numeroCart}`
- **Description**: Récupère le code PIN d'une carte bancaire spécifiée.
- **URL Parameter**:
    - `numeroCart`: Le numéro de la carte.
- **Response**: ResponseEntity contenant le code PIN.

#### GET `/compte/cart/connectCart/{numeroCart}/{codePin}`
- **Description**: Connecte une carte bancaire en vérifiant le numéro de carte et le code PIN.
- **URL Parameters**:
    - `numeroCart`: Le numéro de la carte.
    - `codePin`: Le code PIN de la carte.
- **Response**: ResponseEntity contenant la carte connectée ou null.

### TransactionController
Gère les transactions bancaires.

#### POST `/compte/cart/transaction`
- **Description**: Effectue une transaction entre deux comptes.
- **Request Body**: JSON représentant les détails de la transaction.
- **Response**: ResponseEntity contenant les détails de la transaction effectuée.

## Configuration

Pour configurer et exécuter l'application, suivez les étapes suivantes :

1. Clonez le dépôt de l'application.
2. Importez le projet dans votre IDE préféré.
3. Configurez votre base de données dans le fichier `application.properties`.
4. Exécutez l'application en utilisant la classe principale `com.diabets.eBank.Application`.


