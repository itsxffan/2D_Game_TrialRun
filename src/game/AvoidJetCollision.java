package game;

import city.cs.engine.*;

/**
 * 'AvoidJetCollision - This class looks at the collision between the Jet
 * and the soldier that needs to be avoided. Depending on what hazard/object they have collided with detrimental effects
 * occur.
 */
public class AvoidJetCollision implements CollisionListener {
    private Soldier soldier;
    
    public AvoidJetCollision(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void collide(CollisionEvent f) {
        if (f.getReportingBody() instanceof Jet && f.getOtherBody() == soldier) {
            soldier.decrementHealthCount();
            f.getReportingBody().destroy();
        } 
    }  
}