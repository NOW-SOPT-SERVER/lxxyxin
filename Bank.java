package com.sopt.classes;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customerList;
    private List<Account> accountList = new ArrayList<>();

    public List<Account> getAccountList() {
        return accountList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    //생성자
    public Bank(){}

    //계좌 존재 여부 확인
    public boolean findByAccountNumber(String accountNumber){
        for (Account account : this.accountList) {
            if (!account.getAccountNumber().equals(accountNumber)) {
                return false; //계좌가 존재하지 않으면 false 반환
            }
        }
        return true;
    }

    public void addAccount(Account account){
        accountList.add(account);
    }
    

}
