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
public class Tank extends Walker{
    /**
     * WALK_SPEED: of the variable float type, will hold the value of the current speed which tank will travel.
     */
    private static final float WALK_SPEED = 4;
    private static final Shape shape = new PolygonShape(1.57f,3.21f, -5.57f,0.83f, -1.78f,
            -3.21f, 5.08f,-3.19f, 5.3f,-0.43f, 2.04f,3.21f

            );

    private static final BodyImage image =
        new BodyImage("data/enemyTank.gif", 7f);
    
    /**
     *
     * @param world
     */
    public Tank(World world) {
        super(world, shape);
        addImage(image);
    }
    
    /**
     *
     */
    public void moveRight() {
        this.startWalking(WALK_SPEED);
    }
    
    /**
     *
     */
    public void moveLeft() {
        this.startWalking(-WALK_SPEED);
    }
}
    
