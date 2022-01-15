package cz.cvut.fel.smarthome;

import com.google.gson.Gson;
import cz.cvut.fel.smarthome.model.location.House;
import cz.cvut.fel.smarthome.model.location.HouseBuilder;
import cz.cvut.fel.smarthome.simpleDI.DICompositionPoint;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import lombok.SneakyThrows;

public class SemOmo {
    @SneakyThrows
    public static void main(String[] args) {
        DICompositionPoint compositionPoint = new DICompositionPoint();
        ApplicationContext context = compositionPoint.run();


        Gson gson = new Gson();

        HouseBuilder hb = new HouseBuilder("HOUSE1");
        House house = hb
                .addGarage("GARAGE1", 0, 2)
                .addRoom("ROOM1", 0)
                .addRoom("ROOM2", 0)
                .addRoom("ROOM3", 0)
                .addRoom("ROOM4", 1)
                .addRoom("ROOM5", 1)
                .addEmbedded("EMB1", "ROOM1")
                .addEmbedded("EMB2", "ROOM2")
                .build();

        System.out.println(gson.toJson(house, House.class));

    }
}
