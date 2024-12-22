
# **SuperHero App**
Une application Vue.js pour rechercher et afficher les détails des super-héros en utilisant l'API externe  [SuperHero API](https://superheroapi.com/). Cette application permet de :

-   Rechercher un super-héros par son nom ou son ID.
    
-   Afficher les détails du super-héros dans deux formats :
    
    -   **Format Brut :**  Données brutes provenant de l'API externe.
        
    -   **Format Transformé :**  Données mappées et transformées via un backend Spring Boot.
        
-   Afficher l'image du super-héros.
- ## **Fonctionnalités**

1.  **Recherche de super-héros :**
    
    -   Saisissez le nom ou l'ID d'un super-héros pour afficher ses détails.
        
2.  **Affichage des détails :**
    
    -   **Format Brut :**  Données JSON brutes provenant de l'API externe.
        
    -   **Format Transformé :**  Données mappées et transformées via un backend Spring Boot.
        
3.  **Affichage de l'image :**
    
    -   L'image du super-héros est affichée dans la section "Format Transformé".
## **Technologies utilisées**

-   **Frontend :**
    
    -   Vue.js 3
        
    -   Axios (pour les requêtes HTTP)
        
    -   Vue Router (optionnel, pour la navigation)
        
    -   CORS Anywhere (pour contourner les restrictions CORS)
        
-   **Backend :**
    
    -   Spring Boot (pour le mapping et la transformation des données)
        
    -   SuperHero API (API externe pour les données des super-héros)
 ## **Prérequis**

Avant de commencer, assurez-vous d'avoir les éléments suivants installés :

1.  **Node.js**  (version 14 ou supérieure) :  [Télécharger Node.js](https://nodejs.org/)
    
2.  **npm**  (généralement installé avec Node.js)
    
3.  **Un IDE**  (comme Visual Studio Code)
    
4.  **Un navigateur web**  (Chrome, Firefox, etc.)
## **Installation**

### **1. Cloner le projet**

Clonez ce dépôt GitHub sur votre machine locale :

    git clone https:https://github.com/ayoubbenkhiroun/superhero.git
    cd superhero-app
### **2. Installer les dépendances**

Installez les dépendances nécessaires pour le frontend :

    npm install
## **Configuration**

### **1. Configurer l'API SuperHero**

1.  Obtenez un  **token d'accès**  pour l'API SuperHero en vous inscrivant sur  [SuperHero API](https://superheroapi.com/).
    
2.  Ajoutez votre token dans le fichier  `App.vue`  :

    const url = isId
      ? `https://cors-anywhere.herokuapp.com/https://superheroapi.com/api/VOTRE_TOKEN/${searchTerm}`
      : `https://cors-anywhere.herokuapp.com/https://superheroapi.com/api/VOTRE_TOKEN/search/${searchTerm}`;
### **2. Configurer le backend Spring Boot**

1.  Assurez-vous que votre backend Spring Boot est en cours d'exécution sur  `http://localhost:8080`.
    
2.  Vérifiez que l'endpoint  `/api/superheroes/mapped/{name}`  est disponible.
## **Exécution**

### **1. Lancer l'application Vue.js**

Exécutez la commande suivante pour démarrer le serveur de développement :

    npm run serve
L'application sera disponible à l'adresse :  [http://localhost:8081](http://localhost:8081/).

### **2. Lancer le backend Spring Boot**

Assurez-vous que votre backend Spring Boot est en cours d'exécution sur  `http://localhost:8080`.
## **Utilisation**

1.  Ouvrez l'application dans votre navigateur à l'adresse  [http://localhost:8081](http://localhost:8081/).
    
2.  Saisissez le nom ou l'ID d'un super-héros dans le champ de recherche.
    
3.  Cliquez sur le bouton "Rechercher".
    
4.  Les détails du super-héros s'afficheront dans deux formats : brut et transformé.

## **Contribution**

Les contributions sont les bienvenues ! Voici comment vous pouvez contribuer :

1.  Fork le projet.
    
2.  Créez une branche pour votre fonctionnalité (`git checkout -b feature/AmazingFeature`).
    
3.  Commit vos changements (`git commit -m 'Ajouter une fonctionnalité incroyable'`).
    
4.  Push vers la branche (`git push origin feature/AmazingFeature`).
    
5.  Ouvrez une Pull Request.
## **Auteur**

-   **Ayoub BEN KHIROUN**  -  [Mon GitHub](https://github.com/ayoubbenkhiroun)
## **Remerciements**

-   [SuperHero API](https://superheroapi.com/)  pour les données des super-héros.
    
-   [Vue.js](https://vuejs.org/)  pour le framework frontend.
    
-   [Spring Boot](https://spring.io/projects/spring-boot)  pour le backend.
