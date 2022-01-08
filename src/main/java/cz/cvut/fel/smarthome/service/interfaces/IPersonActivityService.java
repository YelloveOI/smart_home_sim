package cz.cvut.fel.smarthome.service.interfaces;

public interface IPersonActivityService {

    void goWork(String personID);

    void goSport(String personID);

    void processEvents(String personID);

}
