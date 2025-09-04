# GenPoZik

GenPoZik est un générateur de pochettes de playlist pour des services de streaming musical.
Il permet de créer rapidement et facilement de nombreuses images suivant un même paterne.

---

# Comment exécuter dans un terminal

## A - Sur Linux
1. se déplacer dans le projet : ``cd GenPoZik``
2. donner les permissions d'exécution : ``chmod u+x genpozik.sh`` (à faire une fois)
3. exécuter : ``./genposik.sh``

## B - Sur tous les OS
1. se déplacer dans le projet : ``cd GenPoZik``
2. compiler : ``javac '@option.list' '@compile.list'``
3. se déplacer dans le dossier d'exécution : ``cd class``
4. exécuter : ``java genpozik.Controleur``

---

# Comment utiliser

fenetre en 2 parties :
- saisie utilisateur
- image d'apperçu

## 1. Saisie utilisateur

3 onglets indépendants
- "1 - BG" : édition du fond
- "2 - FG" : édition du premier plan
- "3 - TXT" : édition du texte

### a. "1 - BG"

- selection RGB de 2 couleurs pour former un dégradé
ou
- selection d'une image (400x400) existante

### b. "2 - FG"

- selection RGBA de la couleur de premier plan
- possibilité de selectionner un modèle (400x400) en png

![modele](data/modele.png "un exemple de modèle")

*remarque : une image modèle doit être bicouleur : transparent et noir*

### c. "3 - TXT"

3 textes "Auteur", "Titre", "Date" avec :
- saisie du texte
- taille de la police
- couleur
- position sur 0 - 400px

## 2. Image d'apperçu

-> apperçu de l'image à générer

![appercu](data/generation/test.png "apperçu")

possibilité de sauvegarder l'image avec le bouton "Générer"
1. choisir un nom de fichier : "image.png"
2. choisir un répertoire de sauvegarde

**attention : pas de vérification de nom de fichier !**

---

# Langage
- java
- version utilisée : "19" 2022-09-20

---

# Auteur
- Développeur : @Maximeuuu
- Licence : [MIT License](LICENSE)
