package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class Tracker implements StepListener {
    
    private WorldView view;
    private Body body;

    /**
     * Constructor of class Tracker.
     * Any instance of this class is used to zoom in and follow a chosen instance of another class on the screen.
     * @param view parameter of class WolrdView
     * @param body parameter of class Body
     */
    public Tracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;
    }

    /**
    * In-built method automatically added alongside method postStep() (this is left unused)
     * @param e in-built parameter to method preStep() of type StepEvent
     */
    @Override
    public void preStep(StepEvent e) {
    }

    /**
     * *
    * In-built method automatically added alongside method pretStep().
    * This generates a constant flow of new Vec2 instances, each time placing the chosen instance at the centre of the screen.
     * @param e automatic parameter set for any class which implements an interface.
     */
    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(body.getPosition().x, body.getPosition().y));
    }   
}
