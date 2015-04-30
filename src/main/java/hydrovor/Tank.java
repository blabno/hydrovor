package hydrovor;

/**
 * Tank provides water to Hydrovor and gets water from Pump
 */
public class Tank {

    private int maxVolume;
    private int volume;

    public Tank(int maxVolume, int volume)
    {
        if(maxVolume < 0 || volume < 0){
            throw new IllegalArgumentException();
        }
        this.maxVolume = maxVolume;
        this.volume = volume;
    }


    public int getWater()
    {
        if (volume > 0){
            volume--;
            return 1;
        }else {
            return 0;
        }
    }


    public int addWater(int volumeToAdd){
        int availalbleVolume = maxVolume - volume;

        if(availalbleVolume >= volumeToAdd){
            volume += volumeToAdd;
            return volumeToAdd;
        }else{
            volume = maxVolume;
            return maxVolume - (volumeToAdd - availalbleVolume);
        }
    }

}
