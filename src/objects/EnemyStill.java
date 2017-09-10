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
        
    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        
    }
    
}
