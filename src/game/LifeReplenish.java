package game;

import city.cs.engine.*;
import java.awt.Polygon;

/**
 *
 * @author Jean-Louis
 */
public class LifeReplenish extends StaticBody{
    

    public static final Shape lifeShape = new PolygonShape(
        -0.529f,0.493f, -0.531f,-0.46f, 0.528f,-0.461f, 0.531f,0.496f);

    public final static BodyImage lifeHeart = new BodyImage("data/lifeHeart.png", 1.0f);
    
    /**
     *Constructor of class LifeReplenish (this class is a subclass of StaticBody class)
     *@param world current instance of class World
     */
    public LifeReplenish(World world){
        
        super(world, lifeShape);
        addImage(lifeHeart);
    }    
}
