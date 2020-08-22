package boxGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {// maintain and update/render all the objects
    ArrayList<GameObject> object = new ArrayList<GameObject>();// holds all the game objects

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){// adds an GameObject to the LinkedList
        this.object.add(object);
    }

    public void removeObject(GameObject object){// removes an GameObject from the LinkedList
        this.object.remove(object);
    }

    public void clearEnemy(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            if(tempObject.getID() != ID.Player) {
                object.clear();
                if(Game.gameState != Game.STATE.End)
                addObject(new Player((int) tempObject.getX(),(int) tempObject.getY(), ID.Player, this));
            }
        }
    }
}
