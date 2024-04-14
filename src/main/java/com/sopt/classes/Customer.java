package com.sopt.classes;

import java.util.List;

public class Customer {
    private String name;
    private List<Account> accountList;

    //생성자
    public Customer(String name){
        this.name = name;
    }

    //getter
    public String getName() {
        return name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
