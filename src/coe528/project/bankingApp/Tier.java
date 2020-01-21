package coe528.project.bankingApp;

public abstract class Tier {

    private double charge;
    private String tierTitle;
    static Tier newtier;

    static Tier setTier(customerAccount owner){
        if(owner.getBalance()< 10000){
            return newtier = new Silver();
        }else if(owner.getBalance()<20000){
            return newtier = new Gold();
        }else{
            return newtier= new Platinum();
        }
    }

    public abstract String  getTierTitle();
    public abstract double getCharge();
}
