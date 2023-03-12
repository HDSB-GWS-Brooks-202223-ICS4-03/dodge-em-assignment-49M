import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

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
   
    private GreenfootImage bg;
    private int bgHeight = 0;
    private GreenfootImage bg2;
    private int bg2Height = -500;
    private PlayerCar playerCar;
    private PoliceCar policeCar;
    // Moving background speed up
    float speedOverTime = 1;
    int timeCount = 0;
    float speedMultiplier = 10;
    private Random random = new Random();
    //time interval variable that spawns in a new instance
    private int spawnRedCarTime = 200;
    private int spawnBlueCarTime = 150;
    boolean gameOver = false;
    // out of bounds (off road)
    private int outLeft = 120;
    private int outRight = 480;
    
    /**
     * Constructor for objects of class PoliceChase.
     * 
     */
    public PoliceChase()
    {    
        // Create a new world with 600x500 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        // Background for world
        bg = new GreenfootImage("roadBackground.tiff");
        bg.scale(getWidth() + 400, getHeight());
        bg2 = new GreenfootImage("roadBackground.tiff");
        bg2.scale(getWidth() + 400, getHeight());
        // draws the background
        getBackground().drawImage(bg, -200, 0);
        // Adds player car to the screen  
        playerCar = new PlayerCar();
        addObject(playerCar, playerCar.getX(), 300);
        // Adds police car to the screen
        policeCar = new PoliceCar();
        addObject(policeCar, policeCar.getX(), policeCar.getY());
    }
    public void act()
    {
        //Makes the background move by using 2 of the same background
        if (bgHeight >= 500){
            bgHeight = -500;
        } else if (bg2Height >= 500) {
            bg2Height = -500;
        }
        getBackground().drawImage(bg, -200, bgHeight);
        getBackground().drawImage(bg2, -200, bg2Height); 
        bgHeight += speedOverTime;
        bg2Height += speedOverTime;
        timeCount += 1;
        // If there is a collision background stops moving
        if (playerCar.isCrashStop())
        {
            speedOverTime = 0;
            gameOver = true;
        }
        //Increases background movement speed (makes the car look like its accelerating
        else
        {
            if (timeCount >= speedMultiplier){
                speedOverTime += 1;
                speedMultiplier *= 2.5;
            }
            // Adds new obstacle instances at a random time interval(within range) and random location on the road with respect to the cars direciton
            if (timeCount == spawnRedCarTime)
            {
                RedCar redCar = new RedCar(300 + random.nextInt(150), 0);
                addObject(redCar, redCar.getX(), redCar.getY());
                spawnRedCarTime += 75 + random.nextInt(200); 
            }
            if (timeCount == spawnBlueCarTime)
            {
                BlueCar blueCar = new BlueCar(150 + random.nextInt(145), 0);
                addObject(blueCar, blueCar.getX(), blueCar.getY());
                spawnBlueCarTime += 100 + random.nextInt(200); 
            }
            //timer
            showText(timeCount/60+"s", 50, 20);
        }
    }
    public float getSpeed() 
    {
        return speedOverTime;
    }
    public PlayerCar getPlayerCar() {
        return playerCar;
    }
    public boolean gameOver()
    {
        return gameOver;
    }
    public int getOutLeft()
    {
        return outLeft;
    }
    public int getOutRight() 
    {
        return outRight;
    }
}
