package game;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import city.cs.engine.*;
import java.awt.BorderLayout;
//import org.jbox2d.common.Vec2;

import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class Game{
   
    //////////////////////////// FIELDS: ///////////////////////////////////
       
    private GameLevel gameLevel;
    private int levelNumber, numKeys1, numKeys2, numKey3, numLife, numAmmo, life=0;
    private UserView view, endView;
    private ControlPanel panel;
    private Soldier soldier;            
    private Controller controller;   
    private MyBackground1 finalImage;
    private SoundClip gameMusic, ouch, kaching, applause, allKeysCollected, openCage, soldierDies;
    private JFrame frame;
    private String username, password;
    private int totalKeysCollected;
    private SplashScreen screen;
    
    //////////////////////////// CONSTRUCTOR: ///////////////////////////////////

    /**
     * Constructor of Game class (with no parameter list)
     */
    
    public Game() {
            
          ///////////////////////////////////////////////////////////////////////////////

        // display the view in a frame (quit the application when the game window is closed)
        frame = new JFrame("Encapsulation Demo");
        screen = new SplashScreen(this);
        
        // frame setup:      
        frame.addKeyListener(controller);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        // display the world in the window:
        frame.getContentPane().add(screen);

        // don't let the game window be resized:
        frame.setResizable(false);
        
        // size the game window to fit the world view:
        frame.pack();
        
        // make the window visible:
        frame.setVisible(true);
        
        // get keyboard focus
        frame.requestFocus();
        
        try {
            gameMusic = new SoundClip("data/Adagio.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        } 
        
        totalKeysCollected = 0;
    /////////////////////////////////////////////////////////////////////      
    }
    
    //---------> END OF CONSTRUCTOR
    
//////////////////////////////// OTHER METHODS /////////////////////////////////

    /**
     * An accessor ("getter" method) which gets the instance of Soldier class from the current game level (passed on by abstract class GamelLevel)
     * @return the instance of Soldier class from the current level
     */

    public Soldier getPlayer() {       
        return gameLevel.getPlayer();
    }

    /**
     * An accessor ("getter" method) which gets the maximum number of keys set in the current level
     * @return a variable of type int which holds the maximum number of keys set in the current level (accessed by abstract class GameLeve)
     */
    public int getNumAllKeys(){
        return gameLevel.getTotalNumKeys();
    }
    
    /**
     * An accessor ("getter" method) which gets the intermediate number of keys set in the current level
     * @return a variable of type int which holds the intermediate number of keys set in the current level (accessed by abstract class GameLevel)
     */
    public int getSomeOfKeys(){
        return gameLevel.getHalfWayNumKeys();
    }
    
    /**
     * An accessor ("getter" method) which gets the current number of keys accumulated by the current instance of Soldier class in the current level
     * @return a variable of type int which holds the current number of keys accumulated by the current instance of Soldier class in the current level (accessed by abstract class GameLevel)
     */
    public int getCurrentNumKeys(){
        return gameLevel.getCurrentNumberOfKeys();
    }

    /**
     * This method checks whether the level is completed or not.
     * @return a variable of type boolean
     */
    public boolean isCurrentLevelCompleted() {       
        return gameLevel.isCompleted();
    }
    
    /**
     * An accessor ("getter" method) which gets the instance of GameLevel
     * @return the instance of GameLevel class
     */
    public GameLevel getWorld(){      
        return gameLevel;       
    }
    
    /**
     *An accessor ("getter" method) which gets the current level number
     * @return a variable of type int corresponding to the current level number
     */
    public int getLevelNumber(){     
        return levelNumber;
    }
    
    /**
     *An accessor ("getter" method) which gets the current game soundtrack
     * @return an object of SoundClip class corresponding to the current game soundtrack
     */
    public SoundClip getMusic(){
        return gameMusic;
    }
    
    /**
     *An accessor ("getter" method) which gets a specific sound clip from the project's DATA folder
     * @return an object of SoundClip class
     */
    public SoundClip getOuch(){
        
        try{
            ouch = new SoundClip("data/ouch.wav");
        }
        catch (UnsupportedAudioFileException|IOException|LineUnavailableException q) {
            System.out.println(q);
        }
        return ouch;
    }
    
    /**
     *An accessor ("getter" method) which gets a specific sound clip from the project's DATA folder
     * @return an object of SoundClip class
     */
    public SoundClip getKaching(){
        
        try{
            kaching = new SoundClip("data/kaching.wav");
        }
        catch (UnsupportedAudioFileException|IOException|LineUnavailableException q) {
            System.out.println(q);
        }
        return kaching;
    }
    
    /**
     *An accessor ("getter" method) which gets a specific sound clip from the project's DATA folder
     * @return an object of SoundClip class
     */
    public SoundClip getYeah(){
        
        try{
            applause = new SoundClip("data/yeah.wav");
        }
        catch (UnsupportedAudioFileException|IOException|LineUnavailableException q) {
            System.out.println(q);
        }
        return applause;
    }
    
    /**
     *An accessor ("getter" method) which gets a specific sound clip from the project's DATA folder
     * @return an object of SoundClip class
     */
    public SoundClip getWoohoo(){

        try{
            allKeysCollected = new SoundClip("data/woohoo1.wav");
        }
        catch (UnsupportedAudioFileException|IOException|LineUnavailableException q) {
            System.out.println(q);
        }
        return allKeysCollected;
    }
       
    /**
     *An accessor ("getter" method) which gets a specific sound clip from the project's DATA folder
     * @return an object of SoundClip class
     */
    public SoundClip soldierDies(){
             
        try{
            soldierDies = new SoundClip("data/sigh.wav");
        }
        catch (UnsupportedAudioFileException|IOException|LineUnavailableException q) {
            System.out.println(q);
        }
        return soldierDies;
    }
    
    /**
     *An accessor ("getter" method) which gets a specific sound clip from the project's DATA folder
     * @return an object of SoundClip class
     */
    public SoundClip getUnlockCage(){
             
        try{
            openCage = new SoundClip("data/openDoor.wav");
        }
        catch (UnsupportedAudioFileException|IOException|LineUnavailableException q) {
            System.out.println(q);
        }
        return openCage;
    }
 
    /**
     *An accessor ("getter" method) which gets a specific sound clip from the project's DATA folder
     * @return an object of SoundClip class
     */
    public SoundClip destroyWall(){
        
        try{
            soldierDies = new SoundClip("data/bazookaShot.wav");
        }
        catch (UnsupportedAudioFileException|IOException|LineUnavailableException q) {
            System.out.println(q);
        }
        return soldierDies;

    }
    
    /**
     * An accessor ("getter" method) which gets the current instance of JFrame class
     * @return an object of class JFrame
     */
    public JFrame getFrame(){
        return frame;
    }
    
    /**
     * This method invokes the constructor of IntroFrame class, which is itself subclass of javax.swing.JPanel.
     * This creates a JPanel, a box inside which the player types in a username and password.
     * This user input is processed and checked by the instance of IntroFrame.
     * A new instance of JFrame is created inside this method, in order to create a window
     * and display this IntroFrame box.
     */
    public void login(){

        // display the view in a frame (quit the application when the game window is closed)
        frame = new JFrame("Encapsulation Demo");
        IntroFrame info = new IntroFrame(this);
        
        // frame setup:     
        frame.addKeyListener(controller);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        // display the world in the window:
        frame.getContentPane().add(info);
        
        // don't let the game window be resized:
        frame.setResizable(false);
        
        // size the game window to fit the world view:
        frame.pack();
        
        // make the window visible:
        frame.setVisible(true);
        
        // get keyboard focus
        frame.requestFocus();       
    }
    
    /**
     * This method is in fact the start of Level 1 of the game.
     * It creates an instance of Level1 class (assigned to current instance of abstract class GameLevel, the parent of Level1 class).
     * Instances from all necessary classes (Soldier, JFrame, UserView, MyBackground1, SoundClip, ControlPanel) are created.
     */
    public void startGame(){
           
        gameLevel = new Level1();
        gameLevel.populate(this);
        levelNumber = 1;
       
        view = new UserView(gameLevel, 1000, 500);
        view = new MyBackground1(gameLevel, 1000, 500, this);
        
         // uncomment this to draw a 1-metre grid over the view
         //view.setGridResolution(1);
         
        panel = new ControlPanel(this);
                
        soldier = gameLevel.getPlayer();       
        soldier.getLife();
        soldier.getEnergy();
        soldier.getKeys();
                                     
        ///////////////////////////////////////////////////////////////////////////////

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame (quit the application when the game window is closed)
        frame = new JFrame("Encapsulation Demo");
        
        // frame setup:

        controller = new Controller(gameLevel.getPlayer());
        frame.addKeyListener(controller);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        // display the world + panels in the window:
        frame.add(view);    
        frame.add(panel, BorderLayout.NORTH);
        
        // don't let the game window be resized:
        frame.setResizable(false);
        
        // size the game window to fit the world view:
        frame.pack();
        
        // make the window visible:
        frame.setVisible(true);
        
        // get keyboard focus
        frame.requestFocus();
        
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(gameLevel, 500, 500);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new FocusOnGameScreen(frame));
        
        //create mouse event:
        view.addMouseListener(new MouseTest());
        
        frame.addKeyListener(new Controller(gameLevel.getPlayer()));

        //uncomment this to make the view track the soldier non-functional:
        gameLevel.addStepListener(new Tracker(view, gameLevel.getPlayer()));
        
        //adding music:
        gameMusic.close();
        
        try {
            gameMusic = new SoundClip("data/Recognizer.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
   
        // start!
        gameLevel.start();
    }
    
 //////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method is invoked when all lives of the current instance of Soldier class have been used.
     * This method sets Game class's field levelNumber to a specific integer value, and invokes Game class's
     * goNextLevel() method (which enables a shift in game levels based on the value of levelNumber variable).
     */
    
    public void gameIsOver(){
       
        levelNumber = 999;
        this.goNextLevel(0);
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     *When an instance of Soldier class has its life field decremented, this method enables the player 
     * to start the same level again.
     * This method is split into two conditions: if the player loses in level 1, another method (restartLevel1) is invoked.
     * If however the player loses a life in any other level, the levelNumber field is decremented, and the goNextLevel() method
     * is invoked (where the levelNumber field is this incremented, which amounts to the player starting at the
     * same level once again).
     */
    public void backToLevelStart(){
        
        if(levelNumber == 1){
            int life = gameLevel.getPlayer().getLife();
            totalKeysCollected -= soldier.getKeys();
            restartLevel1(life);   
        }
        else{            
            gameLevel.getPlayer().loseLife();
            levelNumber--;
            int life = gameLevel.getPlayer().getLife();
            totalKeysCollected -= soldier.getKeys();
            goNextLevel(life);   
        }
    }
   
//////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *This method is invoked if the player loses a life in level1.
     * the current JFrame object is used to invoke two methods: setVisible(false) and removeAll(),
     * which gets rid of the current game screen; this is then replaced by a new instance of Level1 class
     * and levelNumber field is reset to value 1.
     * @param life a variable of type int
     */   
    public void restartLevel1(int life){
        
        frame.setVisible(false);
        frame.removeAll();

        gameLevel = new Level1();
        gameLevel.populate(this);
        levelNumber = 1;

        view = new UserView(gameLevel, 1000, 500);
        view = new MyBackground1(gameLevel, 1000, 500, this);
        
         // uncomment this to draw a 1-metre grid over the view
         //view.setGridResolution(1);
        
        panel = new ControlPanel(this);

        soldier = gameLevel.getPlayer(); 
        soldier.setLife(life);
        soldier.getLife();
        soldier.getEnergy();
        soldier.getKeys();
        totalKeysCollected = 0;

        ///////////////////////////////////////////////////////////////////////

        // display the view in a frame (quit the application when the game window is closed)
        frame = new JFrame("Encapsulation Demo");
        
        // frame setup:
        controller = new Controller(gameLevel.getPlayer());
        frame.addKeyListener(controller);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        // display the world + panels in the window:
        frame.add(view);    
        frame.add(panel, BorderLayout.NORTH);

        // don't let the game window be resized:
        frame.setResizable(false);
        
        // size the game window to fit the world view:
        frame.pack();
        
        // make the window visible:
        frame.setVisible(true);
        
        // get keyboard focus
        frame.requestFocus();
        
        ///////////////////////////////////////////////////////////////////////

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(gameLevel, 500, 500);
        
        ///////////////////////////////////////////////////////////////////////

        
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new FocusOnGameScreen(frame));
        
        //create mouse event:
        view.addMouseListener(new MouseTest());
        
        frame.addKeyListener(new Controller(gameLevel.getPlayer()));

        //uncomment this to make the view track the soldier non-functional:
        gameLevel.addStepListener(new Tracker(view, gameLevel.getPlayer()));
        
        //adding music:
        gameMusic.close();
        try {
            gameMusic = new SoundClip("data/Recognizer.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
        
        // start!
        gameLevel.start();        
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method is invoked if the player has successfully completed a level,
     * finished the entire game, lost a life or lost all lives.
     * @param life This parameter of type int is what enables the current number of lives 
     * of the instance of Soldier class to be passed on from one level to the next.
     * 
     * This method is either activated by one of the JButtons on the ControlPanel, or is invoked
     * in the course of the game.
     */
      
    public void goNextLevel(int life) {
        
        switch(levelNumber){
            
            case 1: 
                    
                    gameLevel.stop();           
                    levelNumber++;
                    gameLevel = new Level2();
                    gameLevel.populate(this);
                    controller.setBody(gameLevel.getPlayer());
                    gameLevel.addStepListener(new Tracker(view, gameLevel.getPlayer()));
                    view.setWorld(gameLevel);
                    
                    //make a soldier:
                    soldier = gameLevel.getPlayer();
                    totalKeysCollected += soldier.getKeys();
                    soldier.setLife(life);                    
                    soldier.getLife();
                    soldier.getEnergy();
                    soldier.getKeys();
                    
                    //closing/adding new music:
                    gameMusic.close();
                    try {
                        gameMusic = new SoundClip("data/Mombasa.wav");   // Open an audio input stream
                        gameMusic.loop();  // Set it to continous playback (looping)
                    } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                        System.out.println(e);
                    }
                    
                    gameLevel.start();                   
                    break;
            

            case 2: 
                    gameLevel.stop();           
                    levelNumber++;
                    gameLevel = new Level3();
                    gameLevel.populate(this);
                    controller.setBody(gameLevel.getPlayer());
                    gameLevel.addStepListener(new Tracker(view, gameLevel.getPlayer()));
                    view.setWorld(gameLevel);
                    
                    soldier = gameLevel.getPlayer();
                    totalKeysCollected += soldier.getKeys();
                    soldier.setLife(life);
                    soldier.getLife();
                    soldier.getEnergy();
                    //l = soldier.sendLifeToGameClass();
                    //soldier.setLife(l);
                    soldier.getKeys();
                    //closing/adding new music:
                    gameMusic.close();
                    try {
                        gameMusic = new SoundClip("data/WannaFight.wav");   // Open an audio input stream
                        gameMusic.loop();  // Set it to continous playback (looping)
                    } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                        System.out.println(e);
                    }
                    gameLevel.start();
                    break;

        
            case 3:                    
                    gameLevel.stop();
                    levelNumber++;
                    gameLevel = new LevelEndOfGame();
                    gameLevel.populate(this);
                    view.setWorld(gameLevel);
                    //closing/adding new music:
                    gameMusic.close();
                    try {
                        gameMusic = new SoundClip("data/SolarSailor.wav");   // Open an audio input stream
                        gameMusic.loop();  // Set it to continous playback (looping)
                    } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                        System.out.println(e);
                    }
                    gameLevel.start();
                    break;
                    
            case 999:
                    gameLevel.stop();
                    gameLevel = new LevelGameOver();
                    gameLevel.populate(this);
                    view.setWorld(gameLevel);
                    gameMusic.close();
                    gameLevel.start();
                    break;
        }
    }
        
    /**
     * Contrary to goNextLevel() method, this method can only be activated by the push of
     * one of the JButtons on the ControlPanel instance.
     * @param life a variable of type int
     */
    public void goPreviousLevel(int life) {
        
        switch(levelNumber){

            case 2: 
                    gameLevel.stop();           
                    levelNumber--;
                    gameLevel = new Level1();
                    gameLevel.populate(this);
                    controller.setBody(gameLevel.getPlayer());
                    gameLevel.addStepListener(new Tracker(view, gameLevel.getPlayer()));
                    view.setWorld(gameLevel);
                    //make a soldier:
                    soldier = gameLevel.getPlayer();
                    soldier.setLife(life);
                    soldier.getLife();
                    soldier.getLife();
                    //soldier.getAmmo();
                    soldier.getKeys();
                    //closing/adding new music:
                    gameMusic.close();
                    try {
                        gameMusic = new SoundClip("data/Recognizer.wav");   // Open an audio input stream
                        gameMusic.loop();  // Set it to continous playback (looping)
                    } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                        System.out.println(e);
                    }
                    gameLevel.start();
                    break;

        
            case 3: 
                    gameLevel.stop();           
                    levelNumber--;
                    gameLevel = new Level2();
                    gameLevel.populate(this);
                    controller.setBody(gameLevel.getPlayer());
                    gameLevel.addStepListener(new Tracker(view, gameLevel.getPlayer()));
                    view.setWorld(gameLevel);
                    //make a soldier:
                    soldier = gameLevel.getPlayer();
                    soldier.setLife(life);
                    soldier.getLife();
                    soldier.getEnergy();
                    //soldier.getAmmo();
                    soldier.getKeys();
                    //closing/adding new music:
                    gameMusic.close();
                    try {
                        gameMusic = new SoundClip("data/Mombasa.wav");   // Open an audio input stream
                        gameMusic.loop();  // Set it to continous playback (looping)
                    } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                        System.out.println(e);
                    }
                    gameLevel.start();
                    break;
                    
            case 4:
                
                    gameLevel.stop();           
                    levelNumber--;
                    gameLevel = new Level3();
                    gameLevel.populate(this);
                    controller.setBody(gameLevel.getPlayer());
                    gameLevel.addStepListener(new Tracker(view, gameLevel.getPlayer()));
                    view.setWorld(gameLevel);
                    //make a soldier:
                    soldier = gameLevel.getPlayer();
                    soldier.setLife(life);
                    soldier.getLife();
                    soldier.getEnergy();
                    soldier.getKeys();
                    //closing/adding new music:
                    gameMusic.close();
                    try {
                        gameMusic = new SoundClip("data/NoTimeForCaution.wav");   // Open an audio input stream
                        gameMusic.loop();  // Set it to continous playback (looping)
                    } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                        System.out.println(e);
                    }
                    gameLevel.start();
                    break;
        }
    }
    
/////////////////////////////// RUNNING THE PROGRAM ////////////////////////////
    
    /**
     * This is the MAIN program, which creates an instance of Game class by invoking its constructor.
     * @param args a String array variable
     */
    public static void main(String[] args) {      
        //creating instance of GAME class in MAIN():
        new Game();
    }
}