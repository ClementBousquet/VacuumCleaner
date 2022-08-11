# 1 Objectifs

L'objectif est de développer un programme permettant à un aspirateur automatique de
parcourir toute la surface d'une pièce. La pièce sera représentée sous la forme d'une matrice
contenant des “M” et des “ “ (espaces) pour représenter les murs et l'absence de mur.
Le pourtour de la pièce est représenté par des M.

Le point de départ de l'aspirateur est aléatoire, il peut être déposé n'importe où dans une case vide de
la matrice.
Il doit parcourir l'ensemble des cases vides, une case vide peut être parcourue plusieurs fois.
Il ne peut pas se déplacer en diagonale.
À un instant donné, l'aspirateur peut savoir si les cases autour de lui sont des murs ou des cases déjà
parcourues. (sauf celles qui sont dans les diagonales)
L'aspirateur n'a pas conscience de sa position initiale dans la pièce, c'est à dire qu'il ne peut pas
s'appuyer sur des les coordonnées initiales pour déterminer comment faire son parcours.
L'aspirateur doit s'arrêter lorsqu'il passe sur la dernière case non parcourue.
Le nombre de déplacements pour parcourir l'ensemble des cases importe peu, mais moins l'aspirateur
a fait de déplacements mieux c'est. (un parcours aléatoire par exemple fonctionne, mais est peu
intéressant)


# 2 Contraintes techniques
Le programme doit être un projet Maven en JAVA.
Le projet doit être accompagné de tests unitaires.
 3 Format des entrées
Les entrées sont présentées sous la forme d'un contenu textuel.
Chaque caractère peut prendre la valeur “M” ou “ “.

# 3.1 Exemple
 
MMMMMMM
M M M
M M M
M M M
MMMMMMM

 4 Format des sorties
Les sorties sont présentées sous la forme d'un contenu textuel.
Le texte représente la suite des coordonnées du personnage à travers le labyrinthe.
Sa position initiale est aléatoire, par exemple [2, 2] (ligne 3, colonne 3)
Chaque position occupera une nouvelle ligne dans le format de sortie.

# 4.1 Exemple
Pour l'exemple d'entrée cité en point 3.1 un parcours possible serait :
0 1 2 3 4 5 6
0 M M M M M M M
1 M 3 M 9 10 11 M
2 M 2-4 1-7 8 M 12 M
3 M 5 6 M 14 13 M
4 M M M M M M M

Le point de départ est [2,2], et les numéros dans les cases correspondent à chaque itération.
la sortie texte sera la suivante
[2,2]
[2,1]
[1,1]
[2,1]
[3,1]
[3,2]
[2,2]
[2,3]
[1,3]
[1,4]
[1,5]
[2,5]
[3,5]
[3,4]
