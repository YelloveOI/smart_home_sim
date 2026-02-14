cz.cvut.fel.smarthome.SemOmo

-   Ivan Shalaev

-   All diagrams are located in the “diagrams” folder

-   The number of iterations is determined by the function parameter
    simulator.start(PARAMETER)

-   To run the second configuration, change
    configurator.config2(“SMART_HOME”) to
    configurator.config1(“SMART_HOME”) in SemOmo.java

-   The log file is house.log; it requires manual cleanup after each run

-   The project is implemented in the MVC style (also applying the idea
    of a one-directional N-tier architecture a-la Enterprise)

General Explanation

-   The main components of the models are entities, which inherit from
    the abstract class AbstractEntity where a parameterized ID is
    encapsulated
-   Entities are composed of combinations of primitive components:
    Active, Consumer, Storage, Usable
-   Each of these components represents a specific property of an entity
-   Repositories and services of the respective entities are separated
    and do not communicate with each other
-   Interactions between entities take place at the Controller level

Model Explanation:

-   Each concrete (non-abstract) class only extends the methods of the
    class it inherits from
-   AbstractAlive represents a living unit, API represented by the
    method order(); each inheriting class extends this method;
    composition: Active
-   AbstractAuxiliary represents a non-smart unit that can be used;
    composition: Usable
-   AbstractSimpleDevice represents a smart appliance that can be
    controlled; API represented by the method command(); each inheriting
    class extends this method; composition: Consumer
-   AbstractStorageDevice inherits from AbstractSimpleDevice and
    represents a device with storage; composition: Storage
-   AbstractUsableDevice inherits from AbstractSimpleDevice and
    represents a device that can be used; composition: Usable
-   Location represents a location; aggregates AbstractEntity
-   House represents a house; aggregates Location and is responsible for
    distributing entities and encapsulating the general state of the
    house

Controller Explanation:

-   Basic controllers fulfill primitive use cases of entities, handle
    exceptions of the respective services, and throw Events
-   BusynessController determines at the controller level whether an
    entity is occupied
-   EventController receives and processes Events
-   ActivityController is responsible for generating random activities
-   SensorEventGenerator is responsible for generating random events
    (specifically triggering sensors)
-   View is represented by the Reporter class, implemented more like a
    controller; it writes reports to a file and to the console
-   Configurator and Simulator fulfill the functions corresponding to
    their names

Requirements:

-   F1) missing entity floor; window is implemented as
    LocationType.EMBEDDED; bike/skis as SportInventory; animal exists
    but functionality is empty
-   F2) AbstractSimpleDevice.command(Command command) represents the
    API; devices with content are represented as AbstractStorageDevice
    (in practice, no interaction with other entities implemented for
    this device type)
-   F3) AbstractSimpleDevice.consumer (see Consumer); consumption
    implemented only in active state; in switched-off state considered 0
-   F4) implemented only using entity.toString(), see Reporter
-   F5) implemented as individual methods in controllers, see
    PersonController
-   F6) entity House is responsible for distributing entities; logic
    encapsulated in LocationService/LocationController; only sensors
    generate events, see SensorEventGenerator
-   F7) see EventController (+ event channels)
-   F8) see Reporter
-   F9) not implemented
-   F10) see ActivityController; additionally, persons use devices

Design Patterns:

1.  Object Pool: model.repository presented as a pool for simplicity
2.  Dependency Injection: simpleDI
3.  Singleton, Prototype: implemented using DI
4.  Bridge: model.basic from which entities are composed
5.  Chain of Responsibility: controller.event_channel
6.  Data Access Object: model.repository
7.  MVC Architecture
