package GameObject;



import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Screen;
import Level.MapEntity;
import Level.Player;


public class Coin extends MapEntity {

    private boolean isCollected;
    private Screen screen;
    private int coinTotal;
    private final float posX, posY;

    public Coin(float x, float y) {
        super(x, y, new Frame(ImageLoader.load("Coin.png")));
        this.posX = x;
        this.posY = y;
        setScale(3);
        coinTotal = 0;
    }

    public void check(Player player) {
        if ((intersects(player) || overlaps(player)) && !isCollected) {
            collectCoin(player);
        }
    }

    private void collectCoin(Player player) {
        isCollected = true;
        //coinTotal++;
        player.addCoins(1);
    }

    public boolean isCollected() {
        return isCollected;
    }

    public int totalCoins(Player player) {
        return player.getCoins();
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        if (!isCollected) {
            super.draw(graphicsHandler);
        }
    }
}