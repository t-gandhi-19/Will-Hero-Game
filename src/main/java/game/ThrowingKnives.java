package game;

public class ThrowingKnives extends Weapon{
    private int throwDistance;
    private int knifeCount;

    public void ThrowingKnives(){
        ThrowingKnives knife = new ThrowingKnives();

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
