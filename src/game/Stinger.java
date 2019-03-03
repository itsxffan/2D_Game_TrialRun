/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * @author Saffan Ahmed
 */
public class Stinger extends Walker{
    private static final float WALK_SPEED = 4;
    private static final Shape shape = new PolygonShape(0.08f,1.99f, 1.42f,0.42f, 1.96f,-0.68f, 
            1.09f,-1.94f, -1.4f,-1.9f, -1.9f,-0.4f, -1.08f,1.74f

            );

    private static final BodyImage image =
        new BodyImage("data/enemyStinger.gif", 4f);

    public Stinger(World world) {
        super(world, shape);
        addImage(image);
    }
    
    public void moveRight() {
        this.startWalking(WALK_SPEED);
    }
    
    public void moveLeft() {
        this.startWalking(-WALK_SPEED);
    }
}
