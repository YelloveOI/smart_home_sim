package cz.cvut.fel.smarthome;

import com.google.gson.Gson;
import cz.cvut.fel.smarthome.model.actor.action.TurnOnAction;
import cz.cvut.fel.smarthome.model.actor.person.Person;
import cz.cvut.fel.smarthome.model.actor.person.PersonRoleType;
import cz.cvut.fel.smarthome.model.actor.pet.Pet;
import cz.cvut.fel.smarthome.model.auxiliary.Auxiliary;
import cz.cvut.fel.smarthome.model.auxiliary.AuxiliaryType;
import cz.cvut.fel.smarthome.model.device.ConsumptionType;
import cz.cvut.fel.smarthome.model.device.Device;
import cz.cvut.fel.smarthome.model.device.DeviceType;
import cz.cvut.fel.smarthome.simpleDI.DICompositionPoint;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import lombok.SneakyThrows;

public class SemOmo {
    @SneakyThrows
    public static void main(String[] args) {
        DICompositionPoint compositionPoint = new DICompositionPoint();
        ApplicationContext context = compositionPoint.run();



        Device device = new Device(
                "device_name",
                DeviceType.WINDOW_BLIND,
                10d,
                5d,
                ConsumptionType.WH
        );

        Person person = new Person("Vasua", PersonRoleType.FATHER);
        person.act(new TurnOnAction(device));

        Auxiliary auxiliary = new Auxiliary("123", AuxiliaryType.SPORT);

        Pet pet = new Pet("K'hel Tass");
        pet.act(new TurnOnAction(device));
        pet.act(new TurnOnAction(device));
        pet.act(new TurnOnAction(device));
        pet.act(new TurnOnAction(device));
        pet.act(new TurnOnAction(device));
        pet.act(new TurnOnAction(device));
        pet.act(new TurnOnAction(device));

        Gson gson = new Gson();
        String json = gson.toJson(person, Person.class);

        System.out.println(json);
//
//        Auxiliary newAux = gson.fromJson(json, Auxiliary.class);
//        newAux.setState(new AvailableAuxiliaryState(newAux));
//        newAux.startUse();
//
//        AuxiliaryRepository repo = new AuxiliaryRepositoryImpl();
    }
}
