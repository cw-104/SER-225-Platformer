package Players;
// check PlayLevelScreen.java for the implementations of max into the level

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Keyboard;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;
import Screens.PlayLevelScreen;

import java.awt.Color;
import java.util.HashMap;

// This is the class for the max player character
// basically just sets some values for physics and then defines animations
public class Max extends Player {
        private int cooldown = 5;// cool down int
        private static int MaxInLevel;

        public Max(float x, float y, int currentLevel) {//added current level//may have to take out 
                super(new SpriteSheet(ImageLoader.load("Max21.png"), 50, 50), x, y, "STAND_RIGHT", currentLevel);
                gravity = .5f;
                terminalVelocityY = 6f;
                jumpHeight = 16.5f;
                jumpDegrade = .5f;
                walkSpeed = 7.5f;
                momentumYIncrease = .5f;
                MaxInLevel = 0; // Initialize MaxInLevel to 0 //has max change in the next level // "Max.setMaxInLevel();" is called in level complete to increase
        }

        public void update() {
                super.update();

                if (cooldown > 0){
                        cooldown--;
                }
                else if(cooldown <= 0 && Keyboard.isKeyDown(ATTACK_KEY)){
                        //method to spawn in a bullet
                        if(MaxInLevel ==1){ 
                                super.playerAttacking();
                        cooldown = 5; }
                        
                }
        }

        public void draw(GraphicsHandler graphicsHandler) {
                super.draw(graphicsHandler);
               //drawBounds(graphicsHandler, new Color(255, 0, 0, 170));// turn this on/ off to see the bounds for Max
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
                                                                .withBounds(19, 3, 16, 28)
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
                                                                .withBounds(19, 3, 16, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(19, 3, 16, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(0, 2), 14)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(19, 3, 16, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(0, 3), 14)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(19, 3, 16, 28)
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
                                                                .withBounds(19, 3, 16, 28)
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
                                                                .withBounds(19, 3, 16, 28)
                                                                .build()
                                });

                                put("CROUCH_RIGHT", new Frame[] { // putting 3 for now- fix
                                                new FrameBuilder(spriteSheet.getSprite(1, 6), 8)
                                                                .withScale(3)
                                                                .withBounds(15, 8, 20, 23)
                                                                .build(),

                                });

                                put("CROUCH_LEFT", new Frame[] { // there is no row 4 fix this
                                                new FrameBuilder(spriteSheet.getSprite(1, 6), 8)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(15, 8, 20, 23)
                                                                .build(),

                                });

                                put("DEATH_RIGHT", new Frame[] {
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

                                put("DEATH_LEFT", new Frame[] {
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
                                put("ATTACK_LEFT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(0, 7), 8)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(1, 3, 33, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(1, 7), 8)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(1, 3, 33, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(2, 7), 8)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(1, 3, 33, 28)
                                                                .build()
                                });

                                put("ATTACK_RIGHT", new Frame[] { // testing for batt attacking
                                                new FrameBuilder(spriteSheet.getSprite(0, 7), 8)
                                                                .withScale(3)
                                                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(18, 3, 33, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(1, 7), 8)
                                                                .withScale(3)
                                                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(18, 3, 33, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(2, 7), 8)
                                                                .withScale(3)
                                                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(18, 3, 33, 28) // .withBounds(8, 9, 8, 9) //
                                                                                           // the original bounds
                                                                .build()
                                });
                        
// checking to see if max is in another level 

//Repeat this process for the next level but change it to 2 (for level 3). //LOOK AT ME!! CHANGES MAX SPRITE FOR THE LEVEL  
if (MaxInLevel == 1) { //was originally > 2 // changed it to 0 to see if it worked and it did 
        setMaxInLevel();
        // Change the attack animations based on the player's/ Max's level
        put("ATTACK_LEFT", new Frame[] {// sprites for attacking with axe
            new FrameBuilder(spriteSheet.getSprite(6, 4), 8)
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(1, 3, 33, 28)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(6, 5 ), 8)//+1
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(1, 3, 33, 28)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(6, 6), 8)
                .withScale(3)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .withBounds(1, 3, 33, 28)
                .build()
        });

        put("ATTACK_RIGHT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(6, 4), 8)
                .withScale(3)
                .withBounds(18, 3, 33, 28)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(6, 5), 8)
                .withScale(3)
                .withBounds(18, 3, 33, 28)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(6, 6 ), 8)
                .withScale(3)
                .withBounds(18, 3, 33, 28)
                .build()
        });
    }                                   // sprites for level 3 will go here // for testing purposes change 2 to 1 or 0 to see if the sprite work[if level 3 test map is not ready]
                                        if (MaxInLevel == 2) { //was originally > 2 // changed it to 0 to see if it worked and it did 
                                                setMaxInLevel();
                                                // Change the attack animations based on the player's/ Max's level
                                                put("SHOOT_LEFT", new Frame[] {// sprites for attacking with axe
                                                new FrameBuilder(spriteSheet.getSprite(8, 3), 8)//8,3
                                                        .withScale(3)
                                                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                        .withBounds(1, 3, 33, 28)
                                                        .build(),
                                                new FrameBuilder(spriteSheet.getSprite(8, 3), 8)//+1
                                                        .withScale(3)
                                                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                        .withBounds(1, 3, 33, 28)
                                                        .build(),
                                                new FrameBuilder(spriteSheet.getSprite(8, 3), 8)
                                                        .withScale(3)
                                                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                        .withBounds(1, 3, 33, 28)
                                                        .build()
                                                });

                                                put("SHOOT_RIGHT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(8, 3), 8)//8,3
                                                        .withScale(3)
                                                        .withBounds(18, 3, 33, 28)
                                                        .build(),
                                                new FrameBuilder(spriteSheet.getSprite(8, 3), 8)
                                                        .withScale(3)
                                                        .withBounds(18, 3, 33, 28)
                                                        .build(),
                                                new FrameBuilder(spriteSheet.getSprite(8, 3 ), 8)
                                                        .withScale(3)
                                                        .withBounds(18, 3, 33, 28)
                                                        .build()
                                                });
                                        }

                        }
                };
        }

         
        public static   void setMaxInLevel() {
              //  this.MaxInLevel++; // Increment MaxInLevel
                MaxInLevel++; // Increment MaxInLevel
            }

}