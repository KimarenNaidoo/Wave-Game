package boxGame;

import java.awt.*;

public class FastEnemy extends GameObject {

    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        speedX = 2;
        speedY = 9;

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick(){
        x += speedX;
        y += speedY;

        if(y <= 0 || y >= (Game.HEIGHT) - 48) speedY *= -1;
        if(x <= 0 || x >= (Game.WIDTH) - 32) speedX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN, 16, 16, 0.02f, handler));
    }

    public void render(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, 16, 16);
    }

}
