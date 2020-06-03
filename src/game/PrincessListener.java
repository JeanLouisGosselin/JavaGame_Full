package game;

import city.cs.engine.*;

/**
 *
 * @author Jean-Louis
 */
public class PrincessListener implements CollisionListener {
    
    private Game game;
    private Soldier hero;
    
    /**
     * Constructor of PrincessListener class
     * @param game parameter of class Game, used to gain access to the Soldier class instance's fields
     */
    public PrincessListener(Game game) {
        
        this.game = game;
    }

    /**
     * This in-built method specific to the CollisionListener interface (inherited and overriden by PrincessListener class)  detects whether the instance of class Princess has been touched by the current instance of Soldier class.
     * @param e automatic parameter set for any class which implements an interface.
     */
    @Override
    public void collide(CollisionEvent e) {
        
        hero = game.getPlayer();
        
        if(e.getOtherBody() == hero && game.isCurrentLevelCompleted()) {
            System.out.println("Mission accomplished, soldier! Princess saved!");
            game.goNextLevel(hero.getLife());
        }
    }
}
