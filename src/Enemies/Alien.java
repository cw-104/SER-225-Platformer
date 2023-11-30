package Enemies;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
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

import java.awt.Color;
import java.util.HashMap;

public class Alien extends Enemy {
    protected Point startLocation;
    protected Point endLocation;

    protected float movementSpeed = 5f;
    private Direction startFacingDirection;
    protected Direction facingDirection;
    protected AirGroundState airGroundState;

    protected int shootWaitTimer;

    protected int shootTimer;

    protected AlienState alienState;
    protected AlienState previousAlienState;

    public Alien(Point startLocation, Point endLocation, Direction facingDirection) {
        super(startLocation.x, startLocation.y, new SpriteSheet(ImageLoader.load("Alien.png"), 50, 50),
                "WALK_LEFT");
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startFacingDirection = facingDirection;
        this.initialize();
    }

    @Override
    public void initialize() {
        super.initialize();
        alienState = AlienState.WALK;
        previousAlienState = alienState;
        facingDirection = startFacingDirection;
        if (facingDirection == Direction.RIGHT) {
            currentAnimationName = "WALK_RIGHT";
        } else if (facingDirection == Direction.LEFT) {
            currentAnimationName = "WALK_LEFT";
        }
        airGroundState = AirGroundState.GROUND;

        // every certain number of frames, the laser will be shot out
        shootWaitTimer = 40;
    }

    @Override
    public void update(Player player) {
        float startBound = startLocation.x;
        float endBound = endLocation.x;

        // if shoot timer is up and hunter is not currently shooting, set its
        // state to
        // SHOOT
        if (shootWaitTimer == 0 && alienState != AlienState.SHOOT_WAIT) {
            alienState = AlienState.SHOOT_WAIT;
        } else {
            shootWaitTimer--;
        }

        if (alienState == AlienState.WALK) {
            if (facingDirection == Direction.RIGHT) {
                currentAnimationName = "WALK_RIGHT";
                moveXHandleCollision(movementSpeed);
            } else {
                currentAnimationName = "WALK_LEFT";
                moveXHandleCollision(-movementSpeed);
            }

            if (getX1() + getWidth() >= endBound) {
                float difference = endBound - (getX2());
                moveXHandleCollision(-difference);
                facingDirection = Direction.LEFT;
            } else if (getX1() <= startBound) {
                float difference = startBound - getX1();
                moveXHandleCollision(difference);
                facingDirection = Direction.RIGHT;
            }
        }

        if (alienState == AlienState.SHOOT_WAIT) {
            if (previousAlienState == AlienState.WALK) {
                shootTimer = 45;
                currentAnimationName = facingDirection == Direction.RIGHT ? "SHOOT_RIGHT" : "SHOOT_LEFT";
            } else if (shootTimer == 0) {
                alienState = AlienState.SHOOT;
               
            } else {
                shootTimer--;
            }
        }
 
        if (alienState == AlienState.SHOOT) {
            int laserX;
            float movementSpeed;
            if (facingDirection == Direction.RIGHT) {
                laserX = Math.round(getX()) + getWidth();
                movementSpeed = 5f;
            } else {
                laserX = Math.round(getX() - 21);
                movementSpeed = -5f;
            }

            int laserY = Math.round(getY() + 85);

            // create laser enemy
            Laser laser = new Laser(new Point(laserX, laserY), movementSpeed, 60);
           
             map.addEnemy(laser);
             map.addEnemy(laser);
             map.addEnemy(laser);
           
            // change alien back to its WALK state after shooting, reset shootTimer
            // to
            // wait a certain number of frames before shooting again
            alienState = AlienState.WALK;

            // reset shoot wait timer so the process can happen again (hunter walks around,
            // then waits, then shoots)
            shootWaitTimer = 100;
        }

        super.update(player);

        previousAlienState = alienState;
    }

    
     public void draw(GraphicsHandler graphicsHandler) {
     super.draw(graphicsHandler);
      //drawBounds(graphicsHandler, new Color(255, 0, 0, 170));
      }
     

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
        // if alien enemy collides with something on the x axis, it turns around
        // and
        // walks the other way
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
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {
            {
                put("WALK_LEFT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                                .withScale(4)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(12, 2, 35, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                                .withScale(4)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(12, 2, 35, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 2), 14)
                                .withScale(4)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(12, 2, 35, 40)
                                .build()
                });

                put("WALK_RIGHT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                                .withScale(4)
                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(12, 2, 35, 40)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                                .withScale(4)
                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(12, 2, 35, 40)
                                .build(),

                        new FrameBuilder(spriteSheet.getSprite(0, 2), 14)
                                .withScale(4)
                                //.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(12, 2, 35, 40)
                                .build()
                });

                put("SHOOT_LEFT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 3))
                                .withScale(4)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(12, 2, 35, 40)
                                .build(),
                });

                put("SHOOT_RIGHT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 3))
                                .withScale(4)
                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(8, 2, 35, 40)
                                .build(),
                });

            }
        };
    }

    public enum AlienState {
        WALK, SHOOT_WAIT, SHOOT,
    }

}