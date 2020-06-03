package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class IceBrick extends StaticBody{
    
    private static final Shape iceShape = new PolygonShape(
       -1.8f,1.62f, -1.79f,-1.59f, 1.78f,-1.6f, 1.78f,1.62f);
    
    private static final BodyImage iceImage = new BodyImage("data/iceBrick.png", 3.25f);
    
    /**
     *Constructor to IceBrick (which inherits all features of parent class StaticBody).
     * @param world a parameter of class World
     */
    public IceBrick(World world) {
         
        super(world, iceShape);       
        addImage(iceImage);       
     }     
}