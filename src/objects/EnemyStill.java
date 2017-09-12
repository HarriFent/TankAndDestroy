package objects;

import input.SpriteSheet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import static objects.GameObject.getBounds;
import static objects.GameObject.getPBounds;
import tankGame.ID;
import tankGame.TankGame;

public class EnemyStill extends GameObject {

    double barrelAngle;
    int trackCount = 0;
    int shootCountDown = 120;
    private AffineTransform tx;

    public EnemyStill(int x, int y, ID id, TankGame game) {
        super(x, y, id, game);
        w = (int) (SpriteList.tankBeige_outline.getw() * 0.7);
        h = (int) (SpriteList.tankBeige_outline.geth() * 0.7);
        this.collide = false;
    }

    @Override
    public void tick() {
        if (shootCountDown > 0) {
            shootCountDown--;
        }
        for (GameObject obj : game.handler.object) {
            if (obj.id == ID.PLAYER) {
                barrelAngle = Math.atan2(obj.y - y, obj.x - x) - (Math.PI / 2);
            }
        }
        if (shootCountDown == 0) {
            Smoke smoke = new Smoke((x + (w / 2) - (58 * Math.sin(barrelAngle))), (y + (w / 2) + (58 * Math.cos(barrelAngle))), ID.SMOKE, game);
            smoke.collide = false;
            game.handler.addObject(smoke);
            Bullet bullet = new Bullet((x - 10 + (w / 2) - (58 * Math.sin(barrelAngle))), (y - 10 + (w / 2) + (58 * Math.cos(barrelAngle))), ID.BULLET, game);
            bullet.collide = false;
            bullet.setAngle(barrelAngle + Math.PI);
            bullet.setVel(10);
            game.handler.addObject(bullet);
            shootCountDown = 120;
        }
        for (GameObject obj : game.handler.object) {
            if (obj.id == ID.BULLET && obj.stateTick == 0) {
                Polygon p1 = getPBounds(angle, x, y, w, h);
                Polygon p2 = getPBounds(obj.angle, obj.x, obj.y, obj.w, obj.h);
                if (p1.contains(obj.x + (obj.w / 2), obj.y + (obj.h / 2))) {
                    ExplosionSmoke esmoke = new ExplosionSmoke(x + (w / 2), y + (w / 2), ID.SMOKE, game);
                    esmoke.collide = false;
                    game.handler.addObject(esmoke);
                    game.handler.removeObject(obj);
                    game.handler.removeObject(this);
                    game.enemyCount --;
                    return;
                }
            }
        }
    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        Graphics2D g2d = (Graphics2D) g;
        tx = AffineTransform.getTranslateInstance(x, y);
        tx.rotate(angle, (w / 2), (h / 2));
        tx.scale(0.7, 0.7);
        g2d.drawImage(ss.grabImage(SpriteList.tankBeige_outline), tx, game);
        tx = AffineTransform.getTranslateInstance(x + (w / 2) - 9, y + (h / 2) - 9);
        tx.rotate(barrelAngle, 8.4, 8.4);
        tx.scale(0.7, 0.7);
        g2d.drawImage(ss.grabImage(SpriteList.barrelBeige_outline), tx, game);

        double dx = vel * Math.sin(angle);
        double dy = vel * Math.cos(angle);
        Polygon p1 = getPBounds(angle, x + dx, y - dy, w, h);
    }

}
