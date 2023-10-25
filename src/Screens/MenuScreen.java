package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This is the class for the main menu screen
public class MenuScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected int menuItemSelected = -1;
    protected SpriteFont playGame;
    protected SpriteFont credits;
    protected SpriteFont instructions;
    protected SpriteFont testLevel;
    protected SpriteFont title;
    protected SpriteFont titleCSR;
    protected SpriteFont titleCSB;
    protected SpriteFont subtitle;
    protected Map background;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();

    public MenuScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        playGame = new SpriteFont("PLAY GAME", 500, 119, "Comic Sans", 30, new Color(0, 0, 0));
        playGame.setOutlineColor(Color.black);
        playGame.setOutlineThickness(3);
        credits = new SpriteFont("CREDITS", 500, 219, "Comic Sans", 30, new Color(0, 0, 0));
        credits.setOutlineColor(Color.black);
        credits.setOutlineThickness(3);
        instructions = new SpriteFont("INSTRUCTIONS", 500,319, "Comic Sans", 30, new Color(0,0,0));
        instructions.setOutlineColor(Color.black);
        instructions.setOutlineThickness(3);
        testLevel = new SpriteFont("TEST LEVEL", 500, 419, "Comic Sans", 30, new Color (0,0,0));
        testLevel.setOutlineColor(Color.black);
        testLevel.setOutlineThickness(3);
        title = new SpriteFont("ESCAPE:", 80, 75, "Comic Sans", 70, new Color(0, 0, 0));
        title.setOutlineColor(Color.black);
        title.setOutlineThickness(3);
        titleCSR = new SpriteFont("ESCAPE:", 86, 75, "Comic Sans", 70, new Color(255, 0, 0));
        titleCSR.setOutlineColor(Color.red);
        titleCSR.setOutlineThickness(3);
        titleCSB = new SpriteFont("ESCAPE:", 74, 75, "Comic Sans", 70, new Color(0, 0, 255));
        titleCSB.setOutlineColor(Color.blue);
        titleCSB.setOutlineThickness(3);
        subtitle = new SpriteFont("Back to Reality", 103, 150, "Comic Sans", 35, new Color(0, 0, 0));
        subtitle.setOutlineColor(Color.white);
        subtitle.setOutlineThickness(2);
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        keyPressTimer = 0;
        menuItemSelected = -1;
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        // update background map (to play tile animations)
        background.update(null);

        // if down or up is pressed, change menu item "hovered" over (blue square in front of text will move along with currentMenuItemHovered changing)
        if (Keyboard.isKeyDown(Key.S) &&  keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.W) &&  keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered--;
        } else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
        if (currentMenuItemHovered > 3) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 3;
        }

        // sets location for blue square in front of text (pointerLocation) and also sets color of spritefont text based on which menu item is being hovered
        if (currentMenuItemHovered == 0) {
            playGame.setColor(new Color(255, 255, 255));
            credits.setColor(new Color(0, 0, 0));
            instructions.setColor(new Color(0, 0, 0));
            testLevel.setColor(new Color(0,0,0));
            pointerLocationX = 470;
            pointerLocationY = 130;
        } else if (currentMenuItemHovered == 1) {
            playGame.setColor(new Color(0, 0, 0));
            credits.setColor(new Color(255, 255, 255));
            instructions.setColor(new Color(0, 0, 0));
            testLevel.setColor(new Color(0,0,0));
            pointerLocationX = 470;
            pointerLocationY = 230;
        } else if (currentMenuItemHovered == 2) {
            playGame.setColor(new Color(0,0,0));
            credits.setColor(new Color(0,0,0));
            instructions.setColor(new Color(255,255,255));
            testLevel.setColor(new Color(0,0,0));
            pointerLocationX = 470;
            pointerLocationY = 330;
        }
        else if (currentMenuItemHovered == 3) {
            playGame.setColor(new Color(0,0,0));
            credits.setColor(new Color(0,0,0));
            instructions.setColor(new Color(0, 0, 0));
            testLevel.setColor(new Color(255,255,255));
            pointerLocationX = 470;
            pointerLocationY = 430;
        }

        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                screenCoordinator.setGameState(GameState.BLACKSCREEN);
            } else if (menuItemSelected == 1) {
                screenCoordinator.setGameState(GameState.CREDITS);
            } else if (menuItemSelected == 2) {
                screenCoordinator.setGameState(GameState.INSTRUCTIONS);
            } else if (menuItemSelected == 3) {
                screenCoordinator.setGameState(GameState.LEVEL);
            }
            
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        playGame.draw(graphicsHandler);
        credits.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
        testLevel.draw(graphicsHandler);
        titleCSR.draw(graphicsHandler);
        titleCSB.draw(graphicsHandler);
        title.draw(graphicsHandler);
        subtitle.draw(graphicsHandler);
        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
    }
}
