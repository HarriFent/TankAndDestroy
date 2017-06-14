package tankGame;

import objects.*;

public enum LevelList {
    level0(0, 0, ID.BACKGROUND,
            0, 0, ID.SANDBAG,
            0, 44, ID.SANDBAG,
            0, 88, ID.SANDBAG,
            0, 132, ID.SANDBAG,
            0, 176, ID.SANDBAG,
            0, 220, ID.SANDBAG,
            0, 264, ID.SANDBAG,
            0, 308, ID.SANDBAG,
            0, 352, ID.SANDBAG,
            0, 396, ID.SANDBAG,
            0, 440, ID.SANDBAG,
            0, 484, ID.SANDBAG,
            0, 528, ID.SANDBAG,
            0, 572, ID.SANDBAG,
            0, 616, ID.SANDBAG,
            0, 660, ID.SANDBAG,
            0, 704, ID.SANDBAG,
            0, 748, ID.SANDBAG,
            66, 0, ID.SANDBAG,
            132, 0, ID.SANDBAG,
            198, 0, ID.SANDBAG,
            264, 0, ID.SANDBAG,
            330, 0, ID.SANDBAG,
            396, 0, ID.SANDBAG,
            462, 0, ID.SANDBAG,
            528, 0, ID.SANDBAG,
            594, 0, ID.SANDBAG,
            660, 0, ID.SANDBAG,
            726, 0, ID.SANDBAG,
            726, 44, ID.SANDBAG,
            726, 88, ID.SANDBAG,
            726, 132, ID.SANDBAG,
            726, 176, ID.SANDBAG,
            726, 220, ID.SANDBAG,
            726, 264, ID.SANDBAG,
            726, 308, ID.SANDBAG,
            726, 352, ID.SANDBAG,
            726, 396, ID.SANDBAG,
            726, 440, ID.SANDBAG,
            726, 484, ID.SANDBAG,
            726, 528, ID.SANDBAG,
            726, 572, ID.SANDBAG,
            726, 616, ID.SANDBAG,
            726, 660, ID.SANDBAG,
            726, 704, ID.SANDBAG,
            726, 748, ID.SANDBAG,
            66, 748, ID.SANDBAG,
            132, 748, ID.SANDBAG,
            198, 748, ID.SANDBAG,
            264, 748, ID.SANDBAG,
            330, 748, ID.SANDBAG,
            396, 748, ID.SANDBAG,
            462, 748, ID.SANDBAG,
            528, 748, ID.SANDBAG,
            594, 748, ID.SANDBAG,
            660, 748, ID.SANDBAG,
            300, 300, ID.SANDBAG,
            300, 344, ID.SANDBAG,
            300, 388, ID.SANDBAG,
            300, 432, ID.SANDBAG,
            100, 100, ID.PLAYER),
    level1(2, 0, ID.BACKGROUND);

    private final Object[] level;

    private LevelList(Object... level) {
        this.level = level;
    }

    public void loadGameObjects(TankGame game) {
        for (int i = 0; i < level.length / 3; i++) {
            int index = i * 3;
            int x = (int) level[index];
            int y = (int) level[index + 1];
            ID id = (ID) level[index + 2];
            switch (id) {
                case SANDBAG:
                    game.handler.addObject(new Sandbag(x, y, id, game));
                    break;
                case BACKGROUND:
                    game.handler.addObject(new Background(x, y, id, game));
                    break;
                case PLAYER:
                    game.handler.addObject(new Player(x,y,id,game));
                    break;
                default:
                    System.out.println(id);
            }
        }
    }
}
