package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountAtm
{
    private String customername;
    private long accountnumber;
    private float balance;
    private int pin;
    private List<Transaction> trans_list = new ArrayList<>();

    public AccountAtm(String customername, long accountnumber, float balance, int pin) {
        this.customername = customername;
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.pin = pin;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public List<Transaction> getTrans_list() {
        return trans_list;
    }

    public void setTrans_list(List<Transaction> trans_list) {
        this.trans_list = trans_list;
    }

    public void deposit()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE AMOUNT TO DEPOSIT ");
        float amount = sc.nextFloat();

        this.balance += amount;
        trans_list.add(new Transaction("DEPOSIT",amount,this.balance));

        System.out.println("AMOUNT DEPOSITED");
        System.out.println("TOTAL AMOUNT  = "+this.balance);
    }

    public void withdraw()
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("ENTER THE AMOUNT TO WITHDRAW ");
            float amount = sc.nextFloat();

            if (amount % 100 == 0)
            {
                if (this.balance > amount)
                {
                    this.balance -= amount;
                    trans_list.add(new Transaction("WITHDRAW",amount,this.balance));
                    break;
                }
                else
                {
                    System.out.println("OOPS!..YOU DON'T HAVE ENOUGH MONEY ");
                }
            }
            else
            {
                System.out.println("ENTER VALID AMOUNT");
            }

        }

        System.out.println("AMOUNT WITHDRAWN");
        System.out.println(" REMAINING AMOUNT  = " + this.balance);

    }

    public void ministatement()
    {
        System.out.println("ACCOUNT HOLDER : "+this.customername);
        System.out.println("ACCOUNT NUMBER : "+this.accountnumber);
        System.out.println("ACCOUNT BALANCE :"+this.balance);
    }
    public void transaction()
    {
        System.out.format("%-20s%-20s%-20s","TYPE","AMOUNT","BALANCE");
        System.out.println();
        for(int i=0;i<this.trans_list.size();i++)
        {
            System.out.format("%-20s%-20s%-20s",this.trans_list.get(i).getType(),this.trans_list.get(i).getAmount(),
                            this.trans_list.get(i).getTrans_bal());
            System.out.println();
        }
    }
}

//
//obj->sowmi  12  123  1000000   trans_list
//                               +  5   b=100
//                               -  2   b=0
//                               +  1   b=1