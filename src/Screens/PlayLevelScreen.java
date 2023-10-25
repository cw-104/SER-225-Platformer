package Screens;

import java.awt.Color;
import Engine.GraphicsHandler;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Coin;
import GameObject.Rectangle;
import Level.Map;
import Level.Player;
import Level.PlayerListener;
import Maps.TestEnvironment;
import Maps.TestMap;
import Players.Cat;
import Utils.Point;
import Maps.TestEnvironment;
import Maps.Lab;
import Players.Max;
import SpriteFont.SpriteFont;
import java.util.ArrayList;
import java.util.List;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen implements PlayerListener {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected int screenTimer;
    protected LevelClearedScreen levelClearedScreen;
    protected LevelLoseScreen levelLoseScreen;
    protected ShopIntroScreen shopIntroScreen;
    protected ShopScreen shopScreen;
    protected boolean levelCompletedStateChangeStart;

    protected List<Coin> coinList = new ArrayList<>();
    protected SpriteFont coinCounter;

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // define/setup map
        this.map = new Lab();

        // Add Coins (only line needed for both creating and counting)
        coinList.add(new Coin(1150, 450));
        coinList.add(new Coin(1450, 350));
        coinList.add(new Coin(1800, 400));
        coinList.add(new Coin(1850, 400));
        coinList.add(new Coin(1750, 400));

        // Setting bounds and coin in map
        for (Coin coin : coinList) {
            coin.setBounds(new Rectangle(0, 0, 16, 16));
            coin.setMap(map);
        }
        // setup player
        // this.player = new Cat(map.getPlayerStartPosition().x,
        // map.getPlayerStartPosition().y);
        this.player = new Max(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y); // this is to implement
                                                                                               // max into the game
        this.player.setMap(map);
        this.player.addListener(this);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);

        levelClearedScreen = new LevelClearedScreen();
        levelLoseScreen = new LevelLoseScreen(this);
        shopIntroScreen = new ShopIntroScreen(this);
        shopScreen = new ShopScreen(this);

        this.playLevelScreenState = PlayLevelScreenState.RUNNING;

        // Coin Counter Display
        this.coinCounter = new SpriteFont("Coins: " + this.getCoinCount(), 15, 25, "Arial", 35, new Color(255, 0, 0));
        this.coinCounter.setOutlineColor(Color.black);
        this.coinCounter.setOutlineThickness(2);

    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {

            // if level is "running" update player and map to keep game logic for the
            // platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                // Coin Check
                for (Coin coin : coinList) {
                    coin.check(player);
                }
                coinCounter.setText("Coins: " + player.getCoins()/*this.getCoinCount()*/);
                break;

            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                if (levelCompletedStateChangeStart) {
                    screenTimer = 130;
                    levelCompletedStateChangeStart = false;
                } else {
                    levelClearedScreen.update();
                    screenTimer--;
                    if (screenTimer == 0) {
                        goToShopIntro(player);
                    }
                }
                break;
                
            // wait on level lose screen to make a decision (either resets level or sends
            // player back to main menu)
            case LEVEL_LOSE: {
                levelLoseScreen.update();
                break;

            }

            case SHOPINTRO: {
                shopIntroScreen.update();
                break;
            }
            case SHOP: {
                shopScreen.update();
                break;
            }

        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(graphicsHandler);
                player.draw(graphicsHandler);

                // drawing Coin Counter
                coinCounter.draw(graphicsHandler);

                // Checking if Coins have been collected
                for (Coin coin : coinList) {
                    if (!coin.isCollected()) {
                        coin.draw(graphicsHandler);
                    }
                }

                break;
            case LEVEL_COMPLETED:
                levelClearedScreen.draw(graphicsHandler);
                break;
            case LEVEL_LOSE:
                levelLoseScreen.draw(graphicsHandler);
                break;
            case SHOPINTRO:
                shopIntroScreen.draw(graphicsHandler);
                break;
            case SHOP:
                shopScreen.draw(graphicsHandler);
                break;
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }

    @Override
    public void onLevelCompleted() {
        if (playLevelScreenState != PlayLevelScreenState.LEVEL_COMPLETED) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
            levelCompletedStateChangeStart = true;
        }
    }

    @Override
    public void onDeath() {
        if (playLevelScreenState != PlayLevelScreenState.LEVEL_LOSE) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;
        }
    }

    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    public void goToShopIntro(Player player) {
        playLevelScreenState = PlayLevelScreenState.SHOPINTRO;
    }

    public void  goToShop(Player player) {
        playLevelScreenState = PlayLevelScreenState.SHOP;
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED, LEVEL_LOSE, SHOPINTRO, SHOP
    }

    // Total # of Coins
    public int getCoinCount() {
        int totalCoins = 0;
        for (Coin coin : coinList) {
            if(coin.isCollected()) {
            totalCoins ++;
            }
        }
        return totalCoins;
    }
}
