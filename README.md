# PlantManager
Application Android - PlantManager - Développée dans le cadre du cours 'TAC - Android' du Master Informatique E-services à l'Université Lille 1


## Configuration
Le projet a été développé sous Android Studio 2.2.2 avec l'API minimum 14 (Android 4.0 Ice Cream Sandwich).  
- Le projet AndroidStudio est le dossier PlantManager.  
- Le fichier APK signé de l'application se trouve dans le dossier apk.


### Mode d'emploi de l'application

Description par écran :

- Ecran principal
![alt tag](http://image.prntscr.com/image/cfba2cd75b70404696825f5e07d29f89.png)

En haut à droite, on retrouve deux menus :  
- Celui ayant la forme de + permet d'aller sur l'écran d'ajout d'une nouvelle plante.  
- Celui fait de trois petits points permet d'obtenir une liste de deux autres menus : un pour les fixtures et un pour quitter l'application.  
Au centre, on retrouve la liste des plantes :  
- Pour chaque plante, on retrouve son nom, entre parenthèse le nombre de jour(s) avant d'avoir besoin d'être arrosé (si ce nombre est négatif, il s'agit du nombre de jours de retard de l'arrosage)  
- La couleur de fond est liée à quand la plante doit être arrosée : rouge si en retard, orange si c'est la veille ou le jour même, vert sinon  


- Ecran d'ajout :
![alt tag](http://image.prntscr.com/image/d3a142a179b644e0a59a70ab4c7544be.png)

On a deux champs permettant d'indiquer le nom de la plante puis le nombre de jours entre chaque arrosage, on peut ensuite valider sa création ou l'annuler pour revenir sur l'écran principal.


- Ecran de modification :
![alt tag](http://image.prntscr.com/image/568b9a53d1664b1daa05759fdacb1743.png)

On a deux champs permettant de modifier le nom de la plante et le nombre de jours entre chaque arrosage, on peut ensuite valider sa modification ou l'annuler, il est aussi possible de la supprimer, il faudra alors confirmer ce choix.


- Ecran des fixtures :
![alt tag](http://image.prntscr.com/image/b3c4c52be782411f8a6a400f682dbff3.png)

Dans le but de tester l'application, on a :  
- Un bouton qui permet d'alimenter la base de données de 12 plantes différentes  
- Un bouton pour faire avancer le nombre de jours d'un nombre défini, ce qui se répercute sur le nombre de jours avant le prochain arrosage des plantes existantes  
- Un bouton pour supprimer toutes les plantes de la base de données  


Utilisation des fonctionnalitées :

Chaque fonctionnalité est décrite à partir de l'écran principal.

- Créer une nouvelle plante : 
Appuyez le bouton + en haut à droite, remplissez le nom de la plante et le nombre de jours entre chaque arrosage puis appuyez sur le bouton VALIDER.

- Modifier une plante : 
Appuyez simplement sur une des plantes de la liste, modifiez le ou les champ(s) voulu(s) et validez les modifications en appuyant sur le bouton MODIFIER.

- Supprimer une plante : 
Appuyez simplement sur une des plantes de la liste puis sur le bouton SUPPRIMER, appuyez sur OK si vous êtes sûr de votre choix.

- Arroser une plante : 
Appuyez longuement sur une des plantes de la liste, le fond de la plante devient vert et un message apparaît pour vous confirmer l'arrosage de la plante.

- Utilisation des fixtures :
Appuyez sur le bouton en forme de trois points verticaux en haut à droite, vous pouvez ensuite ajouter de nouvelles plantes dans la base de données, avancer les jours pour simuler l'avancement du temps et supprimer les plantes de la base de données.


### Rapport technique

Tout a été fait. 
Les différentes fonctionnalités spécifiées sont présentes et fonctionnent. 
On a un menu dédié aux fixtures afin de faciliter les tests de l'application. 
L'avancement du temps est fait avec un nombre de jours fixé plutôt qu'avez la manipulation d'une date.
Il n'y a aucun bug connu pour le moment.


_2016 - Nicolas Vasseur_