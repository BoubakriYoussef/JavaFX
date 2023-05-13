package com.example.youssefboubakri;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller1 {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogin(ActionEvent event) throws IOException {
        MainApp mainApp = new MainApp();
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            System.out.println("Success !");
            mainApp.changeScene("Scene2.fxml");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Authentication Error");
            alert.setHeaderText("Wrong username or password !");
            alert.setContentText("You can retry again !");
            alert.show();
        }
    }
}
