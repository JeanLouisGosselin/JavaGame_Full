package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class Key extends StaticBody{
    
    private static final Shape keyShape = new PolygonShape(
     -0.58f,1.0f, -0.56f,-0.85f, 0.15f,-0.86f, 0.2f,1.02f);
    
    private static final BodyImage keyImage = new BodyImage("data/myKey.png", 3.25f);
    
    /**
     *Constructor to Key (which inherits all features of parent class StaticBody).
     * @param world a parameter of class World
     */
    public Key(World world) {
         
        super(world, keyShape);       
        addImage(keyImage);       
    }

}