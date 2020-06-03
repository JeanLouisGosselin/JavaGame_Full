package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class LeftSpikedWall extends StaticBody{
    
    private static final Shape spikedWallShape = new PolygonShape(
       -1.01f,1.62f, -1.0f,-1.39f, 0.96f,-1.38f, 0.98f,1.59f);
    
    private static final BodyImage spikedWallImage = new BodyImage("data/leftSpikes.png", 3.25f);
    
    /**
     *Constructor to IceBrick (which inherits all features of parent class StaticBody).
     * @param world a parameter of class World
     */
    public LeftSpikedWall(World world) {
         
        super(world, spikedWallShape);       
        addImage(spikedWallImage);
     }     
}
