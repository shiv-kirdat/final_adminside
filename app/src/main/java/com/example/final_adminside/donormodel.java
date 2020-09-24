package com.example.final_adminside;

public class donormodel {

    String name2, amount, emil2, msg2;

    public donormodel(){

    }

    public donormodel(String donor_name, String amount) {
        this.name2 = donor_name;
        this.amount = amount;


    }

    public String getDonor_name() {
        return name2;
    }

    public void setDonor_name(String donor_name) {
        this.name2 = donor_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
