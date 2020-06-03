package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class Level1 extends GameLevel {
    
    private Game thisCurrentGame;
    private Soldier hero;
    private EnemyRobot robot1, robot2;
    private DeadlySpaceship spaceship1, spaceship2, spaceship3;
    private Portal portal;
    private LeftSpikedWall leftSpikes;
    private RightSpikedWall rightSpikes;
    private Key key1, key2, key3, key4, key5, key6, key7, key8, key9, key10;
    private LifeReplenish lifeHeart;
    private Cage cage;
    private FireWall littleFire1, littleFire2, littleFire3, littleFire4, littleFire5, littleFire6;
    private SpikedWall spikedWall;
    private GroundSpikes groundSpikes;
    
    private int flag;
    
    private float   xHero, yHero,
                    xRobot1, yRobot1, 
                    xRobot2, yRobot2,
                    xSpaceship, ySpaceship,
                    xPortal, yPortal,
                    xLeftWall, yLeftWall,
                    xRightWall, yRightWall,
                    xHeart, yHeart;
       
    @Override
    public void populate(Game game) {
        
        thisCurrentGame = game;
        
        super.populate(game);
        
        xHero = 8;
        yHero = -10;
        xRobot1 = 3;
        yRobot1 = 0;      
        xRobot2 = -8;
        yRobot2 = -8;       
        xSpaceship = 0;
        ySpaceship = 10;
        xPortal = 10;
        yPortal = 10;
        
        numKeys = 10;
        someKeys = 5;
        
        flag = 0;
                     
////////////////////////////  all 4 characters in the game: //////////////////////////////

        thisCurrentGame = game;
        
        //Soldier object:
        hero = new Soldier(this);
        hero.setPosition(setHeroPosition(8, -10)); //originally: (8, -10)

        //Cage object (hiding the portal until all starts are collected)
        cage = new Cage(this, hero, numKeys);
        cage.setPosition(setCagePosition(10, 10.3f));
        cage.addCollisionListener(new CageListener(game));

        //Portal object (+ collision with SOLDIER)
        portal = new Portal(this);
        portal.setPosition(setPortalPosition(10, 10));
        portal.addCollisionListener(new PortalListener(game));
        
        //double-sided Spiked Wall: 
        float x = 18;
        float y = 22.2f;
        float limitLeft = 13.8f;
        float limitRight = 20;
        spikedWall = new SpikedWall(this, limitLeft, limitRight);
        spikedWall.setPosition(setSpikedWallPosition(x, y));
        spikedWall.setGravityScale(0);
        this.addStepListener(spikedWall);
        spikedWall.addCollisionListener(new SoldierListener(hero, game));
        spikedWall.startWalking(-2);        
      
        //DeadlySpaceship object (+ collision with SOLDIER):
        float left1 = -19;
        float right1 = 8;
        spaceship1 = new DeadlySpaceship(this, left1, right1);
        spaceship1.setPosition(setDeadlySpaceshipPosition(0, 6.8f));
        spaceship1.setGravityScale(0);
        this.addStepListener(spaceship1);
        spaceship1.addCollisionListener(new SoldierListener(hero, game)); 
        spaceship1.startWalking(-3);

        float left2 = -15;
        float right2 = 6;
        spaceship2 = new DeadlySpaceship(this, left2, right2);
        spaceship2.setPosition(setDeadlySpaceshipPosition(-3, 13.1f)); 
        spaceship2.setGravityScale(0);
        this.addStepListener(spaceship2);
        spaceship2.addCollisionListener(new SoldierListener(hero, game)); 
        spaceship2.startWalking(-3);
        
        float left5 = -8;
        float right5 = 9;
        spaceship3 = new DeadlySpaceship(this, left5, right5);
        spaceship3.setPosition(setDeadlySpaceshipPosition(0, 30f)); 
        spaceship3.setGravityScale(0);
        this.addStepListener(spaceship3);
        spaceship3.addCollisionListener(new SoldierListener(hero, game)); 
        spaceship3.startWalking(-3);

    
        //2 EnemyRobot objects (+ collision with SOLDIER):
        float left3 = -10;
        float right3 = -5;
        robot1 = new EnemyRobot(this, left3, right3);
        robot1.setPosition(setEnemyRobotPosition(-8, -8.8f));
        this.addStepListener(robot1);
        robot1.addCollisionListener(new SoldierListener(hero, game));
        robot1.startWalking(-2);
        
        float left4 = -11;
        float right4 = -2;
        robot2 = new EnemyRobot(this, left4, right4);
        robot2.setPosition(setEnemyRobotPosition(-7, 19.6f));
        this.addStepListener(robot2);
        robot2.addCollisionListener(new SoldierListener(hero, game));
        robot2.startWalking(-2);
        
        //////////////////////////////  keys    /////////////////////////////////
        
        key1 = new Key(this);
        key1.setPosition(setKeyPosition(-19.5f, -9.6f)); 
        key1.addCollisionListener(new SoldierListener(hero, game));       
        
        key2 = new Key(this);
        key2.setPosition(setKeyPosition(12, 17.7f)); 
        key2.addCollisionListener(new SoldierListener(hero, game));  
        
        key3 = new Key(this);
        key3.setPosition(setKeyPosition(-15.7f, 31.7f)); 
        key3.addCollisionListener(new SoldierListener(hero, game));  
        
        key4 = new Key(this);
        key4.setPosition(setKeyPosition(-15, 31.7f)); 
        key4.addCollisionListener(new SoldierListener(hero, game));  
        
        key5 = new Key(this);
        key5.setPosition(setKeyPosition(7, -0.5f)); 
        key5.addCollisionListener(new SoldierListener(hero, game));  
        
        key6 = new Key(this);
        key6.setPosition(setKeyPosition(39.1f, 29)); 
        key6.addCollisionListener(new SoldierListener(hero, game));  
        
        key7 = new Key(this);
        key7.setPosition(setKeyPosition(27.1f, 21)); 
        key7.addCollisionListener(new SoldierListener(hero, game)); 
       
        key8 = new Key(this);
        key8.setPosition(setKeyPosition(39.1f, 13)); 
        key8.addCollisionListener(new SoldierListener(hero, game));
        
        key9 = new Key(this);
        key9.setPosition(setKeyPosition(27.1f, 5)); 
        key9.addCollisionListener(new SoldierListener(hero, game));
       
        key10 = new Key(this);
        key10.setPosition(setKeyPosition(39.1f, -3)); 
        key10.addCollisionListener(new SoldierListener(hero, game));
      
////////////////////////////////// life heart: //////////////////////////////

        lifeHeart = new LifeReplenish(this);
        lifeHeart.setPosition(setEnergyHeartPosition(-12, 3.5f));
        lifeHeart.addCollisionListener(new SoldierListener(hero, game));

////////////////////////////////////////////////////////////////////////////////


                            //PLATFORMS LEFT-HAND SIDE
                            
                            
////////////////////////////////////////////////////////////////////////////////
                                   
        //ground platform:
        Shape groundShape = new BoxShape(38, 1.0f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(setBasePlatformPosition(10, -11.5f));
        ground.setFillColor(Color.black);

        
        //long middle-low platform:
        Shape middlePlatformShape = new BoxShape(5, 0.1f);
        Body platform1 = new StaticBody(this, middlePlatformShape);
        platform1.setPosition(setMiddleLowPlatform(5, -1.5f));
        platform1.setFillColor(Color.black);
        
        //short middle-high platform:
        Shape shortMiddlePlatformShape = new BoxShape(3, 0.1f);
        Body platform2 = new StaticBody(this, shortMiddlePlatformShape);
        platform2.setPosition(setMiddleHighPlatform(-12, 3.0f));
        platform2.setFillColor(Color.black);
        
        //Portal platform:
        Shape smallPlatformShape = new BoxShape(5, 0.1f);       
        Body portalPlatform = new StaticBody(this, smallPlatformShape);
        portalPlatform.setPosition(setUpperPlatform(10, 8.7f));
        portalPlatform.setFillColor(Color.black);
        
        //platform on top of portal platform (leading to tunnel)
        Shape platformShape1 = new BoxShape(3, 0.1f);       
        Body otherPlatform1 = new StaticBody(this, platformShape1);
        otherPlatform1.setPosition(setUpperPlatform(10, 16.7f));
        otherPlatform1.setFillColor(Color.black);
        
        //long platform on top of that:
        Shape platformShape2 = new BoxShape(6, 0.1f);       
        Body otherPlatform2 = new StaticBody(this, platformShape2);
        otherPlatform2.setPosition(setLongTopPlatform(-7, 19.7f));
        otherPlatform2.setFillColor(Color.black);
        
        //side platform (upper part)
        Shape platformShape3 = new BoxShape(2, 0.1f);       
        Body otherPlatform3 = new StaticBody(this, platformShape3);
        otherPlatform3.setPosition(setShortLeftPlatform(-14, 30.7f));
        otherPlatform3.setFillColor(Color.black);        
        
/////////////////////////////////// middle wall (2-part) ///////////////////////
        
        //middle wall (low half)
        Shape middleWall1 = new BoxShape(4, 17);       
        Body midWall1 = new StaticBody(this, middleWall1);
        midWall1.setPosition(setLowerMidWall(17, 4.5f));
        midWall1.setFillColor(Color.black);
        
        //middle wall (upper part)
        Shape middleWall2 = new BoxShape(4, 17);       
        Body midWall2 = new StaticBody(this, middleWall2);
        midWall2.setPosition(setUpperMidWall(17, 41.8f));
        midWall2.setFillColor(Color.black);
        
        
////////////////////////////////////////////////////////////////////////////////


                            //PLATFORMS RIGHT-HAND SIDE
                            
                            
////////////////////////////////////////////////////////////////////////////////


        //right platform1:
        Shape rightPlatform1 = new BoxShape(1.5f, 0.1f);       
        Body rightPlat1 = new StaticBody(this, rightPlatform1);
        rightPlat1.setPosition(setPlatRight1(39, 28));
        rightPlat1.setFillColor(Color.black);

        //right platform2:
        Shape rightPlatform2 = new BoxShape(1.5f, 0.1f);       
        Body rightPlat2 = new StaticBody(this, rightPlatform2);
        rightPlat2.setPosition(setPlatRight2(27, 20));
        rightPlat2.setFillColor(Color.black);        
               
        //right platform3:
        Shape rightPlatform3 = new BoxShape(1.5f, 0.1f);       
        Body rightPlat3 = new StaticBody(this, rightPlatform3);
        rightPlat3.setPosition(setPlatRight3(39, 12));
        rightPlat3.setFillColor(Color.black);        
        
        //right platform4:
        Shape rightPlatform4 = new BoxShape(1.5f, 0.1f);       
        Body rightPlat4 = new StaticBody(this, rightPlatform4);
        rightPlat4.setPosition(setPlatRight4(27, 4));
        rightPlat4.setFillColor(Color.black); 
        
        //right platform5:
        Shape rightPlatform5 = new BoxShape(1.5f, 0.1f);       
        Body rightPlat5 = new StaticBody(this, rightPlatform5);
        rightPlat5.setPosition(setPlatRight5(39, -4));
        rightPlat5.setFillColor(Color.black);         

////////////////////////////////// Both spiked walls: //////////////////////////////

        float spikeSpace = 0;
        for(int i=0; i<30; i++){

            leftSpikes = new LeftSpikedWall(this);
            leftSpikes.setPosition(setLeftSpikedWallPosition(-27f, (-8.9f + spikeSpace)));
            leftSpikes.addCollisionListener(new SoldierListener(hero, game));

            rightSpikes = new RightSpikedWall(this);
            rightSpikes.setPosition(setRightSpikedWallPosition(47f, (-8.9f + spikeSpace)));
            rightSpikes.addCollisionListener(new SoldierListener(hero, game));
            
            spikeSpace += 3.1f;
        }
               
////////////////////////////////// spiked ground ///////////////////////////////////
     
        int spikesSpace=0;
        for(int i= 0; i<5; i++){
           groundSpikes = new GroundSpikes(this);
           groundSpikes.setPosition(setGroundSpikesPosition(23.5f + spikesSpace, -8.8f));
           groundSpikes.addCollisionListener(new SoldierListener(hero, game));
           spikesSpace += 5;          
        }
        
///////////////////////////////// small fires /////////////////////////////////

        littleFire1 = new FireWall(this);
        littleFire1.setPosition(setLittleFirePosition(0.3f, -0.2f));
        littleFire1.addCollisionListener(new SoldierListener(hero, game));
        
        littleFire2 = new FireWall(this);
        littleFire2.setPosition(setLittleFirePosition(9.7f, -0.2f));
        littleFire2.addCollisionListener(new SoldierListener(hero, game));
        
        littleFire3 = new FireWall(this);
        littleFire3.setPosition(setLittleFirePosition(-14.5f, 4.2f));
        littleFire3.addCollisionListener(new SoldierListener(hero, game));

    }   
        
    @Override    
    public Soldier getPlayer(){          
        return hero;
    } 

    @Override
    public Vec2 setPortalPosition(float x, float y) {
        return new Vec2(x, y);
    }
    
    @Override
    public Vec2 setCagePosition(float x, float y){
        return new Vec2(x, y);
    }
    


    public Vec2 setEnemyRobotPosition(float x, float y){
        return new Vec2(x, y);
    }

    public Vec2 setDeadlySpaceshipPosition(float x, float y){
        return new Vec2(x, y);
    }
    

    public Vec2 setAmmoBoxPosition(float x, float y){
        return new Vec2(x, y);
    }
    

    public Vec2 setKeyPosition(float x, float y){
        return new Vec2(x, y);
    }
    

    public Vec2 setEnergyHeartPosition(float x, float y){
        return new Vec2(x, y);
    }
    

    public Vec2 setBasePlatformPosition(float x, float y){
        return new Vec2(x, y);
    }
    

    public Vec2 setMiddleLowPlatform(float x, float y){
        return new Vec2(x, y);       
    }
    

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
        return hero.getKeys() == numKeys;
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

    public Vec2 setLittleFirePosition(float x, float y){
        return new Vec2(x, y);         
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

    /**
     * This mutator ("setter" method) sets the x and y coordinates of the instance of GroundSpikes class.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */
    public Vec2 setGroundSpikesPosition(float x, float y){
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
    
/////////////////////////// LEFT-HAND SIDE PLATFORMS ///////////////////////////

    /**
     * This mutator ("setter" method) sets the x and y coordinates of the platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */
    public Vec2 setLongTopPlatform(float x, float y){
        return new Vec2(x, y);
    }
    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */
    public Vec2 setShortLeftPlatform(float x, float y){
        return new Vec2(x, y);
    }
    
    
//////////////////////////// RIGHT-HAND SIDE PLATFORMS /////////////////////////

    /**
     * This mutator ("setter" method) sets the x and y coordinates of the platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */  
    public Vec2 setPlatRight1(float x, float y){
        return new Vec2(x, y);
    }
    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */
    public Vec2 setPlatRight2(float x, float y){
        return new Vec2(x, y);
    }
    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */
    public Vec2 setPlatRight3(float x, float y){
        return new Vec2(x, y);
    }
    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */
    public Vec2 setPlatRight4(float x, float y){
        return new Vec2(x, y);
    }
    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */
    public Vec2 setPlatRight5(float x, float y){
        return new Vec2(x, y);
    }
     
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */
    public Vec2 setPlatRight6(float x, float y){
        return new Vec2(x, y);
    }
     
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */
    public Vec2 setPlatRight7(float x, float y){
        return new Vec2(x, y);
    }
     
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the instance of LeftSpikedWall class.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
     */
    public Vec2 setLeftSpikedWallPosition(float x, float y){
        return new Vec2(x, y);
    }
    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the instance of RightSpikedWall class.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
    */
    public Vec2 setRightSpikedWallPosition(float x, float y){
        return new Vec2(x, y);
    }

}
