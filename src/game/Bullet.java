/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;

/**
 *
 * @author Saffan Ahmed
 */
public class Bullet extends DynamicBody {
    
    public Bullet(World world) {
        super(world, new CircleShape(0.2f));
    }
    
}
