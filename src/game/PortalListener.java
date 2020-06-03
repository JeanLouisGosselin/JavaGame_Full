package game;

import city.cs.engine.*;

/**
 *
 * @author Jean-Louis
 */
public class PortalListener implements CollisionListener {
    
    private Game game;
    private Soldier hero;
    
    /**
     * Constructor of PortalListener class
     * @param game parameter of class Game, used to gain access to the Soldier class instance's fields
     */
    public PortalListener(Game game) {
        
        this.game = game;
    }

    /**
     * This in-built method specific to the CollisionListener interface (inherited and overriden by PortalListener class)  detects whether the instance of class Portal has been touched by the current instance of Soldier class.
     * @param e automatic parameter set for any class which implements an interface.
     */
    @Override
    public void collide(CollisionEvent e) {
        
        hero = game.getPlayer();
        
        if (e.getOtherBody() == hero && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            //game.delete
            game.goNextLevel(hero.getLife());
        }
    }
}

