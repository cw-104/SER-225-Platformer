package Screens;

import Engine.*;
import Level.Map;
import Level.Player;
import Maps.CutsceneMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This is the class for the final cutscenes
public class FinalCutscene3Screen extends Screen {
    protected SpriteFont narration;
    protected SpriteFont prompt;
    protected Map background;
    protected PlayLevelScreen playLevelScreen;
    protected Player player;
    protected int keyPressTimer;
    protected KeyLocker keyLocker = new KeyLocker();

     public FinalCutscene3Screen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void initialize() {
        background = new CutsceneMap();
        background.setAdjustCamera(false);
        narration = new SpriteFont("WHAT.", 180, 405, "Helvetica Bold", 25, Color.white);
        prompt = new SpriteFont("Press SPACE to continue...", 490, 510, "Comic Sans", 15, Color.white);
        keyPressTimer = 0;
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        // update background map (to play tile animations)
        background.update(null);


        
        // if space is pressed go to next scene
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            playLevelScreen.goBackToMenu();
           
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        narration.drawWithParsedNewLines(graphicsHandler, 2);
        prompt.draw(graphicsHandler);
    }
}




