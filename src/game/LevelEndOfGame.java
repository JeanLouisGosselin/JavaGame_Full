package game;

import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class LevelEndOfGame extends GameLevel{
    
    private Game thisCurrentGame;
    private Soldier hero;
    private EnemyRobot robot1, robot2;
    private DeadlySpaceship spaceship;
    private Princess princess;
    private Portal portal;
    private FireWall leftWall, rightWall;
    private Key keys;
    private LifeReplenish lifeHeart;
    private int numKeys, someKeys;
    
    @Override
    public void populate(Game game){
        super.populate(game);
        thisCurrentGame = game;
    }

    @Override    
    public Soldier getPlayer(){          
        return hero;
    } 
       
    @Override
    public Vec2 setHeroPosition(float x, float y) {
        return new Vec2(x, y);
    }
    
    @Override
    public Vec2 setPortalPosition(float x, float y) {
        return new Vec2(x, y);
    } 
    
    @Override
    public Vec2 setCagePosition(float x, float y){
        return new Vec2(x, y);
    }
 
    @Override
    public Vec2 setKeyPosition(float x, float y){
        return new Vec2(x, y);
    }
    
    @Override
    public Vec2 setEnergyHeartPosition(float x, float y){
        return new Vec2(x, y);
    }
    
    @Override
    public Vec2 setBasePlatformPosition(float x, float y){
        return new Vec2(x, y);
    }
    
    @Override
    public Vec2 setMiddleLowPlatform(float x, float y){
        return new Vec2(x, y);       
    }
    
    @Override
    public Vec2 setMiddleHighPlatform(float x, float y){
        return new Vec2(x, y);       
    }
    
    @Override
    public Vec2 setUpperPlatform(float x, float y){
        return new Vec2(x, y);       
    }

    
    @Override
    public boolean reachedAllKeys(){
        return (hero.getKeys() == numKeys);
    }

    @Override
    public boolean isCompleted() {       
        return getPlayer().getKeys() == numKeys;
    }
    
    @Override
    public boolean isFinished(){
        
        if(thisCurrentGame.getLevelNumber() == 4)
            return true;
        else 
            return false;
    }
    
    @Override
    public int getCurrentNumberOfKeys(){
        return getPlayer().getKeys();
    }
        
    @Override
    public int getKeyLimitInLevel(){
        return numKeys;
    }

    
    @Override
    public Vec2 setGroundTwoPosition(float y, float x){        
        return new Vec2(x, y);
    }
    
    @Override
    public Vec2 setMiniPlatformLevel2Position(float y, float x){
        return new Vec2(x, y);
    }
    
    @Override
    public int getTotalKeys(){
        return numKeys;
    }
    
    @Override
    public Vec2 setSpikedWallPosition(float x, float y){
        return new Vec2(x, y);
    }

    @Override
    public Vec2 setLowerMidWall(float x, float y){
        return new Vec2(x, y);
    }
    
    @Override
    public Vec2 setUpperMidWall(float x, float y){
        return new Vec2(x, y);
    }
    
    @Override
    public int getSomeKeys(){
        return someKeys;
    }
 
}
