package game;

import java.io.IOException;
import java.lang.Integer;
import java.util.HashMap;

public class TreasureChest extends Chests{
    private int id;
    private int coins;

    public HashMap<Integer,Integer> coinChest = new HashMap<>();

    public TreasureChest() throws IOException {
    }
    public void setCoins(int coinCount){
        this.coins= coinCount;

    }
    public void getCoins(Hero hero){
        hero.addCoins(coins);

    }

}
