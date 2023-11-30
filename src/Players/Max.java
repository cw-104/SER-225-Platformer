package Players;
// check PlayLevelScreen.java for the implementations of max into the level

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.LevelState;
import Level.Player;
import Screens.PlayLevelScreen;

import java.awt.Color;
import java.util.HashMap;

// This is the class for the max player character
// basically just sets some values for physics and then defines animations
public class Max extends Player {
private int currentLevel;
private int MaxInLevel =0;
        public Max(float x, float y){
                super(new SpriteSheet(ImageLoader.load("Max19.png"), 50, 50), x, y, "STAND_RIGHT");
                gravity = .5f;
                terminalVelocityY = 6f;
                jumpHeight = 16.5f;
                jumpDegrade = .5f;
                walkSpeed = 7.5f;
                momentumYIncrease = .5f;
                this.currentLevel =currentLevel;
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

//jumpattack
                put("JUMPATTACK_RIGHT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(4, 6))
                                                                .withScale(3)
                                                                .withBounds(1, 3, 33, 28)
                                                                .build(),
                                              

                                                                
                                });

                                put("JUMPATTACK_LEFT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(4, 6))
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                 .withBounds(1, 3, 33, 28)
                                                                .build(),
                                                 
                                

                             
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
                                                                .withBounds(15, 8, 20, 23)// Original: 15,8,20,23
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
                                                new FrameBuilder(spriteSheet.getSprite(4, 4), 8)

                                               .withScale(3)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(4, 5), 8)
                                                                .withScale(3)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(5, 0), -1)
                                                                .withScale(3)
                                                                .build()
                                });

                               
                                put("DEATH_LEFT", new Frame[] {
                                                new FrameBuilder(spriteSheet.getSprite(5, 0), 8)

                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(4, 5), 8)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(5, 0), -1)
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
                                                new FrameBuilder(spriteSheet.getSprite(7, 6), 8)

                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(1, 3, 33, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(1, 7), 8)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(1, 3, 33, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(3, 7), -1)
                                                                .withScale(3)
                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(1, 3, 33, 28)
                                                                .build()
                                });

                                put("ATTACK_RIGHT", new Frame[] { // testing for batt attacking
                                                new FrameBuilder(spriteSheet.getSprite(7, 6), 8)//6,0
                                                                .withScale(3)
                                                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(18, 3, 33, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(1, 7), 8)//6,1
                                                                .withScale(3)
                                                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(18, 3, 33, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(3, 7), -1)//6,2
                                                                .withScale(3)
                                                                // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                .withBounds(18, 3, 33, 28) // .withBounds(8, 9, 8, 9) //
                                                                                           // the original bounds
                                                                .build()
                                });
                                
                               //attempt to change the sprites in changing kevel //startOfTest
                                                                if(MaxInLevel>0){ //using column 6 as testvale //remember to come back and add the ptoper sprite sets
                                put("ATTACK_LEFT", new Frame[] { 
                                                                                new FrameBuilder(spriteSheet.getSprite(6, 6), 8)
                                                                                                .withScale(3)
                                                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                                                .withBounds(1, 3, 33, 28)
                                                                                                .build(),
                                                                                new FrameBuilder(spriteSheet.getSprite(6, 7), 8)
                                                                                                .withScale(3)
                                                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                                                .withBounds(1, 3, 33, 28)
                                                                                                .build(),
                                                                                new FrameBuilder(spriteSheet.getSprite(8, 6), -1)
                                                                                                .withScale(3)
                                                                                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                                                                                .withBounds(1, 3, 33, 28)
                                                                                                .build()
                                                                });

                                }//EndOfTest
//attempt to change the sprites in changing kevel //startOfTest //right side 
                                if(MaxInLevel>0){ //using column 6 as testvale //remember to come back and add the ptoper sprite sets
put("ATTACK_RIGHT", new Frame[] { 
                                                new FrameBuilder(spriteSheet.getSprite(6, 6), 8)
                                                                .withScale(3)
                                                                .withBounds(1, 3, 33, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(6, 7), 8)
                                                                .withScale(3)                                                             
                                                                .withBounds(1, 3, 33, 28)
                                                                .build(),
                                                new FrameBuilder(spriteSheet.getSprite(8, 6), -1)
                                                                .withScale(3)                                                         
                                                                .withBounds(1, 3, 33, 28)
                                                                .build()
                                });

}//EndOfTest //right side 
                        }
                };


        }
        public int setMaxinLevel(int MaxInLevel){
                this.MaxInLevel = MaxInLevel + 1 ;
                if (levelState == LevelState.LEVEL_COMPLETED){
                        MaxInLevel ++;
                }
                return MaxInLevel++;
        }//come back 
        //option a: swap images based on counter or B: have multiple max methods with differnt pngs

        public int getMAxInLevel( int MaxInLevel){
                return MaxInLevel;
        }
        
}


        
        
        

