/**
 * @author ParthShreyashPatel - 500522466
 * @Overview: maintains the account of the user. Sets account balance, handles transactions, updates account Tier
 */
package coe528.project.bankingApp;

import javafx.event.ActionEvent;

import java.io.*;


public class customerAccount extends user {
    private String userID;
    private double balance = 0.00;
    private Tier currentTier;
    private BufferedWriter writer;
    private BufferedReader reader;
    private String str = "";

    /**
     * sets accounts reader and writer.
     * reader is used to add all transactions to obtain the account balance.
     * writer is used to append new transactions to maintain account balance, once user signs back in.
     * @param  user of type String, used to get user's file
     * @throws IOException
     */
    customerAccount(String user) throws IOException {
        this.userID = user;
        reader = new BufferedReader( new FileReader("/home/parthshreyashpatel/IdeaProjects/bankingApp/src/coe528/project/bankingApp/Accounts/"+this.userID+".txt"));
        writer = new BufferedWriter (new FileWriter("/home/parthshreyashpatel/IdeaProjects/bankingApp/src/coe528/project/bankingApp/Accounts/"+this.userID+".txt", true));
        this.setBalance();
        this.setTier();

    }

    /**
     * Uses user's file to set the current account balance.
     * @throws IOException
     */
    public void setBalance() throws IOException {
        reader.readLine();
        reader.readLine();
        while((str = reader.readLine()) != null){
        balance = balance + Double.parseDouble(str);
        }
    }

    /**
     * Returns account balance.
     * @return current balance of customer(user)
     */
    public double getBalance(){
        return balance;
    }

    /**
     * adds deposit to balance, and readjusts balance and sets account Tier
     * @param depositAmount used to adjust account balance
     * @throws IOException
     */
    public void deposit(double depositAmount) throws IOException {
        writer.newLine();
        writer.write(String.valueOf(depositAmount));
        writer.flush();
        balance = balance + depositAmount;
        setTier();
    }

    /**
     * subtracts withdrawal amount from balance, and sets balance and account Tier
     * @param withdrawalAmount used to adjust account balance
     * @throws IOException
     */
    public void withdraw(double withdrawalAmount) throws IOException {
        writer.newLine();
        writer.write("-"+ String.valueOf(withdrawalAmount));
        writer.flush();
        balance = balance - withdrawalAmount;
        setTier();

    }

    /**
     * Subtracts purchase amount, and charges due to account Tier. Sets Tier after purchase
     * @param purchaseAmount
     * @throws IOException
     */
    public void makePurchase(double purchaseAmount) throws IOException {
        writer.newLine();
        writer.write("-"+ String.valueOf(currentTier.getCharge()+purchaseAmount));
        writer.flush();
        balance = balance - currentTier.getCharge() - purchaseAmount;
        setTier();
    }

    /**
     * sets Tier for account. Adjusted as account balance changes.
     */
    public void setTier(){
        currentTier = Tier.setTier(this);
    }

    /**
     * Gets current Tier of the account
     * @return Tier
     */
    public Tier getTier(){
        setTier();
        return currentTier;
    }

    /**
     * Logs user out of account window, and returns to login page
     * @param event uses event to logout of account page
     * @throws IOException
     */
    @Override
    public void userLogout(ActionEvent event) throws IOException {
        reader.close();
        writer.flush();
        writer.close();
        super.userLogout(event);
    }
}
