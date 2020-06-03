package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class MobilePlatform extends StaticBody implements StepListener{
    
    private static final Shape platformShape = new PolygonShape(
        -1.8f,1.62f, -1.79f,-1.59f, 1.78f,-1.6f, 1.78f,1.62f);
    
    private static final BodyImage platformImage = new BodyImage("data/iceBrick.png", 3.25f);
    
    private float direction;
    
    float limitLeft, limitRight;
    
    private Vec2 v;
    
    /**
     Constructor of class MobilePlatform (this class is a subclass of StaticBody class, which itself inherits features from StepListener interface)
    * @param world current instance of class World
     * @param x variable of type float representing the upper y coordinate to which the platform can move
     * @param y variable of type float representing the lower y coordinate to which the platform can move
     * @param v parameter of Vec2 class, the x and y values of which are used to follow the instance's position step by step
      */
    public MobilePlatform(World world, float x, float y, Vec2 v) {
         
        super(world, platformShape);        
        addImage(platformImage);
        
        direction = 0.05f;
        
        limitLeft = x;
        limitRight = y;
        
        this.v = new Vec2(v); 
    }
      
    /**
     *This in-built method specific to StepListener interface follows the ongoing motion of instance of FlyingZombie on the horizontal axis, and makes adjustments to it according to specific conditions
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void preStep(StepEvent e) {

        if(this.getPosition().x<limitRight && direction == 0.05f){
            v.x = v.x + direction;
            this.setPosition(v);
        }
        
        else if(this.getPosition().x>limitLeft && direction == -0.05f){
            v.x = v.x + direction;
            this.setPosition(v);
        }
        
        else if(this.getPosition().x<=limitLeft || this.getPosition().x>=limitRight)
            direction *= -1;
    }

    /**
     * This in-built ethod is automatically called whenever we implement the StepListener class
     * This method is not used.
     * @param e a variable of class StepEvent
     */
    @Override
    public void postStep(StepEvent e) {}

}
