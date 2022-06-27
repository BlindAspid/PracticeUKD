package com.example.practice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.*;

import java.io.File;

public class HelloController {
    @FXML
    public TextField folderLocationField;
    @FXML
    public ListView<String> listView;
    @FXML
    public TextField timeField;
    @FXML
    Location l = new Location();
    CheckFiles cf = new CheckFiles();
    public void setItems(ActionEvent event) {
        ObservableList<File> ol =l.getLocation(folderLocationField.getText());
        listView.setItems(FXCollections.observableArrayList(cf.check(ol, timeField.getText())));
        }

    public Label filesAmountField;
    @FXML
    public Label filesSizeField;
    @FXML
    public void showAmount(ActionEvent event) {
        Location l = new Location();
        ObservableList<File> ol =l.getLocation(folderLocationField.getText());
        int count=0;
        if (ol != null || ol.size() != 0) {
            for (File s : ol) {
                count++;
            }
        }
        filesAmountField.setText(String.valueOf(count));
    }
    public void showSize(ActionEvent event){
        Location l = new Location();
        ObservableList<File> ol =l.getLocation(folderLocationField.getText());

        if (ol == null || ol.size() == 0) {

        }else{
            long sum = 0;
            for (int i = 0; i< ol.size();i++) {
                File file = new File(ol.get(i).getName());
                long len =file.length();

                sum+=len;

                System.out.println(file.getName()+" Len "+len);
            }
            System.out.println(sum);
            filesSizeField.setText(sum+" Byte");
        }
    }
            public void deleteFromList(ActionEvent event) {
                Location l = new Location();
                final int selectedIdx = listView.getSelectionModel().getSelectedIndex();
                if (selectedIdx != -1) {
                    String itemToRemove = listView.getSelectionModel().getSelectedItem();

                    final int newSelectedIdx =
                            (selectedIdx == listView.getItems().size() - 1)
                                    ? selectedIdx - 1
                                    : selectedIdx;
                    l.getFile(selectedIdx, folderLocationField.getText()).delete();
                    listView.getItems().remove(selectedIdx);
                    listView.getSelectionModel().select(newSelectedIdx);
                    System.out.println("selectIdx: " + selectedIdx);
                    System.out.println("item: " + itemToRemove);
        }
    }
    public void setItemsEnter(KeyEvent e)
    {
        if(e.getCode().toString().equals("ENTER"))
        {
            ObservableList<File> ol =l.getLocation(folderLocationField.getText());
            listView.setItems(FXCollections.observableArrayList(cf.check(ol, timeField.getText())));
        }
        }
}