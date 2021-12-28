package game;

public class ThrowingKnives extends Weapon{
    private int throwDistance;
    private int knifeCount;

    public ThrowingKnives(int level, int hitPoint,int knifeC) {
        super(level, hitPoint);
        knifeCount = knifeC;
    }

    public int getThrowDistance(){
        return this.throwDistance;
    }
    public int getKnifeCount(){
        return this.knifeCount;

    }
    public void setKnifeCount(boolean b, int k){
        this.knifeCount=k;
    }
}
