package hydrovor;

/**
 * Hydrovor provides water to Sink and gets water from Tank
 */
public class Hydrovor {

    private Tank tank;
    private boolean isOn;
    private int volume;

    public Hydrovor(Tank tank, int volume)
    {
        if(tank == null || volume < 0){
            throw new IllegalArgumentException();
        }
        this.tank = tank;
        this.volume = volume;
    }

    public void on()
    {
        isOn = true;
    }
    public void off()
    {
        isOn = false;
    }

    public int getWater()
    {
        if(volume > 0){
            volume--;
            return 1;
        }else{
            return 0;
        }
    }

    public void tick(){
        if (isOn){
            volume ++;
        }
    }
}
