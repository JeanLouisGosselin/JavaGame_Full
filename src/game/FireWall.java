package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class FireWall extends StaticBody{
    
    private static final Shape fireWallShape = new PolygonShape(
        -0.472f,0.623f, -0.486f,-0.453f, 0.608f,-0.455f, 0.589f,0.614f);
    
    private static final BodyImage fireWallImage = new BodyImage("data/fireWall.gif", 2.25f);
    
    /**
      *Constructor of class Firewall (this class is a subclass of StaticBody)
    * @param world current instance of class World
    */
    public FireWall(World world) {
         
        super(world, fireWallShape);       
        addImage(fireWallImage);       
     }     
}
