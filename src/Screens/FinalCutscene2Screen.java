package Screens;

import Engine.*;
import Level.Map;
import Level.Player;
import Maps.BlackScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This is the class for the final cutscenes
public class FinalCutscene2Screen extends Screen {
    protected SpriteFont narration;
    protected SpriteFont prompt;
    protected Map background;
    protected PlayLevelScreen playLevelScreen;
    protected Player player;
    protected int keyPressTimer;
    protected KeyLocker keyLocker = new KeyLocker();

     public FinalCutscene2Screen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void initialize() {
        background = new BlackScreenMap();
        background.setAdjustCamera(false);
        //narration = new SpriteFont("Greetings, [currentSubject.getID]! You have comepleted three\ntrials in search of the \"end\" Please, pay no\nmind to any faintness or dizziness.", 175, 22, "Helvetica Bold", 22, Color.white);
        prompt = new SpriteFont("Press SPACE to continue...", 300, 500, "Comic Sans", 15, Color.white);
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
            playLevelScreen.goToEndCutscene3(player);
           
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        prompt.draw(graphicsHandler);
    }
}




