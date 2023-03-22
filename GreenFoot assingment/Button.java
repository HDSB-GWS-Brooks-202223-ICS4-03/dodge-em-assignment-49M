import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the button.
 * It contains button state and text.
 * When the button is not clicked it is green 
 * When the button is clicked it turns pink and makes buttonState true.
 * 
 * Code referenced from {@link https://www.youtube.com/watch?v=J_1cY_TNv5o}
 * 
 */
public class Button extends Actor
{
    boolean buttonState = false;
    String buttonText = "PLAY";
    /**
     * Constructs button with button off state and default button text.
     */
    public Button() {
        buttonOff();
    }
    /**
     * Constructs button with a given state and text.
     * @param stateIn boolean representing on or off state
     * @param textIn the text of the button
     */
    public Button(boolean stateIn, String textIn) {
        buttonText = textIn;
        if (stateIn) buttonOn();
        else buttonOff();
    }
    /**
     * Sets the button in off state and sets the button background to green.
     */
    public void buttonOff() {
        GreenfootImage buttonImage = new GreenfootImage(buttonText, 35, Color.BLACK, Color.GREEN);
        setImage(buttonImage);
        buttonState = false;
    }
    /**
     * Sets the button in on state and sets the button background to pink.
     */
    public void buttonOn() {
        GreenfootImage buttonImage = new GreenfootImage(buttonText, 35, Color.BLACK, Color.PINK);
        setImage(buttonImage);
        buttonState = true;
    }
    // toggles the button for actions
    /**
     * Switches button state from off to on or on to off
     */
    public void buttonToggle() {
        if (buttonState) {
            buttonOff();        
        } else {
            buttonOn();
        }
    }
}