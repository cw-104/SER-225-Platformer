package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.CutsceneMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This is the class for the main menu screen
public class CutsceneScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected int menuItemSelected = -1;
    protected SpriteFont narration;
    protected SpriteFont prompt;
    protected Map background;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();

    public CutsceneScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        background = new CutsceneMap();
        background.setAdjustCamera(false);
        narration = new SpriteFont("Where am I?", 180, 405, "Helvetica Bold", 25, Color.white);
        prompt = new SpriteFont("Press SPACE to continue...", 490, 510, "Comic Sans", 15, Color.white);
        keyPressTimer = 0;
        menuItemSelected = -1;
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
           screenCoordinator.setGameState((GameState.CUTSCENE2));
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        narration.draw(graphicsHandler);
        prompt.draw(graphicsHandler);
    }
}
