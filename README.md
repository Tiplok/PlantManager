# PlantManager
Application Android - PlantManager - D�velopp�e dans le cadre du cours 'TAC - Android' du Master Informatique E-services � l'Universit� Lille 1


## Configuration
Le projet a �t� d�velopp� sous Android Studio 2.2.2 avec l'API minimum 14 (Android 4.0 Ice Cream Sandwich).  
- Le projet AndroidStudio est le dossier PlantManager.  
- Le fichier APK sign� de l'application se trouve dans le dossier apk.


### Mode d'emploi de l'application

#### Description par �cran

<p align="center">Ecran principal</p>
<p align="center"><img src="http://image.prntscr.com/image/cfba2cd75b70404696825f5e07d29f89.png" alt="Image de l'ecran principal introuvable"></p>

En haut � droite, on retrouve deux menus :  
- Celui ayant la forme de + permet d'aller sur l'�cran d'ajout d'une nouvelle plante.  
- Celui fait de trois petits points permet d'obtenir une liste de deux autres menus : un pour les fixtures et un pour quitter l'application.  
Au centre, on retrouve la liste des plantes :  
- Pour chaque plante, on retrouve son nom, entre parenth�se le nombre de jour(s) avant d'avoir besoin d'�tre arros� (si ce nombre est n�gatif, il s'agit du nombre de jours de retard de l'arrosage)  
- La couleur de fond est li�e � quand la plante doit �tre arros�e : rouge si en retard, orange si c'est la veille ou le jour m�me, vert sinon  

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<p align="center">Ecran d'ajout d'une plante</p>
<p align="center"><img src="http://image.prntscr.com/image/d3a142a179b644e0a59a70ab4c7544be.png" alt="Image de l'ecran d'ajout d'une plante introuvable"></p>

On a deux champs permettant d'indiquer le nom de la plante puis le nombre de jours entre chaque arrosage, on peut ensuite valider sa cr�ation ou l'annuler pour revenir sur l'�cran principal.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<p align="center">Ecran de modification d'une plante</p>
<p align="center"><img src="http://image.prntscr.com/image/568b9a53d1664b1daa05759fdacb1743.png" alt="Image de l'ecran de modification d'une plane introuvable"></p>

On a deux champs permettant de modifier le nom de la plante et le nombre de jours entre chaque arrosage, on peut ensuite valider sa modification ou l'annuler, il est aussi possible de la supprimer, il faudra alors confirmer ce choix.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<p align="center">Ecran des fixtures</p>
<p align="center"><img src="http://image.prntscr.com/image/b3c4c52be782411f8a6a400f682dbff3.png" alt="Image de l'ecran des fixtures introuvable"></p>

Dans le but de tester l'application, on a :  
- Un bouton qui permet d'alimenter la base de donn�es de 12 plantes diff�rentes  
- Un bouton pour faire avancer le nombre de jours d'un nombre d�fini, ce qui se r�percute sur le nombre de jours avant le prochain arrosage des plantes existantes  
- Un bouton pour supprimer toutes les plantes de la base de donn�es  

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### Utilisation des fonctionnalit�es

Chaque fonctionnalit� est d�crite � partir de l'�cran principal.

- _Cr�er une nouvelle plante :_  
Appuyez le bouton + en haut � droite, remplissez le nom de la plante et le nombre de jours entre chaque arrosage puis appuyez sur le bouton VALIDER.

- _Modifier une plante :_  
Appuyez simplement sur une des plantes de la liste, modifiez le ou les champ(s) voulu(s) et validez les modifications en appuyant sur le bouton MODIFIER.

- _Supprimer une plante :_   
Appuyez simplement sur une des plantes de la liste puis sur le bouton SUPPRIMER, appuyez sur OK si vous �tes s�r de votre choix.

- _Arroser une plante :_  
Appuyez longuement sur une des plantes de la liste, le fond de la plante devient vert et un message appara�t pour vous confirmer l'arrosage de la plante.

- _Utilisation des fixtures :_  
Appuyez sur le bouton en forme de trois points verticaux en haut � droite, vous pouvez ensuite ajouter de nouvelles plantes dans la base de donn�es, avancer les jours pour simuler l'avancement du temps et supprimer les plantes de la base de donn�es.


### Rapport technique

Tout a �t� fait. 
Les diff�rentes fonctionnalit�s sp�cifi�es sont pr�sentes et fonctionnent.  
Un menu est d�di� aux fixtures afin de faciliter les tests de l'application.   
L'avancement du temps est fait avec un nombre de jours fix� plut�t qu'avez la manipulation d'une date.  
Il n'y a aucun bug connu pour le moment.


_2016 - Nicolas Vasseur_