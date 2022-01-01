package game;

import java.io.IOException;

public class WeaponChest extends Chests{
    private Weapon weapon;
    public WeaponChest(Weapon weapon) throws IOException {
        super("Weapon", false);
        this.weapon= weapon;
    }
    @Override
    public void collectChest(Hero hero) {
        this.open = true;
        hero.getHelmet().addWeapon(weapon);

    }
}
