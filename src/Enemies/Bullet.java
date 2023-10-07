package Enemies;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.MapEntity;
import Level.MapEntityStatus;
import Level.Player;
import Utils.Direction;
import Utils.Point;

import java.awt.Color;
import java.util.HashMap;

public class Bullet extends Enemy {
    // This class is for the bullet enemy that the PrisonGuardEnemy class shoots out
    // it will travel in a straight line (x axis) for a set time before disappearing
    // it will disappear early if it collides with a solid map tile

    private float movementSpeed;
    private int existenceFrames;

    public Bullet(Point location, float movementSpeed, int existenceFrames) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("bullet.png"), 31, 11), "DEFAULT");
        this.movementSpeed = movementSpeed;

        // how long the bullet will exist for before disappearing
        this.existenceFrames = existenceFrames;

        initialize();

    }

    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
       // drawBounds(graphicsHandler, new Color(255, 0, 0, 170));
    }

    @Override
    public void update(Player player) {
        // if timer is up, set map entity status to REMOVED
        // the camera class will see this next frame and remove it permanently from the
        // map
        if (existenceFrames == 0) {
            this.mapEntityStatus = MapEntityStatus.REMOVED;
        } else {
            // move bullet forward
            moveXHandleCollision(movementSpeed);
            super.update(player);
        }
        existenceFrames--;
    }

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
        // if bullet collides with anything solid on the x axis, it is removed
        if (hasCollided) {
            this.mapEntityStatus = MapEntityStatus.REMOVED;
        }
    }

    @Override
    public void touchedPlayer(Player player) {
        // if bullet touches player, it disappears
        super.touchedPlayer(player);
        this.mapEntityStatus = MapEntityStatus.REMOVED;
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {
            {
                put("DEFAULT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withBounds(1, 1, 5, 5)
                                .build()
                });
            }
        };
    }
}
