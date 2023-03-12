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
        PoliceChase world = (PoliceChase)getWorld();
        y += world.getSpeed();
        setLocation(x, y);
        setRotation(180);
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
