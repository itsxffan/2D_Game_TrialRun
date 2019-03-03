/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.WorldView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Saffan Ahmed
 */
public class DropBomb extends MouseAdapter{
    private static final float RADIUS = 0.5f;
    
    private static final Shape ballShape
                = new CircleShape(RADIUS);
    
    private static final BodyImage ballImage
                = new BodyImage("data/bowl.png", 2*RADIUS);
    
    private WorldView view;

    public DropBomb(WorldView view) {
        this.view = view;
    }

    /**
     * Create a bowling ball at the current mouse position.
     * @param e event object containing the mouse position
     */
    public void mousePressed(MouseEvent e) {
        DynamicBody ball = new DynamicBody(view.getWorld(), ballShape);
        ball.setPosition(view.viewToWorld(e.getPoint()));
        ball.addImage(ballImage);
        //ball.addCollisionListener(new AvoidBombCollision(view.getWorld().getPlayer));
    }
    
}
