package tankGame;

import input.SpriteSheet;
import java.awt.Graphics;
import java.util.LinkedList;
import objects.GameObject;

public class Handler {

    public LinkedList<GameObject> object = new LinkedList<>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g, SpriteSheet ss) {
        orderObjects();
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g, ss);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
        object.setIndex(this.object.size() - 1);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public void clearObjects() {
        object = new LinkedList<GameObject>();
    }

    private void orderObjects() {
        LinkedList<GameObject> object2 = new LinkedList<>();
        for (ID id : ID.values()){
            for (GameObject obj : object) {
                if (obj.getID() == id){
                    object2.add(obj);
                }
            }
        }
        object = object2;
    }
}
