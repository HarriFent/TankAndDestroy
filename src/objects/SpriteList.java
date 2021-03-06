package objects;

import java.awt.Rectangle;

public enum SpriteList {
    barrelBeige(842, 108, 16, 50),
    barrelBeige_outline(840, 368, 24, 58),
    barrelBlack(840, 426, 16, 50),
    barrelBlack_outline(818, 168, 24, 58),
    barrelBlue(850, 58, 16, 50),
    barrelBlue_outline(827, 226, 24, 58),
    barrelGreen(834, 58, 16, 50),
    barrelGreen_outline(818, 110, 24, 58),
    barrelGreen_side(746, 48, 44, 62),
    barrelGreen_side_damaged(790, 48, 44, 62),
    barrelGreen_up(746, 0, 48, 48),
    barrelGrey_sde_rust(783, 244, 44, 62),
    barrelGrey_side(796, 410, 44, 62),
    barrelGrey_up(735, 252, 48, 48),
    barrelRed(842, 158, 16, 50),
    barrelRed_outline(834, 0, 24, 58),
    barrelRed_side(805, 306, 44, 62),
    barrelRed_up(730, 454, 48, 48),
    bulletBeige(48, 481, 12, 26),
    bulletBeigeSilver(188, 345, 12, 26),
    bulletBeigeSilver_outline(671, 140, 20, 34),
    bulletBeige_outline(128, 345, 20, 34),
    bulletBlue(0, 481, 12, 26),
    bulletBlueSilver(12, 481, 12, 26),
    bulletBlueSilver_outline(148, 345, 20, 34),
    bulletBlue_outline(755, 300, 20, 34),
    bulletGreen(24, 481, 12, 26),
    bulletGreenSilver(36, 481, 12, 26),
    bulletGreenSilver_outline(691, 140, 20, 34),
    bulletGreen_outline(168, 345, 20, 34),
    bulletRed(120, 481, 12, 26),
    bulletRedSilver(60, 481, 12, 26),
    bulletRedSilver_outline(711, 140, 20, 34),
    bulletRed_outline(735, 300, 20, 34),
    bulletSilver(72, 481, 12, 26),
    bulletSilverSilver(84, 481, 12, 26),
    bulletSilverSilver_outline(778, 472, 20, 34),
    bulletSilver_outline(775, 306, 20, 34),
    bulletYellow(96, 481, 12, 26),
    bulletYellowSilver(108, 481, 12, 26),
    bulletYellowSilver_outline(794, 0, 20, 34),
    bulletYellow_outline(814, 0, 20, 34),
    dirt(0, 0, 128, 128),
    grass(0, 128, 128, 128),
    oil(200, 408, 96, 96),
    sand(0, 256, 128, 128),
    sandbagBeige(128, 301, 66, 44),
    sandbagBrown(730, 410, 66, 44),
    smokeGrey0(416, 188, 87, 87),
    smokeGrey1(296, 408, 92, 89),
    smokeGrey2(478, 384, 90, 99),
    smokeGrey3(651, 353, 79, 79),
    smokeGrey4(128, 97, 100, 97),
    smokeGrey5(128, 194, 98, 107),
    smokeOrange0(486, 275, 87, 87),
    smokeOrange1(324, 196, 92, 89),
    smokeOrange2(388, 408, 90, 99),
    smokeOrange3(656, 261, 79, 79),
    smokeOrange4(0, 384, 100, 97),
    smokeOrange5(228, 0, 98, 107),
    smokeWhite0(324, 107, 92, 89),
    smokeWhite1(396, 285, 90, 99),
    smokeWhite2(590, 182, 79, 79),
    smokeWhite3(128, 0, 100, 97),
    smokeWhite4(226, 194, 98, 107),
    smokeWhite5(418, 0, 87, 87),
    smokeYellow0(228, 107, 87, 87),
    smokeYellow1(326, 0, 92, 89),
    smokeYellow2(416, 89, 90, 99),
    smokeYellow3(651, 432, 79, 79),
    smokeYellow4(100, 384, 100, 97),
    smokeYellow5(298, 301, 98, 107),
    tankBeige(730, 340, 75, 70),
    tankBeige_outline(505, 0, 83, 78),
    tankBlack(671, 0, 75, 70),
    tankBlack_outline(568, 362, 83, 78),
    tankBlue(671, 70, 75, 70),
    tankBlue_outline(506, 78, 83, 78),
    tankGreen(669, 182, 75, 70),
    tankGreen_outline(573, 275, 83, 78),
    tankRed(568, 440, 75, 70),
    tankRed_outline(588, 0, 83, 78),
    tracksLarge(589, 78, 82, 104),
    tracksSmall(744, 140, 74, 104),
    treeLarge(200, 301, 98, 107),
    treeSmall(503, 188, 87, 87),
    menuPlay_off(866, 0, 136, 61),
    menuPlay_on(866, 61, 136, 61),
    menuExit_off(866, 122, 136, 61),
    menuExit_on(866, 183, 136, 61),
    menuLevel_off(866, 244, 70, 61),
    menuLevel_on(936, 244, 70, 61),
    menuNumber_1(864, 310, 30, 35),
    menuNumber_2(894, 310, 30, 35),
    menuNumber_3(924, 310, 30, 35),
    menuNumber_4(954, 310, 30, 35),
    menuNumber_5(984, 310, 30, 35),
    menuNumber_6(864, 351, 30, 35),
    menuNumber_7(894, 351, 30, 35),
    menuNumber_8(924, 351, 30, 35),
    menuNumber_9(954, 351, 30, 35),
    menuNumber_0(984, 351, 30, 35),
    menuGame(862, 400, 114, 35);

    private final Rectangle bound;

    SpriteList(int x, int y, int w, int h) {
        bound = new Rectangle(x, y, w, h);
    }

    public int getx() {
        return bound.x;
    }

    public int gety() {
        return bound.y;
    }

    public int getw() {
        return bound.width;
    }

    public int geth() {
        return bound.height;
    }

}
