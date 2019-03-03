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
public class Unknown extends StaticBody {
    private static final Shape shape = new PolygonShape(-0.07f,1.48f, 1.45f,1.4f, 
            1.45f,-1.39f, -1.49f,-1.45f, -1.45f,1.39f, -1.36f,1.48f);

    private static final BodyImage image =
        new BodyImage("data/unknown.png", 2f);

    public Unknown(World world) {
        super(world, shape);
        addImage(image);
    }
    
}
