package game;

import java.io.IOException;

public class Boss extends Orc{
    private  int forwardBossDistance=40;

    public Boss() throws IOException {

    }
    public int getForwardBossDistance(){
        return  forwardBossDistance;
    }


}