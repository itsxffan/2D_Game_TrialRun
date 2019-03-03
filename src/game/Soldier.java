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
public class Soldier extends Walker{
    
    private static final Shape shape = new PolygonShape(-0.13f,1.97f, 1.04f,-0.01f, 0.26f,-1.93f, 
            -0.81f,-1.97f, -1.05f,0.58f, -0.52f,1.94f);

    private static final BodyImage image =
        new BodyImage("data/soldier.png", 4f);

    private int orangeCount;
    private int inventoryCount;
    private int pointScore;
    private int healthCount;
    private int count;
    
    public Soldier(World world) {
        super(world, shape);
        addImage(image);
        orangeCount = 0;
        inventoryCount = 0;
        pointScore = 0;
        healthCount = 10;
        count = 0;
    }
    
    public int getInventoryCount() {
        return inventoryCount;
    }
    
    public int getHealthCount() {
        return healthCount;
    }
    
    public int getPointScore() {
        return pointScore;
    }
    
    public void incrementInventoryCount() {
        inventoryCount++;
        System.out.println("Picked Item! Inventory Count = " + inventoryCount);
    }
    
    public void decrementHealthCount() {
        healthCount--;
        if (healthCount == 0) {
            System.out.println("Game Over!");
            System.exit(0);
        } else if (healthCount <= 5) {
            System.out.println("Be careful you are losing life fast! Health = " + healthCount);
        } else {
            System.out.println("Outch! Health =  " + healthCount);
        }
    }
    
    public void incrementHealthCount() {
        healthCount++;
        System.out.println("Health Added! Health " + healthCount);
    }
    
    public void incrementPointScore() {
        pointScore++;
        System.out.println("Point + 1 Total Points =  " + pointScore);
    }
    
    public void setInventoryCount(int cnt) {
        inventoryCount = cnt;
    }
    
}
