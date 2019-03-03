package game;

import city.cs.engine.*;

/**
 * 'AvoidSpikeCollision - This class looks at the collision between the Spikes Hazard
 * and the soldier that needs to be avoided. Depending on what hazard/object they have collided with detrimental effects
 * occur.
 */
public class AvoidSpikeCollision implements CollisionListener {
    private Soldier soldier;
    
    public AvoidSpikeCollision(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void collide(CollisionEvent h) {
        if (h.getReportingBody() instanceof Spike && h.getOtherBody() == soldier) {
            soldier.decrementHealthCount();
            h.getReportingBody().destroy();
        } 
    }  
}