package objects;

import input.SpriteSheet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
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
        AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
        tx.rotate(angle, (w / 2), (h / 2));
        Graphics2D g2d = (Graphics2D) g;
        switch (id) {
            case SANDBAG:
                g2d.drawImage(ss.grabImage(SpriteList.sandbagBeige), tx, game);
                break;
            case SANDBAG2:
                g2d.drawImage(ss.grabImage(SpriteList.sandbagBrown), tx, game);
                break;
        }
    }

}
