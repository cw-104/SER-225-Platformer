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
public class Arrow extends Enemy {
    private float movementSpeed;
    private int existenceFrames;

    public  Arrow(Point location, float movementSpeed, int existenceFrames) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Arrow.png"), 29 , 7), "DEFAULT");
        this.movementSpeed = movementSpeed;

        // how long the arow will exist for before disappearing
        this.existenceFrames = existenceFrames;

        initialize();

      
    }

     public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
       drawBounds(graphicsHandler, new Color(255, 0, 0, 170));
    }

    @Override
    public void update(Player player) {
        // if timer is up, set map entity status to REMOVED
        // the camera class will see this next frame and remove it permanently from the map
        if (existenceFrames == 0) {
            this.mapEntityStatus = MapEntityStatus.REMOVED;
        } else {
            // move fireball forward
            moveXHandleCollision(movementSpeed);
            super.update(player);
        }
        existenceFrames--;
    }

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
        // if fireball collides with anything solid on the x axis, it is removed
        if (hasCollided) {
            this.mapEntityStatus = MapEntityStatus.REMOVED;
        }
    }

    @Override
    public void touchedPlayer(Player player) {
        // if fireball touches player, it disappears
        super.touchedPlayer(player);
        this.mapEntityStatus = MapEntityStatus.REMOVED;
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("DEFAULT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(1, 1, 30, 5)
                            .build()
            });
        }};
    }
    
}
