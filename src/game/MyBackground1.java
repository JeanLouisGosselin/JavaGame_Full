package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.YELLOW;

/**
 *
 * @author Jean-Louis
 */
public class MyBackground1 extends UserView {

    private String score, life, ammo, gameCompletedMessage, finalScore, 
                    finalAmmo, finalLife, wallToDestroy, cageUnlocked, savePrincess;
    private Image background1, background2, background3, endBackground, gameOverBackground;
    private Image lifeHeart;
    private Image key;
    private Image tinyKey, tinyHead, tinyHeart;
    private Soldier player;
    private Game gameObject;
    private GameLevel gameLevel;

    /**
     * Constructor of MyBackground1 class (which inherits and overrides features from UserView class)
     * @param world parameter of class GameLevel
     * @param width variable if type int corresponding to the width of the image
     * @param height variable if type int corresponding to the height of the image
     * @param g parameter of class Game
     */
    public MyBackground1(GameLevel world, int width, int height, Game g) {
        
        super(world, width, height);        
        gameObject = g;
        player = gameObject.getPlayer();
        background1 = new ImageIcon("data/firstDestroyedWorld.jpg").getImage();
        background2 = new ImageIcon("data/secondDestroyedWorld.jpg").getImage();
        background3 = new ImageIcon("data/thirdDestroyedWorld.jpg").getImage();
        endBackground = new ImageIcon("data/lastBackground.jpg").getImage();
        gameOverBackground = new ImageIcon("data/gameOver.jpg").getImage();
        lifeHeart = new ImageIcon("data/lifeHeart.png").getImage();
        key = new ImageIcon("data/key.png").getImage();
        tinyHead = new ImageIcon("data/tinyHead.png").getImage();
        tinyHeart = new ImageIcon("data/tinyHeart.png").getImage();
        tinyKey = new ImageIcon("data/tinyKey.png").getImage();
        score = "KEYS = ";
        life = "LIFE = ";
        wallToDestroy = "Great! You can now run through the spiked wall!!";
        cageUnlocked = "All keys collected! Cage to portal can be unlocked!";
        savePrincess = "NOW GO SAVE THE PRINCESS SOLDIER!!!";
        gameCompletedMessage = "Mission accomplished soldier!";
        finalScore = "FINAL SCORE = ";
        finalAmmo = "AMMO LEFT = ";
        finalLife = "LIFE REMAINING = ";
        
    }
    
    /**
     * This in-built method from class UserView paints images in the frame's foreground.
     * According to the level number (passed on by the instance of class Game), this method
     * displays the appropriate image from the project's DATA folder.
     * @param g a parameter of class Graphics2D, specific to UserView class
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        
        switch(gameObject.getLevelNumber()){
            
            case 1:
                    g.drawImage(background1, 0, 0, this);
                    break;
                    
            case 2:
                    g.drawImage(background2, 0, 0, this);
                    break;
                    
            case 3:
                    g.drawImage(background3, 0, 0, this);
                    break;
                    
            case 4:
                    g.drawImage(endBackground, 0, 0, this);
                    break;
            
            case 999:
                    g.drawImage(gameOverBackground, 0, 0, this);
                    break;
        }
    }

    /**
     * This in-built method from class UserView paints images in the frame's foreground.
     * According to the level number (passed on by the instance of class Game), this method
     * displays the scoreboard on the screen with little icons and symbols representing
     * the character's number of lives, energy and keys collected.
     * This method in turn invokes three methods, each displaying the scoreboard and notices
     * in a slightly different way (level 3 notice is different from the previous 2 messages).
     * @param g a parameter of class Graphics2D, specific to UserView class
     */
    @Override
    protected void paintForeground(Graphics2D g){

        if(gameObject.getLevelNumber() == 1)          
            scoreBoard1(g);

        else if(gameObject.getLevelNumber() == 2)
            scoreBoard2(g);

        else if(gameObject.getLevelNumber() == 3)
            scoreBoard3(g);              

     //////////////////////////////////////////////////////////////////////////////
    //                                                                          //
    //                        win page                                          //
    //                                                                          //
    //////////////////////////////////////////////////////////////////////////////        

        else if(gameObject.getLevelNumber() == 4){

            g.setColor(RED);
            g.drawRect(375, 120, 200, 50);
            g.setColor(RED);
            g.drawString(gameCompletedMessage, 390, 150);
        }
    }
    
    /**
     * This method is one version to display the scoreboard (in level 1).
     * @param g a parameter of class Graphics2D, specific to UserView class
     */
    public void scoreBoard1(Graphics2D g){
        
      System.out.println(gameObject.getPlayer().getLife());
      System.out.println(gameObject.getPlayer().getEnergy());
      System.out.println(gameObject.getPlayer().getKeys());
      
        int space = 0;
        for(int i = gameObject.getPlayer().getLife(); i>0 ; i--){
            g.drawImage(tinyHead, 20 + space, 05, this);
            space += 30;
        }
        
        int space1 = 0;
        for(int i = gameObject.getPlayer().getEnergy(); i>0 ; i--){
            g.drawImage(tinyHeart, 120 + space1, 10, this);
            space1 += 30;
        }
        
        int space2 = 0;
        for(int i = 0; i<gameObject.getPlayer().getKeys(); i++){
            g.drawImage(tinyKey, 210 + space2, 10, this);
            space2 += 20;                
        }

        if(gameObject.getPlayer().getKeys() >= gameObject.getSomeOfKeys()){
            g.setColor(RED);
            g.drawString(wallToDestroy, 33, 60); //480
        }
        
        if(gameObject.getPlayer().getKeys() >= gameObject.getNumAllKeys()){
            g.setColor(RED);
            g.drawString(cageUnlocked, 33, 80); // 700, 480
        }         
    }
    
    /**
     * This method is one version to display the scoreboard (in level 2).
     * @param g a parameter of class Graphics2D, specific to UserView class
     */
    public void scoreBoard2(Graphics2D g){
        
      System.out.println(gameObject.getPlayer().getLife());
      System.out.println(gameObject.getPlayer().getEnergy());
      System.out.println(gameObject.getPlayer().getKeys());
      
        int space = 0;
        for(int i = gameObject.getPlayer().getLife(); i>0 ; i--){
            g.drawImage(tinyHead, 20 + space, 05, this);
            space += 30;
        }
        
        int space1 = 0;
        for(int i = gameObject.getPlayer().getEnergy(); i>0 ; i--){
            g.drawImage(tinyHeart, 120 + space1, 10, this);
            space1 += 30;
        }
        
        int space2 = 0;
        for(int i = 0; i<gameObject.getPlayer().getKeys(); i++){
            g.drawImage(tinyKey, 210 + space2, 10, this);
            space2 += 20;                
        }

        if(gameObject.getPlayer().getKeys() >= gameObject.getSomeOfKeys()){
            g.setColor(RED);
            g.drawString(wallToDestroy, 33, 60); //480
        }
        
        if(gameObject.getPlayer().getKeys() >= gameObject.getNumAllKeys()){
            g.setColor(RED);
            g.drawString(cageUnlocked, 33, 80); // 700, 480
        }         
    }

    /**
     * This method is one version to display the scoreboard (in level 3).
     * @param g a parameter of class Graphics2D, specific to UserView class
     */
    public void scoreBoard3(Graphics2D g){
        
      System.out.println(gameObject.getPlayer().getLife());
      System.out.println(gameObject.getPlayer().getEnergy());
      System.out.println(gameObject.getPlayer().getKeys());
      
        int space = 0;
        for(int i = gameObject.getPlayer().getLife(); i>0 ; i--){
            g.drawImage(tinyHead, 20 + space, 05, this);
            space += 30;
        }
        
        int space1 = 0;
        for(int i = gameObject.getPlayer().getEnergy(); i>0 ; i--){
            g.drawImage(tinyHeart, 120 + space1, 10, this);
            space1 += 30;
        }
        
        int space2 = 0;
        for(int i = 0; i<gameObject.getPlayer().getKeys(); i++){
            g.drawImage(tinyKey, 210 + space2, 10, this);
            space2 += 20;                
        }
        
        if(gameObject.getPlayer().getKeys() >= gameObject.getNumAllKeys()){
            g.setColor(RED);
            g.drawString(savePrincess, 33, 80);
        }
    }
    
    /**
     * This method resets the scoreboard (by still keeping crucial data which runs its course
     * throughout the game) with every change of level.
     * @param g a parameter of class Graphics2D, specific to UserView class
     */
    public void resetScoreBoardNextLevel(Graphics2D g){

        int space = 0;
        for(int i = gameObject.getPlayer().getLife(); i>0 ; i--){
            g.drawImage(tinyHead, 20 + space, 05, this);
            space += 30;
        }

        int space1 = 0;
        for(int i = gameObject.getPlayer().getEnergy(); i>0 ; i--){
            g.drawImage(tinyHeart, 120 + space1, 10, this);
            space1 += 30;
        }

        int space2 = 0;
        for(int i = 0; i<gameObject.getPlayer().getKeys(); i++){
            g.drawImage(tinyKey, 210 + space2, 10, this);
            space2 += 20;                
        }            
    }
}
