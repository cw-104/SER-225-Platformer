package Screens;

import Engine.*;
import Level.Map;
import Level.Player;
import Maps.CutsceneLev3Map;
import SpriteFont.SpriteFont;

import java.awt.*;

// This is the class for the main menu screen
public class CutsceneLev3Screen extends Screen {
    protected SpriteFont narration;
    protected SpriteFont prompt;
    protected Map background;
    protected PlayLevelScreen playLevelScreen;
    protected Player player;
    protected int keyPressTimer;
    protected KeyLocker keyLocker = new KeyLocker();

     public CutsceneLev3Screen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void initialize() {
        background = new CutsceneLev3Map();
        background.setAdjustCamera(false);
        narration = new SpriteFont("Congratulations, [currentSubject.getID]! Enjoy\n this prize for your achievement [gun]. Proceed\nonwards and upwards! A new new reality awaits!", 175, 22, "Helvetica Bold", 22, Color.white);
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
            playLevelScreen.goToCutscene2_1(player);
           
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        narration.drawWithParsedNewLines(graphicsHandler, 2);
        prompt.draw(graphicsHandler);
    }
}




