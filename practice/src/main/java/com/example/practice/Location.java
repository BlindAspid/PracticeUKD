package com.example.practice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.File;

public class Location {
    @FXML
    public ObservableList<File> getLocation(String folderLocation){
    File carpeta = new File(folderLocation);
    File[] listt = carpeta.listFiles();
    ObservableList<File> ol = FXCollections.observableArrayList(listt);
        if (listt == null || listt.length == 0) {
        System.out.println("Folder is empty");
    }

        return ol;
    }
    @FXML
    public File getFile(Integer indx,String folderLocation){
        File file = new File(getLocation(folderLocation).get(indx).getName());
        return file;
    }
}
