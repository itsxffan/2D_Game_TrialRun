/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author Saffan Ahmed
 */
public class StingerHeartCollision implements CollisionListener {
    private Stinger stinger;
    
    public StingerHeartCollision(Stinger stinger) {
        this.stinger = stinger;
    }

    @Override
    public void collide(CollisionEvent f) {
        if (f.getReportingBody() instanceof Heart && f.getOtherBody() == stinger) {
            f.getReportingBody().destroy();
        }
    }  
}
