package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.model.entities.alive.AbstractAlive;
import cz.cvut.fel.smarthome.model.entities.auxiliary.AbstractAuxiliary;
import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.model.entities.device.AbstractStorageDevice;
import cz.cvut.fel.smarthome.model.entities.device.AbstractUsableDevice;
import cz.cvut.fel.smarthome.model.repository.interfaces.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.io.File;
import java.io.FileWriter;
import java.util.stream.Collectors;

/**
 * Responsible to report writing
 * Writes report into file house.log and console
 */
public class Reporter {

    @Inject
    private AliveRepository aliveRepository;
    @Inject
    private UsableDeviceRepository usableDeviceRepository;
    @Inject
    private SimpleDeviceRepository simpleDeviceRepository;
    @Inject
    private StorageDeviceRepository storageDeviceRepository;
    @Inject
    private AuxiliaryRepository auxiliaryRepository;
    @Inject
    private HouseRepository houseRepository;

    public void report(String report) {
        try {
            FileWriter fw = new FileWriter(new File("house.log"), true);
            fw.write(report + "\n");
            fw.flush();
        } catch (Exception ex) {
            System.out.println("cant reach file to log");
        }

        System.out.println(report);
    }

    public void aliveReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t> ALIVE REPORT\n--------------------------------\n");
        for(String s : aliveRepository.findAll().stream().map(AbstractAlive::toString).collect(Collectors.toSet())) {
            sb.append(s);
        }
        report(sb.toString());
    }

    public void deviceReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t> DEVICE REPORT\n");
        for(String s : usableDeviceRepository.findAll().stream().map(AbstractUsableDevice::toString).collect(Collectors.toSet())) {
            sb.append("--------------------------------\n");
            sb.append(s);
        }
        for(String s : simpleDeviceRepository.findAll().stream().map(AbstractSimpleDevice::toString).collect(Collectors.toSet())) {
            sb.append("--------------------------------\n");
            sb.append(s);
        }
        for(String s : storageDeviceRepository.findAll().stream().map(AbstractStorageDevice::toString).collect(Collectors.toSet())) {
            sb.append("--------------------------------\n");
            sb.append(s);
        }
        sb.append("\n\n");
        report(sb.toString());
    }

    public void auxiliaryReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t>AUXILIARY REPORT\n");
        for(String s : auxiliaryRepository.findAll().stream().map(AbstractAuxiliary::toString).collect(Collectors.toSet())) {
            sb.append("--------------------------------\n");
            sb.append(s);
        }
        report(sb.toString());
    }

    public void houseReport() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("\t\t> HOUSE REPORT\n--------------------------------\n")
                .append(houseRepository.find("SMART_HOME").get())
                .append("\n--------------------------------\n");
        report(sb.toString());
    }

}
