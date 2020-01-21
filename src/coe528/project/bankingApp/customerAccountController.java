package coe528.project.bankingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.DecimalFormat;

public class customerAccountController extends accountController {

    static customerAccount user;
    DecimalFormat df = new DecimalFormat("0.00");
    double needIt;
    Alert alert;

    @FXML
    Button depositButton;
    @FXML
    Button withdrawButton;
    @FXML
    Button purchaseButton;
    @FXML
    Button logoutButton;
    @FXML
    TextField amountText;
    @FXML
    Label currentBalanceWindow;
    @FXML
    Text tierText;

    public static void setAccount(String username) throws IOException {
        user = new customerAccount(username);
    }

    @Override
    public void logout(ActionEvent event) throws IOException {
        user.userLogout(event);
    }

    @FXML
    public void makeDeposit() throws IOException {
        try {
            if (amountText.getText() != null) {
                needIt = Double.parseDouble(amountText.getText());
                if (needIt > 0) {
                    user.deposit(needIt);
                    currentBalanceWindow.setText("$" + df.format(user.getBalance()));
                    update();
                }else{
                    alert = new Alert(Alert.AlertType.ERROR, "Cannot make negative deposit");
                    alert.show();
                }
            }
        }catch (Exception e){
            emptyField();
        }

    }

    @FXML
    public void makeWithdrawal() throws IOException {
        try {
            if (amountText.getText() != null) {
                checkBalance();
                needIt = Double.parseDouble(amountText.getText());
                if(needIt > 0 && !checkBalance()) {
                    user.withdraw(needIt);
                    currentBalanceWindow.setText("$" + df.format(user.getBalance()));
                    update();
                }else{
                    if(checkBalance()){
                        alert = new Alert(Alert.AlertType.ERROR, "You Owe Too Much");
                        alert.show();
                    }else {
                        alert = new Alert(Alert.AlertType.ERROR, "Cannot make negative Withdrawal");
                        alert.show();
                    }
                }
            }
        }catch (Exception e){
            emptyField();
        }
    }

    @FXML
    public void makePurchase() throws IOException {
        try {
            if (amountText.getText() != null) {
                needIt = Double.parseDouble(amountText.getText());
                if (needIt >= 50.00 && !checkBalance()) {
                    user.makePurchase(needIt);
                    currentBalanceWindow.setText("$" + df.format(user.getBalance()));
                    update();
                } else {
                    if(checkBalance()){
                        alert = new Alert(Alert.AlertType.ERROR, "You Owe Too Much Money");
                        alert.show();
                    }else {
                        alert = new Alert(Alert.AlertType.ERROR, "Purchase must be ATLEAST $50.");
                        alert.show();
                    }
                }
            }
        }catch (Exception e){
            emptyField();
        }
    }

    @FXML
    public void update() {
        currentBalanceWindow.setText("$"+ df.format(user.getBalance()));
        tierText.setText(user.getTier().getTierTitle());
    }

    public void emptyField(){
        alert = new Alert(Alert.AlertType.ERROR, "Need to enter an amount");
        alert.show();
    }

    public boolean checkBalance(){
        if(user.getBalance() < -1000){
            return true;
        }else{
            return false;
        }
    }
}
