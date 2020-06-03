/*
This CONTROLLER class includes all code for object movement + object collision
*/

package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jean-Louis
 */
public class Controller extends KeyAdapter {
    
    private static final float JUMPING_SPEED = 16;
    private static final float WALKING_SPEED = 6;
    
    private Soldier soldier;
    
    private WorldView view;
    
    /**
     *Constructor of instance of Controller class
     * @param s instance of class Soldier
     */
    public Controller(Soldier s) {        
        this.soldier = s;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        // 0 = quit
        if (code == KeyEvent.VK_0) 
            System.exit(0); 
        
        // J = jump
        else if (code == KeyEvent.VK_J) {
            
            Vec2 v = soldier.getLinearVelocity();
            // only jump if body is not already jumping           
            if (Math.abs(v.y) < 0.01f) 
                soldier.jump(JUMPING_SPEED);          
        } 
        
        // Q = walk left (NOTE: negative value)
        else if (code == KeyEvent.VK_Q){
            soldier.startWalking(-WALKING_SPEED); 
            soldier.removeAllImages();
            soldier.imageChangeLeft();
        }
        
        // T = walk right (here: positive value)
        else if (code == KeyEvent.VK_T) {           
            soldier.startWalking(WALKING_SPEED);
            soldier.removeAllImages();
            soldier.imageChangeRight();          
        }

    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_Q){
            soldier.stopWalking();
            soldier.showStillImageLeft();
        }       
        else if (code == KeyEvent.VK_T){
            soldier.stopWalking();
            soldier.showStillImageRight();
        }
    }
    
    /**
     * This method sets the body of the instance of class Soldier
     * @param s instance of Soldier class
     */
    public void setBody(Soldier s) {
        this.soldier = s;
    }
}
