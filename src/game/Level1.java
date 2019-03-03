package game;

import city.cs.engine.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 * @author      Saffan, Ahmed, saffan.ahmed@city.ac.uk
 * @version     current version number of program
 * @since       the version of the package this class was first added to
*/
public class Level1 extends GameLevel implements ActionListener {
    
    private static final int NUM_AMMO = 5;
    private Timer timer;
    /**
     * Populate the world.
     * @param game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        
        timer = new Timer(1000, this);
        timer.setInitialDelay(100); 
        timer.start();
        
        setGravity(60f);
        
        // make the ground
        Shape groundShape = new BoxShape(33.3f, 1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -19.5f));
        
        // make the top
        Shape topShape = new BoxShape(33.3f, 1f);
        Body top = new StaticBody(this, topShape);
        top.setPosition(new Vec2(0, 19.5f));
        
         // Creating a Tank
        Tank tank = new Tank(this);
        tank.setPosition(new Vec2(8, -10));
        tank.addCollisionListener(new AvoidTankCollision(getPlayer()));
        tank.moveLeft();
        
        // Creating a Stinger (Flying Object to Avoid)
        Stinger stinger = new Stinger(this);
        stinger.setPosition(new Vec2(0, 0));
        stinger.addCollisionListener(new AvoidStingerCollision(getPlayer()));
        stinger.moveRight();
        
        
        // walls
        Shape leftWallShape = new BoxShape(0.7f, 40f);
        Body leftWall = new StaticBody(this, leftWallShape);
        leftWall.setPosition(new Vec2(-34f, 14.5f));
        Fixture leftBorder = new SolidFixture(leftWall, leftWallShape);
        //((SolidFixture) leftBorder).setFriction(10);
        leftWall.addCollisionListener(new LeftWallCollision(tank));
  
        
        
        Shape rightWallShape = new BoxShape(0.7f, 40f);
        Body rightWall = new StaticBody(this, rightWallShape);
        rightWall.setPosition(new Vec2(34f, 14.5f));
        Fixture rightBorder = new SolidFixture(rightWall, rightWallShape);
        //((SolidFixture) leftBorder).setFriction(10);
        rightWall.addCollisionListener(new RightWallCollision(tank));
        
        // BoxShape Sizes - 4 Variations:
        // Horizontal Blocks
        Shape boxShape = new BoxShape(25, 0.5f);
        Shape boxShape4 = new BoxShape(5f, 0.5f);
        
        // Vertical Blocks
        Shape boxShape2 = new BoxShape(0.5f, 5f);
        
        // Square Blocks
        Shape boxShape3 = new BoxShape(1f, 1f);
        Shape boxShape5 = new BoxShape(1.3f, 0.5f);
        
        // make platforms
        Body platformBase = new StaticBody(this, boxShape);
        platformBase.setPosition(new Vec2(0, -4.6f));
        platformBase.setFillColor(Color.lightGray);
        
        Body baseLeft = new StaticBody(this, boxShape2);
        baseLeft.setPosition(new Vec2(-25.5f, -0.1f));
        Fixture leftBaseBorder = new SolidFixture(baseLeft, boxShape2);
        baseLeft.setFillColor(Color.lightGray);
        baseLeft.addCollisionListener(new StingerLeftCollision(stinger));
        
        Body baseRight = new StaticBody(this, boxShape2);
        baseRight.setPosition(new Vec2(25.5f, -0.12f));
        Fixture rightBaseBorder = new SolidFixture(baseRight, boxShape2);
        baseRight.setFillColor(Color.lightGray);
        baseRight.addCollisionListener(new StingerRightCollision(stinger));
        
        Body finalBase = new StaticBody(this, boxShape4);
        finalBase.setPosition(new Vec2(32f, 12f));
        finalBase.setFillColor(Color.lightGray);
        
        Body aboveBase1 = new StaticBody(this, boxShape4);
        aboveBase1.setPosition(new Vec2(-15f, 9.5f-4f));
        aboveBase1.setFillColor(Color.lightGray);
        
        Body aboveBase2 = new StaticBody(this, boxShape4);
        aboveBase2.setPosition(new Vec2(15f, 9.5f-4f));
        aboveBase2.setFillColor(Color.lightGray);
        
        Body aboveBase3 = new StaticBody(this, boxShape4);
        aboveBase3.setPosition(new Vec2(0f, 9.f-6.5f));
        aboveBase3.setFillColor(Color.lightGray);
        
        Body ledge1 = new StaticBody(this, boxShape5);
        ledge1.setPosition(new Vec2(-32f, -13f));
        ledge1.setFillColor(Color.lightGray);
        
        Body ledge2 = new StaticBody(this, boxShape5);
        ledge2.setPosition(new Vec2(-28f, -8.5f));
        ledge2.setFillColor(Color.lightGray);
        
        Body ledge3 = new StaticBody(this, boxShape5);
        ledge3.setPosition(new Vec2(-32f, -4f));
        ledge3.setFillColor(Color.lightGray);
        
        Body ledge4 = new StaticBody(this, boxShape5);
        ledge4.setPosition(new Vec2(-28f, 0.5f));
        ledge4.setFillColor(Color.lightGray);
        /*
        Body ledge3 = new StaticBody(this, boxShape5);
        ledge3.setPosition(new Vec2(-32f, -14.5f));
        ledge3.setFillColor(Color.lightGray);
        
        Body ledge4 = new StaticBody(this, boxShape5);
        ledge4.setPosition(new Vec2(-32f, -14.5f));
        ledge4.setFillColor(Color.lightGray);
        */
        
        /*
        Body aboveBase4 = new StaticBody(this, boxShape4);
        aboveBase4.setPosition(new Vec2(15f, 9.5f));
        aboveBase4.setFillColor(Color.lightGray);
        */ 
        Body squareBase1 = new StaticBody(this, boxShape3);
        squareBase1.setPosition(new Vec2(-9f, 5f));
        squareBase1.setFillColor(Color.lightGray);
        
        Body squareBase2 = new StaticBody(this, boxShape3);
        squareBase2.setPosition(new Vec2(9f, 5f));
        squareBase2.setFillColor(Color.lightGray);
        
        Body squareBase3 = new StaticBody(this, boxShape3);
        squareBase3.setPosition(new Vec2(-21f, 5f));
        squareBase3.setFillColor(Color.lightGray);
        
        Body squareBase4 = new StaticBody(this, boxShape3);
        squareBase4.setPosition(new Vec2(21f, 5f));
        squareBase4.setFillColor(Color.lightGray);
        
        
//        // Collisions to Avoid:
//        // Boxes
//        Shape boxes = new BoxShape(1f, 1f);
//        for (int i = 0; i < 6; i++) {
//        Body box_set_right = new DynamicBody(this, boxes);
//        box_set_right.setPosition(new Vec2(25, i*0.5f));
//        box_set_right.addCollisionListener(new Pickup(soldier));
//        Body box_set_left = new DynamicBody(this, boxes);
//        box_set_left.setPosition(new Vec2(-25, i*0.5f));
//        box_set_left.addCollisionListener(new Pickup(soldier));
//        }
        
        
        // Suprise Collision
        Unknown unknown = new Unknown(this);
        unknown.setPosition(new Vec2(-7f,5f));
        unknown.addCollisionListener(new SupriseCollision(getPlayer()));
        Unknown unknown2 = new Unknown(this);
        unknown2.setPosition(new Vec2(7f, 5f));
        unknown2.addCollisionListener(new SupriseCollision(getPlayer()));
        
        // Creating the Heart Object that would increment Health
        Heart heart = new Heart(this);
        heart.setPosition(new Vec2(0f, 10f));
        heart.addCollisionListener(new Pickup(getPlayer()));
        
        // Collisions to Avoid:
        // Spikes
        for (int obj1 = 0; obj1 < 52; obj1++) {
            Spike spike = new Spike(this);
            spike.rotateDegrees(180f);
            spike.setPosition(new Vec2(obj1 *-1f + 25f + 0.4f, -5.7f));
            spike.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        for (int obj2 = 0; obj2 < 45; obj2++) {
            Spike spike2 = new Spike(this);
            spike2.rotateDegrees(180f);
            spike2.setPosition(new Vec2(obj2 *-1f + 22f, 18f));
            spike2.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }     
        
        /*/ Creating the finishing flag in GameWorld.
        Flag flag = new Flag(this);
        flag.setPosition(new Vec2(32.f, 15.5f));
        flag.addCollisionListener(new Pickup(getPlayer()));
        */
        // Creating the ammo crates in the GameWorld.
        for (int i = 0; i < NUM_AMMO; i++) {
            Body itemSet1 = new Item(this);
            itemSet1.setPosition(new Vec2(i*4-21f, 14f));
            itemSet1.addCollisionListener(new Pickup(getPlayer()));
            
            Body itemSet2 = new Item(this);
            itemSet2.setPosition(new Vec2(i*4+9f, 14f));
            itemSet2.addCollisionListener(new Pickup(getPlayer()));
            
        }
    }
    @Override
    public Vec2 startPosition() {
        return new Vec2(-5, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(30f, 15f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getInventoryCount() >= NUM_AMMO;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
    }
}
