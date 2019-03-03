package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_AMMO = 5;
    /**
     * Populate the world.
     * @param game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        
        setGravity(60f);
        
        // make the ground
        Shape groundShape = new BoxShape(33.3f, 1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -19.5f));
        
        // make the top
        Shape topShape = new BoxShape(33.3f, 1f);
        Body top = new StaticBody(this, topShape);
        top.setPosition(new Vec2(0, 19.5f));
        
         // Creating a Enemy Soldier
        Enemy enemySoldier = new Enemy(this);
        enemySoldier.setPosition(new Vec2(20f, 1.7f));
        enemySoldier.moveLeft();
        enemySoldier.addCollisionListener(new AvoidEnemyCollision(getPlayer()));
        
        Enemy enemySoldier2 = new Enemy(this);
        enemySoldier2.setPosition(new Vec2(-6f, 0f));
        enemySoldier2.moveLeft();
        enemySoldier2.addCollisionListener(new AvoidEnemyCollision(getPlayer()));
        
        // walls
        Shape leftWallShape = new BoxShape(0.7f, 40f);
        Body leftWall = new StaticBody(this, leftWallShape);
        leftWall.setPosition(new Vec2(-34f, 14.5f));
        Fixture leftBorder = new SolidFixture(leftWall, leftWallShape);
        //((SolidFixture) leftBorder).setFriction(10);
        leftWall.addCollisionListener(new HBLeftCollision(enemySoldier));
        
        
        Shape rightWallShape = new BoxShape(0.7f, 40f);
        Body rightWall = new StaticBody(this, rightWallShape);
        rightWall.setPosition(new Vec2(34f, 14.5f));
        Fixture rightBorder = new SolidFixture(rightWall, rightWallShape);
        //((SolidFixture) leftBorder).setFriction(10);
        rightWall.addCollisionListener(new HBRightCollision(enemySoldier2));
        
        // Suprise Collision
        Unknown unknown = new Unknown(this);
        unknown.setPosition(new Vec2(-24f,-8.4f));
        unknown.addCollisionListener(new SupriseCollision(getPlayer()));
        Unknown unknown2 = new Unknown(this);
        unknown2.setPosition(new Vec2(28f, -8.4f));
        unknown2.addCollisionListener(new SupriseCollision(getPlayer()));

        // BoxShape Sizes - 4 Variations:
        // Horizontal Blocks
        Shape boxShape = new BoxShape(14.4f, 0.5f);
        Shape boxShape2 = new BoxShape(19f, 0.5f);
        Shape boxShape3 = new BoxShape(29.5f, 0.5f);
        Shape boxShape4 = new BoxShape(3f, 0.5f);
        Shape boxShape5 = new BoxShape(8f, 0.7f);
        Shape boxShape6 = new BoxShape(20f, 0.7f);
        Shape boxShape7 = new BoxShape(3f, 0.7f);
        Shape boxShape8 = new BoxShape(2.2f, 0.7f);
        Shape boxShape9 = new BoxShape(4f, 0.5f);
        Shape boxShape10 = new BoxShape(0.1f, 1f);
        
        // make platforms
        Body platformBase = new StaticBody(this, boxShape);
        platformBase.setPosition(new Vec2(-19f, 9.5f));
        platformBase.setFillColor(Color.lightGray);
        
        Body platformBase1 = new StaticBody(this, boxShape2);
        platformBase1.setPosition(new Vec2(19f, 9.5f));
        platformBase1.setFillColor(Color.lightGray);
        
        Body platformBase2 = new StaticBody(this, boxShape3);
        platformBase2.setPosition(new Vec2(4f, 0.5f));
        platformBase2.setFillColor(Color.lightGray);
        
        Body hiddenBox1 = new StaticBody(this, boxShape10);
        hiddenBox1.setPosition(new Vec2(4f, 2f));
        Fixture hb1 = new SolidFixture(hiddenBox1, boxShape10);
        hiddenBox1.setFillColor(Color.lightGray);
        hiddenBox1.addCollisionListener(new HBLeftCollision(enemySoldier));
                
        Body platformBase3 = new StaticBody(this, boxShape4);
        platformBase3.setPosition(new Vec2(-33f, 0.5f));
        platformBase3.setFillColor(Color.lightGray);
        
        Body platformBase4 = new StaticBody(this, boxShape5);
        platformBase4.setPosition(new Vec2(-33f, -8f));
        platformBase4.setFillColor(Color.lightGray);
        
        Body platformBase5 = new StaticBody(this, boxShape6);
        platformBase5.setPosition(new Vec2(-3f, -8f));
        platformBase5.setFillColor(Color.lightGray);
        
        Body platformBase6 = new StaticBody(this, boxShape7);
        platformBase6.setPosition(new Vec2(24f, -8f));
        platformBase6.setFillColor(Color.lightGray);
        
        Body platformBase7 = new StaticBody(this, boxShape8);
        platformBase7.setPosition(new Vec2(31.2f, -8f));
        platformBase7.setFillColor(Color.lightGray);
        
        Body ledge1 = new StaticBody(this, boxShape9);
        ledge1.setPosition(new Vec2(19f, -15f));
        ledge1.setFillColor(Color.lightGray);
        
        Body ledge2 = new StaticBody(this, boxShape9);
        ledge2.setPosition(new Vec2(1f, -15f));
        ledge2.setFillColor(Color.lightGray);
        
        Body ledge3 = new StaticBody(this, boxShape9);
        ledge3.setPosition(new Vec2(-17f, -15f));
        ledge3.setFillColor(Color.lightGray);
        
        /*
        // Collisions to Avoid:
        // Boxes
        Shape boxes = new BoxShape(1f, 1f);
        for (int i = 0; i < 6; i++) {
        Body box_set_right = new DynamicBody(this, boxes);
        box_set_right.setPosition(new Vec2(25, i*0.5f));
        box_set_right.addCollisionListener(new Pickup(soldier));
        Body box_set_left = new DynamicBody(this, boxes);
        box_set_left.setPosition(new Vec2(-25, i*0.5f));
        box_set_left.addCollisionListener(new Pickup(soldier));
        }
         */
        
        // Creating the Heart Object that would increment Health
        Heart heart = new Heart(this);
        heart.setPosition(new Vec2(1f, -12f));
        heart.addCollisionListener(new Pickup(getPlayer()));
        
        Heart heart2 = new Heart(this);
        heart2.setPosition(new Vec2(28f, -5f));
        heart2.addCollisionListener(new Pickup(getPlayer()));
        
        Heart heart3 = new Heart(this);
        heart3.setPosition(new Vec2(-32f, 4f));
        heart3.addCollisionListener(new Pickup(getPlayer()));
        
        
        // Collisions to Avoid:
        // Spikes
        for (int obj1 = 0; obj1 < 67; obj1++) {
            Spike spike = new Spike(this);
            spike.setPosition(new Vec2(obj1 *-1f + 33f, -17.8f));
            spike.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }

        Spike spike3 = new Spike(this);
        spike3.setPosition(new Vec2(-33.6f + 1f, 1.7f));
        spike3.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        
        Spike spike4 = new Spike(this);
        spike4.setPosition(new Vec2(-32.3f + 1f, 1.7f));
        spike4.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        
        Spike spike5 = new Spike(this);
        spike5.rotateDegrees(180f);
        spike5.setPosition(new Vec2(-33.6f + 1f, -0.7f));
        spike5.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        
        Spike spike6 = new Spike(this);
        spike6.rotateDegrees(180f);
        spike6.setPosition(new Vec2(-32.3f + 1f, -0.7f));
        spike6.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        
        for (int obj3 = 0; obj3 < 5; obj3++) {
            Spike spike7 = new Spike(this);
            spike7.setPosition(new Vec2(obj3 *-1f - 21f, 1.7f));
            spike7.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        for (int obj4 = 0; obj4 < 5; obj4++) {
            Spike spike8 = new Spike(this);
            spike8.rotateDegrees(180f);
            spike8.setPosition(new Vec2(obj4 *-1f - 18f, -0.7f));
            spike8.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        for (int obj5 = 0; obj5 < 5; obj5++) {
            Spike spike8 = new Spike(this);
            spike8.rotateDegrees(180f);
            spike8.setPosition(new Vec2(obj5 *-1f - 5f, 8.3f));
            spike8.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        for (int obj6 = 0; obj6 < 5; obj6++) {
            Spike spike8 = new Spike(this);
            spike8.rotateDegrees(180f);
            spike8.setPosition(new Vec2(obj6 *-1f + 20.5f, -0.7f));
            spike8.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        // Creating the ammo crates in the GameWorld.
        for (int i = 0; i < NUM_AMMO; i++) {
            Body ammoCrates1 = new Item(this);
            ammoCrates1.setPosition(new Vec2(i*4-28f, 17f));
            ammoCrates1.addCollisionListener(new Pickup(getPlayer()));
            
            Body ammoCrates2 = new Item(this);
            ammoCrates2.setPosition(new Vec2(i*4+14f, 8f));
            ammoCrates2.addCollisionListener(new Pickup(getPlayer()));
            
        }
        
        Body singleCrate1 = new Item(this);
        singleCrate1.setPosition(new Vec2(-19f, 1.8f));
        singleCrate1.addCollisionListener(new Pickup(getPlayer()));
        
        Body singleCrate2 = new Item(this);
        singleCrate2.setPosition(new Vec2(22f, -9.5f));
        singleCrate2.addCollisionListener(new Pickup(getPlayer()));
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(29f, 15.1f);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-19f, -11.9f);
    }
    
    @Override
    public boolean isCompleted() {
        return getPlayer().getInventoryCount() >= NUM_AMMO;
    }
}
