package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class Level3 extends GameLevel {
    
    private Game thisCurrentGame;
    private Soldier hero;
    private DeadlySpaceship spaceship;
    private Princess princess;
    private Cage cage;
    private Portal portal;
    private FireWall leftWall1, rightWall1, leftWall2, rightWall2;
    private LittleFire fire1, fire2;
    private Key key;
    private LifeReplenish lifeHeart;
    private GroundPlatformLevel3 groundPlat;
    private FlyingZombie zombie1, zombie2, zombie3, zombie4, zombie5, zombie6, zombie7,
                            zombie8, zombie9, zombie;
    private LastLevelMovingPlatform movingPlat1, movingPlat2;
       
    @Override
    public void populate(Game game) {
        
        super.populate(game);
        
        numKeys = 1;

        thisCurrentGame = game;
        
        //Soldier object:
        hero = new Soldier(this);
        hero.setPosition(setHeroPosition(12.7f, 1.7f));
        
        //Cage object (hiding the portal until all starts are collected)
        cage = new Cage(this, hero, numKeys);
        cage.setPosition(setCagePosition(20.2f, 1.7f));
        cage.addCollisionListener(new CageListener(game));

        princess = new Princess(this);
        princess.setPosition(setPrincessPosition(20.2f, 1.7f));
        princess.addCollisionListener(new PrincessListener(game));

        key = new Key(this);
        key.setPosition(setKeyPosition(-19.5f, 1.2f));
        key.addCollisionListener(new SoldierListener(hero, game));
        
        lifeHeart = new LifeReplenish(this);
        lifeHeart.setPosition(setEnergyHeartPosition(-17, .8f));
        lifeHeart.addCollisionListener(new SoldierListener(hero, game));

        ////////////////////////////    flying zombies:    ///////////////////////////
    
        float left2 = 2;
        float right2 = 19;
        zombie1 = new FlyingZombie(this, left2, right2);
        zombie1.setPosition(setZombiePosition(4, -7.7f));
        zombie1.setGravityScale(0);
        zombie1.startWalking(-6);
        this.addStepListener(zombie1);
       
        float left3 = 2;
        float right3 = 19;
        zombie2 = new FlyingZombie(this, left3, right3);
        zombie2.setPosition(setZombiePosition(8, -5f));
        zombie2.setGravityScale(0);
        zombie2.startWalking(-6);
        this.addStepListener(zombie2);
      
        float left4 = -19;
        float right4 = -2;
        zombie3 = new FlyingZombie(this, left4, right4);
        zombie3.setPosition(setZombiePosition(-15.5f, -7.7f));
        zombie3.setGravityScale(0);
        zombie3.startWalking(-6);
        this.addStepListener(zombie3);
      
        float left5 = -19;
        float right5 = -2;
        zombie4 = new FlyingZombie(this, left5, right5);
        zombie4.setPosition(setZombiePosition(-10.5f, -5f));
        zombie4.setGravityScale(0);
        zombie4.startWalking(-6);
        this.addStepListener(zombie4);
       
        float left6 = -14;
        float right6 = -10;
        zombie5 = new FlyingZombie(this, left6, right6);
        zombie5.setPosition(setZombiePosition(-12, -0.2f));
        zombie5.setGravityScale(0);
        zombie5.startWalking(-6);
        this.addStepListener(zombie5);
        
        float left7 = 7;
        float right7 = 10;
        zombie6 = new FlyingZombie(this, left7, right7);
        zombie6.setPosition(setZombiePosition(8, -0.2f));
        zombie6.setGravityScale(0);
        zombie6.startWalking(-6);
        this.addStepListener(zombie6);  
       
        float left8 = -19;
        float right8 = -3;
        zombie7 = new FlyingZombie(this, left8, right8);
        zombie7.setPosition(setZombiePosition(-8, 7f));
        zombie7.setGravityScale(0);
        zombie7.startWalking(-6);
        this.addStepListener(zombie7);
                
        float left9 = 3;
        float right9 = 19;
        zombie8 = new FlyingZombie(this, left9, right9);
        zombie8.setPosition(setZombiePosition(8, 7f));
        zombie8.setGravityScale(0);
        zombie8.startWalking(-6);
        this.addStepListener(zombie8); 
      
        float left10 = -18;
        float right10 = -4;
        zombie9 = new FlyingZombie(this, left10, right10);
        zombie9.setPosition(setZombiePosition(-7, 10f));
        zombie9.setGravityScale(0);
        zombie9.startWalking(-6);
        this.addStepListener(zombie9); 
        
        float left11 = 4;
        float right11 = 18;
        zombie = new FlyingZombie(this, left11, right11);
        zombie.setPosition(setZombiePosition(7, 10f));
        zombie.setGravityScale(0);
        zombie.startWalking(-6);
        this.addStepListener(zombie); 
        
////////////////////////////////// all platforms: //////////////////////////////

        groundPlat = new GroundPlatformLevel3(this);
        groundPlat.setPosition(setBasePlatformPosition(0, -11.5f));
        
        //Princess platform:
        Shape smallPlatformShape = new BoxShape(5, 0.3f);       
        Body princessPlatform = new StaticBody(this, smallPlatformShape);
        princessPlatform.setPosition(setUpperPlatform(17, 0));
        princessPlatform.setFillColor(Color.black);
        
        //key platform:
        Shape smallPlatformShape2 = new BoxShape(2.5f, 0.3f);       
        Body keyPlatform = new StaticBody(this, smallPlatformShape2);
        keyPlatform.setPosition(setUpperPlatform(-19, 0));
        keyPlatform.setFillColor(Color.black);
        
        float up1 = 2.5f;
        float down1 = -2.5f;
        float direction1 = 0.05f;
        movingPlat1 = new LastLevelMovingPlatform(this, up1, down1, new Vec2(-5, 0), direction1); //-5, 0
        this.addStepListener(movingPlat1);
        
        float up2 = 2.5f;
        float down2 = -2.5f;
        float direction2 = -0.05f;
        movingPlat2 = new LastLevelMovingPlatform(this, up2, down2, new Vec2(2, 0), direction2); //2, 0
        this.addStepListener(movingPlat2);
                        
////////////////////////////////// Both firewalls: //////////////////////////////

        int space1 = 0;
        for(int i=0; i<40; i++){
            
            leftWall1 = new FireWall(this);
            leftWall1.setPosition(setFirewallLeftPosition(-23, -20+space1));
            leftWall1.addCollisionListener(new SoldierListener(hero, game));
            
            leftWall2 = new FireWall(this);
            leftWall2.setPosition(setFirewallLeftPosition(-24.2f, -20+space1));
            leftWall2.addCollisionListener(new SoldierListener(hero, game));
            
            space1 += 2;
        }
        

        int space2 = 0;
        for(int i=0; i<40; i++){
            
            rightWall1 = new FireWall(this);
            rightWall1.setPosition(setFirewallRightPosition(23, -20+space2));
            rightWall1.addCollisionListener(new SoldierListener(hero, game));
            
            rightWall2 = new FireWall(this);
            rightWall2.setPosition(setFirewallRightPosition(24.2f, -20+space2));
            rightWall2.addCollisionListener(new SoldierListener(hero, game));
            
            space2 += 2;
        }
        
    /////////////////////////////// METHOD FOR MAKING SPACHIP SHOOT
          
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
    
    //@Override
    public Vec2 setPrincessPosition(float x, float y) {
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

    public Vec2 setFirewallLeftPosition(float x, float y){
        return new Vec2(x, y);
    }

    public Vec2 setFirewallRightPosition(float x, float y){
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
       return getPlayer().getKeys() == numKeys;
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
    
    public Vec2 setZombiePosition(float x, float y){
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