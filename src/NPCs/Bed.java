package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;
import java.awt.Color;

import java.util.HashMap;

// This is the class for the Cat player character
// basically just sets some values for physics and then defines animations
public class Bed extends Player {

        public Bed(float x, float y) {
                super(new SpriteSheet(ImageLoader.load("Bed.png"), 24, 24), x, y, "BED_RIGHT");
                gravity = .5f;
                terminalVelocityY = 6f;
                jumpHeight = 14.5f;
                jumpDegrade = .5f;
                walkSpeed = 2.3f;
                momentumYIncrease = .5f;
        }

        public void update() {
                super.update();
        }

        public void draw(GraphicsHandler graphicsHandler) {
                super.draw(graphicsHandler);
                drawBounds(graphicsHandler, new Color(255, 0, 0, 170));
        }

        @Override
        public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {
                        {
                                put("BED_RIGHT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                                                .withScale(3)
                                                                .withBounds(8, 9, 8, 9)
                                                                .build()
                                });

                                put("BED_LEFT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(8, 9, 8, 9)
                                                                .build()
                                });

                                
                        }
                };
        }
}
