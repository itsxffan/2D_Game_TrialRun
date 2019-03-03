package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_AMMO = 1;
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
        
        
        // walls
        Shape leftWallShape = new BoxShape(0.7f, 40f);
        Body leftWall = new StaticBody(this, leftWallShape);
        leftWall.setPosition(new Vec2(-34f, 14.5f));
        Fixture leftBorder = new SolidFixture(leftWall, leftWallShape);
        //((SolidFixture) leftBorder).setFriction(10);
        //leftWall.addCollisionListener(new AvoidTankCollision());
        
        
        Shape rightWallShape = new BoxShape(0.7f, 40f);
        Body rightWall = new StaticBody(this, rightWallShape);
        rightWall.setPosition(new Vec2(34f, 14.5f));
        Fixture rightBorder = new SolidFixture(rightWall, rightWallShape);
        //((SolidFixture) leftBorder).setFriction(10);
        //leftWall.addCollisionListener(new AvoidTankCollision());
        
        // Platform Size Variatiosn:
        // Vertical Blocks
        Shape boxShape_v1 = new BoxShape(0.5f, 10f);
        Shape boxShape_v2 = new BoxShape(0.5f, 7f);
        Shape boxShape_v3 = new BoxShape(0.5f, 5.2f);
        Shape boxShape_v4 = new BoxShape(0.5f, 1.5f);
        Shape boxShape_v5 = new BoxShape(0.5f, 4.5f);
        Shape boxShape_v6 = new BoxShape(0.5f, 4.5f);
        // Horizontal Blocks
        Shape boxShape_h1 = new BoxShape(5f, 0.5f);
        Shape boxShape_h2 = new BoxShape(6.5f, 0.5f);
        Shape boxShape_h3 = new BoxShape(2.5f, 0.5f);
        Shape boxShape_h4 = new BoxShape(4.5f, 0.5f);
        
        // Creating the Platforms:
        Body platform1 = new StaticBody(this, boxShape_v1);
        platform1.setPosition(new Vec2(-5f, -10f));
        platform1.setFillColor(Color.lightGray);
        
        Body platform2 = new StaticBody(this, boxShape_v1);
        platform2.setPosition(new Vec2(5f, -10f));
        platform2.setFillColor(Color.lightGray);
        
        Body platform3 = new StaticBody(this, boxShape_h1);
        platform3.setPosition(new Vec2(-10f, -5f));
        platform3.setFillColor(Color.lightGray);
        
        Body platform4 = new StaticBody(this, boxShape_h1);
        platform4.setPosition(new Vec2(10f, -5f));
        platform4.setFillColor(Color.lightGray);
        
        Body platform5 = new StaticBody(this, boxShape_v2);
        platform5.setPosition(new Vec2(-14.5f, 2.3f));
        platform5.setFillColor(Color.lightGray);
        
        Body platform6 = new StaticBody(this, boxShape_v2);
        platform6.setPosition(new Vec2(14.5f, 2.3f));
        platform6.setFillColor(Color.lightGray);
        
        Body platform7 = new StaticBody(this, boxShape_h1);
        platform7.setPosition(new Vec2(-20f, 0f));
        platform7.setFillColor(Color.lightGray);
        
        Body platform8 = new StaticBody(this, boxShape_h1);
        platform8.setPosition(new Vec2(20f, 0f));
        platform8.setFillColor(Color.lightGray);
        
        Body platform9 = new StaticBody(this, boxShape_h2);
        platform9.setPosition(new Vec2(-27f, 8.8f));
        platform9.setFillColor(Color.lightGray);
        
        Body platform10 = new StaticBody(this, boxShape_h2);
        platform10.setPosition(new Vec2(27f, 8.8f));
        platform10.setFillColor(Color.lightGray);
        
        Body platform11 = new StaticBody(this, boxShape_v3);
        platform11.setPosition(new Vec2(-25.5f, -4.7f));
        platform11.setFillColor(Color.lightGray);
        
        Body platform12 = new StaticBody(this, boxShape_v3);
        platform12.setPosition(new Vec2(25.5f, -4.7f));
        platform12.setFillColor(Color.lightGray);
        
        Body platform13 = new StaticBody(this, boxShape_h3);
        platform13.setPosition(new Vec2(22.6f, -9.4f));
        platform13.setFillColor(Color.lightGray);
        
        Body platform14 = new StaticBody(this, boxShape_h3);
        platform14.setPosition(new Vec2(-22.6f, -9.4f));
        platform14.setFillColor(Color.lightGray);
        
        Body platform15 = new StaticBody(this, boxShape_v4);
        platform15.setPosition(new Vec2(-21, 7.7f));
        platform15.setFillColor(Color.lightGray);
        
        Body platform16 = new StaticBody(this, boxShape_v4);
        platform16.setPosition(new Vec2(21, 7.7f));
        platform16.setFillColor(Color.lightGray);
        
        Body platform17 = new StaticBody(this, boxShape_v5);
        platform17.setPosition(new Vec2(-9.5f, 14f));
        platform17.setFillColor(Color.lightGray);
        
        Body platform18 = new StaticBody(this, boxShape_v5);
        platform18.setPosition(new Vec2(9.5f, 14f));
        platform18.setFillColor(Color.lightGray);
        
        Body platform19 = new StaticBody(this, boxShape_h4);
        platform19.setPosition(new Vec2(-0f, 10f));
        platform19.setFillColor(Color.lightGray);
        
        Body platform20 = new StaticBody(this, boxShape_v6);
        platform20.setPosition(new Vec2(-0f, 5f));
        platform20.setFillColor(Color.lightGray);
        
        // Collectable: Ammo Crates
        Body singleCrate1 = new Item(this);
        singleCrate1.setPosition(new Vec2(-11f, 17.8f));
        singleCrate1.addCollisionListener(new Pickup(getPlayer()));
        
        Body singleCrate2 = new Item(this);
        singleCrate2.setPosition(new Vec2(11f, 17.8f));
        singleCrate2.addCollisionListener(new Pickup(getPlayer()));
        
        Body singleCrate3 = new Item(this);
        singleCrate3.setPosition(new Vec2(6.5f, -6.2f));
        singleCrate3.addCollisionListener(new Pickup(getPlayer()));
        
        Body singleCrate4 = new Item(this);
        singleCrate4.setPosition(new Vec2(-6.5f, -6.2f));
        singleCrate4.addCollisionListener(new Pickup(getPlayer()));
        
        Body singleCrate5 = new Item(this);
        singleCrate5.setPosition(new Vec2(-1.2f, 8.8f));
        singleCrate5.addCollisionListener(new Pickup(getPlayer()));
        
        Body singleCrate6 = new Item(this);
        singleCrate6.setPosition(new Vec2(1.2f, 8.8f));
        singleCrate6.addCollisionListener(new Pickup(getPlayer()));
        
        Body singleCrate7 = new Item(this);
        singleCrate7.setPosition(new Vec2(-24f, -1.2f));
        singleCrate7.addCollisionListener(new Pickup(getPlayer()));
        
        Body singleCrate8 = new Item(this);
        singleCrate8.setPosition(new Vec2(24f, -1.2f));
        singleCrate8.addCollisionListener(new Pickup(getPlayer()));
        
        for (int obj1 = 0; obj1 < 12; obj1++) {
            Spike spike = new Spike(this);
            spike.rotateDegrees(180f);
            spike.setPosition(new Vec2(obj1 *1f - 33f, 7.6f));
            spike.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        for (int obj2 = 0; obj2 < 12; obj2++) {
            Spike spike = new Spike(this);
            spike.rotateDegrees(180f);
            spike.setPosition(new Vec2(obj2 *1f + 22f, 7.6f));
            spike.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        for (int obj3 = 0; obj3 < 7; obj3++) {
            Spike spike = new Spike(this);
            spike.rotateDegrees(180f);
            spike.setPosition(new Vec2(obj3 *1f - 14f, -6.2f));
            spike.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        for (int obj4 = 0; obj4 < 7; obj4++) {
            Spike spike = new Spike(this);
            spike.rotateDegrees(180f);
            spike.setPosition(new Vec2(obj4 *1f + 8f, -6.2f));
            spike.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        for (int obj5 = 0; obj5 < 2; obj5++) {
            Spike spike = new Spike(this);
            spike.rotateDegrees(180f);
            spike.setPosition(new Vec2(obj5 *1f - 3.5f, 8.8f));
            spike.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        for (int obj6 = 0; obj6 < 2; obj6++) {
            Spike spike = new Spike(this);
            spike.rotateDegrees(180f);
            spike.setPosition(new Vec2(obj6 *1f + 2.5f, 8.8f));
            spike.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        for (int obj7 = 0; obj7 < 6; obj7++) {
            Spike spike = new Spike(this);
            spike.rotateDegrees(180f);
            spike.setPosition(new Vec2(obj7 *1f - 25.5f, -10.6f));
            spike.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        for (int obj8 = 0; obj8 < 6; obj8++) {
            Spike spike = new Spike(this);
            spike.rotateDegrees(180f);
            spike.setPosition(new Vec2(obj8 *1f + 20.5f, -10.6f));
            spike.addCollisionListener(new AvoidSpikeCollision(getPlayer()));
        }
        
        // Creating a Enemy Tanks:
        Tank tank1 = new Tank(this);
        tank1.setPosition(new Vec2(-20f, -15f));
        tank1.moveLeft();
        tank1.addCollisionListener(new AvoidTankCollision(getPlayer()));
       
        Tank tank2 = new Tank(this);
        tank2.setPosition(new Vec2(20f, -15));
        tank2.moveRight();
        tank2.addCollisionListener(new AvoidTankCollision(getPlayer()));
        
        // Creating Enemy Jets:
        Jet jet1 = new Jet(this);
        jet1.setPosition(new Vec2(7f, 5f));
        jet1.addCollisionListener(new AvoidJetCollision(getPlayer()));
        
        // Creating Enemy Jets:
        Jet jet2 = new Jet(this);
        jet2.setPosition(new Vec2(25f, 15f));
        jet2.addCollisionListener(new AvoidJetCollision(getPlayer()));
        
         // Creating a Enemy Sodliers:
        Enemy enemySoldier1 = new Enemy(this);
        enemySoldier1.setPosition(new Vec2(-27f, 10f));
        enemySoldier1.addCollisionListener(new AvoidEnemyCollision(getPlayer()));
        
        Enemy enemySoldier2 = new Enemy(this);
        enemySoldier2.setPosition(new Vec2(-20f, 1f));
        enemySoldier2.addCollisionListener(new AvoidEnemyCollision(getPlayer()));
        
        // Suprise Collision
        Unknown unknown = new Unknown(this);
        unknown.setPosition(new Vec2(16f,8.2f));
        unknown.addCollisionListener(new SupriseCollision(getPlayer()));
        
        Unknown unknown2 = new Unknown(this);
        unknown2.setPosition(new Vec2(-16f,8.2f));
        unknown2.addCollisionListener(new SupriseCollision(getPlayer()));
        
        // Creating the Heart Object that would increment Health
        Heart heart = new Heart(this);
        heart.setPosition(new Vec2(0f, 15f));
        heart.addCollisionListener(new Pickup(getPlayer()));
        
        Heart heart2 = new Heart(this);
        heart2.setPosition(new Vec2(23f, -5f));
        heart2.addCollisionListener(new Pickup(getPlayer()));
        
        Heart heart3 = new Heart(this);
        heart3.setPosition(new Vec2(-23f, -5f));
        heart3.addCollisionListener(new Pickup(getPlayer()));
        
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(0f, 0f);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(0f, -16f);
    }   
    
    @Override
    public boolean isCompleted() {
        return getPlayer().getInventoryCount() >= NUM_AMMO;
    }
}
