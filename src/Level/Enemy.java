package Level;

import GameObject.Frame;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Utils.Direction;
import java.util.HashMap;

// This class is a base class for all enemies in the game -- all enemies should extend from it
public class Enemy extends MapEntity {
       
    
    protected boolean isInvincible = false; // if true, player cannot be hurt by enemies (good for testing)
    protected LevelState levelState;

    private Direction facingDirection;

    public Enemy(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
        super(x, y, spriteSheet, startingAnimation);
        //this.health = 15;
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
        
        // other entities can call this method to hurt the enemy

        public void hurtEnemy() {
                 this.mapEntityStatus = MapEntityStatus.REMOVED;
               //  System.out.println("i'm working");
            }

            

// Common interface or superclass for both MaxBullet and Enemy
public interface BulletInteractable {
    void onInteract(MapEntity entity);
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

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void hurtEnemy(Player player) {
    }
}
