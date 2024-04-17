package com.sopt.classes;

public class Account {
    private String name; //계좌주인
    private String accountNumber; //계좌번호

    private int password; //계좌 비밀번호

    private int balance; //잔액

    //생성자
    public Account(String name, String accountNumber, int password, int balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = balance;
    }
    //getter
    public String getName() {
        return name;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public int getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    //입금
    public void deposit(String accountNumber, int amount){
        this.balance += amount;
    }

    //출금
    public void withdraw(String accountNumber, int amount){
        this.balance -= amount;
    }

    public boolean checkPassword(int password){
        if (this.password != password){
            return false;
        }
        return true;
    }
}

