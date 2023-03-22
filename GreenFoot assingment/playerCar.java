import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the player car.
 * It contains coordinates, rotation and turn information.
 * It controls the car movement and detects collisions.
 * 
 * @author Michal Buczek
 * 
 */
public class PlayerCar extends Actor {
    private int x = 300;
    private int y = 300;
    private int rotation = 0;
    private boolean crashStop = false;
    private int crashTurn = 360;
    private int crashRotation = -8;
    
    /**
     * Controls the car movement and detects collision.
     * Sets coordinates and rotation of car based on pressed arrow keys and game speed.
     * Makes the car do a 360 after collision and change crashStop to true.
     */
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
        //Makes the car do a 360 after collision
        if (crashStop)
        {
            if (crashTurn != 0)
            {
                crashTurn += crashRotation;            
                turn(crashTurn);
                
            }
        }
    }
    /**
     * Gets the x-position of the car
     * @return x-position of the car
     */
    public int getX() {
        return x;
    }
    /** 
     * Gets the y-position of the car
     * @return y-position of the car
     */
    public int getY() {
        return y;
    }
    /**
     * Returns whether the car has crashed or not
     * @return true if car has collision and false if not
     */ 
    public boolean isCrashStop() {
        return crashStop;
    }
}
