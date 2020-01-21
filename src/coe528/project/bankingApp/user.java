package coe528.project.bankingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class user {


    public void userLogout(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root =  FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        stage.setTitle("Simple Bank: Login Page");
        stage.setScene(new Scene(root));
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
