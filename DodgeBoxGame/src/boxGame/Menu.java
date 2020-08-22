package boxGame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private HUD hud;
    Random r  = new Random();

    public Menu(Game game, Handler handler,HUD hud){
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(game.gameState == Game.STATE.Menu){

            // Game btn
            if(mouseOver(mx, my, 200, 100, 225, 64)){
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemy();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }

            // Help btn
            if(mouseOver(mx, my, 200, 200, 225, 64)){
                game.gameState = Game.STATE.Help;
            }

            if(game.gameState == Game.STATE.Help){
                if(mouseOver(mx, my, 200, 300, 225,64)){
                    game.gameState = Game.STATE.Menu;
                    return;
                }
            }

            // Quit btn
            if(mouseOver(mx, my, 200, 300, 225,64)){
                System.exit(1);
            }
        }

        // Getting back to the Menu from Help
        if(game.gameState == Game.STATE.Help){
            if(mouseOver(mx, my, 200, 300, 225,64)){
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        // Try again btn
        if(game.gameState == Game.STATE.End){
            if(mouseOver(mx, my, 200, 300, 225,64)){
                game.gameState = Game.STATE.Game;
                hud.setLevel(1);
                hud.setScore(0);
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemy();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));

            }
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){// checks to see where the mouse clicks the field
        if(mx > x && mx < x + width){
            if (my > y && my < y + height){
                return true;
            }else return false;
        }else return false;
    }

    public void tick(){

    }

    public void render(Graphics g){
        if(game.gameState == Game.STATE.Menu){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("Wave", 248, 70);

            g.setFont(fnt2);
            g.drawRect(200, 100, 225, 64);
            g.drawString("Play", 280, 144);

            g.setColor(Color.WHITE);
            g.drawRect(200, 200, 225, 64);
            g.drawString("Help", 280, 244);

            g.setColor(Color.WHITE);
            g.drawRect(200, 300, 225, 64);
            g.drawString("Quit", 280, 344);
        }else if(game.gameState == Game.STATE.Help){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("Help", 248, 70);

            g.setFont(fnt3);
            g.drawString("The WASD keys are used to dodge the enemies.", 100,200);

            g.setFont(fnt2);
            g.drawRect(200, 300, 225, 64);
            g.drawString("Back", 280, 344);
        }else if(game.gameState == Game.STATE.End){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("Game Over", 200, 70);

            g.setFont(fnt3);
            g.drawString("You lost with a score of: " + hud.getScore(), 100,200);

            g.setFont(fnt2);
            g.drawRect(200, 300, 225, 64);
            g.drawString("Try Again", 245, 344);
        }

    }

}
