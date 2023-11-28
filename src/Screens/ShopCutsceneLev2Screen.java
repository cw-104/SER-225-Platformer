package Screens;

import Engine.*;
import Level.Map;
import Level.Player;
import Maps.ShopCutsceneLev2Map;
import SpriteFont.SpriteFont;

import java.awt.*;

// This is the class for the main menu screen
public class ShopCutsceneLev2Screen extends Screen {
    protected SpriteFont narration;
    protected SpriteFont prompt;
    protected Map background;
    protected PlayLevelScreen playLevelScreen;
    protected Player player;
    protected int keyPressTimer;
    protected KeyLocker keyLocker = new KeyLocker();

     public ShopCutsceneLev2Screen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void initialize() {
        background = new ShopCutsceneLev2Map();
        background.setAdjustCamera(false);
        narration = new SpriteFont("Why is it blue now?", 175, 22, "Helvetica Bold", 22, Color.white);
        prompt = new SpriteFont("Press SPACE to continue...", 490, 130, "Comic Sans", 15, Color.white);
        keyPressTimer = 0;
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        // update background map (to play tile animations)
        background.update(null);


        
        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            playLevelScreen.goToShop2(player);
           
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        narration.drawWithParsedNewLines(graphicsHandler, 2);
        prompt.draw(graphicsHandler);
    }
}




