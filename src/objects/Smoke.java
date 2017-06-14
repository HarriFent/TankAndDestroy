package objects;

import input.SpriteSheet;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import tankGame.ID;
import tankGame.TankGame;

public class Smoke extends GameObject {

    private double scaleCount = 0;

    public Smoke(double x, double y, ID id, TankGame game) {
        super(x, y, id, game);
        stateTick = 255;
    }

    @Override
    public void tick() {
        scaleCount++;
        if (stateTick > 0) {
            stateTick -= 5;
        } else if (stateTick <= 5) {
            game.handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        Graphics2D g2d = (Graphics2D) g;
        Composite ogComp = g2d.getComposite();
        float alpha = (float) stateTick / 255;
        AlphaComposite alphaComp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(alphaComp);
        w = (int) (SpriteList.smokeWhite3.getw() * (0.5+ (scaleCount / 40)));
        h = (int) (SpriteList.smokeWhite3.geth() * (0.5+ (scaleCount / 40)));
        AffineTransform tx = AffineTransform.getTranslateInstance(x-(w/2), y-(h/2));
        tx.scale(0.5 + (scaleCount / 40), 0.5 + (scaleCount / 40));
        if (stateTick > 235) {
            g2d.drawImage(ss.grabImage(SpriteList.smokeWhite3), tx, game);
        } else if (stateTick > 215) {
            g2d.drawImage(ss.grabImage(SpriteList.smokeWhite4), tx, game);
        } else {
            g2d.drawImage(ss.grabImage(SpriteList.smokeWhite5), tx, game);
        }
        g2d.setComposite(ogComp);
    }

}
