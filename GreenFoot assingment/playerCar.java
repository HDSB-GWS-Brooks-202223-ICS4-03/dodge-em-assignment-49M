import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * player controlled car
 * 
 * Michal Buczek
 * 1.0
 */
public class PlayerCar extends Actor {
    private int x = 300;
    private int y = 300;
    private int rotation = 0;
    
    public void act() {
        PoliceChase world = (PoliceChase)getWorld();
        // car movement side to side controlled with arrow keys
        if (Greenfoot.isKeyDown("Right")) {
            rotation = 15;
            x += (world.getSpeed() / 2);
        } else if (Greenfoot.isKeyDown("Left")) {
            rotation = -15;
            x -= (world.getSpeed() / 2);
        } else {
            rotation = 0;
        }
        setLocation(x, y);
        setRotation(rotation);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
