package cz.cvut.fel.smarthome.model.interfaces;

import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.device.Device;

public interface IActive {

    void goSport(Auxiliary sportAux);

    void goWork(Auxiliary workAux);

    void goProcrastinate(Device procrastinator);

    void getFreeFromActivity();

}
