package game;

import city.cs.engine.*;

/**
 * 'AvoidEnemyCollision - This class looks at the collision between the Enemy
 * and the soldier that needs to be avoided. Depending on what hazard/object they have collided with detrimental effects
 * occur.
 */
public class AvoidEnemyCollision implements CollisionListener {
    private Soldier soldier;
    
    public AvoidEnemyCollision(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void collide(CollisionEvent f) {
        if (f.getReportingBody() instanceof Enemy && f.getOtherBody() == soldier) {
            soldier.decrementHealthCount();
            f.getReportingBody().destroy();
        } 
    }  
}
