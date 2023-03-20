import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    public Text(String text, int size, Color textColor, Color background) {
        GreenfootImage buttonImage = new GreenfootImage(text, size, textColor, background);
        setImage(buttonImage);         
    }
}
