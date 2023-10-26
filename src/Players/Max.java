package Players;
// check PlayLevelScreen.java for the implementations of max into the level

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;

import java.awt.Color;
import java.util.HashMap;

// This is the class for the max player character
// basically just sets some values for physics and then defines animations
public class Max extends Player {

        public Max(float x, float y) {
                super(new SpriteSheet(ImageLoader.load("Max11.png"), 50, 50), x, y, "STAND_RIGHT");
                gravity = .5f;
                terminalVelocityY = 6f;
                jumpHeight = 16.5f;
                jumpDegrade = .5f;
                walkSpeed = 7.5f;
                momentumYIncrease = .5f;
        }

        public void update() {
                super.update();
        }

        public void draw(GraphicsHandler graphicsHandler) {
                super.draw(graphicsHandler);
                // drawBounds(graphicsHandler, new Color(255, 0, 0, 170));
        }

        @Override
        public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {
                        {
                                put("STAND_RIGHT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                                                .withScale(3)
                                                                .withBounds(15, 3, 16, 28)// originally was 9for height
                                                                                          // // was .withBounds(15, 20,
                                                                                          // 20, 11)
                                                                .build()
                                });

                                put("STAND_LEFT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(20, 3, 16, 28)
                                                                .build()
                                });

                                put("WALK_RIGHT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                                                                .withScale(3)
                                                                .withBounds(15, 3, 16, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(0, 2), 14)
                                                                .withScale(3)
                                                                .withBounds(15, 3, 16, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(0, 3), 14)
                                                                .withScale(3)
                                                                .withBounds(15, 3, 16, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(0, 4), 14)
                                                                .withScale(3)
                                                                .withBounds(15, 3, 16, 28)
                                                                .build()
                                });

                                put("WALK_LEFT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(20, 3, 16, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(20, 3, 16, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(0, 2), 14)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(20, 3, 16, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(0, 3), 14)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(20, 3, 16, 28)
                                                                .build()
                                });

                                put("JUMP_RIGHT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(2, 0))
                                                                .withScale(3)
                                                                .withBounds(15, 3, 16, 28)
                                                                .build()
                                });

                                put("JUMP_LEFT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(2, 0))
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(20, 3, 16, 28)
                                                                .build()
                                });

                                put("FALL_RIGHT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(3, 0))
                                                                .withScale(3)
                                                                .withBounds(15, 3, 16, 28)
                                                                .build()
                                });

                                put("FALL_LEFT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(3, 0))
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(15, 3, 16, 28)
                                                                .build()
                                });

                                put("CROUCH_RIGHT", new Frame[] { // putting 3 for now- fix
                                                new FrameBuilder(spriteSheet.getSprite(3, 0))
                                                                .withScale(3)
                                                                .withBounds(15, 20, 25, 28)
                                                                .build()
                                });

                                put("CROUCH_LEFT", new Frame[] { // there is no row 4 fix this
                                                new FrameBuilder(spriteSheet.getSprite(3, 0))
                                                                .withScale(3)// keep as 3 for now
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(15, 3, 16, 28)
                                                                .build()
                                });

                                put("DEATH_RIGHT", new Frame[] { // there is no row 5 fix this
                                                new FrameBuilder(spriteSheet.getSprite(5, 0), 8)
                                                                .withScale(3)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(5, 1), 8)
                                                                .withScale(3)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(5, 2), -1)
                                                                .withScale(3)
                                                                .build()
                                });

                                put("DEATH_LEFT", new Frame[] { // currently no row 5
                                                new FrameBuilder(spriteSheet.getSprite(5, 0), 8)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(5, 1), 8)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(5, 2), -1)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .build()
                                });

                                put("SWIM_STAND_RIGHT", new Frame[] { // currently no row 6
                                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                                                .withScale(3)
                                                                .withBounds(15, 3, 16, 28)
                                                                .build()
                                });

                                put("SWIM_STAND_LEFT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(15, 3, 16, 28)
                                                                .build()
                                });

                                put("ATTACK_LEFT", new Frame[] { // testing for batt attacking
                                                new FrameBuilder(spriteSheet.getSprite(6, 0), 8)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(12, 3, 20, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(6, 1), 8)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(12, 3, 20, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(6, 2), -1)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .build()
                                });

                                put("ATTACK_RIGHT", new Frame[] { // testing for batt attacking
                                                new FrameBuilder(spriteSheet.getSprite(6, 0), 8)
                                                                .withScale(3)
                                                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(20, 3, 20, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(6, 1), 8)
                                                                .withScale(3)
                                                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(20, 3, 20, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(6, 2), -1)
                                                                .withScale(3)
                                                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(20, 3, 20, 28) // .withBounds(8, 9, 8, 9) //
                                                                                           // the original bounds
                                                                .build()
                                });

                        }
                };
        }
}
