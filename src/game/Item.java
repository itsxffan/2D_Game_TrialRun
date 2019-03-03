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
public class Item extends StaticBody{
    private static final Shape shape = new PolygonShape(0.482f,0.702f, 0.787f,0.653f, 0.839f,0.367f, 
            0.795f,-0.698f, -0.679f,-0.724f, -0.865f,-0.244f, -0.754f,0.676f

            );

    private static final BodyImage image =
        new BodyImage("data/ammo.png", 1.5f);

    public Item(World world) {
        super(world, shape);
        addImage(image);
    }
}