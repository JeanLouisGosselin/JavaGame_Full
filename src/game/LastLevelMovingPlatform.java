package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class LastLevelMovingPlatform extends StaticBody implements StepListener{
    
    private static final Shape platformShape = new PolygonShape(
        -3.22f,0.73f, -3.25f,-0.7f, 3.22f,-0.71f, 3.22f,0.7f);
    
    private static final BodyImage platformImage = new BodyImage("data/brickPlatform.png", 3.25f);
    
    private float direction;
    
    float limitUp, limitDown;
    
    private Vec2 v;
    
    /**
     *Constructor of class LastLevelMovingPlatform (this class is a subclass of StaticBody class, which itself inherits features from StepListener interface)
    * @param world current instance of class World
     * @param up variable of type float representing the upper y coordinate to which the platform can move
     * @param down variable of type float representing the lower y coordinate to which the platform can move
     * @param v parameter of Vec2 class, the x and y values of which are used to follow the instance's position step by step
     * @param dir a variable of float type indicating the speed at which the instance must move
     */
    public LastLevelMovingPlatform(World world, float up, float down, Vec2 v, float dir) {
         
        super(world, platformShape);        
        addImage(platformImage);
        
        direction = dir;
        
        limitUp = up;
        limitDown = down;
        
        this.v = new Vec2(v); 
    }
      
    /**
     *This in-built method specific to StepListener interface follows the ongoing motion of instance of FlyingZombie on the horizontal axis, and makes adjustments to it according to specific conditions
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void preStep(StepEvent e) {

        if(this.getPosition().y<limitUp && direction == 0.05f){
            v.y = v.y + direction;
            this.setPosition(v);
        }
        
        else if(this.getPosition().y>limitDown && direction == -0.05f){
            v.y = v.y + direction;
            this.setPosition(v);
        }
        
        else if(this.getPosition().y<=limitDown || this.getPosition().y>=limitUp)
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
