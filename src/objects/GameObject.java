package objects;

import input.SpriteSheet;
import tankGame.ID;
import tankGame.TankGame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
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
        int[] xs = new int[8];
        int[] ys = new int[8];
        double x1 = w / 2;
        double y1 = h / 2;
        double cenx = x + x1;
        double ceny = y + y1;

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 1:
                    y = y + y1;
                    break;
                case 2:
                    y = y + y1;
                    break;
                case 3:
                    x = x + x1;
                    break;
                case 4:
                    x = x + x1;
                    break;
                case 5:
                    y = y - y1;
                    break;
                case 6:
                    y = y - y1;
                    break;
                case 7:
                    x = x - x1;
                    break;
            }
            // translate point to origin
            double tempX = x - cenx;
            double tempY = y - ceny;

            // now apply rotation
            double rotatedX = tempX * Math.cos(angle) - tempY * Math.sin(angle);
            double rotatedY = tempX * Math.sin(angle) + tempY * Math.cos(angle);

            // translate back
            xs[i] = (int) (rotatedX + cenx);
            ys[i] = (int) (rotatedY + ceny);

        }
        return new Polygon(xs, ys, 8);
    }

    public boolean canMove(double angle, double dx, double dy) {
        Polygon p1 = getPBounds(angle, x + dx, y - dy, w, h);
        for (GameObject object : game.handler.object) {
            if (object.id != ID.PLAYER && object.collide) {
                Polygon p2 = object.getPBounds(object.getAngle(), object.x, object.y, object.w, object.h);
                for (int i = 0; i < p1.npoints; i++) {
                    Point cood = new Point(p1.xpoints[i], p1.ypoints[i]);
                    if (p2.contains(cood)) {
                        return false;
                    }
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
