# CalculateurImpots – LAB 2
Application Android permettant de calculer le montant des impôts locaux d’une habitation à partir de plusieurs critères:
   - la surface de la maison (en m²) ;
   - le nombre de pièces ;
   - la présence ou non d’une piscine.

## Objectif:
Le but de ce laboratoire est de :
- Manipuler des composants UI plus avancés (formulaire)
- Gérer la saisie utilisateur
- Implémenter une logique de calcul
  
- ## Description de l’application:
L’application contient :
- Des champs de saisie (EditText)
- Une case à cocher (CheckBox)
- Un bouton de calcul
- Une zone d’affichage du résultat
  
## Fonctionnalités:
- Saisie des informations de l’habitation :
    - Nom
    - Adresse
    - Surface
    - Nombre de pièces
- Sélection de la présence d’une piscine
- Calcul automatique des impôts après clic sur Calculer
- Affichage détaillé :
    - Montant de base
    - Supplément
    - Total à payer
- Gestion des erreurs (champs vides ou invalides)

## Formule utilisée:
- Impôt de base = surface × 2
- Supplément = (nombre de pièces × 50) + 100 (si piscine)
- Total = base + supplément

## Technologies utilisées:
- Android Studio
- Java
- XML (interface utilisateur)
- API minimum : 24 (Android 7.0)

## Aperçu de l’application:
<img width="1080" height="2400" alt="Interface" src="https://github.com/user-attachments/assets/72b60166-d5d8-4153-befc-fceb28620f43" />
<img width="1080" height="2400" alt="TEST" src="https://github.com/user-attachments/assets/b3d87174-56e2-44fb-8029-1e5098da8b5f" />

## Structure du projet:
### **res/layout/activity_main.xml** – Interface utilisateur


