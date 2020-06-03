package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class FlyingZombie extends Walker implements StepListener{
    
    private static final Shape zombieShape = new PolygonShape(
        -1.36f,1.29f, -1.39f,-1.3f, 0.5f,-1.28f, 1.42f,-0.17f, 1.26f,1.1f);
    
    private static final BodyImage zombieImageLeft = new BodyImage("data/zombieLeft.gif", 3.25f);
    private static final BodyImage zombieImageRight = new BodyImage("data/zombieRight.gif", 3.25f);
    
    int direction;
    
    float limitLeft, limitRight;
    
    /**
      *Constructor of class FlyingZombie (this class is a subclass of Walker class, which itself inherits features from StepListener interface)
    * @param world current instance of class World
     * @param x variable of type float which sets the leftmost x coordinate to where the instance of FlyingZombie can go to (before switching course)
     * @param y variable of type float which sets the rightmost x coordinate to where the instance of FlyingZombie can go to (before switching course)
     */
    public FlyingZombie(World world, float x, float y) {
         
        super(world, zombieShape);        
        addImage(zombieImageLeft);
        
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

        if(this.getPosition().x>limitLeft && direction == -1)
            this.startWalking(-6);
        
        else if(this.getPosition().x<limitRight && direction == 1) 
            this.startWalking(6);
        
        else if(this.getPosition().x>=limitLeft || this.getPosition().x<=limitRight)
            direction *= -1;
        
        if(direction == 1){
           this.removeAllImages();          
           this.addImage(zombieImageRight);          
        }
        else{
           this.removeAllImages();           
           this.addImage(zombieImageLeft);           
        }
    }

    /**
      *In-built method automatically added alongside method preStep() (this is left unused)
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void postStep(StepEvent e) {}
}
