package tankGame;

import input.MouseInput;
import input.SpriteSheet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import objects.SpriteList;
import tankGame.TankGame.GameState;

public class Menu {

    private TankGame game;
    private MouseInput mouseInput;
    private ArrayList<Button> btnArray = new ArrayList<Button>();
    private int gameOverTime = 0;

    public Menu(TankGame game, MouseInput mouseInput) {
        this.game = game;
        this.mouseInput = mouseInput;
    }

    public void render(Graphics g, SpriteSheet ss) {
        GameState state = game.gameState;
        switch (state) {
            case MENU:
                for (int i = 0; i < btnArray.size(); i++) {
                    btnArray.get(i).drawButton(g, ss, game);
                }
                break;
            case LEVELSELECT:
                g.setColor(Color.black);
                g.setFont(new Font(Font.DIALOG, 0, 20));
                g.drawString("Level Select", 10, 30);
                for (int i = 0; i < btnArray.size(); i++) {
                    btnArray.get(i).drawButton(g, ss, game);
                }
                break;
            case GAME:
                if (game.enemyCount == 0){
                    g.drawImage(ss.grabImage(SpriteList.menuGame), 0, 0, game);
                }
                break;
            default:
                break;
        }
    }

    public void tick() {
        GameState state = game.gameState;
        switch (state) {
            case MENU:
                if (btnArray.size() == 0) {
                    btnArray.add(new Button(10, 10, SpriteList.menuPlay_off, 0));
                    btnArray.add(new Button(10, 72, SpriteList.menuExit_off, 1));
                }
                for (Button btn : btnArray) {
                    if (btn.getBounds().contains(mouseInput.getMousePos())) {
                        btn.mouseOver = true;
                        if (mouseInput.clicked) {
                            //clicked
                            mouseInput.clicked = false;
                            switch (btn.getIndex()) {
                                case 0:
                                    game.gameState = GameState.LEVELSELECT;
                                    btnArray.clear();
                                    for (int i = 0; i < 10; i++) {
                                        btnArray.add(new Button(10 + (70 * i), 40, SpriteList.menuLevel_off, i + 1));
                                    }
                                    return;
                                case 1:
                                    System.exit(0);
                                    break;
                            }
                        }
                    } else {
                        btn.mouseOver = false;
                    }
                }
                break;
            case LEVELSELECT:
                for (Button btn : btnArray) {
                    if (btn.getBounds().contains(mouseInput.getMousePos())) {
                        btn.mouseOver = true;
                        if (mouseInput.clicked) {
                            mouseInput.clicked = false;
                            game.gameState = GameState.GAME;
                            btnArray.clear();
                            switch (btn.getIndex()) {
                                case 1:
                                    game.currentLevel = LevelList.level0;
                                    break;
                                case 2:
                                    game.currentLevel = LevelList.level1;
                                    break;
                                default:
                                    break;
                            }
                            game.currentLevel.loadGameObjects(game);
                            return;
                        }
                    } else {
                        btn.mouseOver = false;
                    }
                }
                break;
            case GAME:
                if (game.enemyCount == 0){
                    gameOverTime ++;
                    if (gameOverTime == 100){
                        game.handler.clearObjects();
                        game.gameState = GameState.GAMEOVER;
                    }
                }
                break;
            case GAMEOVER:
                game.gameState = GameState.MENU;
                break;
            default:
                break;
        }
    }
}

class Button {

    private final int x, y, w, h, index;
    private final SpriteList sprite;
    public boolean mouseOver = false;

    public Button(int x, int y, SpriteList sprite, int index) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.w = sprite.getw();
        this.h = sprite.geth();
        this.sprite = sprite;
    }

    public void drawButton(Graphics g, SpriteSheet ss, TankGame game) {
        if (mouseOver) {
            switch (sprite) {
                case menuPlay_off:
                    g.drawImage(ss.grabImage(SpriteList.menuPlay_on), x, y, game);
                    break;
                case menuExit_off:
                    g.drawImage(ss.grabImage(SpriteList.menuExit_on), x, y, game);
                    break;
                case menuLevel_off:
                    g.drawImage(ss.grabImage(SpriteList.menuLevel_on), x, y, game);
                    switch (index) {
                        case 1:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_1), x + 10, y + 10, game);
                            break;
                        case 2:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_2), x + 10, y + 10, game);
                            break;
                        case 3:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_3), x + 10, y + 10, game);
                            break;
                        case 4:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_4), x + 10, y + 10, game);
                            break;
                        case 5:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_5), x + 10, y + 10, game);
                            break;
                        case 6:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_6), x + 10, y + 10, game);
                            break;
                        case 7:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_7), x + 10, y + 10, game);
                            break;
                        case 8:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_8), x + 10, y + 10, game);
                            break;
                        case 9:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_9), x + 10, y + 10, game);
                            break;
                        case 10:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_1), x + 10, y + 10, game);
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_0), x + 30, y + 10, game);
                            break;
                    }
                    break;
            }
        } else {
            switch (sprite) {
                case menuPlay_off:
                    g.drawImage(ss.grabImage(SpriteList.menuPlay_off), x, y, game);
                    break;
                case menuExit_off:
                    g.drawImage(ss.grabImage(SpriteList.menuExit_off), x, y, game);
                    break;
                case menuLevel_off:
                    g.drawImage(ss.grabImage(SpriteList.menuLevel_off), x, y, game);
                    switch (index) {
                        case 1:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_1), x + 10, y + 10, game);
                            break;
                        case 2:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_2), x + 10, y + 10, game);
                            break;
                        case 3:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_3), x + 10, y + 10, game);
                            break;
                        case 4:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_4), x + 10, y + 10, game);
                            break;
                        case 5:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_5), x + 10, y + 10, game);
                            break;
                        case 6:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_6), x + 10, y + 10, game);
                            break;
                        case 7:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_7), x + 10, y + 10, game);
                            break;
                        case 8:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_8), x + 10, y + 10, game);
                            break;
                        case 9:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_9), x + 10, y + 10, game);
                            break;
                        case 10:
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_1), x + 10, y + 10, game);
                            g.drawImage(ss.grabImage(SpriteList.menuNumber_0), x + 30, y + 10, game);
                            break;
                    }
                    break;
            }
        }
    }

    public int getIndex() {
        return index;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }
}
