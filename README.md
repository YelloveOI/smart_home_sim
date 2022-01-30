# cz.cvut.fel.smarthome.SemOmo

- Ivan Shalaev, Oleksii Afanasiev

- Všechny diagramy jsou ve složce "diagrams"

- Počet iterací určuje parametr funkce simulator.start(PARAMETR)

- Aby se spustila druhá konfigurace změňte configurator.config2("SMART_HOME") na configurator.config1("SMART_HOME") v SemOmo.java

- Soubor s logami je house.log, potřebuje manuální vyklizení po každém spuštění

- Projekt je realizován ve styly MVC (také použitá myšlenka  jednosměrné N-tier architektury a-la Enterprise)
- ###Obecné vysvětlení: 
  - Hlavními součástí modelů jsou _entity_, ty dědí od abstraktní třídy AbstractEntity ve které je zapouzdřen parametrický ID
  - _Entity_ jsou složené z kombinací primitivních komponent: _Active_, _Consumer_, _Storage_, _Usable_
  - Každá z těchto komponent reprezentuje nějakou vlastnost _entity_
  - Repositáře a servisy příslušných _entit_ jsou odděleny a mezi sebou nekomunikují 
  - Interakce mezi _entitami_ se koná v Controller úrovni
- ### Vysvětlení modelu:
  - Každá konkrétní (neabstrakni) třída pouze rozšiřuje metody třídy od kterou dědí
  - **AbstractAlive** reprezentuje živý unit, API reprezentováno metodem _order()_, každá dědici ji třída přitížuje tento metod, compozice: _Active_
  - **AbstractAuxiliary** reprezentuje non-smart unit který může být použit, compozice: _Usable_
  - **AbstractSimpleDevice** reprezentuje smart spotřebič který můžeme řídit, API reprezentováno metodem _command()_, každá dědici ji třída přitížuje tento metod, compozice: _Consumer_
  - **AbstractStorageDevice** dědí od _AbstractSimpleDevice_ a reprezentuje device se schránkou, compozice: _Storage_
  - **AbstractUsableDevice** dědí od _AbstractSimpleDevice_ a reprezentuje device který může být použit, compozice: _Usable_
  - **Location** reprezentuje lokaci, agreguje _AbstractEntity_
  - **House** reprezentuje dům, agreguje _Location_ a je určena pro rozmístění entit a zapouzdření obecného stavu domů
- ###Vysvětlení kontroléru:
  - Basic kontroléry splní primitivní use-casy _entit_, ošetřuje výjimky příslušných servisů a hodí _Eventy_
  - **BusynessController** určuje na úrovni kontroléru je-li _entita_ obsazena
  - **EventController** dostává _Eventy_ a zpracuje
  - **ActivityController** je určen pro generaci náhodných aktivit
  - **SensorEventGenerator** je určen pro generaci náhodných událostí (respektivě zapíná triggery sensorů)
- View je představen třídou **Reporter** udělán více jako kontroller, zapisuje reporty do souboru a konzole
- **Configurator** a **Simulator** splňují příslušné názvům funkce

- ###Požadavky:
  - F1) chybí entita patro, okno je realizováno jako LocationType.EMBEDDED, kolo/lyze jako SportInventory, zvíře existuje, ale funkcionalita je prázdná
  - F2) AbstractSimpleDevice.command(Command command) reprezentuje API, devicy s obsahem reprezentovány jako AbstractStorageDevice (prakticky pro tento ty devicu neimplementovaná žádná interakce s jinými entitamy)
  - F3) AbstractSimpleDevice.consumer (viz. Consumer), implementovaná spotřeba jen v aktivním stavu, ve vypnutém stavu považuje se za 0
  - F4) implementováno pouze pomoci *entity*.toString() viz. Reporter
  - F5) implementováno jako jednotlivý metody v kontrolérech viz PersonController
  - F6) entita House je zodpovědná za rozmístění entit, logika zapouzdřena do LocationService/LocationControllera. Pouze sensory generují eventy viz. SensorEventGenerator
  - F7) viz. EventController (+ event channels)
  - F8) viz. Reporter
  - F9) nesplněno
  - F10) viz. ActivityController, krom toho osoby pouzivaji devicy

- ###Návrhové vzory:
  1. Object Pool: model.repository pro jednoduchost představen jako pool
  2. Dependency Injection: simpleDI
  3. Singleton, Prototype: implementovaný pomocí DI
  4. Bridge: model.basic z nichz jsou sestaveny entity
  5. Chain of Responsibility: controller.event_channel
  6. Data Access Object: model.repository 
  7. Architektura MVC
