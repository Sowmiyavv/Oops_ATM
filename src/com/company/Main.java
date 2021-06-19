package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main
{
    static ArrayList<AccountAtm> list = new ArrayList<>();
    static
    {
        list.add(new AccountAtm("sowmi",123456,1000,123));
        list.add(new AccountAtm("sarah",78906,2000,456));
    }
    public static void main(String[] args)
    {
        Main ob = new Main();
        ob.menu();
    }
    public void menu()
    {
        while(true)
        {
            System.out.println("WELCOME");

            System.out.println("1. LOGIN");
            System.out.println("2. REGISTER");
            System.out.println("3. VIEW DETAILS");
            System.out.println("4. VIEW ALL CUSTOMER TRANSACTION");
            System.out.println("5. CLOSE");

            Scanner sc = new Scanner(System.in);
            System.out.println("ENTER THE OPTION ");
            int n = sc.nextInt();
            if (n == 1) {
                Accountlogin();
            } else if (n == 2) {
                Accountregister();
            } else if (n == 3) {
                viewDetails();
            }else if(n == 4)
            {
                viewAllDetails();
            }
            else
            {
                return;
            }
        }
    }
    public void viewAllDetails()
    {
        System.out.format("%-20s%-20s%-20s%-20s%-20s","ACCOUNT NAME","ACCOUNT NUMBER","TYPE","AMOUNT","BALANCE");
        System.out.println();
        for(int i=0;i<list.size();i++)
        {
            for (int j=0;j<list.get(i).getTrans_list().size();j++)
            {
                System.out.format("%-20s%-20s%-20s%-20s%-20s",list.get(i).getCustomername(),list.get(i).getAccountnumber(),
                        list.get(i).getTrans_list().get(j).getType(),list.get(i).getTrans_list().get(j).getAmount(),
                        list.get(i).getTrans_list().get(j).getTrans_bal());
                System.out.println();
            }
        }
    }
    public void viewDetails()
    {
        System.out.format("%-20s%-20s%-20s","ACCOUNT NUMBER","ACCOUNT HOLDER","BALANCE");
        System.out.println();
        for(int i=0;i<list.size();i++)
        {
            System.out.format("%-20s%-20s%-20s",list.get(i).getAccountnumber(),list.get(i).getCustomername(),
                    list.get(i).getBalance());
            System.out.println();
        }
    }
    public void Accountregister()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO BANK");

        System.out.println("ENTER YOUR NAME");
        String accountholder = sc.nextLine();

        System.out.println("ENTER YOUR ACCOUNT NUMBER");
        long accountnumber = sc.nextLong();

        System.out.println("ENTER YOUR PIN");
        int pin = sc.nextInt();

        AccountAtm obj = new AccountAtm(accountholder,accountnumber,0,pin);
        list.add(obj);

        System.out.println("REGISTRATION SUCCESSFULL");

        showmenu(obj);
    }
    public void Accountlogin()
    {
        System.out.println("hi......");
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("ENTER YOUR ACCOUNT NUMBER");
            long accountnumber = sc.nextLong();
            System.out.println("ENTER YOUR PIN");
            int pin = sc.nextInt();

            AccountAtm accobj = findAccount(accountnumber, pin);
            if (accobj != null) {
                showmenu(accobj);
                break;
            } else {
                System.out.println("INVALID CREDIANTIALS");
            }
        }
    }

    public AccountAtm findAccount(long accountnumber,int pin)
    {
        for(int i=0;i<list.size();i++)
        {
            if (list.get(i).getAccountnumber()==accountnumber && list.get(i).getPin() == pin)
            {
                return list.get(i);
            }
        }
        return null;
    }

    public void showmenu(AccountAtm obj)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("hello"+obj.getCustomername());

        while(true)
        {
            System.out.println("ENTER YOUR CHOICE");
            System.out.println("1. DEPOSIT");
            System.out.println("2. WITHDRAW");
            System.out.println("3. MINISTATEMENT");
            System.out.println("4. TRANSACTION");
            System.out.println("5. EXIT");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    obj.deposit();
                    break;

                case 2:
                    obj.withdraw();
                    break;

                case 3:
                    obj.ministatement();
                    break;

                case 4:
                    obj.transaction();
                    break;


                case 5:
                    System.out.println("THANk YOU!");
                    return;

                default:
                    System.out.println("ENTER CORRECT CHOICE");
                    break;
            }
        }
    }
}



















//name,id,balnce,prevTransaction;
//
//menu()
//        {
//            withdraw()
//            deposit()
//            balance()
//        }