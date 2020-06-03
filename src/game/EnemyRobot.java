package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class EnemyRobot extends Walker implements StepListener{
    
    private static final Shape enemyShape = new PolygonShape(
        -1.39f,1.45f, -1.44f,-1.16f, 0.92f,-1.17f, 1.45f,-0.09f, 0.99f,1.49f);
    
    private static final BodyImage robotImageLeft = new BodyImage("data/robotLeft.png", 3.25f);
    private static final BodyImage robotImageRight = new BodyImage("data/robotRight.png", 3.25f);
    
    int direction;
    
    float limitLeft, limitRight;
    
    /**
     *Constructor of class Drone (this class is a subclass of Walker class, which itself inherits features from StepListener interface)
    * @param world current instance of class World
     * @param x variable of type float which sets the leftmost x coordinate to where the instance of Drone can go to (before switching course)
     * @param y variable of type float which sets the rightmost x coordinate to where the instance of Drone can go to (before switching course)
     */
    public EnemyRobot(World world, float x, float y) {
         
        super(world, enemyShape);        
        addImage(robotImageLeft);
        
        direction = 1;
        
        limitLeft = x;
        limitRight = y;
    }

    /**
     *This in-built method specific to StepListener interface follows the ongoing motion of instance of EnemyRobot on the horizontal axis, and makes adjustments to it according to specific conditions
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void preStep(StepEvent e) {
        
        if(this.getPosition().x<limitLeft && direction == 1){
            this.startWalking(2);
            this.removeAllImages();          
            this.addImage(robotImageRight); 
        }
        
        else if(this.getPosition().x>limitRight && direction == -1){ 
            this.startWalking(-2);
            this.removeAllImages();           
            this.addImage(robotImageLeft);  
        }
        
        else if(this.getPosition().x<=limitRight || this.getPosition().x>=limitLeft){
            direction *= -1;            
        }
    }

    /**
     *In-built method automatically added alongside method preStep() (this is left unused)
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void postStep(StepEvent e) {
        
    }
}
