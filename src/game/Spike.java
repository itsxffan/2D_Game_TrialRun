/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author Saffan Ahmed
 */
public class Spike extends StaticBody {
    private static final Shape shape = new PolygonShape(0.0f,1.48f, 1.08f,-1.49f, 
            -1.0f,-1.48f, -1.04f,-0.11f, -0.37f,1.23f);

    private static final BodyImage image =
        new BodyImage("data/spike.png", 1.5f);

    public Spike(World world) {
        super(world, shape);
        addImage(image);
    }
    
}
