package coe528.project.bankingApp;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.*;

public class manager extends user {

    private String username;
    private static manager admin = null;
    private BufferedReader reader;
    private BufferedWriter writer;
    static File file;

    public manager() {
    }


    @Override
    public void userLogout(ActionEvent event) throws IOException {
        super.userLogout(event);
    }

    public manager(String username){
        this.username = username;
        manager.getInstance();

    }

    public static manager getInstance(){
        if(admin == null){
            admin = new manager();
            file = new File("/home/parthshreyashpatel/IdeaProjects/bankingApp/src/coe528/project/bankingApp/Accounts/admin.txt");
        }
        return admin;
    }



    public void createCustomer(String userID, String psw, String firstDeposit) throws IOException {
        Alert alert;
        if(Double.parseDouble(firstDeposit)>=100) {
            File newCustomer = new File("/home/parthshreyashpatel/IdeaProjects/bankingApp/src/coe528/project/bankingApp/Accounts/" + userID + ".txt");
            if(!newCustomer.exists()) {
                writer = new BufferedWriter(new FileWriter("/home/parthshreyashpatel/IdeaProjects/bankingApp/src/coe528/project/bankingApp/Accounts/" + userID + ".txt"));
                writer.write(psw);
                writer.newLine();
                writer.write("customer");
                writer.newLine();
                writer.write(firstDeposit);
                writer.flush();
            }else{
                alert = new Alert(Alert.AlertType.ERROR, "Username already exists,\nchoose another one");
                alert.show();
            }
        }else{
            alert = new Alert(Alert.AlertType.ERROR, "First Deposit must be ATLEAST $100");
            alert.show();
        }

    }

    public void deleteCustomer(String deletePlease){
        File file = new File("/home/parthshreyashpatel/IdeaProjects/bankingApp/src/coe528/project/bankingApp/Accounts/"+deletePlease);
        file.delete();
    }


}
