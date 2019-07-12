package objects;

import input.SpriteSheet;
import java.awt.Color;
import tankGame.ID;
import tankGame.TankGame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import static objects.GameObject.getPBounds;

public class Player extends GameObject {

    double barrelAngle;
    int trackCount = 0;
    int shootCountDown = 0;
    private AffineTransform tx;

    public Player(int x, int y, double angle, ID id, TankGame game) {
        super(x, y, id, game);
        w = (int) (SpriteList.tankGreen_outline.getw() * 0.7);
        h = (int) (SpriteList.tankGreen_outline.geth() * 0.7);
        barrelAngle = Math.toRadians(0);
        this.angle = angle;
    }

    @Override
    public void tick() {
        if (trackCount == 6) {
            trackCount = 0;
            Track track = new Track(x, y, ID.TRACKS, game);
            track.setAngle(angle);
            game.handler.addObject(track);
        }
        if (shootCountDown > 0) {
            shootCountDown--;
        }
        trackCount++;

        barrelAngle = Math.atan2(game.mouseInput.y - 20 - y, game.mouseInput.x - 20 - x) - (Math.PI / 2);
        if (game.mouseInput.clicked && shootCountDown == 0) {
            Smoke smoke = new Smoke((x + (w / 2) - (58 * Math.sin(barrelAngle))), (y + (w / 2) + (58 * Math.cos(barrelAngle))), ID.SMOKE, game);
            smoke.collide = false;
            game.handler.addObject(smoke);
            Bullet bullet = new Bullet((x - 10 + (w / 2) - (58 * Math.sin(barrelAngle))), (y - 10 + (w / 2) + (58 * Math.cos(barrelAngle))), ID.BULLET, game);
            bullet.collide = false;
            bullet.setAngle(barrelAngle + Math.PI);
            bullet.setVel(10);
            game.handler.addObject(bullet);
            shootCountDown = 30;
        }

        for (GameObject obj : game.handler.object) {
            if (obj.id == ID.BULLET && obj.stateTick == 0) {
                Rectangle2D r1 = getBounds(angle, x, y, w, h).createIntersection(obj.getBounds(obj.angle, obj.x, obj.y, obj.w, obj.h));
                if (r1.getWidth() > 0 && r1.getHeight() > 0) {
                    ExplosionSmoke esmoke = new ExplosionSmoke(x + (w / 2), y + (w / 2), ID.SMOKE, game);
                    esmoke.collide = false;
                    game.handler.addObject(esmoke);
                    game.handler.removeObject(obj);
                    game.handler.removeObject(this);
                    
                    return;
                }
            }
        }

        if (vel > 0 || vel < 0) {
            double dx = vel * Math.sin(angle);
            double dy = vel * Math.cos(angle);
            if (canMove(angle, dx, dy)) {
                x = x + dx;
                y = y - dy;
                vel = 0;
            }
        }

        while (angle > Math.PI * 2 || angle < 0) {
            if (angle > (Math.PI * 2)) {
                angle -= Math.PI * 2;
            } else if (angle < 0) {
                angle += Math.PI * 2;
            }
        }
    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        Graphics2D g2d = (Graphics2D) g;
        tx = AffineTransform.getTranslateInstance(x, y);
        tx.rotate(angle, (w / 2), (h / 2));
        tx.scale(0.7, 0.7);
        g2d.drawImage(ss.grabImage(SpriteList.tankGreen_outline), tx, game);
        tx = AffineTransform.getTranslateInstance(x + (w / 2) - 9, y + (h / 2) - 9);
        tx.rotate(barrelAngle, 8.4, 8.4);
        tx.scale(0.7, 0.7);
        g2d.drawImage(ss.grabImage(SpriteList.barrelGreen_outline), tx, game);

        double dx = vel * Math.sin(angle);
        double dy = vel * Math.cos(angle);
        Polygon p1 = getPBounds(angle, x + dx, y - dy, w, h);
//        g.setColor(Color.red);
//        for (int i = 0; i < p1.npoints; i++) {
//            Point cood = new Point(p1.xpoints[i], p1.ypoints[i]);
//            g.drawOval(cood.x - 3, cood.y - 3, 6, 6);
//        }
    }

}
