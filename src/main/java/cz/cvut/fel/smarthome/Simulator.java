package cz.cvut.fel.smarthome;

import cz.cvut.fel.smarthome.model.entities.Order;
import cz.cvut.fel.smarthome.model.entities.alive.AbstractAlive;
import cz.cvut.fel.smarthome.model.entities.alive.Person;
import cz.cvut.fel.smarthome.model.entities.alive.Pet;
import cz.cvut.fel.smarthome.model.entities.device.AbstractSimpleDevice;
import cz.cvut.fel.smarthome.model.repository.interfaces.*;
import cz.cvut.fel.smarthome.simpleDI.annotation.Inject;

import java.util.*;

public class Simulator {

    @Inject
    private AliveRepository aliveRepository;
    @Inject
    private HouseRepository houseRepository;
    @Inject
    private SimpleDeviceRepository simpleDeviceRepository;
    @Inject
    private StorageDeviceRepository storageDeviceRepository;
    @Inject
    private UsableDeviceRepository usableDeviceRepository;
    @Inject
    private AuxiliaryRepository auxiliaryRepository;

    private List<Person> busyPeople = new LinkedList<>();

    public void simulate(int numberOfIterations){
        for(Person p :busyPeople){
            //iterate the timer and make free
        }
        if(numberOfIterations >0) {
            Random rand = new Random();
            int number = rand.nextInt(11);
            //0 - do nothing
            //1-3 - person does something
            //4-5 - pet does something
            //6-10 - device generates activity
            if(number == 0){
                System.out.println("Nothing happened.");
            } else if (number >= 1 && number <= 3) {
                personGenerateActivity();
            } else if (number >= 4 && number <= 5) {
                petGenerateActivity();
            } else if (number >= 6) {
                deviceGenerateActivity();
            }
            simulate(numberOfIterations - 1);
        }
        else{
            System.out.println("Simulation complete");
        }
    }
    private void personGenerateActivity(){
        Random rand = new Random();
        Collection<AbstractAlive> alive = aliveRepository.findAll();
        List<Person> people = new ArrayList<>();
        for(AbstractAlive p : alive){
            if(p.getClass() == Person.class && !busyPeople.contains(p)){
                people.add((Person) p); //get all free people
            }
        }
        int number = rand.nextInt(people.size());
        Person person = people.get(number);
        number = rand.nextInt(3);
        if(number == 0){
            person.order(Order.O_WORK);
        }
        else if(number == 1){
            person.order(Order.O_SPORT);
        }
        else if(number == 2){
            person.order(Order.O_PROCRASTINATE);
        }
        busyPeople.add(person);
        aliveRepository.update(person); //update in repo don't know if works
    }
    private void petGenerateActivity(){
        Random rand = new Random();
        Collection<AbstractAlive> alive = aliveRepository.findAll();
        List<Pet> pets = new ArrayList<>();
        for(AbstractAlive p : alive){
            if(p.getClass() == Pet.class){
                pets.add((Pet) p); //get all pets from alive repo
            }
        }
        int number = rand.nextInt(pets.size());
        Pet pet = pets.get(number);
        //pet.order() to do whatever pets do
    }
    private void deviceGenerateActivity(){
        Random rand = new Random();
        List<AbstractSimpleDevice> devices = simpleDeviceRepository.findAll().stream().toList();
        int number = rand.nextInt(devices.size());
        AbstractSimpleDevice device = devices.get(number);
        //device.command() whatever devices do
    }
}
