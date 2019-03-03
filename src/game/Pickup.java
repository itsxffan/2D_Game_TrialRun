package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Collision listener that allows the soldier to collect things.
 */
public class Pickup implements CollisionListener {
    private Soldier soldier;
    
    /**
     *
     * @param soldier
     */
    public Pickup(Soldier soldier) {
        this.soldier = soldier;
    }

    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Item && e.getOtherBody() == soldier) {
            soldier.incrementInventoryCount();
            soldier.incrementPointScore();
            e.getReportingBody().destroy();
        } else if (e.getReportingBody() instanceof Flag && e.getOtherBody() == soldier) {
            System.exit(0);
        } else if (e.getReportingBody() instanceof Heart && e.getOtherBody() == soldier) {
            soldier.incrementHealthCount();
            e.getReportingBody().destroy();
        }
    }
}
