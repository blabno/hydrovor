package hydrovor;

public class Pump {

    private Tank tank;

    private Well well;
    private boolean on;

    public Pump(Tank tank, Well well)
    {
        if(tank == null || well == null){
            throw new IllegalArgumentException();
        }
        this.tank = tank;
        this.well = well;
        on=false;
    }

    public void on()
    {
        on=true;
    }

    public void off()
    {
        on=false;
    }

    /**
     * Takes 1 unit of water from well and tries to push it to tank.
     * <p/>
     * In case tank is not able to accept whole volume of water the remaining volume must be returned to well.
     */
    public void tick()
    {
        if(on) {
            int wellWater = well.getWater(1);
             int tankWater = tank.addWater( wellWater);
            if (tankWater !=  wellWater) {
                 well.addWater( wellWater - tankWater);
                 }
            }
    }
}
