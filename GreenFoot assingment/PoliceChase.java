import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PoliceChase here.
 * 
 * Michal Buczek 
 *  V 0.3 Monday, March 8, 2023 
 */
public class PoliceChase extends World
{
    //Variables:
    String gameState;
    private int xPlayer = 300;
    private int yPlayer = 450;
    /**
     * Constructor for objects of class PoliceChase.
     * 
     */
    public PoliceChase()
    {    
        // Create a new world with 600x500 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        // Background for world
        GreenfootImage bg = new GreenfootImage("roadBackground.tiff");
        bg.scale(getWidth() + 400, getHeight());
        //setBackground(bg);
        getBackground().drawImage(bg, -200, 0);
        // Adds player car to the screen  
        playerCar p1 = new playerCar();
        addObject(p1, 300, 250);
        // Adds police car to the screen
        policeCar police = new policeCar();
        addObject(police, xPlayer, yPlayer);

        
    }
    public void act()
    {

    }
}
