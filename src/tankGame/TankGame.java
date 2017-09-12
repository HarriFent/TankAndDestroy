package tankGame;

import input.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import objects.*;

public class TankGame extends Canvas implements Runnable {

    public enum GameState {
        MENU,
        LEVELSELECT,
        GAME,
        GAMEOVER;
    }

    public static final int screenWidth = 792, screenHeight = 792;
    private Thread thread;
    private boolean running = false;
    private boolean paused;
    private int frameCount = 0;
    private int fps = 60;
    public Handler handler = new Handler();
    private Menu menu;
    public MouseInput mouseInput;
    private BufferedImage imgSpriteSheet;
    private KeyInput keyInput = new KeyInput(this);
    public SpriteSheet spriteSheet;
    public GameState gameState = GameState.MENU;
    public static LevelList currentLevel = LevelList.level0;
    public int enemyCount = 0;

    public TankGame() {
        new Window(screenWidth + 6, screenHeight + 29, "Tank Fighter", this);
        mouseInput = new MouseInput();
        this.addMouseListener(mouseInput);
        this.addMouseMotionListener(mouseInput);
        this.addKeyListener(keyInput);
        menu = new Menu(this, mouseInput);
        try {
            imgSpriteSheet = ImageIO.read(getClass().getResource("/sheet_tanks.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        spriteSheet = new SpriteSheet(imgSpriteSheet);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TankGame game = new TankGame();
    }

    public void run() {
        final double GAME_HERTZ = 30.0;
        final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
        final int MAX_UPDATES_BEFORE_RENDER = 5;
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime = System.nanoTime();

        final double TARGET_FPS = 60;
        final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;

        int lastSecondTime = (int) (lastUpdateTime / 1000000000);

        while (running) {
            double now = System.nanoTime();
            int updateCount = 0;

            if (!paused) {
                while (now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER) {
                    tick();
                    lastUpdateTime += TIME_BETWEEN_UPDATES;
                    updateCount++;
                }
                if (now - lastUpdateTime > TIME_BETWEEN_UPDATES) {
                    lastUpdateTime = now - TIME_BETWEEN_UPDATES;
                }

                float interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES));
                render();
                lastRenderTime = now;

                int thisSecond = (int) (lastUpdateTime / 1000000000);
                if (thisSecond > lastSecondTime) {
                    //System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                    fps = frameCount;
                    frameCount = 0;
                    lastSecondTime = thisSecond;
                }

                while (now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES) {
                    Thread.yield();

                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                    }

                    now = System.nanoTime();
                }
            }
        }
    }

    private void tick() {
        handler.tick();
        keyInput.tick();
        menu.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        try {
            switch (gameState) {
                case MENU:
                case LEVELSELECT:
                    g.setColor(new Color(220, 220, 220));
                    g.fillRect(0, 0, screenWidth, screenHeight);
                    menu.render(g, spriteSheet);
                    break;
                case GAME:
                case GAMEOVER:
                    g.setColor(new Color(230, 230, 200));
                    g.fillRect(0, 0, screenWidth, screenHeight);
                    handler.render(g, spriteSheet);
                    break;
            }
        } catch (Exception e) {

        }
        g.dispose();
        bs.show();
        frameCount++;
    }
}
