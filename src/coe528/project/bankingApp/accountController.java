package coe528.project.bankingApp;

import javafx.event.ActionEvent;

import java.io.IOException;

public abstract class accountController {

    public static void setAccount(String username) throws IOException {
        if (!username.equalsIgnoreCase("admin")){
            customerAccountController.setAccount(username);
        }else{
            managerPageController.setAccount(username);
        }
    }

    public abstract void logout(ActionEvent event) throws IOException;

}
