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
    /**
     * Act - do whatever the RedCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        PoliceChase world = (PoliceChase)getWorld();
        y += world.getSpeed() / 2;
        setLocation(x, y);
        if (y >= 370)
        {
            world.removeObject(this);
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
