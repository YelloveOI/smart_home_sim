package cz.cvut.fel.smarthome.controller;

import java.io.File;
import java.io.FileWriter;

public class ReportController {

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

}
