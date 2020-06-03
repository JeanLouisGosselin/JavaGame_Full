package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class GroundPlatformLevel2 extends StaticBody{
    
    private static final Shape groundShape = new PolygonShape(
        -5.4f,1.61f, -5.4f,-1.58f, 5.39f,-1.57f, 5.38f,1.58f);
    
    private static final BodyImage groundImage = new BodyImage("data/lavaFlow.gif", 3.25f);
    
    /**
     *Constructor to GroundPlatformLevel2 (which inherits all features of parent class StaticBody).
     * @param world a parameter of class World
     */
    public GroundPlatformLevel2(World world) {
         
        super(world, groundShape);       
        addImage(groundImage);        
     }
    
    /**
     * This method may be used in Game class to set the x an y coordinates of an instance of GroundPlatformLevel1
     * @param y float value of y coordinate
     * @param x float value of x coordinate
     * @return a new instance of Vec2 class (containing the values of x and y)
     */
    public Vec2 setGroundTwoPosition(float y, float x){        
        return new Vec2(x, y);
    }
}
