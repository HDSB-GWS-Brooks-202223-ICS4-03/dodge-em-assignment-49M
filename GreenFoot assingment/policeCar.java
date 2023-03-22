import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the police car.
 * It contains coordinates and rotation information.
 * It follows the movement of the player car and controls rotation.
 * 
 * @author Michal Buczek 
 * 
 */
public class PoliceCar extends Actor
{
    private int x = 300;
    private int y = 450;
    private int rotation = 0;
    
    /**
     * Constructs police car object.
     * Sets the image of the car and scales it to the relative size of the other cars.
     */
    public PoliceCar()
    {
        // Image set up with scaling to match player car size
        GreenfootImage thePolice = getImage();
        int imgHeight = (int)thePolice.getHeight()/3;
        int imgWidth = (int)thePolice.getWidth()/3;
        thePolice.scale(imgWidth, imgHeight);
        
    }
    /**
     * Controls the movement of the police car.
     * It follows the x-position of the player car and rotates towards it.
     * Once car crashes, police car moves up to the height of the car (caught)
     */
    public void act()
    {
        PoliceChase world = (PoliceChase)getWorld();
        // car movement side to side controlled with arrow keys
        PlayerCar playerCar = world.getPlayerCar();
        // Police Car follows the x-movement of the player car
        int playerCarX = playerCar.getX();
        if (x > playerCarX)
        {
            x -= 1;
            rotation = -8;
        } else if (x < playerCarX)
        {
            x += 1;
            rotation = 8;
        } else
        {
            rotation = 0;
        }
        setLocation(x, y);
        setRotation(rotation);
        // Once car crashes, police car moves up to the height of the car (caught)
        if (world.gameOver())
        {
            if (y > 375)
            {
                y -= 2;   
            }
        }
    }
    /**
     * Gets the x-position of the police car
     * @return x-position of the police car
     */
    public int getX()
    {
        return x;
    }
    /** 
     * Gets the y-position of the police car
     * @return y-position of the police car
     */
    public int getY() 
    {
        return y;    
    }
}
