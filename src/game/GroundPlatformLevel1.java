package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class GroundPlatformLevel1 extends StaticBody{
    
    private static final Shape groundShape = new PolygonShape(
        -1.58f,1.59f, -1.58f,-1.15f, 1.56f,-1.18f, 1.57f,1.6f);
    
    private static final BodyImage groundImage = new BodyImage("data/longPlatform1.png", 3.25f);
    
    /**
     *Constructor to GroundPlatformLevel1 (which inherits all features of parent class StaticBody).
     * @param world a parameter of class World
     */
    public GroundPlatformLevel1(World world) {
         
        super(world, groundShape);       
        addImage(groundImage);        
     }
    
    /**
     * This method may be used in Game class to set the x an y coordinates of an instance of GroundPlatformLevel1
     * @param y float value of y coordinate
     * @param x float value of x coordinate
     * @return a new instance of Vec2 class (containing the values of x and y)
     */
    public Vec2 setGroundOnePosition(float x, float y){
        
        return new Vec2(x, y);
    }
}
