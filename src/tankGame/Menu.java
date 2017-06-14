package tankGame;

import input.MouseInput;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import tankGame.TankGame.GameState;

public class Menu {

    private TankGame game;
    private MouseInput mouseInput;
    private ArrayList<Button> btnArray = new ArrayList<Button>();

    public Menu(TankGame game, MouseInput mouseInput) {
        this.game = game;
        this.mouseInput = mouseInput;
        btnArray.add(new Button(350, 380, 100, 20, "Play", 0));
        btnArray.add(new Button(350, 410, 100, 20, "Exit", 1));
    }

    public void render(Graphics g) {
        GameState state = game.gameState;
        switch (state) {
            case MENU:
                for (int i = 0; i < btnArray.size(); i++) {
                    btnArray.get(i).drawButton(g);
                }
                break;
            case LEVELSELECT:
                g.setColor(Color.black);
                g.setFont(new Font(Font.DIALOG, 0, 20));
                g.drawString("Level Select", 10, 30);
                for (int i = 0; i < btnArray.size(); i++) {
                    btnArray.get(i).drawButton(g);
                }
                break;
            case GAME:

                break;
            default:
                break;
        }
    }

    public void tick() {
        GameState state = game.gameState;
        switch (state) {
            case MENU:
                for (Button btn : btnArray) {
                    if (btn.getBounds().contains(mouseInput.getMousePos())) {
                        btn.mouseOver = true;
                        if (mouseInput.clicked) {
                            //clicked
                            switch (btn.getIndex()) {
                                case 0:
                                    game.gameState = GameState.LEVELSELECT;
                                    btnArray.clear();
                                    for (int i = 0; i < 10; i++) {
                                        btnArray.add(new Button(10 + (45 * i), 40, 40, 40, Integer.toString(i), i));
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
                            game.gameState = GameState.GAME;
                            switch (btn.getIndex()) {
                                case 0:
                                    game.currentLevel = LevelList.level0;
                                    break;
                                case 1:
                                    game.currentLevel = LevelList.level1;
                                    break;
                                default:
                                    break;
                            }
                            game.currentLevel.loadGameObjects(game);
                        }
                    } else {
                        btn.mouseOver = false;
                    }
                }
                break;
            case GAME:

                break;
            default:
                break;
        }
    }
}

class Button {

    private final int x, y, w, h, index;
    private final String text;
    public boolean mouseOver = false;

    public Button(int x, int y, int w, int h, String text, int index) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.text = text;
    }

    public void drawButton(Graphics g) {
        if (mouseOver) {
            g.setColor(new Color(50, 50, 155));
            g.fillRoundRect(x, y, w, h, 5, 5);
            g.setColor(new Color(0, 0, 0));
            g.drawString(text, x + 5, y + ((h * 3) / 4));
            g.drawRoundRect(x, y, w, h, 5, 5);
        } else {
            g.setColor(new Color(150, 150, 255));
            g.fillRoundRect(x, y, w, h, 5, 5);
            g.setColor(new Color(0, 0, 0));
            g.drawString(text, x + 5, y + ((h * 3) / 4));
            g.drawRoundRect(x, y, w, h, 5, 5);
        }
    }

    public int getIndex() {
        return index;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }
}
