package com.company;

public class Transaction
{
    private String type;
    private float amount;
    private float trans_bal;

    public Transaction(String type, float amount, float trans_bal) {
        this.type = type;
        this.amount = amount;
        this.trans_bal = trans_bal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTrans_bal() {
        return trans_bal;
    }

    public void setTrans_bal(float trans_bal) {
        this.trans_bal = trans_bal;
    }
}



//withdraw
//depo
//trans_amount

//balance after tans