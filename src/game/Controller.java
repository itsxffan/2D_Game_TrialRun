package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 25;
    private static final float WALKING_SPEED = 10;
    
    private Walker body;
    boolean left = true;

    public Controller(Walker body) {
        this.body = body;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // A = walk left
            body.removeAllImages();
            BodyImage image = new BodyImage("data/soldierLeft.png", 4);
            body.addImage(image);
        } else if (code == KeyEvent.VK_D) {
            body.removeAllImages();
            BodyImage image = new BodyImage("data/soldierRight.png", 4);
            body.addImage(image);
            body.startWalking(WALKING_SPEED); // D = Walk Right
        } else if (code == KeyEvent.VK_SPACE) { // SPACE = Levitate
            body.setGravityScale(-2f);
            body.getLinearVelocity();
        }  
        if (code == KeyEvent.VK_F) { // F = Shoot
            Vec2 currentPosition = body.getPosition();
            Bullet bullet = new Bullet(body.getWorld());
            //bullet.addCollisionListener(new BulletCollision(stinger));
            if (left == true) {
                bullet.setPosition(new Vec2(currentPosition.x + 1, currentPosition.y));
                bullet.setLinearVelocity(new Vec2(100, 0));
            } else if (left == false) {
                bullet.setPosition(new Vec2(currentPosition.x - 1, currentPosition.y));
                bullet.setLinearVelocity(new Vec2(-100, 0));
            }
            
        }
        
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
            body.removeAllImages();
            BodyImage image = new BodyImage("data/soldier.png", 4);
            body.addImage(image);
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
            body.removeAllImages();
            BodyImage image = new BodyImage("data/soldier.png", 4);
            body.addImage(image);
        } else if (code == KeyEvent.VK_SPACE) {
            body.setGravityScale(2f);
        } else if (code == KeyEvent.VK_F) {
            //
        }
    }
    
    public void setBody(Walker body) {
        this.body = body;
    }
}
