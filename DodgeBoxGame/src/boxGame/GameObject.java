package boxGame;

import java.awt.*;

public abstract class GameObject {// refers to all the game objects
    protected float x, y;
    protected ID id;
    protected float speedX, speedY;

    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();// using rectangles for the collision

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void setID(ID id){
        this.id = id;
    }

    public ID getID(){
        return id;
    }

    public void setSpeedX(int speedX){
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY){
        this.speedY = speedY;
    }

    public float getSpeedX(){
        return speedX;
    }

    public float getSpeedY(){
        return speedY;
    }
}
