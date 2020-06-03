package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class GroundPlatformLevel3 extends StaticBody{
    
    private static final Shape groundShape = new PolygonShape(
        -22.57f,1.63f, -22.48f,-1.35f, 22.21f,-1.26f, 22.21f,1.35f);
    
    private static final BodyImage groundImage = new BodyImage("data/groundPlatform3.png", 3.25f);
    
    /**
     *Constructor to GroundPlatformLevel3 (which inherits all features of parent class StaticBody).
     * @param world a parameter of class World
     */
    public GroundPlatformLevel3 (World world) {
         
        super(world, groundShape);       
        addImage(groundImage);        
     }
    
    /**
     * This method may be used in Game class to set the x an y coordinates of an instance of GroundPlatformLevel1
     * @param y float value of y coordinate
     * @param x float value of x coordinate
     * @return a new instance of Vec2 class (containing the values of x and y)
     */
    public Vec2 setGroundThreePosition(float y, float x){
        
        return new Vec2(x, y);
    }
}
