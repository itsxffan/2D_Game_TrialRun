package game;

import city.cs.engine.*;

/**
 * 'AvoidTankCollision - This class looks at the collision between the Tank
 * and the soldier that needs to be avoided. Depending on what hazard/object they have collided with detrimental effects
 * occur.
 */
public class AvoidTankCollision implements CollisionListener {
    /**
     * Soldier: conditional variable that will be used to implement the collision between the tank and soldier.
     */
    private Soldier soldier;
  
    /**
     *
     * @param soldier
     */
    public AvoidTankCollision(Soldier soldier) {
        this.soldier = soldier;
    }

    /**
     *
     * @param f
     */
    @Override
    public void collide(CollisionEvent f) {
        if (f.getReportingBody() instanceof Tank && f.getOtherBody() == soldier) {
            soldier.decrementHealthCount();
            //f.getReportingBody().destroy();
        }
    }  
}