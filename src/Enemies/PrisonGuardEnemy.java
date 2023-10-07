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

// Guard Death Sprite (0,8), Guard Shoot Sprite(1,0)

public class PrisonGuardEnemy extends Enemy {
    protected Point startLocation;
    protected Point endLocation;

    protected float movementSpeed = 1f;
    private Direction startFacingDirection;
    protected Direction facingDirection;
    protected AirGroundState airGroundState;

    protected int shootWaitTimer;

    protected int shootTimer;

    protected PrisonGuardState prisonGuardState;
    protected PrisonGuardState previousPrisonGuardState;

    public PrisonGuardEnemy(Point startLocation, Point endLocation, Direction facingDirection) {
        super(startLocation.x, startLocation.y, new SpriteSheet(ImageLoader.load("GuardSpriteSheet.png"), 50, 50),
                "WALK_LEFT");
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startFacingDirection = facingDirection;
        this.initialize();
    }

    @Override
    public void initialize() {
        super.initialize();
        prisonGuardState = PrisonGuardState.WALK;
        previousPrisonGuardState = prisonGuardState;
        facingDirection = startFacingDirection;
        if (facingDirection == Direction.RIGHT) {
            currentAnimationName = "WALK_RIGHT";
        } else if (facingDirection == Direction.LEFT) {
            currentAnimationName = "WALK_LEFT";
        }
        airGroundState = AirGroundState.GROUND;

        // every certain number of frames, the bullet will be shot out
        shootWaitTimer = 50;
    }

    @Override
    public void update(Player player) {
        float startBound = startLocation.x;
        float endBound = endLocation.x;

        // if shoot timer is up and prison guard is not currently shooting, set its state to
        // SHOOT
        if (shootWaitTimer == 0 && prisonGuardState != PrisonGuardState.SHOOT_WAIT) {
            prisonGuardState = PrisonGuardState.SHOOT_WAIT;
        } else {
            shootWaitTimer--;
        }

        if (prisonGuardState == PrisonGuardState.WALK) {
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

        if (prisonGuardState == PrisonGuardState.SHOOT_WAIT) {
            if (previousPrisonGuardState == PrisonGuardState.WALK) {
                shootTimer = 65;
                currentAnimationName = facingDirection == Direction.RIGHT ? "SHOOT_RIGHT" : "SHOOT_LEFT";
            } else if (shootTimer == 0) {
                prisonGuardState = PrisonGuardState.SHOOT;
            } else {
                shootTimer--;
            }
        }

        if (prisonGuardState == PrisonGuardState.SHOOT) {
            int bulletX;
            float movementSpeed;
            if (facingDirection == Direction.RIGHT) {
                bulletX = Math.round(getX()) + getWidth();
                movementSpeed = 2.5f;
            } else {
                bulletX = Math.round(getX() - 21);
                movementSpeed = -2.5f;
            }

            int bulletY = Math.round(getY()+50) ;

            // create bullet enemy
            Bullet bullet = new Bullet(new Point(bulletX, bulletY), movementSpeed, 60);

            // add bullet enemy to the map for it to spawn in the level
            map.addEnemy(bullet);

            // change prison guard back to its WALK state after shooting, reset shootTimer to
            // wait a certain number of frames before shooting again
            prisonGuardState = PrisonGuardState.WALK;

            // reset shoot wait timer so the process can happen again (dino walks around,
            // then waits, then shoots)
            shootWaitTimer = 130;
        }

        super.update(player);

        previousPrisonGuardState = prisonGuardState;
    }

    /*public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        drawBounds(graphicsHandler, new Color(255, 0, 0, 170));
    }*/

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
        // if prison guard enemy collides with something on the x axis, it turns around and
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
                                .withScale(3)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(22,16,12,25)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                                .withScale(3)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(22, 16, 12, 25)
                                .build()
                });

                put("WALK_RIGHT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                                .withScale(3)
                              // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                              .withBounds(12, 16, 12, 25)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                                .withScale(3)
                               // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                              .withBounds(12, 16, 12,25 )
                                .build()
                });

                put("SHOOT_LEFT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(1, 0))
                                .withScale(3)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(22, 16, 12, 25)
                                .build(),
                });

                put("SHOOT_RIGHT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(1, 0))
                                .withScale(3)
                               // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(12, 16, 12, 25)
                                .build(),
                });
            }
        };
    }

    public enum PrisonGuardState {
        WALK, SHOOT_WAIT, SHOOT
    }

}
