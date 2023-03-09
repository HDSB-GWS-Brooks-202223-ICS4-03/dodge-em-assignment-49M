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
    public void playerMovement(int xPlayer)
    {
         //GreenfootImage playerCar = new GreenfootImage("playerCar.png");
         //getWorld().getBackground().drawImage(playerCar, xPlayer, yPlayer);
         //setImage(GreenfootImage image);
    }
    public void act()
    {
        // car movement side to side controlled with arrow keys
        if (Greenfoot.isKeyDown("Right"))
        {
            //move(5);
            setRotation(rotation + 15);
            x += 5;
        } else if (Greenfoot.isKeyDown("Left"))
        {
            //move(-5);
            setRotation(rotation - 15);
            x -= 5;
        } else 
        {
            setRotation(rotation);
        }
        setLocation(x, 250);
    }
    public int xMove() {
        return x;
    }
}
