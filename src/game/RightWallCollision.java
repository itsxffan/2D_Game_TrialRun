/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author Saffan Ahmed
 */
public class RightWallCollision implements CollisionListener  {
    private Tank tank;
    
    public RightWallCollision(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void collide(CollisionEvent h) {
        if (h.getOtherBody() == tank) {
            tank.moveLeft();
            tank.removeAllImages();
            BodyImage image = new BodyImage("data/enemyTank.gif", 7f);
            tank.addImage(image);
        } 
    }  
}
