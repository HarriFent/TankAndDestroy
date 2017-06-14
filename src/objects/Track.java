package objects;

import input.SpriteSheet;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import tankGame.ID;
import tankGame.TankGame;

public class Track extends GameObject {

    public Track(double x, double y, ID id, TankGame game) {
        super(x, y, id, game);
        w = (int) (SpriteList.tracksLarge.getw() * 0.7);
        h = (int) (SpriteList.tracksLarge.geth() * 0.5);
        stateTick = 255;
        collide = false;
    }

    @Override
    public void tick() {
        if (stateTick > 2) {
            stateTick -= 2;
        } else if (stateTick <= 2) {
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
        AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
        tx.rotate(angle, w / 2, h / 2);
        tx.scale(0.7, 0.5);
        g2d.drawImage(ss.grabImage(SpriteList.tracksLarge), tx, game);
        g2d.setComposite(ogComp);
    }

}
