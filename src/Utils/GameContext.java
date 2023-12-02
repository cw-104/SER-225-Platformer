package Utils;
public class GameContext {
    private static boolean playerHasShield = false;

    public static boolean playerHasShield() {
        return playerHasShield;
    }

    public static void setPlayerHasShield(boolean hasShield) {
        playerHasShield = hasShield;
    }
}
