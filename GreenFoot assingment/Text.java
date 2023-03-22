import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the text that can be added to the World.
 *  
 * @author Michal Buczek
 */
public class Text extends Actor
{
    /**
     * Constructs text object with text size, color and background color
     * @param text any string
     * @param size text size
     * @param textColor color of the text
     * @param background highlight color
     */
    public Text(String text, int size, Color textColor, Color background) {
        GreenfootImage buttonImage = new GreenfootImage(text, size, textColor, background);
        setImage(buttonImage);         
    }
}
