package objects;

import input.SpriteSheet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import static objects.GameObject.getBounds;
import tankGame.ID;
import tankGame.TankGame;

public class Bullet extends GameObject {

    Rectangle2D drawR = new Rectangle();
    int bounceCount = 0;

    public Bullet(double x, double y, ID id, TankGame game) {
        super(x, y, id, game);
        w = (int) (SpriteList.bulletSilverSilver_outline.getw() * 0.5);
        h = (int) (SpriteList.bulletSilverSilver_outline.geth() * 0.5);
        stateTick = 5;
    }

    @Override
    public void tick() {
        if (stateTick > 0) {
            stateTick--;
        }
        if (bounceCount > 2) {
            game.handler.removeObject(this);
        }

        double dx = vel * Math.sin(angle);
        double dy = vel * Math.cos(angle);
        Rectangle r1 = getBounds(angle, x + dx, y - dy, w, h);
        for (GameObject object : game.handler.object) {
            if (object.collide) {
                Rectangle2D r2 = r1.createIntersection(object.getBounds());
                if (r2.getWidth() > 0 && r2.getHeight() > 0) {
                    drawR = r2;
                    if (r2.getWidth() < r2.getHeight()) {
                        if ((r2.getX() == object.x) || (r2.getX() + r2.getWidth() == object.x + object.w)) {
                            angle = (2 * Math.PI - angle);
                            bounceCount++;
                            return;
                        }
                    } else if (r2.getWidth() > r2.getHeight()) {
                        if ((r2.getY() == object.y) || (r2.getY() + r2.getHeight() == object.y + object.h)) {
                            angle = (Math.PI - angle);
                            bounceCount++;
                            return;
                        }
                    }
                }
            }
        }
        x = x + dx;
        y = y - dy;
    }

    @Override
    public void render(Graphics g, SpriteSheet ss
    ) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
        tx.rotate(angle, w / 2, h / 2);
        tx.scale(0.5, 0.5);
        g2d.drawImage(ss.grabImage(SpriteList.bulletSilverSilver_outline), tx, game);
    }

}
