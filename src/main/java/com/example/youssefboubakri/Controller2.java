package com.example.youssefboubakri;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Controller2 {
    @FXML
    private TextField id, name, hoursWork;
    @FXML
    private ComboBox type;
    @FXML
    private ListView<String> listView;

    @FXML
    protected void onSubmit() throws IOException {
        String ID = id.getText();
        String Name = name.getText();
        Float Hours = Float.parseFloat(hoursWork.getText());

        writeRead test = new writeRead(new File("testObject.txt"));
        if (type.getValue().equals("Senior")){
            ManagerSenior managerSenior = new ManagerSenior(ID, Name, Hours);
            listView.getItems().add("ID : "+ID +" Name : "+ Name +" Hours : "+ Hours.toString()+" Cout : "+ managerSenior.calculerCout());
            test.write(managerSenior);
        }else {
            ManagerJunior managerJunior = new ManagerJunior(ID, Name, Hours);
            listView.getItems().add("ID : "+ID +" Name : "+ Name +" Hours : "+ Hours.toString()+" Cout : "+ managerJunior.calculerCout());
            test.write(managerJunior);
        }
    }

    @FXML
    protected void onRecap() throws IOException {
        writeRead test = new writeRead(new File("testObject.txt"));
        Set<Manager> ms = new HashSet<Manager>();
        ms = test.Read();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Data Stored");
        alert.setHeaderText("Recap !");
        String S = "";
        for (Manager elmnt : ms){
            S += "ID : "+elmnt.ID+"Name : "+elmnt.name+" Hours: "+elmnt.Hours+" Cost : "+ elmnt.calculerCout()+"\n";
            alert.setContentText(S);
        }
        alert.show();
    }

    @FXML
    protected void onCout() throws IOException {
        String ID = id.getText();
        String Name = name.getText();
        String Type = (String) type.getValue();
        Float Hours = Float.parseFloat(hoursWork.getText());

        if (Type.equals("Senior")){
            ManagerSenior mSenior = new ManagerSenior(ID, Name, Hours);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cout du manager "+mSenior.name);
            alert.setHeaderText("Calcul du cout");
            alert.setContentText(String.valueOf(mSenior.calculerCout()));
            alert.show();
        }else {
            ManagerJunior mJunior = new ManagerJunior(ID, Name, Hours);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cout du manager "+mJunior.name);
            alert.setHeaderText("Calcul du cout");
            alert.setContentText(String.valueOf(mJunior.calculerCout()));
            alert.show();
        }
    }
}