import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class policeCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class policeCar extends Actor
{
    public policeCar()
    {
        GreenfootImage ThePolice = getImage();
        int imgHeight = (int)ThePolice.getHeight()/3;
        int imgWidth = (int)ThePolice.getWidth()/3;
        ThePolice.scale(imgWidth, imgHeight);
        
    }
    /**
     * Act - do whatever the policeCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //greenfoot.GreenfootImage.scale(50, 100);
    }
}
