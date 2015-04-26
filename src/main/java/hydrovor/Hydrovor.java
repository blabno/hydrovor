package hydrovor;

/**
 * Hydrovor provides water to Sink and gets water from Tank
 */
public class Hydrovor {

    private Tank tank;

    private int volume;

    public Hydrovor(int volume){
        this.volume = volume;
    }

    public Hydrovor(Tank tank, int volume)
    {


    }

    public void on()
    {

    }

    public void off()
    {

    }

    /**
     * Simulates water out flow.
     *
     * @return 1 when there is any water (volume) and decrements volume; 0 otherwise
     */
    public int getWater(int decrement_volume)
    {
        if (volume > 0) {
            volume = volume - decrement_volume;
            return 1;


        }

            else
            return 0;
    }

    /**
     * When Hydrovor is on increments volume by value provided from Tank.
     */
    public void tick()
    {

    }
}
