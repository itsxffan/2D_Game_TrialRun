package game;

import city.cs.engine.*;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {
    private Game game;
    
    public DoorListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Soldier player = game.getPlayer();
        boolean levelDone = game.isCurrentLevelCompleted();
        System.out.println("Door access granted!"+ levelDone);
        if (e.getOtherBody() == player && levelDone) {
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
}
