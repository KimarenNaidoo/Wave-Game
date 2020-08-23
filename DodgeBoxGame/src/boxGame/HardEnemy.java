package boxGame;

import java.awt.*;
import java.util.Random;

public class HardEnemy extends GameObject {

    private Handler handler;
    private Random r = new Random();
    public HardEnemy(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        speedX = 5;
        speedY = 5;

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick(){
        x += speedX;
        y += speedY;

        if(y <= 0 || y >= (Game.HEIGHT) - 48){
            if(speedY < 0) speedY = -(r.nextInt(7) + 1) * -1; else speedY = (r.nextInt(7) + 1) * -1;
        }
        if(x <= 0 || x >= (Game.WIDTH) - 32) {
            if(speedX < 0) speedX = -(r.nextInt(7) + 1) * -1; else speedX = (r.nextInt(7) + 1) * -1;
        }

        handler.addObject(new Trail(x, y, ID.Trail, Color.YELLOW, 16, 16, 0.02f, handler));
    }

    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect((int)x, (int)y, 16, 16);
    }

}
