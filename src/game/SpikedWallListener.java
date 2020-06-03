package game;

import city.cs.engine.*;

/**
 *
 * @author Jean-Louis
 */
public class SpikedWallListener implements CollisionListener {
    
    private Game game;
    private Soldier hero;
    
    /**
     * Constructor of PrincessListener class
     * @param game parameter of class Game, used to gain access to the Soldier class instance's fields
     */
    public SpikedWallListener(Game game) {
        
        this.game = game;
    }

    /**
     * This in-built method specific to the CollisionListener interface (inherited and overriden by PrincessListener class)  detects whether the instance of class Princess has been touched by the current instance of Soldier class.
     * @param e automatic parameter set for any class which implements an interface.
     */
    @Override
    public void collide(CollisionEvent e) {
        
        hero = game.getPlayer();
        
        if (e.getOtherBody() == hero) {
            if(e.getReportingBody() instanceof SpikedWall && hero.getKeys() >= game.getSomeOfKeys())
                e.getReportingBody().destroy();
        }
    }
}
