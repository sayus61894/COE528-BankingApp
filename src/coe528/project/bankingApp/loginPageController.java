package coe528.project.bankingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;


public class loginPageController {

    public loginPageController(){}
    @FXML
    private TextField userIdField;

    @FXML
    private PasswordField pswField;

    @FXML
    private Label statusLabel;

    @FXML
    private Button loginButton;

    @FXML
    private TextField roleField;

    public void login(ActionEvent event) throws IOException {
        loginVerify log = new loginVerify(userIdField.getText(), pswField.getText(), roleField.getText());
        if (!log.checkExistence()) {
            statusLabel.setText("customerAccount not in bank. See manager to create");
        }else{
            statusLabel.setText("logged in successfully");
            log.successfullyLoggedIn(userIdField.getText(), event);
        }

    }



}
