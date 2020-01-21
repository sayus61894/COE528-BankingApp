package coe528.project.bankingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class loginVerify {
    private String username;
    private String password;
    private String role;
    private String firstLine;
    private String secondLine;

    public loginVerify(String userid, String pass, String role) throws IOException {
        this.password = pass;
        this.username = userid;
        this.role = role;
    }

    public boolean checkExistence() throws IOException {
        BufferedReader reader;
        File file = new File("/home/parthshreyashpatel/IdeaProjects/bankingApp/src/coe528/project/bankingApp/Accounts/"+username+".txt");
        if (!file.exists()) {
            return false;
        } else if (file.exists()) {
            reader = new BufferedReader(new FileReader("/home/parthshreyashpatel/IdeaProjects/bankingApp/src/coe528/project/bankingApp/Accounts/"+username+".txt"));
            firstLine = reader.readLine();
            secondLine = reader.readLine();
            reader.close();
            if (firstLine.equals(password) && secondLine.equalsIgnoreCase(role)) {
                return true;
            } else return false;
            } else {
                return false;
            }
    }

    public void successfullyLoggedIn(String usr, ActionEvent event) throws IOException {
        Stage loggedIn = new Stage();
        Parent root = null;
        if(secondLine.equalsIgnoreCase("customer")) {
            root = FXMLLoader.load(getClass().getResource("customerAccount.fxml"));
        }else if(secondLine.equalsIgnoreCase("manager")){
            root = FXMLLoader.load(getClass().getResource("managerPage.fxml"));
        }
        loggedIn.setTitle("Simple Bank: "+ usr.toUpperCase());
        loggedIn.setScene(new Scene(root));
        accountController.setAccount(this.username);
        loggedIn.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
