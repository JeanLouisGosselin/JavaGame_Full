package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class Soldier extends Walker{
    
    private static final Shape soldierShape = new PolygonShape(
            -0.731f,0.858f, -0.723f,-0.824f, 0.863f,-0.83f, 0.802f,0.866f);
    
    private static final BodyImage soldierImageLeft = new BodyImage("data/originalRunningSoldierLeft.gif", 2.25f);  
    private static final BodyImage soldierImageRight = new BodyImage("data/originalRunningSoldierRight.gif", 2.25f);
    private static final BodyImage soldierStillLeft = new BodyImage("data/stillSoldierLeft.gif", 2.25f);
    private static final BodyImage soldierStillRight = new BodyImage("data/stillSoldierRight.gif", 2.25f);
    
    private static int energy, life, keys;
    private boolean isFacingRight;
    
    /**
     * Constructor of Soldier class.
     * @param world parameter of class World
     */
    public Soldier(World world) {  
        
        super(world, soldierShape);       
        addImage(soldierStillLeft);              
        this.life = 3;
        this.energy = 3;
        this.keys = 0;
        isFacingRight = false;
    }
    
    
    /**
     * This accessor ("getter" method) gets the current value of the Soldier class instance's energy
     * @return a variable of type int
     */
    public int getEnergy(){
        return energy;
    }
    
    /**
     * This accessor ("getter" method) gets the current number of the Soldier class instance's lives.
     * @return a variable of type int
     */
    public int getLife(){       
        return life;
    }
    
    
    /**
     * This accessor ("getter" method) gets the current number of keys which the Soldier class instance has so far collected.
     * @return a variable of type int
     */
    public int getKeys(){
        return keys;
    }
 
    
    /**
     *This method sets the number of current lives of the instance of Soldier class from Game class.
     * @param l a variable of type int
     */
    public void setLife(int l){      
        life = l;
    }

    
    /**
     *This method sets the value of energy of the instance of Soldier class from Game class.
     * @param e a variable of type int
     */
    public void setEnergy(int e){
        energy = e;
    }
    
    /**
     * This method serves to decrement the value of energy for the current instance of Soldier class.
     * If energy reaches value, the gameOver() method is invoked.
     */
    public void decrementEnergy(){      
        energy--;
        if(energy > 0)
            System.out.println("Ouch! You've lost energy! -> energy count = " + energy); 
        else if(energy <= 0)
            loseLife();
    }
    
    /**
     * This method is invoked whenever an instance of Soldier class has lost all of its energy.
     * The value of the class's LIFE fiels is decremented.
     */
    public void loseLife(){       
        life -= 1;
    }
    
    
    /**
     * This method sets the LIFE field from Game class.
     * @param l a variable of type int.
     */
    public void getLifeFromGameClass(int l){
        life = l;
    }
    
    /**
     * This method sends the current number of lives of the instance of Soldier class back to Game class.
     * @return a variable of type int.
     */
    public int sendLifeToGameClass(){
        return life;
    }
    
    /**
     * whenever an instance of Soldier class contacts with an instance of LifeReplenish class, the instance's energy filed is set to max value.
     */
    public void increaseEnergy(){       
        energy = 3;
        System.out.println("Energy replenished! -> energy count = " + energy); 
    }
    
    /**
     * Whenever an instance of Soldier class connects with an instance of Key class, the number of keys of the Soldier class instance is incremented.
     * A message is also sent to the console as confirmation of this.
     */
    public void earnKeys(){       
        keys++;
        System.out.println("Key collected! keys = " + keys);
    }

    
    /**
     * When an instance of Soldier class has reached the end of the game (ie: touched an instance of Princess class), 
     * a message is sent to the console as confirmation.
     */
    public void gameWin(){      
        System.out.println("Mission accomplished, soldier! Princess saved!");
        //System.exit(0); //--> this screen exit is temporary (waiting to implement new game level)
    }   
    
    ////////////  methods for changing soldier's image according to his direction of movement /////////////

    /**
     * This method is used to change the appearance of the current instance of Soldier class according to the 
     * direction induced by the player.
     */  
    public void imageChangeRight(){       
        removeAllImages();
        addImage(soldierImageRight);
        isFacingRight=true;
    }
    
    /**
    * This method is used to change the appearance of the current instance of Soldier class according to the 
     * direction induced by the player.
     */
    public void imageChangeLeft(){       
        removeAllImages();
        addImage(soldierImageLeft);
        isFacingRight=false;
    }
     
    /**
     * This method is used to change the appearance of the current instance of Soldier class from moving
     * moving body to immobile (facing left).
     */
    public void showStillImageLeft(){       
        removeAllImages();
        addImage(soldierStillLeft);   
        isFacingRight=false;
    } 
    
    /**
     * This method is used to change the appearance of the current instance of Soldier class from moving
     * moving body to immobile (facing right).
     */
    public void showStillImageRight(){       
        removeAllImages();
        addImage(soldierStillRight);  
        isFacingRight=true;
    }
    
    /**
     * This method is used to confirm whether or not the instance of Soldiwer class is facing right.
     * @return a variable of type boolean.
     */
    public boolean isFacingRight(){
        return isFacingRight;    
        
    }
}
