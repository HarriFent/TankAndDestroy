package input;

import java.awt.image.BufferedImage;
import objects.SpriteList;

public class SpriteSheet {

    private BufferedImage sprite;

    public SpriteSheet(BufferedImage ss) {
        this.sprite = ss;
    }

    public BufferedImage grabImage(SpriteList spriteList) {
        BufferedImage img = sprite.getSubimage(spriteList.getx(),spriteList.gety(),spriteList.getw(),spriteList.geth());
        return img;
    }
}
