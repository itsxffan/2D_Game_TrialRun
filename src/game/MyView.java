package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import java.awt.Color;

/**
 * extended view
 */
public class MyView extends UserView {
    Soldier soldier;
    
    private Image background;
    
    public MyView(World world, Soldier soldier, int width, int height) {
        super(world, width, height);
        this.soldier = soldier;
        this.background = new ImageIcon("data/background.png").getImage();
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, 1390, 800, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("INVENTORY: " + soldier.getInventoryCount(), 60, 60);
        g.setColor(Color.WHITE);
        g.drawString("HEALTH: " + soldier.getHealthCount(), 60, 80);
        g.setColor(Color.WHITE);
        g.drawString("POINTS: " + soldier.getPointScore(), 60, 100);
        g.setColor(Color.WHITE);
        
    }


}
