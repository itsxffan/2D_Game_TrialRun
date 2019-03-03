package game;

import city.cs.engine.*;

/**
 * LeftWallCollision - This class looks at the collision between the Left Wall Border and Tank. 
 * Depending on what hazard/object they have collided with detrimental effects
 * will occur.
 */
public class LeftWallCollision implements CollisionListener {
    private Tank tank;
    
    public LeftWallCollision(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void collide(CollisionEvent h) {
        if (h.getOtherBody() == tank) {
            tank.moveRight();
            tank.removeAllImages();
            BodyImage image = new BodyImage("data/enemyTankRight.gif", 7f);
            tank.addImage(image);
        } 
    }  
}