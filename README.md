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
Ce fichier définit toute l’interface graphique de l’application.

- Structure générale:
   - Un ScrollView permet le défilement de l’interface
   - Un LinearLayout principal organise les éléments verticalement
   - Une carte principale (@drawable/bg_main_card) contient tout le formulaire
     
- En-tête (header):    <TextView android:text="Calcul des impôts locaux" ... />
   - Présent dans un conteneur stylisé (@drawable/bg_header_card)
   - Utilise un dégradé de couleurs
   - Donne une identité visuelle à l’application
     
- Champs de saisie:    <EditText android:id="@+id/etSurfaceMaison" ... />
   - Nom, Adresse, Surface, Nombre de pièces
   - Style personnalisé avec @drawable/bg_field
   - Coins arrondis + dégradé + bordure
  
- Zone de sélection:    <CheckBox android:id="@+id/cbPiscine" ... />
   - Permet d’indiquer la présence d’une piscine
     
- Bouton de calcul:    <Button android:id="@+id/btnCalculerTaxe" ... />
   - Déclenche le calcul
   - Style personnalisé avec @drawable/bg_button
   - Effet de profondeur (layer-list)
     
- Résultat:    <TextView android:id="@+id/tvAffichageResultat" ... />
   - Affiche le résultat du calcul
   - Encadré dans une carte stylisée (@drawable/bg_result)

 ### **res/drawable/** – Personnalisation visuelle
 Les fichiers drawable définissent l’apparence graphique de l’application.
 
- **bg_screen.xml**:
  
      -- Définit le fond global de l’application
      -- Utilise un gradient (bleu → rose)
      -- Donne un effet moderne et dynamique
  
- **bg_main_card.xml**:
  
      -- Conteneur principal
      -- Fond clair avec :
            - coins arrondis
            - bordure
            - effet d’ombre (layer-list)

- **bg_header_card.xml**:
  
      -- En-tête du formulaire
      -- Dégradé coloré
      -- Met en valeur le titre principal
  
- **bg_field.xml**:
  
      -- Style des champs de saisie
      -- Structure en layer-list :
           - Couche externe → ombre légère
           - Couche interne → dégradé + bordure
      => Donne un effet de profondeur (relief)
  
- **bg_button.xml**:
  
      -- Style du bouton "Calculer"
      -- Utilise :
           - un dégradé (bleu → rose)
           - un effet d’ombre
           - un état pressé (selector)
      => Bouton plus interactif et visuellement riche
  
- **bg_result.xml**:
  
      -- Carte affichant le résultat
      -- Dégradé léger + bordure
      -- Permet de distinguer clairement la zone de sortie

### **res/values/** – Ressources globales

- **colors.xml**:
  
   Centralise toutes les couleurs utilisées :
  
        -- Arrière-plan :
            - bg_start, bg_end
  
        -- Carte principale :
            - panel_bg, panel_stroke
  
        -- Champs :
            - field_top, field_bottom, field_stroke
  
        -- Boutons :
            - btn_start, btn_end, btn_shadow
  
        -- Résultat :
            - result_start, result_end, result_stroke
  
        -- Texte :
            - text_main, label_text, title_text
     => Permet cohérence + maintenance facile

- **themes.xml / themes-night.xml**:
  
        -- Définit le thème global de l’application
  
        -- Configure :
            - la couleur de l’ActionBar
            - les couleurs principales (primary, accent)

### **java/ma/ens/calculateurimpots/MainActivity.java** – Logique
Classe principale de l’application.

- **Initialisation**:    setContentView(R.layout.activity_main);
  
      -- Charge l’interface
      -- Récupère les composants avec findViewById()
  
- **Gestion des entrées utilisateur**:    Double.parseDouble(...)
                                          Integer.parseInt(...)
  
      -- Conversion des valeurs saisies
      -- Vérification des champs vides
      -- Gestion des erreurs avec try/catch

- **Calcul**:    double taxeBase = surface * 2;
double taxeSupplementaire = pieces * 50 + (piscine ? 100 : 0);
  
      -- Calcul séparé en méthodes pour plus de clarté

- **Affichage du résultat**:    zoneResultat.setText(message);
  
      -- Résultat formaté avec String.format
      -- Affichage dynamique dans le TextView

## Conclusion:
Ce projet permet d’aller au-delà d’une simple interface statique en introduisant :

   - la gestion de formulaire
   - le traitement de données
   - un design personnalisé et moderne

Il met en pratique la séparation entre :

   - interface (XML)
   - logique (Java)
   - style (drawable / values)

Ce laboratoire constitue une étape importante vers le développement d’applications Android plus complètes et professionnelles.




