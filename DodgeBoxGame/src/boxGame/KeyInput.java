package boxGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler){
        this.handler = handler;
        for(int i = 0; i < keyDown.length; i++){
            keyDown[i] = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Player) {
                // all key events for player1
                if (key == KeyEvent.VK_W) { tempObject.setSpeedY(-5); keyDown[0] = true; }
                if (key == KeyEvent.VK_S) { tempObject.setSpeedY(5); keyDown[1] = true; }
                if (key == KeyEvent.VK_D) { tempObject.setSpeedX(5); keyDown[2] = true; }
                if (key == KeyEvent.VK_A) { tempObject.setSpeedX(-5); keyDown[3] = true; }

            }
        }
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Player){
                // all key events for player1
                if(key == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setSpeedY(0);
                if(key == KeyEvent.VK_S) keyDown[1] = false;//tempObject.setSpeedY(0);
                if(key == KeyEvent.VK_D) keyDown[2] = false;//tempObject.setSpeedX(0);
                if(key == KeyEvent.VK_A) keyDown[3] = false;//tempObject.setSpeedX(0);

                // vertical movement
                if(!keyDown[0] && !keyDown[1]) tempObject.setSpeedY(0);
                // horizontal movement
                if(!keyDown[2] && !keyDown[3]) tempObject.setSpeedX(0);
            }
        }
    }
}
