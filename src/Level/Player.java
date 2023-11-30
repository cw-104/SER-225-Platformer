package Level;

import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import GameObject.AnimatedSprite;
import GameObject.GameObject;
import GameObject.IntersectableRectangle;
import GameObject.Rectangle;
import GameObject.SpriteSheet;
import Players.MaxBullet;
import Utils.AirGroundState;
import Utils.Direction;
import Utils.Point;

import java.util.ArrayList;

import java.util.List;

import Enemies.DogEnemy;

public abstract class Player extends GameObject {
    // values that affect player movement
    // these should be set in a subclass
    protected float walkSpeed = 0;
    protected float gravity = 0;
    protected float jumpHeight = 0;
    protected float jumpDegrade = 0;
    protected float terminalVelocityY = 0;
    protected float momentumYIncrease = 0;
    int lives = 3;
    
    private int currentLevel = 1; // Default level is 1// used to determine which level max/ player is in 
    // coin
    protected int coins;
    private int cooldown = 5;// cool down int
    private SpeedPowerUp speedPowerUp;
    public int getCoins() {
        return coins;
    }
    private static int MaxInLevel;
    private int level; // to determine the current level // may use as a replacement to maxInLevel to avoid confusion//besa
    
    public void addCoins(int newCoins) {
        coins += newCoins;
    }

    public void removeCoins(int lessCoins) {
        coins -= lessCoins;
    }

    public void resetCoins() {
        coins = 0;
    }
    public void setCoins(int value) {
        coins = value;
    }

    // values used to handle player movement
    protected float jumpForce = 0;
    protected float momentumY = 0;
    protected float moveAmountX, moveAmountY;
    protected float lastAmountMovedX, lastAmountMovedY;

    // values used to keep track of player's current state
    protected PlayerState playerState;
    protected PlayerState previousPlayerState;
    protected Direction facingDirection;
    protected AirGroundState airGroundState;
    protected AirGroundState previousAirGroundState;
    protected LevelState levelState;

    // classes that listen to player events can be added to this list
    protected ArrayList<PlayerListener> listeners = new ArrayList<>();

    // define keys
    protected KeyLocker keyLocker = new KeyLocker();
    protected Key JUMP_KEY = Key.W;
    protected Key MOVE_LEFT_KEY = Key.A;
    protected Key MOVE_RIGHT_KEY = Key.D;
    protected Key CROUCH_KEY = Key.S;
    protected Key ATTACK_KEY = Key.K;// testing button for swing attack annimation
    protected Key SHOOT_KEY = Key.L; //  appropriate key for level 3

    // flags
    protected boolean isInvincible = true; // if true, player cannot be hurt by enemies (good for testing)
    protected boolean isAttacking = false;// when max is NOT attacking
        protected boolean isShooting = false;// for max shooting gun //stating as false
    public Player(SpriteSheet spriteSheet, float x, float y, String startingAnimationName,int initialLevel) {
        super(spriteSheet, x, y, startingAnimationName);
        facingDirection = Direction.RIGHT;
        airGroundState = AirGroundState.AIR;
        previousAirGroundState = airGroundState;
        playerState = PlayerState.STANDING;

        previousPlayerState = playerState;
        levelState = LevelState.RUNNING;
        this.level = initialLevel;// just added to detmine level //besa 
    }
    //// Add this attribute to your Player class to keep track of active enemies //

    private List<Enemy> activeEnemies = new ArrayList<>();
    private List<MapEntity> listOfMapEntities = new ArrayList<>(); /// map entities list

    private IntersectableRectangle attackHitbox;
    // for the enemy
// Flag to track whether the player is currently performing a jump attack
private boolean isJumpAttacking = false;// besa +atatck jump
    public void update() {
        moveAmountX = 0;
        moveAmountY = 0;

        // if player is currently playing through level (has not won or lost)
        if (levelState == LevelState.RUNNING) {
            applyGravity();

            // update player's state and current actions, which includes things like
            // determining how much it should move each frame and if its walking or jumping
            do {
                previousPlayerState = playerState;
                handlePlayerState();
            } while (previousPlayerState != playerState);

            previousAirGroundState = airGroundState;

            // move player with respect to map collisions based on how much player needs to
            // move this frame

            lastAmountMovedX = super.moveXHandleCollision(moveAmountX);
            lastAmountMovedY = super.moveYHandleCollision(moveAmountY);

            handlePlayerAnimation();

            updateLockedKeys();

            if (speedPowerUp != null) {
                speedPowerUp.update();
                if (speedPowerUp.isCollected()) {
                    speedPowerUp.applyPowerUp(this);
                    speedPowerUp = null; // Speed power-up used, set it to null
                }
            }
// all the things are in the greg class. matches what we did it is just not in the player class
if(cooldown>0){
    cooldown --;
}else if(cooldown <= 0 && Keyboard.isKeyDown(ATTACK_KEY)){
    //method to spawn in a bullet
    if(MaxInLevel ==1){ 
           playerAttacking();
    cooldown = 5; }
}
if(cooldown >0){
    cooldown --;
}
if (Keyboard.isKeyDown(ATTACK_KEY) && cooldown <= 0){
    if (MaxInLevel ==0){
        isAttacking = true;
        attack();
cooldown = 30; // for cool-down testing
    }
    else if(MaxInLevel ==1){
        playerAttacking();//BESA
    }
}
            // update player's animation
            super.update();
        }
        

        // if player has beaten level
        else if (levelState == LevelState.LEVEL_COMPLETED) {
            updateLevelCompleted();
        }

        // if player has lost level
        else if (levelState == LevelState.PLAYER_DEAD) {
            updatePlayerDead();
        }
    }

    // add gravity to player, which is a downward force
    protected void applyGravity() {
        moveAmountY += gravity + momentumY;
    }




    // based on player's current state, call appropriate player state handling
    // method
    protected void handlePlayerState() {
        switch (playerState) {
            case STANDING:
                playerStanding();
                if (Keyboard.isKeyDown(ATTACK_KEY) && !keyLocker.isKeyLocked(ATTACK_KEY)) {
                    keyLocker.lockKey(ATTACK_KEY);
                    playerState = PlayerState.ATTACKING;
                }
                break;
            case WALKING:
                playerWalking();
                break;
            case CROUCHING:
                playerCrouching();
                break;
            case JUMPING:
                playerJumping();
                break;

            case ATTACKING: // when max is attacking //WORKING NOW
                playerAttacking();
               
                if (isJumpAttacking) {
                    // Check if the jump attack animation has reached its last frame
                    if (currentFrameIndex == getCurrentAnimation().length - 1) {
                        // The jump attack animation has finished; return to the previous state
                        playerState = previousPlayerState;
                        isJumpAttacking = false;
                    } else {
                        // Continue updating the jump attack animation
                        super.update();

                        // Handle jump attacking logic here, e.g., check for collisions with enemies
                        attackHitbox = currentFrame.getBounds();
                        for (MapEntity entity : listOfMapEntities) {
                            if (entity.getMapEntityStatus() == MapEntityStatus.ACTIVE &&
                                    entity.getBounds().intersects(attackHitbox)) {
                                defeatEnemy(entity);
                            }
                        }
                    }
                }//just added

                else if (currentFrameIndex == getCurrentAnimation().length - 1) {
                    // Attack animation is finished; transition back to another state.
                    playerState = PlayerState.STANDING; // You can choose a different state.
                } else {
                    // Continue playing the attack animation.
                    super.update();
                    attackHitbox = currentFrame.getBounds();
                    for (MapEntity entity : listOfMapEntities) {
                        if (entity.getMapEntityStatus() == MapEntityStatus.ACTIVE &&
                                entity.getBounds().intersects(attackHitbox)) {
                            // Handle damaging the enemy
                            defeatEnemy(entity); // Call a method to defeat the enemy
                        }
                    }

                }
                    break;
                
                
                default:
if (isJumpAttacking) {
                    // Check if the jump attack animation has reached its last frame
                    if (currentFrameIndex == getCurrentAnimation().length - 1) {
                        // The jump attack animation has finished; return to the previous state
                        playerState = previousPlayerState;
                        isJumpAttacking = false;
                    } else {
                        // Continue updating the jump attack animation
                        super.update();

                        // Handle jump attacking logic here, e.g., check for collisions with enemies
                        attackHitbox = currentFrame.getBounds();
                        for (MapEntity entity : listOfMapEntities) {
                            if (entity.getMapEntityStatus() == MapEntityStatus.ACTIVE &&
                                    entity.getBounds().intersects(attackHitbox)) {
                                defeatEnemy(entity);
                            }
                        }
                    }
                }//just added

                else if (currentFrameIndex == getCurrentAnimation().length - 1) {
                    // Attack animation is finished; transition back to another state.
                    playerState = PlayerState.STANDING; // You can choose a different state.
                } else {
                    // Continue playing the attack animation.
                    super.update();
                    attackHitbox = currentFrame.getBounds();
                    for (MapEntity entity : listOfMapEntities) {
                        if (entity.getMapEntityStatus() == MapEntityStatus.ACTIVE &&
                                entity.getBounds().intersects(attackHitbox)) {
                            // Handle damaging the enemy
                            defeatEnemy(entity); // Call a method to defeat the enemy
                        }
                    }

                }
                if (Keyboard.isKeyDown(ATTACK_KEY) && !keyLocker.isKeyLocked(ATTACK_KEY )) {// may have to make SHOOT_KEY
                    keyLocker.lockKey(ATTACK_KEY);// may have to make SHOOT_KEY
                    playerState = PlayerState.SHOOTING;
                }
    
                break;
        }
    }
   

    // player STANDING state logic
    protected void playerStanding() {
        // if walk left or walk right key is pressed, player enters WALKING state
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY) || Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {
            playerState = PlayerState.WALKING;
        }

        // if jump key is pressed, player enters JUMPING state
        else if (Keyboard.isKeyDown(JUMP_KEY) && !keyLocker.isKeyLocked(JUMP_KEY)) {
            keyLocker.lockKey(JUMP_KEY);
            playerState = PlayerState.JUMPING;
        }

        // if crouch key is pressed, player enters CROUCHING state
        else if (Keyboard.isKeyDown(CROUCH_KEY)) {
            playerState = PlayerState.CROUCHING;
        }

        else if (Keyboard.isKeyDown(ATTACK_KEY)) {
            playerState = PlayerState.ATTACKING;
            performAttack(); // Implement this method to handle the attack logic.
        }
        // trying to add attacking
        else if (Keyboard.isKeyDown(ATTACK_KEY) && !keyLocker.isKeyLocked(ATTACK_KEY)) {
            keyLocker.lockKey(ATTACK_KEY);
            playerState = PlayerState.ATTACKING;
System.out.println("hello they are atttacking now, outside the statment");
            
            if(MaxInLevel ==0){// besa //just added this //LOOKATME
                 isAttacking = true; // for when max is attacking
                 System.out.println("hello they are atttacking now");
                 attack();//just added
            }
           

        }
    }

    public void update(Enemy enemy) {
        super.update();
        if (intersects(enemy)) {
            touchedEnemy(enemy);
        }
    }

    private void performAttack() {
        if (facingDirection == Direction.RIGHT) {
            // Play the attack animation for Max facing right.
            playAnimation("ATTACK_RIGHT");
        } else {
            // Play the attack animation for Max facing left.
            playAnimation("ATTACK_LEFT");
        }
        // Implement any additional attack logic here.
    }

    private void playAnimation(String string) {
    }

    /* */// A subclass can override this method to specify what it does when it touches
         // the enemy
    public void touchedEnemy(Enemy enemy) {
       
        System.out.println("i'm working");
        // enemy.hurtEnemy(this); //come back to this later //BESA
        defeatEnemy(enemy);
    }

    public void attack() {
        if (!isAttacking) {
            isAttacking = true;

            // Define the attackHitbox based on the player's current position and dimensions
            attackHitbox = new Rectangle(x, y, 12, 16); // 12 and 16 testvalues for attack hitbox//besa

            // Notify active enemies about the attack
            for (Enemy enemy : activeEnemies) {
                if (((AnimatedSprite) attackHitbox).intersects(enemy.getBounds())) {
defeatEnemy(enemy);//besa added
                }
            }
        }
        playerState = PlayerState.ATTACKING;//added 
    }

    // player WALKING state logic
    protected void playerWalking() {
        // if walk left key is pressed, move player to the left
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY)) {
            moveAmountX -= walkSpeed;
            facingDirection = Direction.LEFT;
        }

        // if walk right key is pressed, move player to the right
        else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {
            moveAmountX += walkSpeed;
            facingDirection = Direction.RIGHT;
        } else if (Keyboard.isKeyUp(MOVE_LEFT_KEY) && Keyboard.isKeyUp(MOVE_RIGHT_KEY)) {
            playerState = PlayerState.STANDING;
        }

        // if jump key is pressed, player enters JUMPING state
        if (Keyboard.isKeyDown(JUMP_KEY) && !keyLocker.isKeyLocked(JUMP_KEY)) {
            keyLocker.lockKey(JUMP_KEY);
            playerState = PlayerState.JUMPING;
        }

        // if crouch key is pressed,
        else if (Keyboard.isKeyDown(CROUCH_KEY)) {
            playerState = PlayerState.CROUCHING;
        }
    }

    // player CROUCHING state logic
    protected void playerCrouching() {
        // if crouch key is released, player enters STANDING state
        if (Keyboard.isKeyUp(CROUCH_KEY)) {
            playerState = PlayerState.STANDING;
        }

        // if jump key is pressed, player enters JUMPING state
        if (Keyboard.isKeyDown(JUMP_KEY) && !keyLocker.isKeyLocked(JUMP_KEY)) {
            keyLocker.lockKey(JUMP_KEY);
            playerState = PlayerState.JUMPING;
        }
    }

    // player JUMPING state logic
    protected void playerJumping() {
        // if last frame player was on ground and this frame player is still on ground,
        // the jump needs to be setup
        if (previousAirGroundState == AirGroundState.GROUND && airGroundState == AirGroundState.GROUND) {

            // sets animation to a JUMP animation based on which way player is facing
            currentAnimationName = facingDirection == Direction.RIGHT ? "JUMP_RIGHT" : "JUMP_LEFT";

            // player is set to be in air and then player is sent into the air
            airGroundState = AirGroundState.AIR;

            jumpForce = jumpHeight;
            if (jumpForce > 0) {
                moveAmountY -= jumpForce;
                jumpForce -= jumpDegrade;
                if (jumpForce < 0) {
                    jumpForce = 0;
                }
            }
        
        }
        else if (airGroundState == AirGroundState.AIR) {
            if (jumpForce > 0) {
                moveAmountY -= jumpForce;
                jumpForce -= jumpDegrade;
                if (jumpForce < 0) {
                    jumpForce = 0;
                }
            }

            // allows you to move left and right while in the air
            if (Keyboard.isKeyDown(MOVE_LEFT_KEY)) {
                moveAmountX -= walkSpeed;
            } else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {
                moveAmountX += walkSpeed;
            }

            // if player is falling, increases momentum as player falls so it falls faster
            // over time
            if (moveAmountY > 0) {
                increaseMomentum();
            }

            // Check if the player is attacking while jumping
            if (Keyboard.isKeyDown(ATTACK_KEY) && !keyLocker.isKeyLocked(ATTACK_KEY)) {
                keyLocker.lockKey(ATTACK_KEY);
                isJumpAttacking = true;
                currentAnimationName = facingDirection == Direction.RIGHT ? "JUMP_ATTACK_RIGHT" : "JUMP_ATTACK_LEFT";

                // player is set to be in air and then player is sent into the air
                airGroundState = AirGroundState.AIR;
                jumpForce = jumpHeight;
                if (jumpForce > 0) {
                    moveAmountY -= jumpForce;
                    jumpForce -= jumpDegrade;
                    if (jumpForce < 0) {
                        jumpForce = 0;
                    }
                }
            }
        }

        
        // jump + attack attempt
        else if (Keyboard.isKeyDown(ATTACK_KEY) && !keyLocker.isKeyLocked(JUMP_KEY)) {
            keyLocker.lockKey(ATTACK_KEY);
            playerState = PlayerState.ATTACKING;
//besa
currentAnimationName = facingDirection == Direction.RIGHT ? "JUMP_RIGHT" : "JUMP_LEFT";

            // player is set to be in air and then player is sent into the air
            airGroundState = AirGroundState.AIR;
            jumpForce = jumpHeight;
            if (jumpForce > 0) {
                moveAmountY -= jumpForce;
                jumpForce -= jumpDegrade;
                if (jumpForce < 0) {
                    jumpForce = 0;
                }
            }
        }

        // if player is in air (currently in a jump) and has more jumpForce, continue
        // sending player upwards
        else if (airGroundState == AirGroundState.AIR) {
            if (jumpForce > 0) {
                moveAmountY -= jumpForce;
                jumpForce -= jumpDegrade;
                if (jumpForce < 0) {
                    jumpForce = 0;
                }
            }

            // allows you to move left and right while in the air
            if (Keyboard.isKeyDown(MOVE_LEFT_KEY)) {
                moveAmountX -= walkSpeed;
            } else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {
                moveAmountX += walkSpeed;
            }

            // if player is falling, increases momentum as player falls so it falls faster
            // over time
            if (moveAmountY > 0) {
                increaseMomentum();
            }
        }

        // if player last frame was in air and this frame is now on ground, player
        // enters STANDING state
        else if (previousAirGroundState == AirGroundState.AIR && airGroundState == AirGroundState.GROUND) {
            playerState = PlayerState.STANDING;
        }
        // trying to add attacking
        if (Keyboard.isKeyDown(ATTACK_KEY) ) {
          //  keyLocker.lockKey(ATTACK_KEY);
            playerState = PlayerState.ATTACKING;
            isAttacking = true; // for when max is attacking
//need to add make separate state for attacking in the air // could possibly get around without doing it, but that would be easiest method
// make attack a part of other states
//
// use: hasAnimationLooped - to 

        }
    }

    // This is for attacking
    protected void playerAttacking() {
        currentAnimationName = (facingDirection == Direction.RIGHT) ? "ATTACK_RIGHT" : "ATTACK_LEFT";

        // Check if the attack animation has reached its last frame
        if (currentFrameIndex == getCurrentAnimation().length - 1) {
            // The attack animation has finished; return to the previous state
            playerState = previousPlayerState;
           // playerState = PlayerState.STANDING; // may change
           // isAttacking = false; //besa

        } else {
            // Handle any logic related to attacking here, e.g., damaging enemies
            // Check for collisions with enemies and apply damage as needed
            super.update();
            attackHitbox = currentFrame.getBounds();//BESA HAL
// Additional logic for shooting in Level 1
        if (MaxInLevel == 1 && Keyboard.isKeyDown(SHOOT_KEY) && !keyLocker.isKeyLocked(SHOOT_KEY)) {
            keyLocker.lockKey(SHOOT_KEY);
            playerShooting();
        }
            for (Enemy entity : map.getActiveEnemies()) {
                if (entity.getMapEntityStatus() == MapEntityStatus.ACTIVE &&
                        entity.getBounds().intersects(attackHitbox)) {
                    entity.hurtEnemy();

                    // remember to add intersecting when player attacks the enemy

                }
            }
  if(MaxInLevel ==1){
        currentAnimationName = (facingDirection == Direction.RIGHT) ? "SHOOT_RIGHT" : "SHOOT_LEFT";

        int bulletx;
        float speedmovebull;
        
        if(facingDirection == Direction.RIGHT  ){//||facingDirection == Direction.LEFT 
            //edit code so bullet flies when k is pressed
            bulletx = Math.round(getX()+ getWidth());
            speedmovebull = 1.5f;
        }
        else{
            bulletx= Math.round(getX()-21);
            speedmovebull = -1.5f;
        }

        int bulletY = Math.round(getY() +90);
        MaxBullet bullet = new MaxBullet(getLocation(), speedmovebull, bulletY, facingDirection);
        map.addEnemy(bullet);
          //just added  
        if (currentFrameIndex == getCurrentAnimation().length - 1) {
            // Shooting animation is finished; transition back to another state.
            playerState = PlayerState.STANDING; // You can choose a different state.
        } else {
            // Continue playing the shooting animation.
            super.update();
        }
    }
            // Ensure the attack animation continues to update
            // super.update();
        }
    }
    protected void playerShooting(){ // add the logic for shooting 
        currentAnimationName = (facingDirection == Direction.RIGHT) ? "SHOOT_RIGHT" : "SHOOT_LEFT";

    int bulletx;
    float speedmovebull;

    if (facingDirection == Direction.RIGHT) {
        bulletx = Math.round(getX() + getWidth());
        speedmovebull = 1.5f;
    } else {
        bulletx = Math.round(getX() - 21);
        speedmovebull = -1.5f;
    }

    int bulletY = Math.round(getY() + 90);
    MaxBullet bullet = new MaxBullet(new Point(bulletx, bulletY), speedmovebull, bulletY, facingDirection);
    map.addEnemy(bullet);

    if (currentFrameIndex == getCurrentAnimation().length - 1) {
        // Shooting animation is finished; transition back to another state.
        playerState = PlayerState.STANDING; // You can choose a different state.
    } else {
        // Continue playing the shooting animation.
        super.update();
    }
    }

   // }

    // while player is in air, this is called, and will increase momentumY by a set
    // amount until player reaches terminal velocity
    protected void increaseMomentum() {
        momentumY += momentumYIncrease;
        if (momentumY > terminalVelocityY) {
            momentumY = terminalVelocityY;
        }
    }

    protected void updateLockedKeys() {
        if (Keyboard.isKeyUp(JUMP_KEY)) {
            keyLocker.unlockKey(JUMP_KEY);
        }
    }

    // anything extra the player should do based on interactions can be handled here
    protected void handlePlayerAnimation() {
        if (playerState == PlayerState.STANDING) {
            // sets animation to a STAND animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";

            // handles putting goggles on when standing in water
            // checks if the center of the player is currently touching a water tile
            int centerX = Math.round(getBounds().getX1()) + Math.round(getBounds().getWidth() / 2f);
            int centerY = Math.round(getBounds().getY1()) + Math.round(getBounds().getHeight() / 2f);
            MapTile currentMapTile = map.getTileByPosition(centerX, centerY);
            if (currentMapTile != null && currentMapTile.getTileType() == TileType.WATER) {
                this.currentAnimationName = facingDirection == Direction.RIGHT ? "SWIM_STAND_RIGHT" : "SWIM_STAND_LEFT";
            }
        } else if (playerState == PlayerState.WALKING) {
            // sets animation to a WALK animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "WALK_RIGHT" : "WALK_LEFT";
        } else if (playerState == PlayerState.CROUCHING) {
            // sets animation to a CROUCH animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "CROUCH_RIGHT" : "CROUCH_LEFT";
        } else if (playerState == PlayerState.JUMPING) {
            // if player is moving upwards, set player's animation to jump. if player moving
            // downwards, set player's animation to fall
            if (lastAmountMovedY <= 0) {
                this.currentAnimationName = facingDirection == Direction.RIGHT ? "JUMP_RIGHT" : "JUMP_LEFT";
            } else {
                this.currentAnimationName = facingDirection == Direction.RIGHT ? "FALL_RIGHT" : "FALL_LEFT";
            }

        }  if (playerState == PlayerState.ATTACKING) {// got rid of else
            // Set the animation to the attack animation based on the facing direction
            this.currentAnimationName = (facingDirection == Direction.RIGHT) ? "ATTACK_RIGHT" : "ATTACK_LEFT";

            // Check if the attack animation has reached its last frame
            if (currentFrameIndex == getCurrentAnimation().length - 1) {
                // The attack animation has finished; return to the previous state
                playerState = previousPlayerState;
                isAttacking = false;
            } else {
                // Continue updating the attack animation
                super.update();

                // Handle attacking logic here, e.g., check for collisions with enemies
                
                // Get the current frame's hitbox
                Rectangle attackHitbox = currentFrame.getBounds();

                for (MapEntity entity : listOfMapEntities) {
                    if (entity.getMapEntityStatus() == MapEntityStatus.ACTIVE &&
                            entity.getBounds().intersects(attackHitbox)) {
                        
                    }
                }
            }
        }
       

    }

    // Method to defeat an enemy on touch
    private void defeatEnemy(MapEntity enemy) {
        System.out.println("i'm working");
        if (enemy instanceof Enemy) {
            // Handle defeating the enemy, e.g., removing it from the game
            enemy.setMapEntityStatus(MapEntityStatus.REMOVED);
            System.out.println("i'm working");
        }
    }

    // Method to add an active enemy to the list
    public void addActiveEnemy(Enemy enemy) {
        activeEnemies.add(enemy);
    }

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
    }

    @Override
    public void onEndCollisionCheckY(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
        // if player collides with a map tile below it, it is now on the ground
        // if player does not collide with a map tile below, it is in air
        if (direction == Direction.DOWN) {
            if (hasCollided) {
                momentumY = 0;
                airGroundState = AirGroundState.GROUND;
            } else {
                playerState = PlayerState.JUMPING;
                airGroundState = AirGroundState.AIR;
            }
        }

        // if player collides with map tile upwards, it means it was jumping and then
        // hit into a ceiling -- immediately stop upwards jump velocity
        else if (direction == Direction.UP) {
            if (hasCollided) {
                jumpForce = 0;
            }
        }
    }

    // other entities can call this method to hurt the player
    public void hurtPlayer(MapEntity mapEntity) {
        if (!isInvincible) {
            if (lives > 0) {
                if (mapEntity instanceof Enemy) {
                    lives--; // Reduce the player's lives

                }
            }
            if (lives <= 0) {
                levelState = LevelState.PLAYER_DEAD; // Set to dead only if all lives are lost
            }
        }
    }

    // other entities can call this to tell the player they beat a level
    public void completeLevel() {
        levelState = LevelState.LEVEL_COMPLETED;
      
    }

    // if player has beaten level, this will be the update cycle
    public void updateLevelCompleted() {
        // if player is not on ground, player should fall until it touches the ground
        if (airGroundState != AirGroundState.GROUND && map.getCamera().containsDraw(this)) {
            currentAnimationName = "FALL_RIGHT";
            applyGravity();
            increaseMomentum();
            super.update();
            moveYHandleCollision(moveAmountY);
        }
        // move player to the right until it walks off screen
        else if (map.getCamera().containsDraw(this)) {
            currentAnimationName = "WALK_RIGHT";
            super.update();
            moveXHandleCollision(walkSpeed);
        } else {
            // tell all player listeners that the player has finished the level
            for (PlayerListener listener : listeners) {
                listener.onLevelCompleted();
            }
        }
    }

    // if player has died, this will be the update cycle
    public void updatePlayerDead() {
        // change player animation to DEATH
        if (!currentAnimationName.startsWith("DEATH")) {
            if (facingDirection == Direction.RIGHT) {
                currentAnimationName = "DEATH_RIGHT";
            } else {
                currentAnimationName = "DEATH_LEFT";
            }
            super.update();
        }
        // if death animation not on last frame yet, continue to play out death
        // animation
        else if (currentFrameIndex != getCurrentAnimation().length - 1) {
            super.update();
        }
        // if death animation on last frame (it is set up not to loop back to start),
        // player should continually fall until it goes off screen
        else if (currentFrameIndex == getCurrentAnimation().length - 1) {
            if (map.getCamera().containsDraw(this)) {
                moveY(3);
            } else {
                // tell all player listeners that the player has died in the level
                for (PlayerListener listener : listeners) {
                    listener.onDeath();
                }
            }
        }
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public AirGroundState getAirGroundState() {
        return airGroundState;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void setLevelState(LevelState levelState) {
        this.levelState = levelState;
        setMaxInLevel();
    }

    public void addListener(PlayerListener listener) {
        listeners.add(listener);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    public void addExtraLife() {
        this.lives++; // Increment the player's lives by one
    }
    // Add a method to apply a speed power-up
public void applySpeedPowerUp(float speedIncrease) {
    walkSpeed += speedIncrease;
    // Example usage in  the game logic// player.applySpeedPowerUp(2.0f); // Increases walk speed by 2 units//besa
}

    public int getCurrentLevel() {
        return currentLevel;
    }
    public void incrementLevel() {
        currentLevel++;
    }
// method to determine what level max is in; similar to the one in max class for the sprite
 public int getMaxInLevel(){
    return MaxInLevel;
 }
//remember to check sprites
//for when max is in level 3 have the bullet attack 
    public static   void setMaxInLevel() { // incraments MaxInLevel
        //  this.MaxInLevel++; // Increment MaxInLevel
          MaxInLevel++; // Increment MaxInLevel
      }

    public void checkAttack(Map map) {
        if(isAttacking ){
System.out.println("i am checking the attack of max");
playerAttacking();
        }
                    else if (isShooting =true){
                    playerShooting();
                }
    }
    
}
