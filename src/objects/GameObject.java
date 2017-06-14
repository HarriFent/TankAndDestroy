package objects;

import input.SpriteSheet;
import tankGame.ID;
import tankGame.TankGame;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import static objects.Player.getBounds;

public abstract class GameObject {

    protected double x, y;
    protected int w, h, index;
    protected ID id;
    protected double vel, accel, angle;
    protected boolean collide = true;
    protected int stateTick = 0;
    protected float alpha;
    protected TankGame game;

    public GameObject(double x, double y, ID id, TankGame game) {
        this.x = x;
        this.y = y;
        this.w = 20;
        this.h = 20;
        this.id = id;
        this.game = game;
    }

    public abstract void tick();

    public abstract void render(Graphics g, SpriteSheet ss);

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, w, h);
    }

    public static Rectangle getBounds(double angle, double x, double y, int w, int h) {
        while (angle > Math.PI / 2 || angle < 0) {
            if (angle > (Math.PI / 2)) {
                angle -= Math.PI / 2;
            } else if (angle < 0) {
                angle += Math.PI / 2;
            }
        }
        int x1, y1, w1, h1;
        h1 = (int) ((h * Math.cos(angle)) + (w * Math.sin(angle)));
        w1 = (int) ((h * Math.sin(angle)) + (w * Math.cos(angle)));
        y1 = (int) y - ((h1 - h) / 2);
        x1 = (int) x - ((w1 - w) / 2);
        return new Rectangle(x1, y1, w1, h1);
    }

    public static Polygon getPBounds(double angle, double x, double y, int w, int h) {
        int[] xs = {0, 0, 0, 0};
        int[] ys = {0, 0, 0, 0};
        for (int i = 1; i < 5; i++) {
            double z = Math.sqrt(((w * w) + (h * h)));
            double beta = ((Math.PI / 4) - angle);
            double x2 = z * Math.cos(beta + (i * (Math.PI / 4)));
            double y2 = z * Math.sin(beta + (i * (Math.PI / 4)));
            xs[i - 1] = (int) ((x + (w / 2)) + x2);
            ys[i - 1] = (int) ((y + (h / 2)) + y2);
        }
        return new Polygon(xs, ys, 4);
    }

    public boolean canMove(double angle, double dx, double dy) {
        Rectangle r1 = getBounds(angle, x + dx, y - dy, w, h);
        for (GameObject object : game.handler.object) {
            if (object.id != ID.PLAYER && object.collide) {
                Rectangle2D r2 = r1.createIntersection(object.getBounds());
                if (r2.getBounds().width > 0 && r2.getBounds().height > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getVel() {
        return vel;
    }

    public void setVel(double d) {
        vel = d;
    }

    public ID getID() {
        return id;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double d) {
        angle = d;
    }

}
