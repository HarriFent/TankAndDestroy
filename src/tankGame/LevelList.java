package tankGame;

import java.util.HashSet;
import java.util.Set;
import objects.*;

public enum LevelList {
    level0(0, 0, ID.BACKGROUND, 0.0,
            0, 0, ID.SANDBAG, 0.0,
            0, 44, ID.SANDBAG, 0.0,
            0, 88, ID.SANDBAG, 0.0,
            0, 132, ID.SANDBAG, 0.0,
            0, 176, ID.SANDBAG, 0.0,
            0, 220, ID.SANDBAG, 0.0,
            0, 264, ID.SANDBAG, 0.0,
            0, 308, ID.SANDBAG, 0.0,
            0, 352, ID.SANDBAG, 0.0,
            0, 396, ID.SANDBAG, 0.0,
            0, 440, ID.SANDBAG, 0.0,
            0, 484, ID.SANDBAG, 0.0,
            0, 528, ID.SANDBAG, 0.0,
            0, 572, ID.SANDBAG, 0.0,
            0, 616, ID.SANDBAG, 0.0,
            0, 660, ID.SANDBAG, 0.0,
            0, 704, ID.SANDBAG, 0.0,
            0, 748, ID.SANDBAG, 0.0,
            66, 0, ID.SANDBAG, 0.0,
            132, 0, ID.SANDBAG, 0.0,
            198, 0, ID.SANDBAG, 0.0,
            264, 0, ID.SANDBAG, 0.0,
            330, 0, ID.SANDBAG, 0.0,
            396, 0, ID.SANDBAG, 0.0,
            462, 0, ID.SANDBAG, 0.0,
            528, 0, ID.SANDBAG, 0.0,
            594, 0, ID.SANDBAG, 0.0,
            660, 0, ID.SANDBAG, 0.0,
            726, 0, ID.SANDBAG, 0.0,
            726, 44, ID.SANDBAG, 0.0,
            726, 88, ID.SANDBAG, 0.0,
            726, 132, ID.SANDBAG, 0.0,
            726, 176, ID.SANDBAG, 0.0,
            726, 220, ID.SANDBAG, 0.0,
            726, 264, ID.SANDBAG, 0.0,
            726, 308, ID.SANDBAG, 0.0,
            726, 352, ID.SANDBAG, 0.0,
            726, 396, ID.SANDBAG, 0.0,
            726, 440, ID.SANDBAG, 0.0,
            726, 484, ID.SANDBAG, 0.0,
            726, 528, ID.SANDBAG, 0.0,
            726, 572, ID.SANDBAG, 0.0,
            726, 616, ID.SANDBAG, 0.0,
            726, 660, ID.SANDBAG, 0.0,
            726, 704, ID.SANDBAG, 0.0,
            726, 748, ID.SANDBAG, 0.0,
            66, 748, ID.SANDBAG, 0.0,
            132, 748, ID.SANDBAG, 0.0,
            198, 748, ID.SANDBAG, 0.0,
            264, 748, ID.SANDBAG, 0.0,
            330, 748, ID.SANDBAG, 0.0,
            396, 748, ID.SANDBAG, 0.0,
            462, 748, ID.SANDBAG, 0.0,
            528, 748, ID.SANDBAG, 0.0,
            594, 748, ID.SANDBAG, 0.0,
            660, 748, ID.SANDBAG, 0.0,
            300, 300, ID.SANDBAG, 0.0,
            300, 344, ID.SANDBAG, 0.0,
            300, 388, ID.SANDBAG, 0.0,
            300, 432, ID.SANDBAG, 0.0,
            500, 350, ID.ENEMY_STILL, 0.0,
            100, 100, ID.PLAYER, 135.0),
    level1(2, 0, ID.BACKGROUND, 0.0,
            0, 0, ID.SANDBAG, 0.0,
            0, 44, ID.SANDBAG, 0.0,
            0, 88, ID.SANDBAG, 0.0,
            0, 132, ID.SANDBAG, 0.0,
            0, 176, ID.SANDBAG, 0.0,
            0, 220, ID.SANDBAG, 0.0,
            0, 264, ID.SANDBAG, 0.0,
            0, 308, ID.SANDBAG, 0.0,
            0, 352, ID.SANDBAG, 0.0,
            0, 396, ID.SANDBAG, 0.0,
            0, 440, ID.SANDBAG, 0.0,
            0, 484, ID.SANDBAG, 0.0,
            0, 528, ID.SANDBAG, 0.0,
            0, 572, ID.SANDBAG, 0.0,
            0, 616, ID.SANDBAG, 0.0,
            0, 660, ID.SANDBAG, 0.0,
            0, 704, ID.SANDBAG, 0.0,
            0, 748, ID.SANDBAG, 0.0,
            66, 0, ID.SANDBAG, 0.0,
            132, 0, ID.SANDBAG, 0.0,
            198, 0, ID.SANDBAG, 0.0,
            264, 0, ID.SANDBAG, 0.0,
            330, 0, ID.SANDBAG, 0.0,
            396, 0, ID.SANDBAG, 0.0,
            462, 0, ID.SANDBAG, 0.0,
            528, 0, ID.SANDBAG, 0.0,
            594, 0, ID.SANDBAG, 0.0,
            660, 0, ID.SANDBAG, 0.0,
            726, 0, ID.SANDBAG, 0.0,
            726, 44, ID.SANDBAG, 0.0,
            726, 88, ID.SANDBAG, 0.0,
            726, 132, ID.SANDBAG, 0.0,
            726, 176, ID.SANDBAG, 0.0,
            726, 220, ID.SANDBAG, 0.0,
            726, 264, ID.SANDBAG, 0.0,
            726, 308, ID.SANDBAG, 0.0,
            726, 352, ID.SANDBAG2, 0.0,
            726, 396, ID.SANDBAG, 0.0,
            726, 440, ID.SANDBAG, 0.0,
            726, 484, ID.SANDBAG2, 0.0,
            726, 528, ID.SANDBAG, 0.0,
            726, 572, ID.SANDBAG, 0.0,
            726, 616, ID.SANDBAG, 0.0,
            726, 660, ID.SANDBAG, 0.0,
            726, 704, ID.SANDBAG2, 0.0,
            726, 748, ID.SANDBAG, 0.0,
            66, 748, ID.SANDBAG, 0.0,
            132, 748, ID.SANDBAG, 0.0,
            198, 748, ID.SANDBAG2, 0.0,
            264, 748, ID.SANDBAG, 0.0,
            330, 748, ID.SANDBAG, 0.0,
            396, 748, ID.SANDBAG, 0.0,
            462, 748, ID.SANDBAG, 0.0,
            528, 748, ID.SANDBAG, 0.0,
            594, 748, ID.SANDBAG, 0.0,
            660, 748, ID.SANDBAG, 0.0,
            300, 300, ID.SANDBAG, 0.0,
            366, 300, ID.SANDBAG, 0.0,
            432, 300, ID.SANDBAG2, 0.0,
            498, 300, ID.SANDBAG2, 0.0,
            100, 100, ID.PLAYER, 0.0);

    private final Object[] level;

    private LevelList(Object... level) {
        this.level = level;
    }

    public void loadGameObjects(TankGame game) {
        for (int i = 0; i < level.length / 4; i++) {
            int index = i * 4;
            int x = (int) level[index];
            int y = (int) level[index + 1];
            ID id = (ID) level[index + 2];
            double angle = Math.toRadians((double) level[index + 3]);
            switch (id) {
                case SANDBAG:
                case SANDBAG2:
                    Sandbag bag = new Sandbag(x, y, id, game);
                    bag.setAngle(angle);
                    game.handler.addObject(bag);
                    break;
                case BACKGROUND:
                    game.handler.addObject(new Background(x, y, id, game));
                    break;
                case PLAYER:
                    Player player = new Player(x, y, id, game);
                    player.setAngle(angle);
                    game.handler.addObject(player);
                    break;
                case ENEMY_STILL:
                    EnemyStill enemy_still = new EnemyStill(x, y, id, game);
                    enemy_still.setAngle(Math.random()*3.1416);
                    game.handler.addObject(enemy_still);
                    game.enemyCount ++;
                    break;
                default:
                    System.out.println(id);
            }
        }
    }
}
