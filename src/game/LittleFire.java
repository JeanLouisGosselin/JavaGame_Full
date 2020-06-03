package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class LittleFire extends StaticBody{
    
    private static final Shape littleFireShape = new PolygonShape(
        -0.381f,0.343f, -0.392f,-0.839f, 0.384f,-0.834f, 0.369f,0.346f);
    
    private static final BodyImage littleFireImage = new BodyImage("data/littleFire.gif", 2.25f);
    
    /**
      *Constructor of class LittleFire (this class is a subclass of StaticBody class)
    * @param world current instance of class World
     */
    public LittleFire(World world) {
         
        super(world, littleFireShape);       
        addImage(littleFireImage);       
     }     
}