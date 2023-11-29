package Players;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.MapEntity;
import Level.MapEntityStatus;
import Level.Player;
import Utils.Direction;
import Utils.Point;

import java.util.HashMap;
//use the fireball as reference
// look at the dino code for reference 
//possibly usefibeball
public class MaxBullet extends Enemy implements BulletInteractable{
    private float movementSpeed;
    private int existenceFrames;

    public MaxBullet(Point location, float movementSpeed, int existenceFrames, Direction direction) {
        super(null, location.x, location.y, "currentAnimationName");
        this.movementSpeed = movementSpeed;
        this.existenceFrames = existenceFrames;

        // Set the initial direction
        setFacingDirection(direction);

        // Load animations
        loadAnimations(new SpriteSheet(ImageLoader.load("bullet.png"), 31, 11));
        setAnimation("DEFAULT");
    }

    public void setFacingDirection(Direction direction) {
    }

    private void setAnimation(String string) {
    }

  //  @Override //besa
    public void update(Player player) {
        // Move bullet based on direction
        moveXHandleCollision((getFacingDirection() == Direction.RIGHT) ? movementSpeed : -movementSpeed);
        super.update();

        existenceFrames--;

        // If the existence frames are exhausted, mark the entity for removal
        if (existenceFrames <= 0) {
            setMapEntityStatus(MapEntityStatus.REMOVED);
        }
    }

    private void setMapEntityStatus(MapEntityStatus removed) {
    }

    public Direction getFacingDirection() {
        return getFacingDirection();
    }
    

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
        // If bullet collides with anything solid on the x-axis, mark it for removal
        if (hasCollided) {
            setMapEntityStatus(MapEntityStatus.REMOVED);
        }
    }

    //@Override //besa
    public void touchedEnemy(Enemy enemy) {
       // If bullet touches an enemy, mark it for removal
    setMapEntityStatus(MapEntityStatus.REMOVED);
    // Defeat the enemy
    if (enemy instanceof Enemy) {
        enemy.hurtEnemy();  // Assuming Enemy has a method to handle being hurt
    }
    }
    // Common interface or superclass for both MaxBullet and Enemy
public interface BulletInteractable {
    void onInteract(MapEntity entity);
}
                    // Constructor, methods, and other members remain the same

    //@Override
    public void onInteract(MapEntity entity) {
        if (entity instanceof Enemy) {
            touchedEnemy((Enemy) entity);
        }
    }
/* *
  //  @Override //besa //commented out the '@override's // messageteam is still stuck on this tmw
    public void touchedEnemy(Enemy enemy) {
        // If bullet touches an enemy, mark it for removal
        setMapEntityStatus(MapEntityStatus.REMOVED);
    }
*/
/* */ //try this 
    public void defeatEnemy(MapEntity enemy) { //try this if touched enemy fails //may be wrong
        // If bullet touches an enemy, mark it for removal
       if (enemy instanceof Enemy) {
        enemy.setMapEntityStatus(MapEntityStatus.REMOVED);// used line 602 of player class as reference " private void defeatEnemy(MapEntity enemy) "
       }
    }
/**/



    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {
            {
                put("DEFAULT", new Frame[]{
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withBounds(1, 1, 5, 5)
                                .build()
                });
            }
        };
    }
}
