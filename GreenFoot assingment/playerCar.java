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
    private boolean crashStop = false;
    private int crashTurn = 360;
    private int crashRotation = -8;
    
    public void act() {
        PoliceChase world = (PoliceChase)getWorld();
        // car movement side to side controlled with arrow keys
        if (!crashStop)
        {
            if (Greenfoot.isKeyDown("Right")) {
                rotation = 15;
                x += (world.getSpeed() / 2);
            } else if (Greenfoot.isKeyDown("Left")) {
                rotation = -15;
                x -= (world.getSpeed() / 2);
            } else {
                rotation = 0;
            }
            //Collision detection between objects

            if (getOneIntersectingObject(RedCar.class) != null || x >= world.getOutRight()) {
                crashStop = true;
            } else if (getOneIntersectingObject(BlueCar.class) != null  || x <= world.getOutLeft()) {
                crashStop = true;
                crashRotation = 8;
                crashTurn = -360;
            }
        }
        setLocation(x, y);
        setRotation(rotation);
        if (crashStop)
        {
            if (crashTurn != 0)
            {
                crashTurn += crashRotation;            
                turn(crashTurn);
                
            }
        }
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean isCrashStop() {
        return crashStop;
    }
}
