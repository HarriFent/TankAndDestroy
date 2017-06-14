package objects;

import input.*;
import java.awt.Graphics;
import tankGame.*;

public class Background extends GameObject {

    public Background(int x, int y, ID id, TankGame game) {
        super(x, y, id, game);
        collide = false;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        for (int j = 0; j < 49; j++) {
            switch ((int)x) {
                case 0:
                    g.drawImage(ss.grabImage(SpriteList.dirt), (j % 7) * 128, (j / 7) * 128, game);
                    break;
                case 1:
                    g.drawImage(ss.grabImage(SpriteList.grass), (j % 7) * 128, (j / 7) * 128, game);
                    break;
                default:
                    g.drawImage(ss.grabImage(SpriteList.sand), (j % 7) * 128, (j / 7) * 128, game);
                    break;
            }
        }
    }

}
