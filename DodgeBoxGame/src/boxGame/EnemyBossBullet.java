package boxGame;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends GameObject {

    private Handler handler;
    Random r = new Random();

    public EnemyBossBullet(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        speedX = r.nextInt(5 - -5) + -5;// Random integer between (-5) and 5
        speedY = 5;

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick(){
        x += speedX;
        y += speedY;

        //if(y <= 0 || y >= (Game.HEIGHT) - 48) speedY *= -1;
        //if(x <= 0 || x >= (Game.WIDTH) - 32) speedX *= -1;

        if(y >= Game.HEIGHT) handler.removeObject(this);
        handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16, 16, 0.02f, handler));
    }

    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 16, 16);
    }

}
