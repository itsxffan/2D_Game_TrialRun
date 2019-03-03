package game;

import city.cs.engine.*;

/**
 * 'AvoidTankCollision - This class looks at the collision between the Bullet
 * and the Stinger. Depending on what hazard/object they have collided with detrimental effects
 * occur.
 */
public class BulletCollision implements CollisionListener {
    private Stinger stinger;
    
    public BulletCollision(Stinger stinger) {
        this.stinger = stinger;
    }

    @Override
    public void collide(CollisionEvent f) {
        if (f.getReportingBody() instanceof Bullet && f.getOtherBody() == stinger) {
            f.getOtherBody().destroy();
            //f.getReportingBody().destroy();
        }
    }  
}