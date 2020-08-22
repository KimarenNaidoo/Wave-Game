package boxGame;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r= new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        x = Game.clamp(x, 0, Game.WIDTH - 48);
        y = Game.clamp(y, 0, Game.HEIGHT - 70);

        handler.addObject(new Trail(x, y, ID.Trail, Color.WHITE, 32, 32, 0.07f, handler));

        collision();
    }

    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject temp = handler.object.get(i);

            if(temp.getID() == ID.BasicEnemy || temp.getID() == ID.FastEnemy || temp.getID() == ID.SmartEnemy){ // temp is now BasicEnemy
                if(getBounds().intersects(temp.getBounds())){
                    // collision code
                    HUD.HEALTH -= 2;

                }
            }
        }
    }

    @Override
    public void render(Graphics g) {


        g.setColor(Color.WHITE);
        g.fillRect((int)x, (int)y, 32, 32);
    }


}
