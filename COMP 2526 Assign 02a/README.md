[BCIT - COMP 2526] [Kevin Vizconde] [Assignment 2 - Part A]

------------
Description:
------------
This program is called "Game Of Life". It simulates a world populated with Plants and Herbivores.
Plants are represented with the colour Green
and Herbivores are represented with the colour Yellow
Herbivores must feed on plants throughout the game or they will go hungry and die.


--------------
Files/Classes:
--------------
>RandomGenerator
>Cell
>GUI
>Herbivore
>LifeForm
>Main
>Movable
>Plant
>Seeds
>World


------------
Application:
------------
To run this simulation, you must run/execute the Main class.
The Green circles are the Plants, and the Yellow Circles are the Herbivores.
When the application launches, you must click on the game screen to initialize "a turn".
Every click is considered "a turn".

A Herbivore checks its neighbouring cells and can move to one cell nearby
only if the neighbouring cell does not contain other Herbivores.

A Herbivore must eat plants, by checking into a cell that contains a Plant.
If a Herbivore fails to eat a Plant before 5 turns, then they die and are removed from the world.

Plants cannot move, however they can pollinate by seeding. Each plant can send a seed to a random
neighbouring empty cell only if there are at least 3 empty cells in that area and there are exactly
4 other plants in the neighbouring cells.
=======
