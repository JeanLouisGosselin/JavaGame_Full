package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
    
public class DeadlySpaceship extends Walker implements StepListener{
    
    private static final Shape spaceShipShape = new PolygonShape(
        -0.31f,1.47f, -3.16f,-0.01f, -0.25f,-1.24f, 2.76f,-0.02f, -0.29f,1.47f);
    
    private static final BodyImage spaceShipImage = new BodyImage("data/spaceship.png", 2.25f);
    
    private int direction;
    private float limitLeft, limitRight;
   
    /**
     * Constructor of DeadlySpaceship class (this class is a subclass of Walker class, which itself inherits features from StepListener interface)
     * @param world current instance of World class
     * @param x variable of type float which sets the leftmost x coordinate to where the instance of DeadlySpaceship can go to (before switching course)
     * @param y variable of type float which sets the rightmost x coordinate to where the instance of DeadlySpaceship can go to (before switching course)
     */
    public DeadlySpaceship(World world, float x, float y) {
         
        super(world, spaceShipShape);       
        addImage(spaceShipImage);

        direction = 1;
        
        limitLeft = x;
        limitRight = y;
    }

    /**
     *This in-built method specific to StepListener interface (inherited and overriden by DeadlySpaceship class) follows the ongoing motion of instance of DeadleySpaceship on the horizontal axis, and makes adjustments to it according to specific conditions
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void preStep(StepEvent e) {
        
        if(this.getPosition().x<limitLeft && direction == 1)
            this.startWalking(3);
        
        else if(this.getPosition().x>limitRight && direction == -1) 
            this.startWalking(-3);
        
        else if(this.getPosition().x<=limitRight|| this.getPosition().x>=limitLeft)
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


