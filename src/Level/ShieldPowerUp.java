
package Level;

public class ShieldPowerUp {
    private boolean isActive;

    public ShieldPowerUp() {
        this.isActive = false;
    }

    public void activate() {
        isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public void use() {
        if (isActive) {
            isActive = false;
        }
    }
}
