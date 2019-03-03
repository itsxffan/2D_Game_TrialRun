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
public class Enemy extends Walker{
    private static final float WALK_SPEED = 4;
    private static final Shape shape = new PolygonShape(0.48f,1.78f, 1.78f,-0.54f, 0.9f,-1.88f, 
            -1.7f,-0.81f, -1.8f,0.56f, -0.94f,1.43f, 0.0f,1.7f
            );

    private static final BodyImage image =
        new BodyImage("data/enemySoldier.png", 4f);

    public Enemy(World world) {
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
    
