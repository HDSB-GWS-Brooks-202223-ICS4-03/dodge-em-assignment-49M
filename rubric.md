# ICS4U Greenfoot Program - Rubric

## Name: Michal Buczek
[TOC]

## Mini Reflection

Mini-Game Genre:

I believe my program is a level 4+ because I completed all the level 3 and 4 requirements and added extra features to make the game feel clean. These extra features ultimately make the game more enjoyable and realistic.  
The extra features I included in my program are: 
- Moving background which speeds up progresively (Did this using two of the same backgrounds which are stacked and moving down at a certain speed and once the bottom one reaches the bottom of the screen it is moved back on top of the other one)
- Car obstacles speed, and player side to side movement speed changes proportionaly to the background speed. (Makes the game look realistic and progress in difficulty)
- Car position rotates when player turns (Realistic affect)
- When car crashes into another car or drives off the road, car spins and game stops (The spin direction is different depending on whether player hits a blue car, red car, or one of the offroad sides). Made it do a 360 after the collision using a boolean to make sure it spins even if the car is no longer touching the collision object when it spins.
- Made police car tracking player movements look slightly delayed. Rather than having the police mirror exactly the movement of the car at the same time, I seperated the police car x-movement to follow the x-position of the player car at a certain speed (Adds a delayed more real reaction time without the rigorous turning of the player)
- "New highscore" text on end screen when a new survival time record is reached


## The Program [KA]
### Level 3 Requirements

- [X] *“Start Screen” - which provides the users instructions and a button to start the game.*
- [X] *User Controlled Object - An object which the user controls manually.*
- [X] *End State - The game must end by some method (lives, timer, running out of gas, etc).*
- [X] *Obstacles (min x 2) - A minimum of two different types of obstacles for the user to avoid. (ex, the random driving car is one, make another)*
- [X] *Progression - The game must get harder as time progresses.*



### Level 4 Requirements

- [X] *All of the level 3 requirements*
- [X] *Score - A way to track user’s progress that is displayed at the end of the game*
- [X] *End Screen - A screen that displays the results of a user’s attempt*
- [X] *Replayability - Adding elements of randomness to the game to ensure that it is different to play each time you try.*

- [X] *- [ ] Extra features above and beyond a minimial implementation of the genre selected*
- [X] *Code follows OO principals and architecture*
- [X] *User-friendly *input-output forms* are implemented*
- [X] *User interface is a pleasure to use*

- [X] *Code is efficient*
  - [ ] No *unnecessary* repetition of code
  - [ ] *Effective* data structures selected (if applicable)
  - [ ] Produce a *modular program* that is divided among multiple classes. (as required)
  - [ ] No bugs in program
  - [ ] etc.


Overall Program Grade: 4+



## Project Management [TC]

### Project Planning
- [X] *UML Class Diagrams are fully complete and match the program submitted*
- [X] *Every attribute and method have appropriate access modifiers*
- [X] *Relationship between classes correctly defined.*

### Program Internal Documentation Requirements
- [X] *Full documentation of code (including javadoc style headers for **every method**)*
- [X] **Code adheres to ICS4UO style guide.**

### Regular Github Commits
- [X] *Regular and meaningful GitHub updates have been made showing daily progress*
- [X] *Reasonable explanations of what was accomplished in the git comments.*



Overall Project Management Grade: 4+
