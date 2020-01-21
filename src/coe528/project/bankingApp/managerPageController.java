package coe528.project.bankingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

public class managerPageController extends accountController{

    @FXML
    Button newCustomerButton;
    @FXML
    Button deleteAccountButton;
    @FXML
    TextField newUserIDField;
    @FXML
    TextField newPassField;
    @FXML
    TextField startingBalanceField;
    @FXML
    ListView currentAccounts;
    @FXML
    Button logoutButton;

    static manager admin;

    public static void setAccount(String username){
        admin = new manager(username);
    }

    public void deleteAccount(){
        File deletable = new File((String)(currentAccounts.getSelectionModel().getSelectedItem()));
        if(deletable.getName().equals("admin.txt")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Cannot Delete Yourself!");
            alert.show();
        }else {
            admin.deleteCustomer(deletable.getName());
        }
    }

    @FXML
    private void fillList(){
        Alert beware = new Alert(Alert.AlertType.ERROR, "Clicking any item will delete the account \nonce the app is closed.");
        beware.show();
        File folder = new File("/home/parthshreyashpatel/IdeaProjects/bankingApp/src/coe528/project/bankingApp/Accounts");
        File[] fileAccounts = folder.listFiles();
        for(File file: fileAccounts){
            currentAccounts.getItems().add(file.getName());
        }

    }

    public void createCustomer() throws IOException {
        Alert newName;
        if(newUserIDField.getText().equalsIgnoreCase("admin")){
            newName= new Alert(Alert.AlertType.ERROR, "Cannot be named admin");
            newName.show();
        }
        else {
            if(newUserIDField.getText().isEmpty()||newPassField.getText().isEmpty()){
                newName = new Alert(Alert.AlertType.ERROR, "Cannot continue with empty fields");
                newName.show();
            }
            admin.createCustomer(newUserIDField.getText(), newPassField.getText(), startingBalanceField.getText());
        }
    }

    public void logout(ActionEvent event) throws IOException {
        admin.userLogout(event);
    }
}
