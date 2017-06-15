package objects;

import input.SpriteSheet;
import java.awt.Graphics;
import tankGame.ID;
import tankGame.TankGame;

public class Sandbag extends GameObject {

    public Sandbag(int x, int y, ID id, TankGame game) {
        super(x, y, id, game);
        w = SpriteList.sandbagBeige.getw();
        h = SpriteList.sandbagBeige.geth();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        switch (id) {
            case SANDBAG:
                g.drawImage(ss.grabImage(SpriteList.sandbagBeige), (int) x, (int) y, game);
                break;
            case SANDBAG2:
                g.drawImage(ss.grabImage(SpriteList.sandbagBrown), (int) x, (int) y, game);
                break;
        }
    }

}
