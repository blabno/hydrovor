package hydrovor;

/**
 * Sink gets water from Hydrovor
 */
public class Sink {

    private Hydrovor hydrovor;

    public Sink(Hydrovor hydrovor)
    {
        if(hydrovor == null){
            throw new IllegalArgumentException();
        }else{
            this.hydrovor = hydrovor;
        }
    }

    /**
     * Simulates water out flow.
     *
     * @return whatever hydrovor returns
     */
    public int getWater()
    {
        return 0;
        return hydrovor.getWater();
    }
}
