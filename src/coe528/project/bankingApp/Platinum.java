package coe528.project.bankingApp;

public class Platinum extends Tier {

    private String tierTitle ="Platinum";


    @Override
    public String getTierTitle() {
        return this.tierTitle;
    }

    @Override
    public double getCharge(){
        double charge = 0.00;
        return charge;
    }
}
