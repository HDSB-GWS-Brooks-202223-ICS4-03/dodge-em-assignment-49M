import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    boolean buttonState = false;
    String buttonText = "PLAY";
    
    public Button() {
        buttonOff();
    }
    public Button(boolean stateIn, String textIn) {
        buttonText = textIn;
        if (stateIn) buttonOn();
        else buttonOff();
    }
    // button not clicked it is green
    public void buttonOff() {
        GreenfootImage buttonImage = new GreenfootImage(buttonText, 35, Color.BLACK, Color.GREEN);
        setImage(buttonImage);
        buttonState = false;
    }
    // when button is clicked it turns pink and makes buttonState true
    public void buttonOn() {
        GreenfootImage buttonImage = new GreenfootImage(buttonText, 35, Color.BLACK, Color.PINK);
        setImage(buttonImage);
        buttonState = true;
    }
    // toggles the button for actions
    public void buttonToggle() {
        if (buttonState) {
            buttonOff();        
        } else {
            buttonOn();
        }
    }
}