package Engine;

public class  PlayerData {
    private boolean speedUpPurchased;

    public PlayerData() {
        speedUpPurchased = false; // Initialize to false by default
    }

    public boolean isSpeedUpPurchased() {
        return speedUpPurchased;
    }

    public void setSpeedUpPurchased(boolean purchased) {
        speedUpPurchased = purchased;
    }
}
