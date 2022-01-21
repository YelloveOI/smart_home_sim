package cz.cvut.fel.smarthome.model.interfaces;

public interface IActive {

    void becomeBusy(IUseable useable);

    void getFree();

    Boolean isFree();

}
