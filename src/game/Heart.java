/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Saffan Ahmed
 */
public class Heart extends StaticBody {
    private static SoundClip heartSound;
    private static final Shape shape = new PolygonShape(0.48f,0.813f, 0.893f,0.35f, 0.573f,
            -0.83f, -0.8f,-0.793f, -0.91f,0.447f, -0.477f,0.87f);

    private static final BodyImage image =
        new BodyImage("data/heart.png", 2f);   
    
    public Heart(World world) {
        super(world, shape);
        addImage(image);
    }
    static {
        try {
           heartSound = new SoundClip("data/heartSound.wav");
           System.out.println("Loading heart sound");
           //heartSound.play();
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }  
    }
}
