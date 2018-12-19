**[BCIT - COMP 2526] [Kevin Vizconde] [Assignment 2 - Part B]**

------------
Description:
------------
This program is called "Game Of Life". It simulates a world populated with Plants, Herbivores,
Carnivores and Omnivores.

Plants are represented with the colour Green,
Herbivores are represented with the colour Yellow,
Carnivores are represented with the colour Red,
Omnivores are represented with the colour Blue,

Herbivores can only feed on Plants.
Additionally, they may give birth if there are at least 1 other Herbivore neighbors,
at least two free neighboring cells, and at least 2 neighboring cells with food (Plants).

Carnivores can feed on Herbivores and Omnivores.
Additionally, they may give birth if there are at least 1 other Carnivore neighbors,
at least 3 free neighboring cells, and 2 neighboring cells with food (Herbivores or Omnivores).

Omnivores can feed on Herbivores, Carnivores, and Plants.
Additionally, they may give birth if there are at least 1 other Omnivore neighbors,
at least 3 free neighboring cells, and 1 neighboring cells with food (Herbivores or Carnivores or Plants).

Plants can live forever unless they get eaten.
Herbivores, Carnivores, and Omnivores must eat within 5 moves or they will go hungry and die.


--------------
Files/Classes:
--------------
- Carnivore
- Cell
- GUI
- Herbivore
- LifeForm
- Main
- Movable
- Omnivore
- Plant
- RandomGenerator
- Seeds
- World


------------
Application:
------------
To run this simulation, you must run/execute the Main class.
The Green circles are the Plants, the Yellow Circles are the Herbivores, Carnivores are Red,
and Omnivores are Blue.

When the application launches, you must click on the game screen to initialize "a turn".
Every click is considered "a turn".

A Herbivore, Carnivore and Omnivore checks its neighbouring cells
and can give birth based on conditions specified in the description above.

They must feed, by checking into a cell that contains the type of food in their diet.
If any of these creatures fail to eat within 5 turns, then they die and are removed from the world.

Plants cannot move, however they can pollinate by seeding. Each plant can send a seed to a random
neighbouring empty cell only if there are at least 3 empty cells in that area and there are at least
2 other plants in the neighbouring cells.

