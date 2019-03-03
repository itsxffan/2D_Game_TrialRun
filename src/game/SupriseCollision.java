package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * 'SupriseCollision - This class looks at the collision between the SupriseBox 
 * and the soldier. As a result of the impact, the soldier will be spawned to a different position.
 */
public class SupriseCollision implements CollisionListener {
    private Soldier soldier;
    
    public SupriseCollision(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void collide(CollisionEvent h) {
        System.out.println("Suprise!");
        if (h.getReportingBody() instanceof Unknown && h.getOtherBody() == soldier) {
            soldier.setPosition(new Vec2(-25f, -10f));
            h.getReportingBody().destroy();
        } 
    }  
}