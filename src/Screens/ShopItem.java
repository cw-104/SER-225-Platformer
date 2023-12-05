package Screens;

import Level.Player;

public class ShopItem {
    private String name;
    private int price;
    private String description;
    private boolean purchased;

    public ShopItem(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.purchased = false;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

//added to attempt fixing speed powerup // besa //get help if needed 
public void applyEffect(Player player) {
        // Implement the effect based on the item (e.g., increase speed, add extra life)
        // You can use a switch statement or if-else conditions based on the item's name or ID
        if (name.equals("Speed Up")) {
           // player.increaseSpeed();
           System.out.println("power up is chosen. good job man");// line for myself to see that code works take out once done// besa
        } else if (name.equals("Health Up")) {
            player.addExtraLife();
        }
        // Add more conditions for other items as needed
    }



}
