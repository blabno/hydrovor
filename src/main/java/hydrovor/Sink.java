package hydrovor;

/**
 * Sink gets water from Hydrovor
 */
public class Sink {

    private Hydrovor hydrovor;

    public Sink(Hydrovor hydrovor) {
        if (hydrovor != null) {
            this.hydrovor = hydrovor;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Simulates water out flow.
     *
     * @return whatever hydrovor returns
     */
    public int getWater() {
        return hydrovor.getWater();
    }
}
