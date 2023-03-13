import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueCars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueCar extends Actor
{
    private int x;
    private int y;
    public BlueCar(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    /**
     * Act - do whatever the RedCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // changes the y-position of the car to oppose the movement of the player car
        PoliceChase world = (PoliceChase)getWorld();
        y += world.getSpeed();
        setLocation(x, y);
        setRotation(180);
        // Makes sure that it doesn't collide with police car by dissapearing
        if (y >= 370)
        {
            world.removeObject(this);
        }
    }
    // gets the x-position of the car
    public int getX()
    {
        return x;
    }
    // gets the y-position of the car
    public int getY()
    {
        return y;
    }
}
