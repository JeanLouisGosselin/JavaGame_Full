package game;

import city.cs.engine.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Jean-Louis
 */
public class SoldierListener implements CollisionListener {
    
    private Soldier hero;
    private SoundClip contact;
    private Game game;
    
    /**
     * Constructor of SoldierListener class.
     * @param s parameter of Soldier class
     * @param game parameter of Game class
     */
    public SoldierListener(Soldier s, Game game) {       
        this.hero = s;
        this.game = game;
        contact = this.game.getOuch();
    }

    /**
     * This in-built method specific to the CollisionListener interface (inherited and overriden by PortalListener class) detects whether any instance of the following classes has been touched by the current instance of Soldier class:
     * LifeReplenish
     * EnemyRobot
     * FireWall
     * FlyingZombie
     * LittleFire
     * Drone
     * SnowLeopard
     * GroundSpikes
     * SpikedWall
     * Cage
     * Key
     * 
     * Crucially, this method also determines whether or not an instance of Soldier class has: lost all energy, or lost all lives.
     * @param e automatic parameter set for any class which implements an interface.
      */
    @Override
    public void collide(CollisionEvent e) {
     
        if (e.getOtherBody() == hero) {
            
            if (e.getReportingBody() instanceof LifeReplenish){
                
                hero.increaseEnergy();
                e.getReportingBody().destroy();
            }
            
            //
            
            else if (e.getReportingBody() instanceof FireWall){
                
                hero.decrementEnergy();
                
                if(game.getPlayer().getEnergy() > 0){
                    contact = game.getOuch();
                    contact.play();                                                      
                }
                else{
                    contact = game.soldierDies();
                    contact.play();               
                }
            }
            
            else if (e.getReportingBody() instanceof EnemyRobot){
                
                hero.decrementEnergy();
                
                if(game.getPlayer().getEnergy() > 0){
                    contact = game.getOuch();
                    contact.play();                                                      
                }
                else{
                    contact = game.soldierDies();
                    contact.play();               
                }
            }
            
            else if (e.getReportingBody() instanceof DeadlySpaceship){
                
                hero.decrementEnergy();
                
                if(game.getPlayer().getEnergy() > 0){
                    contact = game.getOuch();
                    contact.play();                                                      
                }
                else{
                    contact = game.soldierDies();
                    contact.play();               
                }
            }
            
            else if (e.getReportingBody() instanceof FlyingZombie){

                hero.decrementEnergy();
                
                if(game.getPlayer().getEnergy() > 0){
                    contact = game.getOuch();
                    contact.play();                                                      
                }
                else{
                    contact = game.soldierDies();
                    contact.play();               
                }
            }
                           
            else if (e.getReportingBody() instanceof LittleFire){
                
                hero.decrementEnergy();
                
                if(game.getPlayer().getEnergy() > 0){
                    contact = game.getOuch();
                    contact.play();                                                      
                }
                else{
                    contact = game.soldierDies();
                    contact.play();               
                }
            }
            
            else if (e.getReportingBody() instanceof Drone){
                
                hero.decrementEnergy();
                
                if(game.getPlayer().getEnergy() > 0){
                    contact = game.getOuch();
                    contact.play();                                                      
                }
                else{
                    contact = game.soldierDies();
                    contact.play();               
                }
            }
            
            else if (e.getReportingBody() instanceof SnowLeopard){
                
                hero.decrementEnergy();
                
                if(game.getPlayer().getEnergy() > 0){
                    contact = game.getOuch();
                    contact.play();                                                      
                }
                else{
                    contact = game.soldierDies();
                    contact.play();               
                }
            }
         
            else if (e.getReportingBody() instanceof GroundSpikes){
                
                hero.decrementEnergy();
                
                if(game.getPlayer().getEnergy() > 0){
                    contact = game.getOuch();
                    contact.play();                                                      
                }
                else{
                    contact = game.soldierDies();
                    contact.play();               
                }
            }
            
            else if (e.getReportingBody() instanceof SpikedWall){
                
                hero.decrementEnergy();
                
                if(game.getPlayer().getEnergy() > 0){
                    contact = game.getOuch();
                    contact.play();                                                      
                }
                else{
                    contact = game.soldierDies();
                    contact.play();               
                }
                
                if(hero.getKeys() == game.getSomeOfKeys()){
                    e.getReportingBody().destroy(); 
                    contact = game.destroyWall();
                    contact.play();
                }
            }            
      
            else if (e.getReportingBody() instanceof Cage){
                
                if(hero.getKeys() == game.getNumAllKeys()){
                    e.getReportingBody().destroy(); 
                    contact = game.getUnlockCage();
                    contact.play();
                }
            }
            
            else if (e.getReportingBody() instanceof Key){

                hero.earnKeys();
                e.getReportingBody().destroy();
                contact = game.getKaching();
                contact.play();
                
                if(hero.getKeys() == game.getSomeOfKeys()){
                    contact = game.getWoohoo();
                    contact.play();                                       
                }
                else if(hero.getKeys() == game.getNumAllKeys()){
                    contact = game.getYeah();
                    contact.play(); 
                }
            }  
        }
        
        if(hero.getEnergy() <= 0)
            game.backToLevelStart();
        
        if(hero.getLife() <= 0)
            game.gameIsOver();
            
    }     
}
