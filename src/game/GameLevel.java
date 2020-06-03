package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public abstract class GameLevel extends World {

    /**
     * This field is set to protected, since it covers all three levels of the game. 
     */
    protected int numKeys,

    /**
     * This field is also set to protected, since it covers all three levels of the game. 
     */
    someKeys;

    /**
     * This serves as the constructor to this abstract class GameLevel.
     * It is empty.
     * @param game a parameter of class Game
     */
    public void populate(Game game) {}

    /**
     * This method sets the x and y coordinates of any instance of Soldier class.
     * @param x variable of type float corresponding to the instance of Soldier class's x coordinate
     * @param y variable of type float corresponding to the instance of Soldier class's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public Vec2 setHeroPosition(float x, float y) {
        return new Vec2(x, y);
    }
    
    /**
     * An accessor which gets the "half-way" number of keys set for each level.
     * @return a variable of type int corresponding to the value of the "half-way" number of keys set for each level
     */
    public int getHalfWayNumKeys(){
        return someKeys;
    }
    
    /**
     * An accessor which gets the total number of keys set for each level.
     * @return a variable of type int corresponding to the value of the total number of keys set for each level
     * @return a variable of type int
     */
    public int getTotalNumKeys(){
        return numKeys;
    }
     
    /**
     * This mutator ("setter" method) sets the position of the instance of Portal class in each level (apart from level 3).
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of Portal class's x coordinate
     * @param y variable of type float corresponding to the instance of Portal class's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setPortalPosition(float x, float y);

    /**
     * This mutator ("setter" method) sets the position of the instance of Cage class in each level.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of Cage class's x coordinate
     * @param y variable of type float corresponding to the instance of Cage class's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setCagePosition(float x, float y); 
 

    /**
     * This mutator ("setter" method) sets the position of the instance of LifeReplenish class in each level.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of LifeReplenish class's x coordinate
     * @param y variable of type float corresponding to the instance of LifeReplenish class's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setEnergyHeartPosition(float x, float y); 

    /**
     * This mutator ("setter" method) sets the position of the instance of Key class in each level.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of Key class's x coordinate
     * @param y variable of type float corresponding to the instance of Key class's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setKeyPosition(float x, float y);


    /**
     * This mutator ("setter" method) sets the position of the instance of GroundPLatformLevel2 class in each level.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of GroundPLatformLevel2 class's x coordinate
     * @param y variable of type float corresponding to the instance of GroundPLatformLevel2 class's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setGroundTwoPosition(float x, float y);

    /**
     * This mutator ("setter" method) sets the position of the instance of GroundPLatformLevel1 class in each level.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of GroundPLatformLevel1 class's x coordinate
     * @param y variable of type float corresponding to the instance of GroundPLatformLevel1 class's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setBasePlatformPosition(float x, float y);


    /**
     * This mutator ("setter" method) sets the position of a middle/low platform.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of the middle/low platform's x coordinate
     * @param y variable of type float corresponding to the instance of the middle/low platform's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setMiddleLowPlatform(float x, float y);

    /**
    * This mutator ("setter" method) sets the position of a middle/high platform.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of the middle/high platform's x coordinate
     * @param y variable of type float corresponding to the instance of the middle/high platform's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setMiddleHighPlatform(float x, float y);

    /**
     *This mutator ("setter" method) sets the position of a n upper platform.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of the upper platform's x coordinate
     * @param y variable of type float corresponding to the instance of the upper platform's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setUpperPlatform(float x, float y);

    /**
     * This method is used to determine whether all keys in a level have been collected.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @return a variable of type boolean
     */
    public abstract boolean reachedAllKeys();

    /**
     * This method is used to confirm when a level has been completed.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @return a variable of type boolean
     */
    public abstract boolean isCompleted();

    /**
     * This method is used to confirm when a level has been completed.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @return a variable of type boolean
     */
    public abstract boolean isFinished();

    /**
     * This accessor ("getter" method) is invoked whenever current values of an instance of Soldier class are needed.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @return a variable of class Soldier
     */
    public abstract Soldier getPlayer();
    
    /**
     * This accessor ("getter" method) is invoked to determine the limit of keys that can be collected per level.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @return a variable of type int
     */
    public abstract int getKeyLimitInLevel();


    /**
     *This mutator ("setter" method) sets the position of a mini platform.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of the mini platform's x coordinate
     * @param y variable of type float corresponding to the instance of the mini platform's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setMiniPlatformLevel2Position(float y, float x);


    /**
     *This method is invoked to know if all keyes in a level have been collected.
     * @return a variable of type int
     */
    public abstract int getTotalKeys();

    /**
     *This mutator ("setter" method) sets the position of a SpikedWall class instance in all levels.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of SpikedWall class's x coordinate
     * @param y variable of type float corresponding to the instance of SpikedWall class's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setSpikedWallPosition(float x, float y);
    //public abstract Vec2 setGroundSpikesPosition(float x, float y);

    /**
     *This mutator ("setter" method) sets the position of a lower-middle.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of the lower-middle wall's x coordinate
     * @param y variable of type float corresponding to the instance of the lower-middle wall's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setLowerMidWall(float x, float y);

    /**
     *This mutator ("setter" method) sets the position of an upper-middle wall.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @param x variable of type float corresponding to the instance of the upper-middle wall's x coordinate
     * @param y variable of type float corresponding to the instance of the upper-middle wall's y coordinate
     * @return a new instance of Vec2 class (which contains both values of x and y)
     */
    public abstract Vec2 setUpperMidWall(float x, float y);

    /**
     * This method is invoked to know what "half-way" number of keys is required to open a SpikedWall instance.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @return a variable of type int
     */
    public abstract int getSomeKeys();

    /**
     * This method is invoked to know the current number of keys collected by an instance of Soldier class.
     * This is an abstract class, therefore it is required to be implemented in all three level classes.
     * @return a variable of type int
     */
    public abstract int getCurrentNumberOfKeys();
}
