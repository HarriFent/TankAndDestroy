package objects;

import input.SpriteSheet;
import java.awt.Graphics;
import tankGame.ID;
import tankGame.TankGame;

public class EnemyStill extends GameObject{

    public EnemyStill(int x, int y, ID id, TankGame game) {
        super(x, y, id, game);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
