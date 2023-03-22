import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the blue car (driving in the opposite direction as the player car).
 * It contains coordinates information.
 * Changes the y-position of the car at the world's speed from top to bottom.
 * Dissapears just above police car and after the player car.
 * 
 * @author Michal Buczek
 * 
 */
public class BlueCar extends Actor
{
    private int x;
    private int y;
    
    /**
     * Constructs blue car object with coordinates.
     * @param x coordinate
     * @param y coordinate
     */
    public BlueCar(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    /**
     * Controls the movement of the blue car.
     * Changes the y-position of the car at the world's speed from top to bottom.
     * Dissapears just above police car and after the player car.
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
    /**
     * Gets the x-position of the blue car
     * @return x-position of the blue car
     */
    public int getX()
    {
        return x;
    }
    /** 
     * Gets the y-position of the blue car
     * @return y-position of the blue car
     */
    public int getY() 
    {
        return y;    
    }
}
