package hydrovor;

/**
 * Well provides water to Tank and gets water from the spring.
 */
public class Well {

    private int volume;

    public Well(int volume)
    {
        if(volume < 0){
            throw new IllegalArgumentException();
        }
        this.volume = volume;
    }

    public void addWater(int volume)
    {
        if(volume < 0){
            throw new IllegalArgumentException();
        }
        this.volume += volume;
    }


    public int getWater(int desiredVolume)
    {
        if (desiredVolume < 0){
            throw new IllegalArgumentException();
        }
        if (desiredVolume <= volume){
            volume -= desiredVolume;
            return desiredVolume;
        }else{
            int ret = volume;
            volume = 0;
            return ret;
        }

    }
}
