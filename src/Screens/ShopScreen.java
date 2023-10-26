package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.ShopScreenMap;
import Players.Max;
import SpriteFont.SpriteFont;
import Utils.Colors;
import Screens.PlayLevelScreen;
import GameObject.Coin;
import GameObject.Sprite;
import Level.Player;
import java.awt.*;

// This is the class for the shop screen
public class ShopScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected int menuItemSelected = -1;
    protected SpriteFont speedUp;
    protected SpriteFont exit;
    protected SpriteFont speedUpText;
    protected boolean speedUpPurchased;
    protected SpriteFont item2;
    protected SpriteFont item3;
    protected SpriteFont item4;
    protected SpriteFont emptyText;
    protected SpriteFont exitText;
    protected SpriteFont purchasedText;
    protected SpriteFont coinCount;
    protected SpriteFont notEnough;
    protected int coins;
    protected Map background;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
    protected Player player;
    protected PlayLevelScreen playLevelScreen;



    public ShopScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }


    @Override
    public void initialize() {
        //player for access coin count
        this.player = playLevelScreen.player;
        //text and icons for shop items
        speedUp = new SpriteFont("Speed up (3)", 65, 300, "Comic Sans", 25, new Color(0, 0, 0));
        speedUp.setOutlineColor(Color.black);
        speedUp.setOutlineThickness(3);
        //marks if item is purchased so  prevents doubles
        speedUpPurchased = false;
        //items not yet in shop
        item2 = new SpriteFont("Slot 2", 245, 300, "Comic Sans", 25, new Color(0, 0, 0));
        item2.setOutlineColor(Color.black);
        item2.setOutlineThickness(3);
        item3 = new SpriteFont("Slot 3", 385, 300, "Comic Sans", 25, new Color(0, 0, 0));
        item3.setOutlineColor(Color.black);
        item3.setOutlineThickness(3);
        item4 = new SpriteFont("Slot 4", 535, 300, "Comic Sans", 25, new Color(0, 0, 0));
        item4.setOutlineColor(Color.black);
        item4.setOutlineThickness(3);
        //leave screen text
        exit = new SpriteFont("Leave", 685, 300, "Comic Sans", 25, new Color(0, 0, 0));
        exit.setOutlineColor(Color.black);
        exit.setOutlineThickness(3);
        //max's text about the item
        speedUpText = new SpriteFont("\"Energy drink.\" Why is that in quotations?\n[Increases Speed]", 180, 400, "Comic Sans", 25, new Color(255, 255, 255));
        emptyText = new SpriteFont("There's nothing here", 180, 400, "Comic Sans", 25, new Color(255, 255, 255));
        exitText = new SpriteFont("I don't want anything.", 180, 400, "Comic Sans", 25, new Color(255, 255, 255));
        purchasedText = new SpriteFont("I guess this is mine now", 180, 400, "Comic Sans", 25, new Color(255, 255, 255));
        speedUpText.setOutlineColor(Color.black);
        speedUpText.setOutlineThickness(3);
        notEnough = new SpriteFont("Don't have enough coins", 180, 400, "Comic Sans", 25, new Color(255,255,255));
        //coint counter in the shop
        coins = player.getCoins();
        coinCount = new SpriteFont(("Coins: " + coins), 60, 180, "Comic Sans", 25, new Color(225,225,225));

        background = new ShopScreenMap();
        background.setAdjustCamera(false);
        keyPressTimer = 0;
        menuItemSelected = -1;
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        // update background map (to play tile animations)
        background.update(null);

        // if down or up is pressed, change menu item "hovered" over (blue square in front of text will move along with currentMenuItemHovered changing)
        if (Keyboard.isKeyDown(Key.D) &&  keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.A) &&  keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered--;
        } else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        coinCount.setText("Coins: " + player.getCoins());

        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
        if (currentMenuItemHovered > 4) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 1;
        }

        // sets color of spritefont text based on which menu item is being hovered
        if (currentMenuItemHovered == 0) {
            if(speedUpPurchased == false) {
            speedUp.setColor(new Color(255, 255, 255));
            }
            else {
                speedUp.setColor(new Color (255, 0, 0));
            }
            exit.setColor(new Color(0, 0, 0));
            item2.setColor(new Color(0,0,0));
            item3.setColor(new Color(0,0,0));
            item4.setColor(new Color(0,0,0));
            pointerLocationX = 470;
            pointerLocationY = 130;
        } else if (currentMenuItemHovered == 1) {
            speedUp.setColor(new Color(0, 0, 0));
            item2.setColor(new Color(255,255,255));
            item3.setColor(new Color(0,0,0));
            item4.setColor(new Color(0,0,0));
            exit.setColor(new Color(0, 0, 0));
            pointerLocationX = 470;
            pointerLocationY = 230;
        } else if (currentMenuItemHovered == 2) {
            speedUp.setColor(new Color(0,0,0));
            item2.setColor(new Color(0,0,0));
            item3.setColor(new Color(255,255,255));
            item4.setColor(new Color(0,0,0));
            exit.setColor(new Color(0, 0, 0));
        } else if (currentMenuItemHovered == 3) {
            speedUp.setColor(new Color(0,0,0));
            item2.setColor(new Color(0,0,0));
            item3.setColor(new Color(0,0,0));
            item4.setColor(new Color(255,255,255));
            exit.setColor(new Color(0, 0, 0));
        } else if (currentMenuItemHovered == 4) {
            speedUp.setColor(new Color(0,0,0));
            item2.setColor(new Color(0,0,0));
            item3.setColor(new Color(0,0,0));
            item4.setColor(new Color(0,0,0));
            exit.setColor(new Color(255,255,255));
        }

        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0) {
            keyPressTimer = 14;
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                if(this.player.getCoins() >= 3 && speedUpPurchased == false) {
                    player.removeCoins(3);
                    coinCount.setText("Coins: " + player.getCoins());
                    speedUpPurchased = true;
                }
                  
                //check for correct amt coins
                //remove coins
                //apply effect
                //mark purchased
                
            } else if (menuItemSelected == 1 || menuItemSelected == 2 || menuItemSelected == 3) {
                //add when there are things to purchase
            } else if (menuItemSelected == 4) {
                //when level 2 exists this should send there - menu is temp
                playLevelScreen.resetLevel();
            }
        }
    } 

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        speedUp.draw(graphicsHandler);
        item2.draw(graphicsHandler);
        item3.draw(graphicsHandler);
        item4.draw(graphicsHandler);
        exit.draw(graphicsHandler);
        coinCount.draw(graphicsHandler);
        
        //the text for each item only appears when the item is hovered 
        menuItemSelected = currentMenuItemHovered;
        if(menuItemSelected == 0 && this.player.getCoins() < 3 && speedUpPurchased == false) {
            notEnough.draw(graphicsHandler);
        }
        if (this.player.getCoins() < 3 && speedUpPurchased == false) {
        // Display a message for not enough coins
        notEnough.draw(graphicsHandler);
    }
        if(menuItemSelected == 0 && speedUpPurchased == false && this.player.getCoins() >= 3) {
            speedUpText.drawWithParsedNewLines(graphicsHandler, 2);
        } else if(menuItemSelected == 0 && speedUpPurchased == true) {
                purchasedText.draw(graphicsHandler);
        } else if (menuItemSelected == 1 || menuItemSelected == 2 || menuItemSelected == 3) {
            emptyText.draw(graphicsHandler);
        }else if(menuItemSelected == 4) {
            exitText.draw(graphicsHandler);
        }
    }
}