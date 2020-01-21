package coe528.project.bankingApp;

public class Gold extends Tier {

    private String tierTitle = "Gold";


    @Override
    public String getTierTitle() {
        return this.tierTitle;
    }

    @Override
    public double getCharge(){
        double charge = 10.00;
        return charge;
    }
}
