package game;

import java.io.IOException;

public class Boss extends Orc{
    private  int forwardBossDistance=40;


    public Boss(int h, int c, String d) throws IOException {
        super(h, c, d);
    }

    public int getForwardBossDistance(){
        return  forwardBossDistance;
    }


}