package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class SnowLeopard extends Walker implements StepListener{
    
    private static final Shape leopardShape = new PolygonShape(
        -1.97f,1.0f, -1.97f,-1.15f, 2.57f,-1.2f, 2.5f,0.97f);
    
    private static final BodyImage leopardImageLeft = new BodyImage("data/walkingAlienLeft.gif", 3.25f);
    private static final BodyImage leopardImageRight = new BodyImage("data/walkingAlienRight.gif", 3.25f);
    
    int direction;
    float limitLeft, limitRight;
    
    /**
      *Constructor of class SnowLeopard (this class is a subclass of Walker class, which itself inherits features from StepListener interface)
    * @param world current instance of class World
     * @param x variable of type float which sets the leftmost x coordinate to where the instance of SnowLeopard can go to (before switching course)
     * @param y variable of type float which sets the rightmost x coordinate to where the instance of SnowLeopard can go to (before switching course)
     */
    public SnowLeopard(World world, float x, float y) {
         
        super(world, leopardShape);        
        addImage(leopardImageLeft);
        
        direction = 1;
        
        limitLeft = x;
        limitRight = y;
    }
      
    /**
     *This in-built method specific to StepListener interface follows the ongoing motion of instance of FlyingZombie on the horizontal axis, and makes adjustments to it according to specific conditions
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void preStep(StepEvent e) {

        if(this.getPosition().x<limitLeft && direction == 1){
            this.startWalking(5);
        this.removeAllImages();          
           this.addImage(leopardImageRight);
        }
        
        else if(this.getPosition().x>limitRight && direction == -1){ 
            this.startWalking(-5);
                   this.removeAllImages();           
           this.addImage(leopardImageLeft);
        }
        
        else if(this.getPosition().x<=limitRight || this.getPosition().x>=limitLeft)
            direction *= -1;
    }

    /**
     *In-built method automatically added alongside method preStep() (this is left unused)
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void postStep(StepEvent e) {}

}
