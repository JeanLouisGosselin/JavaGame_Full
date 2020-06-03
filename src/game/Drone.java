package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class Drone extends Walker implements StepListener{
    
    private static final Shape droneShape = new PolygonShape(
        -4.41f,1.51f, -4.43f,-1.55f, 4.43f,-1.51f, 4.43f,1.57f);
    
    private static final BodyImage droneImageLeft = new BodyImage("data/droneLeft.gif", 3.25f);
    private static final BodyImage droneImageRight = new BodyImage("data/droneRight.gif", 3.25f);
    
    int direction;
    float limitLeft, limitRight;
    
    /**
     * Constructor of class Drone (this class is a subclass of Walker class, which itself inherits features from StepListener interface)
     * @param world current instance of class World
     * @param x variable of type float which sets the leftmost x coordinate to where the instance of Drone can go to (before switching course)
     * @param y variable of type float which sets the rightmost x coordinate to where the instance of Drone can go to (before switching course)
     */
    public Drone(World world, float x, float y) {
         
        super(world, droneShape);        
        addImage(droneImageLeft);
        
        direction = 1;
        
        limitLeft = x;
        limitRight = y;
    }

    /**
     *This in-built method specific to StepListener interface follows the ongoing motion of instance of Drone on the horizontal axis, and makes adjustments to it according to specific conditions
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void preStep(StepEvent e) {

        if(this.getPosition().x<limitRight && direction == 1)
            this.startWalking(3);
        
        else if(this.getPosition().x>limitLeft && direction == -1) 
            this.startWalking(-3);
        
        else if(this.getPosition().x<=limitLeft || this.getPosition().x>=limitRight)
            direction *= -1;
               
        if(direction == 1){
           this.removeAllImages();          
           this.addImage(droneImageRight);          
        }
        else{
           this.removeAllImages();           
           this.addImage(droneImageLeft);           
        }
    }

    /**
     *In-built method automatically added alongside method preStep() (this is left unused)
     * @param e in-built parameter to method preStep() of type StepEvent
     */    
    @Override
    public void postStep(StepEvent e) {}

}
