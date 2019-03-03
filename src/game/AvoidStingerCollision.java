/**
 *
 * @author Saffan Ahmed
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * 'AvoidStingerCollision - This class looks at the collision between the Stinger
 * and the soldier that needs to be avoided. Depending on what hazard/object they have collided with detrimental effects
 * occur.
 */
public class AvoidStingerCollision implements CollisionListener {
    private Soldier soldier;
    
    public AvoidStingerCollision(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void collide(CollisionEvent f) {
        if (f.getReportingBody() instanceof Stinger && f.getOtherBody() == soldier) {
            soldier.decrementHealthCount();
            f.getReportingBody().destroy();
        }
    }  
}
