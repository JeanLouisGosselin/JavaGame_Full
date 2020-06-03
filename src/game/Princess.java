package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class Princess extends StaticBody{
    
    private static final Shape princessShape = new PolygonShape(
        -0.6f,1.54f, -0.61f,-1.5f, 0.55f,-1.49f, 0.57f,1.57f);
    
    private static final BodyImage princessImage = new BodyImage("data/femalePrisoner.png", 3.25f);
    
    /**
     *Constructor of class Princess (this class is a subclass of StaticBody class)
     *@param world current instance of class World
      */
    public Princess(World world) {
         
        super(world, princessShape);       
        addImage(princessImage);        
     }   
}