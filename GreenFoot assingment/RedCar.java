import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the red car (driving in the same direction as the player car).
 * It contains coordinates information.
 * Changes the y-position of the car at half of the world's speed from top to bottom.
 * Dissapears just above police car and after the player car.
 * 
 * @author Michal Buczek
 * 
 */
public class RedCar extends Actor
{
    private int x;
    private int y;
    
    /**
     * Constructs red car object with coordinates.
     * @param x coordinate
     * @param y coordinate
     */
    public RedCar(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    /**
     * Controls the movement of the red car.
     * Changes the y-position of the car at the half of the world's speed from top to bottom.
     * Dissapears just above police car and after the player car.
     */
    public void act()
    {
        // Makes car move down but facing same direction as player car to make them seem slower
        PoliceChase world = (PoliceChase)getWorld();
        y += world.getSpeed() / 2;
        setLocation(x, y);
        // makes sure they don't collide with police car by dissapearing
        if (y >= 370)
        {
            world.removeObject(this);
        }
    }
    /**
     * Gets the x-position of the red car
     * @return x-position of the red car
     */
    public int getX()
    {
        return x;
    }
    /** 
     * Gets the y-position of the red car
     * @return y-position of the red car
     */
    public int getY() 
    {
        return y;    
    }
}
