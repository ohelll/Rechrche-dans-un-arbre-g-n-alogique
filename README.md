# Rechrche-dans-un-arbre-genealogique
<!-- C'est projet fait durant ma licence d'informatique -->


Dans projet, on s’intéresse à la manipulation d’un arbre généalogique. Le but est de 
construire un programme qui permet d’effectuer des recherches sur un arbre 
généalogique. Le but est de trouver les relations entre les différentes personnes 
présente dans l’arbre. Pour cela va partir d'un model : 

Ce model représente toutes les classes qui vont être utiles à la création d’un arbre 
généalogique. Dans ce package (model), on a 5 classes:
-Personne, sert aux affectations des attributs qui définissent une personne (prénom. 
Age, etc.). 
-Homme et Femme, héritent de Personne. Elles servent a différencié le sexe des 
personnes, cela est utile pour différencier père et la mère. Elles ont des attributs pour 
les enfants et pour les conjoints.
-Mariage sert principalement pour l’affection des conjoints vu dans les classes 
précédentes. 
-Arbre contient toutes les méthodes pour les recherches de relation.

Avec ces classes on peut donc faire le package vue qui comporte deux class:
-Main qui permet de structurer les personnes et les relations dans l’arbre (ex : définir 
de p1 est le père de p2.). 
-Fenetre qui contient les éléments qui servent à la mise en page de la fenêtre qui 
servira de menu (zone de texte pour entrer des prénoms et des boutons pour 
effectuer les recherches de relation). 


Les méthodes dans la classe Arbre et les boutons dans la classe Fenetre nous 
permettent de créer le package controler et de configurer les actions que vont 
effectuer les boutons du package vue.

Lorsque l’on rentrer un seul prénom (une seul instante du type Personne homme ou 
femme) on a plusieurs boutons pour choisir les types personnes et de relations que 
l’on veut trouver à la personne rentrer. On peut cliquer sur le bouton Parents pour 
trouver ses parents, le bouton enfant pour trouver ses enfants, etc. Ces boutons 
fonctionnent grâce au méthode correspondante dans la classe Arbre.

Cependant si on entre deux prénoms dans les zones fait pour cela, on peut trouver la 
relation qui lie ces deux personnes. Cela est gérer part un bouton, l’action qui est 
effectuer est celle de trouver la relation entre deux personnes en essayer toutes les 
relations que peuvent avoir deux personnes issues de la même famille. Ces 
recherches s’effectuent avec des méthodes booléennes et dès qu’une d’entre elles 
renvoie true on affiche la relation trouver.
