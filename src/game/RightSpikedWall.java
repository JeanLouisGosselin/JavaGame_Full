package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class RightSpikedWall extends StaticBody{
    
    private static final Shape spikedWallShape = new PolygonShape(
       0.99f,1.62f, -0.86f,1.6f, -0.93f,-1.39f, 1.01f,-1.39f);
    
    private static final BodyImage spikedWallImage = new BodyImage("data/rightSpikes.png", 3.25f);
    
    /**
      *Constructor of class RightSpikedWall (this class is a subclass of StaticBody class)
    * @param world current instance of class World
    */
    public RightSpikedWall(World world) {
         
        super(world, spikedWallShape);       
        addImage(spikedWallImage);
     }     
}
