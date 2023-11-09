package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.ShopHallMap;
import SpriteFont.SpriteFont;
import Level.Player;
import java.awt.*;

// This is the class for the main menu screen
public class ShopIntroScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected SpriteFont narration;
    protected SpriteFont prompt;
    protected Map background;
    protected int keyPressTimer;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected Player player;
    protected int totalCoins;

    public ShopIntroScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void initialize() {
        background = new ShopHallMap();
        background.setAdjustCamera(false);
        //fun fact if you're trying to remember why \n isn't working: use the other draw command it has one that works with \n
        narration = new SpriteFont("...Is that... a vending machine?\n...Why is it so bright?", 180, 22, "Helvetica Bold", 25, Color.white);
        prompt = new SpriteFont("Press SPACE to continue...", 490, 130, "Comic Sans", 15, Color.white);
        keyLocker.lockKey(Key.SPACE);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, reset level. if escape is pressed, go back to main menu
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
            playLevelScreen.goToShop(this.player);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        narration.drawWithParsedNewLines(graphicsHandler, 3);
        prompt.draw(graphicsHandler);
    }
}


