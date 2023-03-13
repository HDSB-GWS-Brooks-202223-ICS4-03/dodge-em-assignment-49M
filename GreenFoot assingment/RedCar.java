import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Same direction moving cars
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedCar extends Actor
{
    private int x;
    private int y;
    public RedCar(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
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
    //gets x-position of car
    public int getX()
    {
        return x;
    }
    //gets y-position of car
    public int getY()
    {
        return y;
    }
}
