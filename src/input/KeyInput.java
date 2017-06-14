package input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import objects.GameObject;
import tankGame.ID;
import tankGame.TankGame;
import tankGame.TankGame.GameState;

public class KeyInput extends KeyAdapter {

    private boolean spacePressed, leftPressed, rightPressed, upPressed, downPressed;
    private TankGame game;

    public KeyInput(TankGame game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                upPressed = true;
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
            case KeyEvent.VK_SPACE:
                spacePressed = true;
                break;
            case KeyEvent.VK_ESCAPE:
                game.handler.clearObjects();
                game.gameState = GameState.MENU;
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
            case KeyEvent.VK_SPACE:
                spacePressed = false;
                break;
            default:
                break;
        }
    }

    public void tick() {
        if (game.gameState == GameState.GAME) {
            GameObject player = findPlayer();
            double dx = player.getVel() * Math.sin(player.getAngle());
            double dy = player.getVel() * Math.cos(player.getAngle());
            if (spacePressed) {

            }

            if (leftPressed && player.canMove(player.getAngle(), dx, dy)) {
                player.setAngle(player.getAngle() - Math.toRadians(5));
            } else if (rightPressed && player.canMove(player.getAngle(), dx, dy)) {
                player.setAngle(player.getAngle() + Math.toRadians(5));
            } 
            
            if (upPressed) {
                player.setVel(8);
            } else if (downPressed) {
                player.setVel(-8);
            } else {
                player.setVel(0);
            }
        }
    }

    private GameObject findPlayer() {
        for (int i = 0; i < game.handler.object.size(); i++) {
            GameObject temp = game.handler.object.get(i);
            if (temp.getID() == ID.PLAYER) {
                return temp;
            }
        }
        return null;
    }

}
