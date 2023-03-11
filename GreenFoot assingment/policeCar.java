import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Police car
 * 
 * Michal Buczek 
 * 2.0
 */
public class policeCar extends Actor
{
    private int policeX = 300;
    private int turnAngle = 0;
    public policeCar()
    {
        // Image set up with scaling to match player car size
        GreenfootImage ThePolice = getImage();
        int imgHeight = (int)ThePolice.getHeight()/3;
        int imgWidth = (int)ThePolice.getWidth()/3;
        ThePolice.scale(imgWidth, imgHeight);
        
    }
    /**
     * Act - do whatever the policeCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
                PoliceChase world = (PoliceChase)getWorld();
        // car movement side to side controlled with arrow keys
        if (Greenfoot.isKeyDown("Right"))
        {
            setRotation(turnAngle + 7);
            policeX += (world.getSpeed() / 2);
        } else if (Greenfoot.isKeyDown("Left"))
        {
            setRotation(turnAngle - 7);
            policeX -= (world.getSpeed() / 2);
        } else 
        {
            setRotation(turnAngle);
        }
        setLocation(policeX, 450);
    }
    public int xPosition()
    {
        return policeX;
    }
}
