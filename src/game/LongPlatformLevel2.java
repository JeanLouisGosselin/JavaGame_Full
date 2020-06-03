package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class LongPlatformLevel2 extends StaticBody{
    
    private static final Shape miniPlatShape = new PolygonShape(
       -3.24f,1.62f, -3.23f,-1.57f, 3.21f,-1.56f, 3.2f,1.6f);
    
    private static final BodyImage miniPlatImage = new BodyImage("data/longPlatform2.png", 3.25f);
    
    /**
      *Constructor of class LongPlatformLevel2 (this class is a subclass of StaticBody class)
    * @param world current instance of class World
     */
    public LongPlatformLevel2(World world) {
         
        super(world, miniPlatShape);       
        addImage(miniPlatImage);        
     }
}
