package game;

public class Weapon {
    private int level;
    public int hitPoint;

    public Weapon(int level, int hitPoint) {
        this.level = level;
        this.hitPoint = hitPoint;
    }

    public void setLevel(int Wlevel){
        this.level=Wlevel;


    }
    public int getLevel(Weapon weapon){
        return weapon.level;

    }
}
