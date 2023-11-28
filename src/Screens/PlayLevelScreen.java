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
import Maps.Lab_copy;
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
    protected CutsceneLev2Screen cutsceneLev2Screen;
    protected boolean levelCompletedStateChangeStart;
    protected SpriteFont livesDisplay;

    protected List<Coin> coinList = new ArrayList<>();
    protected SpriteFont coinCounter;
private int currentLevel =1;
    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        this.currentLevel =1;
    }
public void changeLevel(int newLevel){

    currentLevel = newLevel;
}
   public void initialize() {
       // define/setup map
          this.map =new Lab();
             this.player = new Max(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
           
        // Add Coins (only line needed for both creating and counting)
        coinList.add(new Coin(1150, 450));
        coinList.add(new Coin(1450, 350));
        coinList.add(new Coin(1800, 400));
        coinList.add(new Coin(2100, 400));
        coinList.add(new Coin(955, 400));
        coinList.add(new Coin(1450, 725));
        coinList.add(new Coin(1660, 725));
        coinList.add(new Coin(1880, 725));
        coinList.add(new Coin(2340, 525));
        coinList.add(new Coin(3050, 400));
        coinList.add(new Coin(3530, 800));
        coinList.add(new Coin(3530, 900));
        coinList.add(new Coin(3530, 1000));
        coinList.add(new Coin(3530, 1100));
        coinList.add(new Coin(3530, 1200));
        coinList.add(new Coin(3530, 1300));
        coinList.add(new Coin(1450, 1440));
        coinList.add(new Coin(2400, 1240));
        coinList.add(new Coin(2700, 1240));
        coinList.add(new Coin(2400, 1540));
        coinList.add(new Coin(1950, 1240));
        coinList.add(new Coin(1000, 1300));
        coinList.add(new Coin(150, 1200));
        coinList.add(new Coin(50, 1700));
        coinList.add(new Coin(50, 1800));
        coinList.add(new Coin(50, 1900));
        coinList.add(new Coin(50, 2000));
        coinList.add(new Coin(550, 2140));
        coinList.add(new Coin(1050, 2140));
        coinList.add(new Coin(2050, 2140));
        coinList.add(new Coin(3150, 2140));
        coinList.add(new Coin(3770, 850));
        coinList.add(new Coin(4200, 400));
        coinList.add(new Coin(5050, 490));
        coinList.add(new Coin(5350, 390));
        coinList.add(new Coin(5500, 700));
        coinList.add(new Coin(5700, 490));
        coinList.add(new Coin(7400, 800));
        coinList.add(new Coin(7400, 1000));
        coinList.add(new Coin(7400, 1200));
        coinList.add(new Coin(7400, 1350));
        coinList.add(new Coin(6550, 1390));
        coinList.add(new Coin(6100, 1540));
        coinList.add(new Coin(5800, 1390));
        coinList.add(new Coin(5340, 1290));
        coinList.add(new Coin(4800, 1290));
        coinList.add(new Coin(4400, 1290));
        coinList.add(new Coin(4100, 1600));
        coinList.add(new Coin(4100, 1800));
        coinList.add(new Coin(4100, 2000));
        coinList.add(new Coin(4800, 2140));
        coinList.add(new Coin(5400, 2140));
        coinList.add(new Coin(6200, 2140));
        coinList.add(new Coin(7000, 2140));

        // Setting bounds and coin in map
        for (Coin coin : coinList) {
            coin.setBounds(new Rectangle(0, 0, 16, 16));
            coin.setMap(map);
        }
        // setup player */

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
        cutsceneLev2Screen = new CutsceneLev2Screen(this);

        this.playLevelScreenState = PlayLevelScreenState.RUNNING;

        // Coin Counter Display
        this.coinCounter = new SpriteFont("Coins: " + player.getCoins(), 15, 25, "Arial", 35, new Color(255, 0, 0));
        this.coinCounter.setOutlineColor(Color.black);
        this.coinCounter.setOutlineThickness(2);

        // health
        this.livesDisplay = new SpriteFont("Lives: " + player.getLives(), 15, 60, "Arial", 35, new Color(255, 0, 0));
        this.livesDisplay.setOutlineColor(Color.black);
        this.livesDisplay.setOutlineThickness(2);
    }

    // initializes second level
    public void initialize1(Player prev) {
        // define/setup map
        this.map = new Lab_copy();
        coinList.clear();
        
        //Third layer coins 
        coinList.add(new Coin(300, 1900));
        coinList.add(new Coin(680, 1850));
        coinList.add(new Coin(800, 1850));
        coinList.add(new Coin(1000, 1650));
        coinList.add(new Coin(1180, 1600));
        coinList.add(new Coin(1460, 1750));
        coinList.add(new Coin(1800, 1600));//
        coinList.add(new Coin(2400, 1900));//
        coinList.add(new Coin(2600, 1900));
        coinList.add(new Coin(2800, 1900));
        coinList.add(new Coin(5000, 1500));
        coinList.add(new Coin(4150, 1330));
        coinList.add(new Coin(4800, 1500));
        coinList.add(new Coin(4400, 1330));//
        coinList.add(new Coin(3900, 1175));
        coinList.add(new Coin(5800, 950));
        coinList.add(new Coin(6000, 950));
        coinList.add(new Coin(6150, 800));
        coinList.add(new Coin(6400, 850));
        coinList.add(new Coin(6600, 950));
        coinList.add(new Coin(6900, 950));
        coinList.add(new Coin(7300, 950));



        // second layer coins 
        coinList.add(new Coin(6900, 2500));
        coinList.add(new Coin(6800, 2500));
        coinList.add(new Coin(6700, 2500));
        coinList.add(new Coin(6500, 2650));
        coinList.add(new Coin(6200, 2340));
        coinList.add(new Coin(6400, 2340));
        coinList.add(new Coin(6000, 2450));
        coinList.add(new Coin(5800, 2550)); 
        coinList.add(new Coin(5400, 2750)); 
        coinList.add(new Coin(5300, 2750)); 
        coinList.add(new Coin(5200, 2750)); 
        coinList.add(new Coin(4500, 2200));
        coinList.add(new Coin(4700, 2200));
        coinList.add(new Coin(4600, 2200));
        coinList.add(new Coin(4200, 2500));
        coinList.add(new Coin(4000, 2500));
        coinList.add(new Coin(3600, 2380));
        coinList.add(new Coin(3400, 2380));
        coinList.add(new Coin(3200, 2380));
        coinList.add(new Coin(3050, 2380));
        coinList.add(new Coin(3600, 2750));
        coinList.add(new Coin(3400, 2750));
        coinList.add(new Coin(3200, 2750));
        coinList.add(new Coin(3050, 2750));
        coinList.add(new Coin(2400, 2300));
        coinList.add(new Coin(2600, 2300));
        coinList.add(new Coin(2400, 2500));
        coinList.add(new Coin(2600, 2500));
        coinList.add(new Coin(2500, 2300));
        coinList.add(new Coin(2500, 2500));
        coinList.add(new Coin(2250, 2200));
        coinList.add(new Coin(1900, 2369));
        coinList.add(new Coin(1750, 2450));
        coinList.add(new Coin(1600, 2500));
        coinList.add(new Coin(1500, 2500));
        coinList.add(new Coin(1900, 2750));
        coinList.add(new Coin(1700, 2750));
        coinList.add(new Coin(1500, 2750));
        coinList.add(new Coin(1300, 2750));
        coinList.add(new Coin(1100, 2750));
        coinList.add(new Coin(1120, 2220));
        coinList.add(new Coin(800, 2320));
     
        //starter level coins    
       coinList.add(new Coin(900, 3390));
       coinList.add(new Coin(1100, 3390));
        coinList.add(new Coin(1300, 3390));
        coinList.add(new Coin(1700, 3450));
        coinList.add(new Coin(2000, 3200));
        coinList.add(new Coin(2190, 3200));
        coinList.add(new Coin(2330, 3200));
         coinList.add(new Coin(2500, 3250));
         coinList.add(new Coin(3200, 3350));
         coinList.add(new Coin(3350, 3350));
         coinList.add(new Coin(4000, 3380));
         coinList.add(new Coin(4100, 3380));
          coinList.add(new Coin(4710, 3278));
          coinList.add(new Coin(4810, 3278));
          coinList.add(new Coin(5000, 3350));
          coinList.add(new Coin(5080, 3278));
          coinList.add(new Coin(5210, 3278));
          coinList.add(new Coin(4700, 3540));
          coinList.add(new Coin(5000, 3540));
          coinList.add(new Coin(5200, 3540));
          coinList.add(new Coin(5500, 3540));
          coinList.add(new Coin(6000, 3280));
          coinList.add(new Coin(6500, 3550));
          coinList.add(new Coin(6800, 3550));
          coinList.add(new Coin(7450, 3350));
        coinList.add(new Coin(7390, 3200));
        coinList.add(new Coin(7450, 2980));
        coinList.add(new Coin(7390, 2760));
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
        // sets the coins and lives as carried over from past level - add powerups
        // changes here too probably
        this.player.setCoins(prev.getCoins());
        this.player.setLives(prev.getLives());

        levelClearedScreen = new LevelClearedScreen();
        levelLoseScreen = new LevelLoseScreen(this);
        shopIntroScreen = new ShopIntroScreen(this);
        shopScreen = new ShopScreen(this);
        cutsceneLev2Screen = new CutsceneLev2Screen(this);

        this.playLevelScreenState = PlayLevelScreenState.RUNNING;

        // Coin Counter Display
        this.coinCounter = new SpriteFont("Coins: " + player.getCoins(), 15, 25, "Arial", 35, new Color(255, 0, 0));
        this.coinCounter.setOutlineColor(Color.black);
        this.coinCounter.setOutlineThickness(2);

        // health
        this.livesDisplay = new SpriteFont("Lives: " + player.getLives(), 15, 60, "Arial", 35, new Color(255, 0, 0));
        this.livesDisplay.setOutlineColor(Color.black);
        this.livesDisplay.setOutlineThickness(2);
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
                coinCounter.setText("Coins: " + this.player.getCoins()/* this.getCoinCount() */);
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
                        goToShopIntro(this.player);
                    }
                }
                break;

            // wait on level lose screen to make a decision (either resets level or sends
            // player back to main menu)
            case LEVEL_LOSE: {
                levelLoseScreen.update();
                this.player.resetCoins();
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
            case CUTSCENELEV2: {
                cutsceneLev2Screen.update();
                ;
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
            case CUTSCENELEV2:
                cutsceneLev2Screen.draw(graphicsHandler);
        }
        livesDisplay.setText("Lives: " + player.getLives());
        livesDisplay.draw(graphicsHandler);
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
        // player.resetCoins();
        if (playLevelScreenState != PlayLevelScreenState.LEVEL_LOSE) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;
        }
    }

    public void resetLevel() {
        initialize();
    }
    

    public void level2() {
        changeLevel(2);
        initialize1(this.player);
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    public void goToShopIntro(Player player) {
        playLevelScreenState = PlayLevelScreenState.SHOPINTRO;
    }

    public void goToShop(Player player) {
        playLevelScreenState = PlayLevelScreenState.SHOP;
    }

    public void goToCutscene(Player player) {
        playLevelScreenState = PlayLevelScreenState.CUTSCENELEV2;
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED, LEVEL_LOSE, SHOPINTRO, SHOP, CUTSCENELEV2
    }

    // Total # of Coins
    public int getCoinCount() {
        int totalCoins = 0;
        for (Coin coin : coinList) {
            if (coin.isCollected()) {
                player.addCoins(1);
            }
        }
        return totalCoins;
    }
    
}
