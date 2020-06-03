package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class Cage extends StaticBody{
    
    //add [ implements StepListener ] above to activate Step methods below
    
    private static final Shape cageShape = new PolygonShape(
        -1.58f,1.59f, -1.58f,-1.15f, 1.56f,-1.18f, 1.57f,1.6f);
    
    private static final BodyImage cageImage = new BodyImage("data/steelCage.png", 3.25f);
    
    private Soldier soldier;
    
    private int nK;
    
    /**
     * Constructor of class Cage (this class is a subclass of StaticBody)
     * @param world parameter of class World
     * @param s current object of class Soldier being used in the game
     * @param numKeys gets current number of keys collected by the soldier
     */
    public Cage(World world, Soldier s, int numKeys) {
         
        super(world, cageShape);       
        addImage(cageImage);
        this.soldier = s; 
        this.nK = numKeys;
     }
    
    /**
     *
     * @param y the y coordinate which will set the position of the cage on the screen
     * @param x the x coordinate which will set the position of the cage on the screen
     * @return an object of class Vec2, containing x and y coordinates of the cage
     */
    public Vec2 setCagePosition(float y, float x){
        
        return new Vec2(x, y);
    }
}
