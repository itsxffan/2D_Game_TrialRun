package game;

import city.cs.engine.*;

/**
 * LeftWallCollision - This class looks at the collision between the Left Wall Border and Tank. 
 * Depending on what hazard/object they have collided with detrimental effects
 * will occur.
 */
public class HBRightCollision implements CollisionListener {
    private Enemy enemySoldier;
    
    public HBRightCollision(Enemy enemy) {
        this.enemySoldier = enemySoldier;
    }

    @Override
    public void collide(CollisionEvent h) {
        if (h.getOtherBody() == enemySoldier) {
            enemySoldier.moveLeft();
            enemySoldier.removeAllImages();
            BodyImage image = new BodyImage("data/enemySoldier.png", 4f);
            enemySoldier.addImage(image);
        } 
    }  
}