package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 * The computer game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;
    private int level;
    private Controller controller;
    private SoundClip gameMusic;

    /** Initialise a new Game. */
    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);
        
        try {
            gameMusic = new SoundClip("data/sound/background.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        view = new MyView(world, world.getPlayer(), 1390, 800);
        //view.setZoom(30);
        view.setBackground(Color.white);
        

        // make a view
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);
        
        // display the view in a frame
        final JFrame frame = new JFrame("Trial Run");
        
        Container buttons = new ControlPanel(this);
        frame.add(buttons, BorderLayout.SOUTH);
        
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        view.addMouseListener(new DropBomb(view));
        
        
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        
        // uncomment to make the view track the Soldier
        //world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }
/** The player in the current level.
     * @return  */
    public Soldier getPlayer() {
        return world.getPlayer();
    }
    
    /**
     *
     */
    public void pause() {
        world.stop();
    }
    
    /**
     *
     */
    public void resume() {
        world.start();
    }
    
    /**
     *
     */
    public void restart() {
        world = new Level1();
        world.populate(this);
        try {
            gameMusic = new SoundClip("data/sound/background.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        controller.setBody(world.getPlayer());
        view.setWorld(world);
        world.start();
    }

    
    /** Is the current level of the game finished?
     * @return  */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        Soldier oldSoldier = world.getPlayer();
        if (level == 3) {
            System.out.println("Completed Game: Well Done!!!");
            System.exit(0);
        } else if (level == 1) {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.getPlayer().setInventoryCount(oldSoldier.getInventoryCount());
            // show the new world in the view
            view.setWorld(world);
            gameMusic.stop();
            try {
                gameMusic = new SoundClip("data/sound/mist.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            world.start();
        } else if (level == 2) {
            level ++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();  
            gameMusic.stop();
            try {
                gameMusic = new SoundClip("data/sound/sunsai.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
    }

    /**
     *
     * @return
     */
    public int getLevel() {
        return level;
    }

    
    /** Run the game.
     * @param args */
    public static void main(String[] args) {
        new Game();
     
        
    }

}
