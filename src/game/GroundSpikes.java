package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class GroundSpikes extends StaticBody{
    
    private static final Shape groundSpikesShape = new PolygonShape(
        -2.55f,-1.57f, -2.56f,1.32f, 2.54f,1.29f, 2.55f,-1.6f);
    
    private static final BodyImage groundSpikesImage = new BodyImage("data/groundSpikes.png", 3.25f);
    
    /**
     *Constructor to GroundSpikes (which inherits all features of parent class StaticBody).
     * @param world a parameter of class World
     */
    public GroundSpikes(World world) {
         
        super(world, groundSpikesShape);        
        addImage(groundSpikesImage);       
    }
}