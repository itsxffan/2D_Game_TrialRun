
package game;

import city.cs.engine.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A MouseListener that drops a bowling ball on each mouse press.
 */
public class DropBowlingBall extends MouseAdapter {

    private WorldView view;

    /**
     * Construct a listener.
     * @param view the view the mouse will be clicked on
     */
    public DropBowlingBall(WorldView view) {
        this.view = view;
    }

    /**
     * Create a bowling ball at the current mouse position.
     * @param e event object containing the mouse position
     */
    @Override
    public void mousePressed(MouseEvent e) {
        DynamicBody ball = new BowlingBall(view.getWorld());
        ball.setPosition(view.viewToWorld(e.getPoint()));
    }

    
           
 
}
