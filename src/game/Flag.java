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
public class Flag extends Walker {
    private static final Shape shape = new PolygonShape(0.67f,1.47f, 1.26f,1.07f, 1.33f,
            -0.26f, -0.1f,-1.45f, -1.17f,-0.45f, -1.16f,1.19f, -0.77f,1.42f
            );

    private static final BodyImage image =
        new BodyImage("data/flag.gif", 3f);

    public Flag(World world) {
        super(world, shape);
        addImage(image);
    }
}
