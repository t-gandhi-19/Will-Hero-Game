package game;

import javafx.scene.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.HashMap;

public class treasureChest extends Chests{
    private int id;
    private int coins;

    public HashMap<Integer,Integer> coinChest = new HashMap<>();

    public treasureChest() throws IOException {
    }
    public void setCoins(int coinCount){
        this.coins= coinCount;

    }
    public void getCoins(Hero hero){
        hero.addCoins(coins);

    }

}
