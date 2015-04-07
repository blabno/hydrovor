package hydrovor;

/**
 * Well provides water to Tank and gets water from the spring.
 */
public class Well {

    private int volume;

    public Well(int volume){
        if(volume < 0)
             throw new IllegalArgumentException();
    	this.volume = volume;
    }

    /**
     * Simulates in flow from the spring.
     *
     * @param volume amount of water that flows in
     */
    public void addWater(int volume){
        if(volume < 0)
            throw new IllegalArgumentException();
        this.volume += volume;
    }

    /**
     * Simulates water out flow.
     * <p/>
     * Does not allow to take out more water than current volume.
     *
     * @param desiredVolume amount of water to take out
     *
     * @return actual amount of water that is going out
     */
    public int getWater(int desiredVolume)
    {
        if(desiredVolume < 0)
            throw new IllegalArgumentException();
        if(desiredVolume > volume){
            int receivedVolume = volume;
            volume = 0;
            return receivedVolume; 
        }
        else{
            volume -= desiredVolume;
            return desiredVolume;
        }
    }
}
