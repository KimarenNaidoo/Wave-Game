package boxGame;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject {

    private Handler handler;
    Random r = new Random();
    private Color col;


    public MenuParticle(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;

        speedX = r.nextInt(5 - -5) + -5;
        speedY = r.nextInt(5 - -5) + -5;

        // if the speed ever hits zero
        if(speedX == 0) speedX = 1;
        if (speedY == 0) speedY = 1;

        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick(){
        x += speedX;
        y += speedY;

        if(y <= 0 || y >= (Game.HEIGHT) - 48) speedY *= -1;
        if(x <= 0 || x >= (Game.WIDTH) - 32) speedX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, col, 16, 16, 0.02f, handler));
    }

    public void render(Graphics g){
        g.setColor(col);
        g.fillRect((int)x, (int)y, 16, 16);
    }

}
