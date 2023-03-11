import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * player controlled car
 * 
 * Michal Buczek
 * 1.0
 */
public class playerCar extends Actor
{
    //private int rotation = 0;
    private int x = 300;
    private int rotation = 0;
    public void act()
    {
        PoliceChase world = (PoliceChase)getWorld();
        // car movement side to side controlled with arrow keys
        if (Greenfoot.isKeyDown("Right"))
        {
            setRotation(rotation + 15);
            x += (world.getSpeed() / 2);
        } else if (Greenfoot.isKeyDown("Left"))
        {
            setRotation(rotation - 15);
            x -= (world.getSpeed() / 2);
        } else 
        {
            setRotation(rotation);
        }
        setLocation(x, 300);
    }
    public int xMove() {
        return x;
    }
}
