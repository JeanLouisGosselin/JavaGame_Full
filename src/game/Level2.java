package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Jean-Louis
 */
public class Level2 extends GameLevel {
    
    private Game thisCurrentGame;
    private Soldier hero;
    private EnemyRobot robot1, robot2, robot3, robot4;
    private DeadlySpaceship spaceship;
    private Portal portal;
    private Cage cage;
    private FireWall leftWall, rightWall, wall1, wall2, wall3, wall4;
    private Key keys, key1, key2, key3, key4, key5, key6, key7, key8, 
                   lastKey1, lastKey2, lastKey3, lastKey4, lastKey5;
    private LifeReplenish lifeHeart1;   
    private int soldierAmmo, soldierLife;
    private GroundPlatformLevel2 lavaFlow;
    private LongPlatformLevel2 mediumPlat;
    private IceBrick iceBrickLeft, iceBrickRight, upperIceBrickRight, icePlatform1, icePlatform2, icePlatform3, 
                        icePlatform4, icePlatform5, finalIceBrickWall;
    private Drone drone1, drone2, drone3;
    private MobilePlatform mPlat1, mPlat2, mPlat3, mPlat4, iceBrickToTravel;
    private SnowLeopard snowLeopard, vaultSnowLeopard;
    private SpikedWall spikedWall;
    private float positionXspaceship, positionYspaceship;
       
    @Override
    public void populate(Game game) {
        
        super.populate(game);
        
        positionXspaceship = 0;
        positionYspaceship = 10;
        
        numKeys = 20;
        someKeys = 15;
                     
////////////////////////////  all characters in the game: //////////////////////////////

        thisCurrentGame = game;
        
        //Soldier object:
        hero = new Soldier(this);
        hero.setPosition(setHeroPosition(-90, -3.5f));
        hero.showStillImageRight();
        hero.addCollisionListener(new SoldierListener(hero, game));

        cage = new Cage(this, hero, numKeys);
        cage.setPosition(setPortalPosition(93, 5.5f));
        cage.addCollisionListener(new CageListener(game));

        portal = new Portal(this);
        portal.setPosition(setPortalPosition(93, 5));
        portal.addCollisionListener(new PortalListener(game));

        Shape portalPlatform = new BoxShape(4, 0.1f);
        Body thisPortalPlat = new StaticBody(this, portalPlatform);
        thisPortalPlat.setPosition(setBasePlatformPosition(95.2f, 3.8f));
        thisPortalPlat.setFillColor(Color.white);

        float limitLeft1 = -90;
        float limitRight1 = -70;
        drone1 = new Drone(this, limitLeft1, limitRight1);
        drone1.setPosition(setDronePosition(-75, 4));
        drone1.setGravityScale(0);
        this.addStepListener(drone1);
        drone1.addCollisionListener(new SoldierListener(hero, game));
        
        float limitLeft2 = -30;
        float limitRight2 = -13;
        drone2 = new Drone(this, limitLeft2, limitRight2);
        drone2.setPosition(setDronePosition(-20, 10));
        drone2.setGravityScale(0);
        this.addStepListener(drone2);
        drone2.addCollisionListener(new SoldierListener(hero, game));
        
        float limitLeft3 = 10;
        float limitRight3 = 30;
        drone3 = new Drone(this, limitLeft3, limitRight3);
        drone3.setPosition(setDronePosition(20, 22));
        drone3.setGravityScale(0);
        this.addStepListener(drone3);
        drone3.addCollisionListener(new SoldierListener(hero, game));
       
        //////////////////////////////////  all keys  //////////////////////////////////////////

        int keySpace = -80;
        for(int index2 = 0; index2 < 9; index2++){
            keys = new Key(this);
            keys.setPosition(setKeyPosition(keySpace+10, 0f));
            keys.addCollisionListener(new SoldierListener(hero, game));
            keySpace += 20;
        }

        //adding platforms:
        Shape plat1 = new BoxShape(4, 0.1f);
        Body highPlat1 = new StaticBody(this, plat1);
        highPlat1.setPosition(setBasePlatformPosition(8, 10));
        highPlat1.setFillColor(Color.white);
        
        Shape plat2 = new BoxShape(4, 0.1f);
        Body highPlat2 = new StaticBody(this, plat2);
        highPlat2.setPosition(setBasePlatformPosition(15, 16));
        highPlat2.setFillColor(Color.white);
        
        Shape plat3 = new BoxShape(5, 0.1f);
        Body highPlat3 = new StaticBody(this, plat3);
        highPlat3.setPosition(setBasePlatformPosition(70, 15));
        highPlat3.setFillColor(Color.white);       
        
        //adding key on plat:

        key1 = new Key(this);
        key1.setPosition(setKeyPosition(11, 11.1f));
        key1.addCollisionListener(new SoldierListener(hero, game));
        
        key2 = new Key(this);
        key2.setPosition(setKeyPosition(16, 17f));
        key2.addCollisionListener(new SoldierListener(hero, game));
        
        key3 = new Key(this);
        key3.setPosition(setKeyPosition(18.5f, 17f));
        key3.addCollisionListener(new SoldierListener(hero, game));
        
        key6 = new Key(this);
        key6.setPosition(setKeyPosition(29, 9f));
        key6.addCollisionListener(new SoldierListener(hero, game));
        
        key4 = new Key(this);
        key4.setPosition(setKeyPosition(71, 16f));
        key4.addCollisionListener(new SoldierListener(hero, game));
        
        key5 = new Key(this);
        key5.setPosition(setKeyPosition(73, 16f));
        key5.addCollisionListener(new SoldierListener(hero, game));
        
                      
////////////////////////////////// lava flow: //////////////////////////////
                                   
        int add = 0;
        for(int index=0; index<20; index++){
        lavaFlow = new GroundPlatformLevel2(this);
        lavaFlow.setPosition(setGroundTwoPosition(-12, -94f + add));
        add += 10;
        }
        
////////////////////////////////// platform under lava flow: //////////////////////////////
        
        //ground platform (under lava flow):       
        Shape groundShape = new BoxShape(102.2f, 0.1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(setBasePlatformPosition(1, -13.8f));
        ground.setFillColor(Color.black);
        
////////////////////////////////// rock platforms: ///////////////////////////////

        int space = 0;
        for(int a=0; a<4; a++){

            mediumPlat = new LongPlatformLevel2(this);
            mediumPlat.setPosition(setMiniPlatformLevel2Position(-7, -90 + space));
            space += 20;           
        }

        
////////////////////////////////// mobile platforms: ///////////////////////////////

        float l1 = -84;
        float r1 = -76;
        mPlat1 = new MobilePlatform(this, l1, r1, new Vec2(-80, -8.1f));
        this.addStepListener(mPlat1);

        float l2 = -64;
        float r2 = -56;
        mPlat2 = new MobilePlatform(this, l2, r2, new Vec2(-60, -8.1f));
        this.addStepListener(mPlat2);

        float l3 = -44;
        float r3 = -36;       
        mPlat3 = new MobilePlatform(this, l3, r3, new Vec2(-40, -8.1f));
        this.addStepListener(mPlat3);

        float l4 = -24;
        float r4 = -16;
        mPlat4 = new MobilePlatform(this, l4, r4, new Vec2(-20, -8.1f));
        this.addStepListener(mPlat4);
        
//////////////////////////////// ice brick which takes hero across lava flow to collect keys: //////////

        float l5 = -7;
        float r5 = 90;
        iceBrickToTravel = new MobilePlatform(this, l5, r5, new Vec2(84, -7f));
        this.addStepListener(iceBrickToTravel);
             
/////////////////////////////// small platform before long ice platform (temporary) ////////////////

        Shape tinyPlatform = new BoxShape(2, 0.1f);
        Body littleStep = new StaticBody(this, tinyPlatform);
        littleStep.setPosition(setBasePlatformPosition(-6, 2.2f));
        littleStep.setFillColor(Color.white);        
        
      
        /////////////////////////////// higher long ice platform ////////////////////////////////

        int iceSpace1 = 0;
        for(int i=0; i<10; i++){
            icePlatform1 = new IceBrick(this);
            icePlatform1.setPosition(setIcePosition(0+iceSpace1, 3.5f));
            iceSpace1 += 2;
        }
        
        
                //////////////// tiny middle platform: //////////////
                
                
        Shape tinyPlatform999 = new BoxShape(1, 0.1f);
        Body littleStep999 = new StaticBody(this, tinyPlatform999);
        littleStep999.setPosition(setBasePlatformPosition(29, 8));
        littleStep999.setFillColor(Color.white);
                
         
        //////////////////////////////// long ice platform: ////////////////////////////////////       
        
        int iceSpace2 = 0;
        for(int i=0; i<20; i++){
            icePlatform2 = new IceBrick(this);
            icePlatform2.setPosition(setIcePosition(40+iceSpace2, 3.5f));
            iceSpace2 += 2;
        }
        
        
        /////////////////////////////// last ice platform (below cage & portal): //////////////////
 
        int iceSpace3 = 0;
        for(int i=0; i<4; i++){
            icePlatform3 = new IceBrick(this);
            icePlatform3.setPosition(setIcePosition(95+iceSpace3, -4f));
            iceSpace3 += 2;
        }       

        
////////////////////////////////// ice walls: //////////////////////////////

        int spc1 = 0;
        for(int i=0; i <30; i++){
            
            iceBrickLeft = new IceBrick(this);
            iceBrickLeft.setPosition(setIcePosition(-103.3f, (spc1 + (-8.1f))));
            spc1 += 2;
            //iceBrickLeft.addCollisionListener(new FirstCollisionClass(hero, spaceship));

        }

        int spc2 = 0;
        for(int i=0; i <8; i++){
            
            iceBrickRight = new IceBrick(this);
            iceBrickRight.setPosition(setIcePosition(105.2f, (spc2 + (-8.1f))));
            spc2 += 2;
            //iceBrickRight.addCollisionListener(new FirstCollisionClass(hero, spaceship));

        }
        
/////////////////////////////// upper ice brick wall (right hand side): /////////////////////////////////

        int spc3 = 0;
        for(int i=0; i<10; i++){
            upperIceBrickRight = new IceBrick(this);
            upperIceBrickRight.setPosition(setIcePosition(105.2f, (spc3 + (12.4f))));
            spc3 += 2;
        }
        
        
//////////////////////////////// 2-sided spiked wall ////////////////////////////////////////

        float x = 105;
        float y = 9;
        float limitLeft = 103.2f;
        float limitRight = 107.4f;
        spikedWall = new SpikedWall(this, limitLeft, limitRight);
        spikedWall.setPosition(setSpikedWallPosition(x, y));
        spikedWall.setGravityScale(0);
        this.addStepListener(spikedWall);
        spikedWall.addCollisionListener(new SpikedWallListener(game));
        spikedWall.startWalking(-2);          

//////////////////////////////// two small ground platforms (for ice walls) /////////////////
        
        //ground for ice wall left:
        Shape groundLeftIceWall = new BoxShape(2, 2);
        Body groundLeft = new StaticBody(this, groundLeftIceWall);
        groundLeft.setPosition(setGroundLeft(-103.3f, -11.8f));
        groundLeft.setFillColor(Color.DARK_GRAY);  
        
        //ground for ice wall right:
        Shape groundRightIceWall = new BoxShape(1.8f, 4f);
        Body groundRight = new StaticBody(this, groundRightIceWall);
        groundRight.setPosition(setGroundRight(105.1f, -13.8f));
        groundRight.setFillColor(Color.DARK_GRAY); 
                                  
/////////////////////////////////// second black groundbase (second part) ///////////////////////////////

        Shape secondGround = new BoxShape(11.7f, 0.1f);
        Body groundLast = new StaticBody(this, secondGround);
        groundLast.setPosition(setGroundRight(115f, -17.9f));
        groundLast.setFillColor(Color.black);
        
/////////////////////////////////// ground for ice wall right: /////////////////////////////////////////

        Shape groundRighFinalWall = new BoxShape(1.8f, 4f);
        Body podium = new StaticBody(this, groundRighFinalWall);
        podium.setPosition(setGroundRight(124.9f, -13.8f));
        podium.setFillColor(Color.DARK_GRAY);
        
////////////////////////////////// final ice wall of the game //////////////////////////////////////////
        
        int spc4 = 0;
        for(int i=0; i <30; i++){
            
            finalIceBrickWall = new IceBrick(this);
            finalIceBrickWall.setPosition(setIcePosition(124.9f, (spc4 + (-8.1f))));
            spc4 += 2;

        }


////////////////////////////////// small fires on lava - fireground /////////////////////////////////////

        float fireSpace = 0;
        for(int i=0; i<136; i++){
            
            leftWall = new FireWall(this);
            leftWall.setPosition(setFirewallLeftPosition(-101f + fireSpace, -10.6f));
            leftWall.addCollisionListener(new SoldierListener(hero, game));
            fireSpace += 1.5f;
        }

////////////////////////////////// snow leopards //////////////////////////////////////////////////////

        float left1 = 40;
        float right1 = 67;      
        snowLeopard = new SnowLeopard(this, left1, right1);
        snowLeopard.setPosition(setSnowLeopardPosition(47, 6f));      
        this.addStepListener(snowLeopard);
        snowLeopard.addCollisionListener(new SoldierListener(hero, game));
        snowLeopard.startWalking(-5);

        float left2 = 110;
        float right2 = 120;      
        vaultSnowLeopard = new SnowLeopard(this, left2, right2);
        //vaultSnowLeopard.setPosition(setSnowLeopardPosition(135, -17.9f)); 
        vaultSnowLeopard.setPosition(setSnowLeopardPosition(115, -15f));
        this.addStepListener(vaultSnowLeopard);
        vaultSnowLeopard.addCollisionListener(new SoldierListener(hero, game));
        vaultSnowLeopard.startWalking(-5);  

        
////////////////////////////////////// last 4 small platforms in vault ////////////////////////////////

        Shape lastPlat1 = new BoxShape(2f, 0.1f);
        Body last1 = new StaticBody(this, lastPlat1);
        last1.setPosition(setGroundRight(111, 4));
        last1.setFillColor(Color.white);
        
        Shape lastPlat2 = new BoxShape(2, 0.1f);
        Body last2 = new StaticBody(this, lastPlat2);
        last2.setPosition(setGroundRight(119, -3));
        last2.setFillColor(Color.white);
        
        Shape lastPlat3 = new BoxShape(2, 0.1f);
        Body last3 = new StaticBody(this, lastPlat3);
        last3.setPosition(setGroundRight(112, -9));
        last3.setFillColor(Color.white);
        
        Shape lastPlat4 = new BoxShape(4, 0.1f);
        Body last4 = new StaticBody(this, lastPlat4);
        last4.setPosition(setGroundRight(121, -12));
        last4.setFillColor(Color.white);
        
//////////////////////////////////////// last 5 keyrs in vault ////////////////////////////////////////

        lastKey1 = new Key(this);
        lastKey1.setPosition(setKeyPosition(112, 5));
        lastKey1.addCollisionListener(new SoldierListener(hero, game));
        
        lastKey2 = new Key(this);
        lastKey2.setPosition(setKeyPosition(120, -2));
        lastKey2.addCollisionListener(new SoldierListener(hero, game));
        
        lastKey3 = new Key(this);
        lastKey3.setPosition(setKeyPosition(113, -8));
        lastKey3.addCollisionListener(new SoldierListener(hero, game));

        lastKey4 = new Key(this);
        lastKey4.setPosition(setKeyPosition(122, -11));
        lastKey4.addCollisionListener(new SoldierListener(hero, game));
        
        lastKey5 = new Key(this);
        lastKey5.setPosition(setKeyPosition(123, -11));
        lastKey5.addCollisionListener(new SoldierListener(hero, game));
        
              
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
        
  }  
    @Override    
    public Soldier getPlayer(){          
        return hero;
    } 
    
    @Override
    public Vec2 setCagePosition(float x, float y){
        return new Vec2(x, y);
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
    
    public Vec2 setIcePosition(float x, float y){
        return new Vec2(x, y);
    }
    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the left platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
    */
    public Vec2 setGroundLeft(float x, float y){
        return new Vec2(x, y);
    }
    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the right platform.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
    */
    public Vec2 setGroundRight(float x, float y){
        return new Vec2(x, y);
    }
    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the instance of BlueFire class.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
    */
    public Vec2 setBlueFire(float x, float y){
        return new Vec2(x, y);
    }
    
    /**
   * This mutator ("setter" method) sets the x and y coordinates of the instance of MobilePlatform class.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
    */
    public Vec2 setMobilePlatformPosition(float x, float y){
        return new Vec2(x, y);
    }

    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the instance of Drone class.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
    */
    public Vec2 setDronePosition(float x, float y){
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
    
    /**
     * This mutator ("setter" method) sets the x and y coordinates of the instance of SnowLeopard class.
     * @param x variable of float type corresponding to the x coordinate
     * @param y variable of float type corresponding to the x coordinate
     * @return an instance of Vec2 class (which contains both x and y values)
    */
    public Vec2 setSnowLeopardPosition(float x, float y){    
        return new Vec2(x, y);
    }
       
}