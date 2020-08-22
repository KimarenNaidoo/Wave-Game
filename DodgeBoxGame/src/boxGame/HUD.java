package boxGame;

import java.awt.*;

public class HUD {

    public static float HEALTH = 100;
    private float greenValue = 255; // RGB values go from 0 to 255 (0 = black)
    private int score = 0;
    private int level = 1;


    public void tick(){
        HEALTH = Game.clamp(HEALTH,0,100);
        greenValue = Game.clamp(greenValue, 0,255);
        greenValue = HEALTH*2;
        score++;
    }

    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75, (int)greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH*2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);// puts a border around the health bar
        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);

    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return level;
    }
}