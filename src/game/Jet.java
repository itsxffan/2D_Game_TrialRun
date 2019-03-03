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
public class Jet extends Walker{
    private static final Shape shape = new PolygonShape(0.27f,2.28f, 1.88f,1.81f, 2.98f,
            -0.02f, 0.97f,-1.89f, -1.59f,-1.92f, -2.79f,-0.78f, -2.75f,1.28f, -1.17f,2.35f


            );

    private static final BodyImage image =
        new BodyImage("data/enemyJet.gif", 7f);

    public Jet(World world) {
        super(world, shape);
        addImage(image);
    }
}
    
