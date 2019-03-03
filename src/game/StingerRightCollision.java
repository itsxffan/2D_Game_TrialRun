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
public class StingerRightCollision implements CollisionListener {
    private Stinger stinger;
    
    public StingerRightCollision(Stinger stinger) {
        this.stinger = stinger;
    }

    @Override
    public void collide(CollisionEvent h) {
        if (h.getOtherBody() == stinger) {
            stinger.moveLeft();
            stinger.removeAllImages();
            BodyImage image = new BodyImage("data/enemyStingerLeft.gif", 4f);
            stinger.addImage(image);
        } 
    }  
}
