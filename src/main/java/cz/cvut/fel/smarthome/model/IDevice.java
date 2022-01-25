package cz.cvut.fel.smarthome.model;

import cz.cvut.fel.smarthome.model.entities.Command;
import cz.cvut.fel.smarthome.model.entities.basic.interfaces.IConsumer;

public interface IDevice extends IConsumer {

    void command(Command command);

    String getInfo();

}
