package cz.cvut.fel.smarthome.model.entities.device;

public class BiStateDevice extends DeviceOLD {

    private Boolean state;
    private final String trueStateDesc;
    private final String falseStateDesc;

    public BiStateDevice(
            String name,
            Double activeConsumption,
            String preferredLocation,
            String trueStateDesc,
            String falseStateDesc
    ) {
        super(name, activeConsumption, preferredLocation);
        this.trueStateDesc = trueStateDesc;
        this.falseStateDesc = falseStateDesc;
        this.state = false;
    }

    void setTrue() {
        if(isActive()) {
            state = true;
        }
    }

    void setFalse() {
        if(isActive()) {
            state = false;
        }
    }

    public Boolean getState() {
        return state;
    }

    public String getTrueStateDesc() {
        return trueStateDesc;
    }

    public String getFalseStateDesc() {
        return falseStateDesc;
    }

}
