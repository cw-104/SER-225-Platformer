package Level;
// class is going to be used to have max speed up once the power up is gained.
//nts: pic icon that could be used for the visual representation of the  power-up
//use coin class as possible reference 
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Screen;
import Level.MapEntity;// might have to change to extending mapentity; posibbly come back to this //besa
import Level.Player;
import GameObject.Frame;
import GameObject.GameObject; /// might change to this

public class SpeedPowerUp  extends MapEntity{
      //  private int speedBoost;
       // private int timeDuration; // possibly will have the power up work for a certain duration // may get rid of duration and have it work till max gets hurt
        private float speedBoostAmount;
        private int durationFrames;// may change
                        private boolean isCollected;
                        private Screen screen;
                        private final float posX, posY;

    public SpeedPowerUp(float x, float y,float speedBoostAmount, int durationFrames) {
        super(15, 35, new Frame(ImageLoader.load("Coin.png"))); // choose pic to be used for speed power up
        this.posX = x;
        this.posY = y;
        this.speedBoostAmount = speedBoostAmount;
        this.durationFrames = durationFrames;
        setScale(3);// might not need this tbd
        //TODO Auto-generated constructor stub
    }
    
        

    public void applyPowerUp(Player player) {
       player.applySpeedPowerUp(20);//just changed // besa
      //may need to change this file
    }



    public boolean isCollected() {
      return isCollected;//besa
    }



    public void setCollected(boolean collected) {
      isCollected = collected;
    }



    public float getSpeedBoostAmount() {
        return speedBoostAmount;
    }



    public int getDurationFrames() {
        return durationFrames;
    }




}

