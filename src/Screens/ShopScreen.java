package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.ShopScreenMap;
import Players.Max;
import SpriteFont.SpriteFont;
import Screens.PlayLevelScreen;
import GameObject.Coin;
import GameObject.Sprite;
import Level.Player;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import Screens.ShopItem;
// This is the class for the main menu screen
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
    protected int coins;
    protected Map background;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
    protected Player player;
    protected PlayLevelScreen playLevelScreen;

    private List<ShopItem> shopItems;  // A list to store your shop items

    public ShopScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();

                         shopItems = new ArrayList<>();
        shopItems.add(new ShopItem("Speed Up", 5, "An energy drink to boost your speed."));

    }


    @Override
    public void initialize() {
        //player for access coin count
        this.player = new Max(0,0);
        //text and icons for shop items
        speedUp = new SpriteFont("Speed up (5)", 70, 300, "Comic Sans", 25, new Color(0, 0, 0));
        speedUp.setOutlineColor(Color.black);
        speedUp.setOutlineThickness(3);
        //marks if item is purchased so it prevents doubles
        speedUpPurchased = false;
        item2 = new SpriteFont("Slot 2", 225, 300, "Comic Sans", 25, new Color(0, 0, 0));
        item2.setOutlineColor(Color.black);
        item2.setOutlineThickness(3);
        item3 = new SpriteFont("Slot 3", 375, 300, "Comic Sans", 25, new Color(0, 0, 0));
        item3.setOutlineColor(Color.black);
        item3.setOutlineThickness(3);
        item4 = new SpriteFont("Slot 4", 525, 300, "Comic Sans", 25, new Color(0, 0, 0));
        item4.setOutlineColor(Color.black);
        item4.setOutlineThickness(3);
        exit = new SpriteFont("Leave", 675, 300, "Comic Sans", 25, new Color(0, 0, 0));
        exit.setOutlineColor(Color.black);
        exit.setOutlineThickness(3);
        //max's text about the item
        speedUpText = new SpriteFont("\"Energy drink.\" Why is that in quotations?", 180, 400, "Comic Sans", 25, new Color(255, 255, 255));
        emptyText = new SpriteFont("There's nothing here", 180, 400, "Comic Sans", 25, new Color(255, 255, 255));
        exitText = new SpriteFont("I don't want anything.", 180, 400, "Comic Sans", 25, new Color(255, 255, 255));
        purchasedText = new SpriteFont("I guess this is mine now", 180, 400, "Comic Sans", 25, new Color(255, 255, 255));
        speedUpText.setOutlineColor(Color.black);
        speedUpText.setOutlineThickness(3);
        //coint counter in the shop
       // coins = playLevelScreen.getCoins(); //besa //come back to this
        coinCount = new SpriteFont(("Coins: " + coins), 225, 20, "Comic Sans", 25, new Color(225,225,225));

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
                ShopItem selectedItem = shopItems.get(menuItemSelected);
                if (!selectedItem.isPurchased() && coins >= selectedItem.getPrice()) {
                    // Deduct the price from coins and mark the item as purchased
                    player.removeCoins(selectedItem.getPrice());
                    coinCount.setText("Coins: " + player.getCoins());
                    selectedItem.setPurchased(true);
                    // Apply the effect for item 0 (if needed)
                }
                //check for correct amt coins
                //remove coins
                //apply effect
                //mark purchased
                
                //screenCoordinator.setGameState(GameState.BLACKSCREEN);
             else  if(menuItemSelected ==1){
                        keyPressTimer = 14;
            menuItemSelected = currentMenuItemHovered;
            
            if (player.getCoins() >= 5 && !speedUpPurchased) {
                player.removeCoins(5);  // Deduct the correct amount of coins
                coinCount.setText("Coins: " + player.getCoins());
                // Apply the effect for item 2
                // You can handle applying the effect here.
                speedUpPurchased = true;


            } else if (menuItemSelected == 1 || menuItemSelected == 2 || menuItemSelected == 3) {
                //add when there are things to purchase
            } else if (menuItemSelected == 4) {
                //when level 2 exists this should send there - menu is temp
                playLevelScreen.resetLevel();
            }
        }
    } }
    }
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        speedUp.draw(graphicsHandler);
        item2.draw(graphicsHandler);
        item3.draw(graphicsHandler);
        item4.draw(graphicsHandler);
        exit.draw(graphicsHandler);
        //coinCount.draw(graphicsHandler);
        
        //the text for each item only appears when the item is hovered 
        menuItemSelected = currentMenuItemHovered;
        if(menuItemSelected == 0 && speedUpPurchased == false) {
            speedUpText.draw(graphicsHandler);
        } else if(menuItemSelected == 0 && speedUpPurchased == true) {
                purchasedText.draw(graphicsHandler);
        } else if (menuItemSelected == 1 || menuItemSelected == 2 || menuItemSelected == 3) {
            emptyText.draw(graphicsHandler);
        }else if(menuItemSelected == 4) {
            exitText.draw(graphicsHandler);
        }
        
        for (int i = 0; i < shopItems.size(); i++) {
            ShopItem item = shopItems.get(i);
            if (i == currentMenuItemHovered) {
                if (!item.isPurchased()) {
                    // Highlight the item
                    // Draw the shop item text
                    speedUp.draw(graphicsHandler);
                }else {
                    // Draw "Purchased" text or some other indicator
                }
            } else {
                if (item.isPurchased()) {
                    // Draw "Purchased" text or some other indicator
                }
            }
        }
    }
}

