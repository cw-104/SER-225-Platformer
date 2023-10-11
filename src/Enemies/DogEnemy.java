package Enemies;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.MapEntity;
import Level.Player;
import Utils.AirGroundState;
import Utils.Direction;
import Utils.Point;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
        //import Level.AttackEntity;
import java.util.List;
import java.util.ArrayList;
//added and may need to take out //besa

//import java.util.List;
//import java.util.ArrayList;
//import java.util.Timer;
//import java.util.TimerTask;
//import Level.AttackEntity; // Add this import


//// may need to tke out the impirts above this comment

// This class is for the Dog enemy
// enemy behaves like a Mario goomba -- walks forward until it h ll down until it hits the ground again, and then will continue walking
public class DogEnemy extends Enemy {

    private float gravity = .5f;
    private float movementSpeed = .5f;
    private Direction startFacingDirection;
    private Direction facingDirection;
    private AirGroundState airGroundState;
    private int health = 1; // Set an initial health value      //besa
//may need to take out 
private Timer removalTimer;

/// may need to take out //besa

    public DogEnemy(Point location, Direction facingDirection) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("GuardDog2.png"), 24, 15
        ), "WALK_LEFT");
        this.startFacingDirection = facingDirection;
        this.initialize();
    }

    @Override
    public void initialize() {
        super.initialize();
        facingDirection = startFacingDirection;
        if (facingDirection == Direction.RIGHT) {
            currentAnimationName = "WALK_RIGHT";
        } else if (facingDirection == Direction.LEFT) {
            currentAnimationName = "WALK_LEFT";
        }
        airGroundState = AirGroundState.GROUND;
    }

    @Override
    public void update(Player player) {
        float moveAmountX = 0;
        float moveAmountY = 0;

        // add gravity (if in air, this will cause dog to fall)
        moveAmountY += gravity;

        // if on ground, walk forward based on facing direction
        if (airGroundState == AirGroundState.GROUND) {
            if (facingDirection == Direction.RIGHT) {
                moveAmountX += movementSpeed;
            } else {
                moveAmountX -= movementSpeed;
            }
        }

        // move dog
        moveYHandleCollision(moveAmountY);
        moveXHandleCollision(moveAmountX);

        super.update(player); 
        /* 
                                    MapEntity[] listOfMapEntities;
                                    MapEntity [] listofMapEntity = [DogEnemy]; // tired and this may be wrong. get sleep 
                                   
                                    //besa
                                    // Check for collisions with attacking entities (e.g., player's attack)
                                    for (MapEntity entity : listOfMapEntities) {
                                        if (entity instanceof MapEntity && entity.getBounds().intersects(getBounds())) {
                                            // Handle damage to the enemy
                                            takeDamage(((MapEntity) entity).getDamage()); // Adjust the method call based on your implementation
                                        }
                                    }
*/

    }

//besa
//taking damage
public void takeDamage(int damage) {
    if (health > 0) {
        health -= damage;
        if (health <= 0) {
            // Enemy has been defeated
            defeat();
        }
    }
}

public void defeat() {
    // Add logic to handle the defeat of the enemy, such as playing defeat animations or removing it from the level
    // You can also trigger any other actions that should occur when the enemy is defeated
 // Play a defeat animation, if you have one
    // Replace "DEFEAT_ANIMATION_NAME" with the actual name of your defeat animation
    currentAnimationName = "DEFEAT_ANIMATION_NAME";

    // Disable any further updates or collisions for the defeated enemy
    setEnabled(false);
    setCollidable(false);
/*              // come back to this later
    HashMap<String, Frame[]> activeEnemies;
    // Remove the enemy from the list of active enemies
    if (activeEnemies.containsKey(this)) {
        activeEnemies.remove(this);
    }
*/
    // You can also award points, update the player's score, or trigger other game events here
    // Example: player.incrementScore(100);
/* */
    // If you want the enemy to disappear after a certain amount of time, you can set a timer
/* 
    Timer.schedule(new TimerTask() {
        @Override
        public void run() {
            // Remove the enemy from the level or perform any other cleanup
            remove();
        }

        private void remove() {
        }
    }, 1.0f); // Adjust the delay as needed
*/
    removalTimer = new Timer();
    removalTimer.schedule(new TimerTask() {
        @Override
        public void run() {
            // Remove the enemy from the level or perform any other cleanup
            remove();
        }

        private void remove() {
            if (removalTimer != null) {
                removalTimer.cancel();
            }
            
        }
    }, 1000); // Adjust the delay as needed (1000 milliseconds = 1 second)



}



    private void setEnabled(boolean b) {
}

    private void setCollidable(boolean b) {
}

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction,  MapEntity entityCollidedWith) {
        // if dog has collided into something while walking forward,
        // it turns around (changes facing direction)
        if (hasCollided) {
            if (direction == Direction.RIGHT) {
                facingDirection = Direction.LEFT;
                currentAnimationName = "WALK_LEFT";
            } else {
                facingDirection = Direction.RIGHT;
                currentAnimationName = "WALK_RIGHT";
            }
        }
    }

    @Override
    public void onEndCollisionCheckY(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
        // if dog is colliding with the ground, change its air ground state to GROUND
        // if it is not colliding with the ground, it means that it's currently in the air, so its air ground state is changed to AIR
        if (direction == Direction.DOWN) {
            if (hasCollided) {
                airGroundState = AirGroundState.GROUND;
            } else {
                airGroundState = AirGroundState.AIR;
            }
        }
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("WALK_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 8)
                            .withScale(2)
                            .withBounds(6, 6, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 8)
                            .withScale(2)
                            .withBounds(6, 6, 12, 7)
                            .build()
            });

            put("WALK_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 8)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 6, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 8)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 6, 12, 7)
                            .build()
            });
        }};
    }
}