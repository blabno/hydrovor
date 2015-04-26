package hydrovor;

public class Pump {

    private Tank tank;
    private Well well;
    private boolean isOn;

    public Pump(Tank tank, Well well){
        if(tank == null || well == null)
            throw new IllegalArgumentException();
        this.tank = tank;
        this.well = well;
    }

    public void on(){
        isOn = true;
    }
    
    public void off(){
        isOn = false;
    }

    /**
     * Takes 1 unit of water from well and tries to push it to tank.
     * <p/>
     * In case tank is not able to accept whole volume of water the remaining volume must be returned to well.
     */
    
    public void tick(){
        if(isOn){
            int waterFromWell = well.getWater(1);
            int addedWater = tank.addWater(waterFromWell);
            if(addedWater != waterFromWell) 
    		well.addWater(waterFromWell - addedWater); 
    	}
    }
}
