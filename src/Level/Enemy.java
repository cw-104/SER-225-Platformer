package Level;

import GameObject.Frame;
import GameObject.SpriteSheet;

import java.util.HashMap;

// This class is a base class for all enemies in the game -- all enemies should extend from it
public class Enemy extends MapEntity {
        private int health; // Besa adding enemy health

    public Enemy(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
        super(x, y, spriteSheet, startingAnimation);
        this.health = 15;
    }

    public Enemy(float x, float y, HashMap<String, Frame[]> animations, String startingAnimation) {
        super(x, y, animations, startingAnimation);
    }

    public Enemy(float x, float y, Frame[] frames) {
        super(x, y, frames);
    }

    public Enemy(float x, float y, Frame frame) {
        super(x, y, frame);
    }

    public Enemy(float x, float y) {
        super(x, y);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    public void update(Player player) {
        super.update();
        if (intersects(player)) {
            touchedPlayer(player);
        }
    }

    // A subclass can override this method to specify what it does when it touches the player
    public void touchedPlayer(Player player) {
        player.hurtPlayer(this);
    }

    public void takeDamage(Object attackDamage) {
    health -= 12;
    if (health <= 0) {
        // Enemy is defeated, perform defeat logic (e.g., play defeat animation, remove from the level)
        defeat();
    }
    }

    private void defeat() {
        // Implement logic for when the enemy is defeated (e.g., play defeat animation, remove from the level)
        setMapEntityStatus(MapEntityStatus.INACTIVE);
    }

    public boolean isDefeated() {
        return false;
    }
}
