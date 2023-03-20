import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;

/**
 * 
 * PoliceChase world initialization, where all game actions take place
 * 
 * @author Michal Buczek
 * 
 */
public class PoliceChase extends World
{
    //Variables:
    // Start Screen Background
    private GreenfootImage startBG = new GreenfootImage("startBG.tiff");
    // Background for world
    private GreenfootImage bg = new GreenfootImage("roadBackground.tiff");
    private int bgHeight = 0;
    private GreenfootImage bg2 = new GreenfootImage("roadBackground.tiff");
    private int bg2Height = -500;
    private PlayerCar playerCar;
    private PoliceCar policeCar;
    // Moving background speed up
    private float speedOverTime = 1;
    private int timeCount = 0;
    private float speedMultiplier = 10;
    private Random random = new Random();
    //time interval variable that spawns in a new instance
    private int spawnRedCarTime = 60;
    private int spawnBlueCarTime = 60;
    private boolean gameOver = false;
    // out of bounds (off road)
    private int outLeft = 120;
    private int outRight = 480;
    //Gamestate
    private String gameState = "Initialize start";
    // timer after crash
    private int crashTimer = 0;
    // Highscore 
    private int highScore = 0;
    private boolean newHighScore;
    
    /**
     * Constructor for objects of class PoliceChase.
     * 
     */
    public PoliceChase()
    {    
        // Create a new world with 600x500 cells with a cell size of 1x1 pixels.
        super(600, 500, 1);  
        bg.scale(getWidth() + 400, getHeight());
        bg2.scale(getWidth() + 400, getHeight());
        startBG.scale(getWidth(), getHeight());
    }
    public void act()
    {
        switch (gameState) {
            case "Initialize start":
                // Background, Title and Start Button
                addObject(new Button(), 300, 300);
                addObject(new Text("POLICE CHASE", 60, Color.WHITE, Color.BLACK), 300, 200);
                getBackground().drawImage(startBG, 0, 0);
                addObject(new Text("Instructions: Use left and right arrow keys to avoid cars!", 20, Color.WHITE, Color.BLACK), 300, 400);
                gameState = "start";
                break;
            case "start":
                MouseInfo mouse = Greenfoot.getMouseInfo();
                
                //Start button click detection
                if (mouse != null) {
                    Actor currentActor = mouse.getActor();
                    if (currentActor != null && currentActor.getClass() == Button.class) {
                        Button currentButton = (Button)currentActor;
                        int mouseButtonPressed = mouse.getButton();
                        int mouseClickCount = mouse.getClickCount();
                        System.out.println(mouseButtonPressed+" "+mouseClickCount);
                        if (mouseClickCount == 1) {
                            currentButton.buttonToggle();
                            gameState = "Initialize game";
                        }
                    }
                }
                break;
            case "Initialize game":
                //variables for game
                removeObjects(getObjects(null));
                bgHeight = 0;  
                bg2Height = -500;
                speedOverTime = 1; 
                timeCount = 0;
                speedMultiplier = 10;
                gameOver = false;
                crashTimer = 0;                 
                spawnRedCarTime = 60;
                spawnBlueCarTime = 60;
                // draws the background
                getBackground().drawImage(bg, -200, 0);
                // Adds player car to the screen  
                playerCar = new PlayerCar();
                addObject(playerCar, playerCar.getX(), 300);
                // Adds police car to the screen
                policeCar = new PoliceCar();
                addObject(policeCar, policeCar.getX(), policeCar.getY());
                gameState = "game";
                newHighScore = false;
                addObject(new Text("High Score: "+highScore+"s", 15, Color.WHITE, Color.BLACK), 545, 20);
                break;
            case "game": //Makes the background move by using 2 of the same background
                // If there is a collision background stops moving
                if (playerCar.isCrashStop())
                {
                    speedOverTime = 0;
                    gameOver = true;
                    crashTimer += 1;
                    // highscore timer checks to see if score is the new highscore
                    if (timeCount/60 > highScore){
                        newHighScore = true;
                        highScore = timeCount/60;
                    }
                    // after crash 2s down time until it initializes game over
                    if (crashTimer / 60 >= 2)
                    {
                        gameState = "Initialize game over";
                    }
                }
                
                else
                {
                    //Increases background movement speed (makes the car look like its accelerating
                    if (bgHeight >= 500){
                        bgHeight = -500;
                    } else if (bg2Height >= 500) {
                        bg2Height = -500;
                    }
                    getBackground().drawImage(bg, -200, bgHeight);
                    getBackground().drawImage(bg2, -200, bg2Height); 
                    bgHeight += speedOverTime;
                    bg2Height += speedOverTime;
                    timeCount += 1;
                
                    if (timeCount >= speedMultiplier){
                        speedOverTime += 1;
                        speedMultiplier *= 2.0;
                    }
                    // Adds new obstacle instances at a random time interval(within range) and random location on the road with respect to the cars direciton
                    if (timeCount == spawnRedCarTime)
                    {
                        RedCar redCar = new RedCar(310 + random.nextInt(150), 0);
                        addObject(redCar, redCar.getX(), redCar.getY());
                        spawnRedCarTime += 60 + random.nextInt(120); 
                    }
                    if (timeCount == spawnBlueCarTime)
                    {
                        BlueCar blueCar = new BlueCar(150 + random.nextInt(140), 0);
                        addObject(blueCar, blueCar.getX(), blueCar.getY());
                        spawnBlueCarTime += 60 + random.nextInt(120); 
                    }
                    //timer
                    showText(timeCount/60+"s", 50, 20);
                }
                break;
            case "Initialize game over":
                removeObjects(getObjects(null));
                addObject(new Text("Game Over", 50, Color.WHITE, Color.BLACK), 300, 200);
                addObject(new Button(false, "Play Again"), 300, 300);
                addObject(new Text("High Score: "+highScore+"s", 20, Color.BLACK, Color.YELLOW), 300, 375);
                //addObject(new Text("New HighScore!", 15, Color.GREEN, Color.BLACK), 300, 425);
                gameState = "Game Over";
                break;
            case "Game Over":
                // checks for new high score if so lets player know
                if (newHighScore){
                    addObject(new Text("New HighScore!", 15, Color.GREEN, Color.BLACK), 300, 425);
                }
                mouse = Greenfoot.getMouseInfo();
                
                //Play Again button click detection
                if (mouse != null) {
                    Actor currentActor = mouse.getActor();
                    if (currentActor != null && currentActor.getClass() == Button.class) {
                        Button currentButton = (Button)currentActor;
                        int mouseButtonPressed = mouse.getButton();
                        int mouseClickCount = mouse.getClickCount();
                        System.out.println(mouseButtonPressed+" "+mouseClickCount);
                        if (mouseClickCount == 1) {
                            currentButton.buttonToggle();
                            gameState = "Initialize game";
                        }
                    }
                }
                break;
        }
    }
    // gets the speed of the background/cars
    public float getSpeed() 
    {
        return speedOverTime;
    }
    // gets the information about the player controlled car (x-variable used for police tracking)
    public PlayerCar getPlayerCar() {
        return playerCar;
    }
    // returns whether the game is over, after a crash
    public boolean gameOver()
    {
        return gameOver;
    }
    // gets position of car and whether it is out of bounds on the left side
    public int getOutLeft()
    {
        return outLeft;
    }
    // gets position of car and whether it is out of bounds on the right side
    public int getOutRight() 
    {
        return outRight;
    }
}
