package com.example.practice;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class CheckFiles {
    @FXML
    Location l = new Location();
    public String[] check(ObservableList<File> ol, String timeField) {
        String[] strings = new String[ol.size()];
        for (int i = 0; i < ol.size(); i++) {
            long lastModified = TimeUnit.MILLISECONDS.toDays(ol.get(i).lastModified());
            long currentDay = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis());
            if (!timeField.equals("")) {
                int day = Integer.parseInt(timeField);
                if (currentDay - lastModified >= day) {
                    System.out.println(currentDay - lastModified);
                    strings[i] = ol.get(i).getName();
                }
            } else if (timeField.equals("")) {
                if (currentDay - lastModified >= 14) {
                    System.out.println(currentDay - lastModified);
                    strings[i] = ol.get(i).getName();
                }
            }
        }
    return strings;
    }
}
