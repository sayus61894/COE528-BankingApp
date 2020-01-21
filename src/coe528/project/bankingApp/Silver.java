package coe528.project.bankingApp;

public class Silver extends Tier {

    private String tierTitle = "Silver";


    @Override
    public String getTierTitle() {
        return this.tierTitle;
    }

    @Override
    public double getCharge(){
        double charge = 20.00;
        return charge;
    }
}
