package game;

import city.cs.engine.*;

/**
 *
 * @author Jean-Louis
 */
public class CageListener implements CollisionListener {
    
    private Game game;
    private Soldier hero;
    
    /**
     * Constructor of class CageListener, which inherits features of interface CollisionListener 
     * @param game current object of class Game (enabling us, for instance, to get access to current instance of Soldier class and the current values of its associated fields).
     */
    public CageListener(Game game) {
        
        this.game = game;
    }

    /**
     * This in-built method specific to the CollisionListener interface (inherited and overriden by CageListener class)  detects whether the instance of class Cage has been touched by the current instance of Soldier class.
     * @param e automatic parameter set for any class which implements an interface.
     */
    @Override
    public void collide(CollisionEvent e) {
        
        hero = game.getPlayer();
        
        if (e.getOtherBody() == hero ) {
            if(e.getReportingBody() instanceof Cage && hero.getKeys() == game.getNumAllKeys())
                e.getReportingBody().destroy();
        }
    }
}
