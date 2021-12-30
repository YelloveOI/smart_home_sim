package cz.cvut.fel.smarthome;

import com.google.gson.Gson;
import cz.cvut.fel.smarthome.model.Home;
import cz.cvut.fel.smarthome.simpleDI.DICompositionPoint;
import cz.cvut.fel.smarthome.simpleDI.context.ApplicationContext;
import cz.cvut.fel.smarthome.test.Base;
import lombok.SneakyThrows;

import java.io.File;

public class SemOmo {
    @SneakyThrows
    public static void main(String[] args) {
        DICompositionPoint compositionPoint = new DICompositionPoint();
        ApplicationContext context = compositionPoint.run();

        Base base = context.getBean(Base.class);
        base.foo();

        Gson g = new Gson();
        Home h = g.fromJson(
                "{\n" +
                        "  \"name\": \"Smart Home 1\",\n" +
                        "  \"floors\": [\n" +
                        "    {\n" +
                        "      \"name\": \"1st\",\n" +
                        "      \"places\": [\n" +
                        "        {\"name\": \"room1\"},\n" +
                        "        {\"name\": \"room2\"},\n" +
                        "        {\"name\": \"room3\"}\n" +
                        "      ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"name\": \"2nd\",\n" +
                        "      \"places\": [\n" +
                        "        {\"name\": \"room4\"},\n" +
                        "        {\"name\": \"room5\"}\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"address\": {\n" +
                        "    \"country\": \"Czech Republic\",\n" +
                        "    \"city\": \"city\",\n" +
                        "    \"street\": \"Omackova\",\n" +
                        "    \"buildingNumber\": \"13/37\"\n" +
                        "  }\n" +
                        "}",
                Home.class
        );

        System.out.println(h.getAddress());

    }
}
