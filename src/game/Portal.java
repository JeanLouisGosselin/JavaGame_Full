package game;

import city.cs.engine.*;

/**
 *
 * @author Jean-Louis
 */
public class Portal extends StaticBody { 
    
   private static final Shape portalShape = new PolygonShape(
            -0.939f,1.007f, -0.942f,-0.802f, 0.875f,-0.81f, 0.849f,0.968f);
   
   private static final BodyImage portalImage = new BodyImage("data/portal.png", 2.25f);

    /**
     *Constructor of class Portal (this class is a subclass of StaticBody class)
    * @param world current instance of class World
    */
    public Portal(World world) {
        
       super(world, portalShape);
       addImage(portalImage);             
    }
}
