# cz.cvut.fel.smarthome.SemOmo

- Všechny diagramy jsou ve složce "diagrams"

- Ivan Shalaev

- Jsou několik typu chování a jejich kombinování (spolu s přidáním dat) tvoří entity - Person, Pět, Děvice, Auxiliary, Sensor. Varianty "chování" jsou
1. Active: umožňuje entitě mít aktivity typu práce, sport a prokrastinace. Liší se pouzivannym předmětem, práce - auto, sport - kolo/lyze prokrastinace - děvice a také následujícím rozmístěním - sport a práce entita jde ven, prokrastinace je domů.

2. Actor: umožňuje entitě provádět akce. Ty momentálně působí na cíl akcí. V projektu k dispozici 3 akce zapnout/vypnout děvice a poškodit děvice.

3. Useable: umožňuje používat entitu entitami Aktive. Blokuje entitu na dobu používání.

4. Každá entita má unikátní ID (String name), stav a je rozmístěna lokátorem . Entita koná podle svého skutečného stavu. Stav se mění ovlivem jiných entit nebo simulovanými činnostmi.

5. Každá entita posílá Event v případě změny svého stavu nebo když provádí činnosti s jinými entitami. Eventy jsou vyšetřeny postupně několika Event Processorami

Person: Aktive, Actor
Pět: Actor
Auxiliary(kolo, auto, lyže): Useable
Děvice: Useable (také Control a Data, ty jsou rozhraní správy a týkají se jen Děvice)

Entity jsou uloženy do JSON souboru a přístupné přes Repository. Také je přidán jednoduchý Dependency Injection Container.

Návrhové vzory:
1. Státe: stavy entit
2. Dependency Injection: simpleDI
3. Decorator: model.location.Location
4. Singleton: implementovaný pomocí DI @Inject(scope=Singleton)
5. Visitor: Actor-Action
6. Chain of Responsibility: model.event.event_channel.EventChannel
7. Data Access Object: repository 
8. Architektura MVC

Projekt není plně implementován ale tuším, že architektura bude vhodná na realizaci nových features. Například, je jasné jak postupovat na ošetření eventu "vhodnými" entitami: pomocí Chain of Responsibility + Event Channel dekorovaný event (který má množinu Action navíc) se pošle do vhodnou instancí a tam bude ošetřen buď Actorem nebo Systémem (univerzální Actor). Je jednoduché přidat jiné chybějící servicy díky DI kontejneru.
