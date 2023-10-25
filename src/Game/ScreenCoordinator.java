package Game;

import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Screen;
import Screens.BlackScreen;
import Screens.CreditsScreen;
import Screens.MenuScreen;
import Screens.PlayLevelScreen;
import Screens.ShopIntroScreen;
import Screens.CutsceneScreen;
import Screens.CutsceneScreen2;
import Screens.CutsceneScreen3;
import Screens.CutsceneScreen4;
import Screens.CutsceneScreen5;
import Screens.InstructionsScreen;
import Screens.ShopScreen;;

/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();

	// keep track of gameState so ScreenCoordinator knows which Screen to show
	protected GameState gameState;
	protected GameState previousGameState;

	public GameState getGameState() {
		return gameState;
	}

	// Other Screens can set the gameState of this class to force it to change the currentScreen
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void initialize() {
		// start game off with Menu Screen
		gameState = GameState.MENU;
	}

	@Override
	public void update() {
		do {
			// if previousGameState does not equal gameState, it means there was a change in gameState
			// this triggers ScreenCoordinator to bring up a new Screen based on what the gameState is
			if (previousGameState != gameState) {
				switch(gameState) {
					case MENU:
						currentScreen = new MenuScreen(this);
						break;
					case LEVEL:
						currentScreen = new PlayLevelScreen(this);
						break;
					case CREDITS:
						currentScreen = new CreditsScreen(this);
						break;
					case INSTRUCTIONS:
						currentScreen = new InstructionsScreen(this);
						break;
					case BLACKSCREEN:
						currentScreen = new BlackScreen(this);
						break;	
					case CUTSCENE1:
						currentScreen = new CutsceneScreen(this);
						break;
					case CUTSCENE2:
						currentScreen = new CutsceneScreen2(this);
						break;
					case CUTSCENE3:
						currentScreen = new CutsceneScreen3(this);
						break;
					case CUTSCENE4:
						currentScreen = new CutsceneScreen4(this);
						break;
					case CUTSCENE5:
						currentScreen = new CutsceneScreen5(this);
						break;
				}
				currentScreen.initialize();
			}
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
		} while (previousGameState != gameState);
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}
}
