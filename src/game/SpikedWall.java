package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class SpikedWall extends Walker implements StepListener{
    
    private static final Shape spikedWallShape = new PolygonShape(
       -1.91f,1.6f, -1.95f,-1.57f, 1.88f,-1.58f, 1.85f,1.58f);
    
    private static final BodyImage spikedWallImage = new BodyImage("data/doubleSpikedWall.png", 3.25f);
    
    int direction;
    float limitLeft, limitRight;
    
    /**
     * Constructor of SpikedWall class (this class is a subclass of Walker class, which itself inherits features from StepListener interface)
     * @param world current instance of World class
     * @param x variable of type float which sets the leftmost x coordinate to where the instance of SpikedWall can go to (before switching course)
     * @param y variable of type float which sets the rightmost x coordinate to where the instance of SpikedWall can go to (before switching course)
      */
    public SpikedWall(World world, float x, float y) {
         
        super(world, spikedWallShape);       
        addImage(spikedWallImage);
        limitLeft = x;
        limitRight = y;
        
        direction = 1;
     }     

    /**
     *This in-built method specific to StepListener interface (inherited and overriden by SpikedWall class) follows the ongoing motion of instance of SpikedWall on the horizontal axis, and makes adjustments to it according to specific conditions.
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void preStep(StepEvent e) {
 
        if(this.getPosition().x<limitLeft && direction == 1)
            this.startWalking(2);
        
        else if(this.getPosition().x>limitRight && direction == -1) 
            this.startWalking(-2);
        
        else if(this.getPosition().x<=limitRight || this.getPosition().x>=limitLeft)
            direction *= -1;
    }

    /**
     * In-built method automatically added alongside method preStep() (this is left unused)
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void postStep(StepEvent e) {
        
    }
}
