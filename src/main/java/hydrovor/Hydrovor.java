package hydrovor;

/**
 * Hydrovor provides water to Sink and gets water from Tank
 */
public class Hydrovor {

    private Tank tank;

    private int volume;

    private boolean on;

    public Hydrovor(Tank tank, int volume) {
        if (tank != null && volume >= 0) {
            this.tank = tank;
            this.volume = volume;
            this.on = false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    /**
     * Simulates water out flow.
     *
     * @return 1 when there is any water (volume) and decrements volume; 0
     * otherwise
     */
    public int getWater() {
        if (volume > 0) {
            volume = volume - 1;
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * When Hydrovor is on increments volume by value provided from Tank.
     */
    public void tick() {
        if (on == true) {
            int temp = tank.getWater();
            this.volume = this.volume + temp;
        }
    }
}
