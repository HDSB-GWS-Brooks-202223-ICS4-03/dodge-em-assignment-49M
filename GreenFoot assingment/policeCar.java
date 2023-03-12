import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Police car
 * 
 * Michal Buczek 
 * 2.0
 */
public class PoliceCar extends Actor
{
    private int x = 300;
    private int y = 450;
    private int rotation = 0;
    
    public PoliceCar()
    {
        // Image set up with scaling to match player car size
        GreenfootImage thePolice = getImage();
        int imgHeight = (int)thePolice.getHeight()/3;
        int imgWidth = (int)thePolice.getWidth()/3;
        thePolice.scale(imgWidth, imgHeight);
        
    }
    /**
     * Act - do whatever the policeCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        PoliceChase world = (PoliceChase)getWorld();
        // car movement side to side controlled with arrow keys
        PlayerCar playerCar = world.getPlayerCar();
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
        if (world.gameOver())
        {
            if (y > 375)
            {
                y -= 2;   
            }
        }
    }
    public int getX()
    {
        return x;
    }
    public int getY() 
    {
        return y;    
    }
}
