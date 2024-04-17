package com.sopt;

import com.sopt.classes.Account;
import com.sopt.classes.Bank;
import com.sopt.classes.Customer;

import java.util.Scanner;

public class Main{
    public static void console(){
        System.out.println("------원하시는 항목의 번호를 입력해주세요.------");
        System.out.println("                1. 입금                 ");
        System.out.println("                2. 출금                 ");
        System.out.println("                3. 종료                 ");
        System.out.println("---------------------------------------");
    }
    public static void main(String[] args) {

        Account account = new Account("이예린", "123-1456-2223",2111, 10000);
        Customer customer = new Customer("이예린");
        Bank bank = new Bank();
        bank.addAccount(account);

        //콘솔 창
        console();
        System.out.print("입력 : ");
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.next());
        System.out.println();
        switch (input){
            case 1:
                System.out.print("입금할 계좌를 입력해주세요 : ");
                String depositAccount = scanner.next();
                System.out.println();
                //계좌 존재 여부 확인
                if (!bank.findByAccountNumber(depositAccount)){
                    System.out.println("입금 계좌가 올바르지 않습니다.");
                    break;
                }
                System.out.print("입금할 금액을 입력해주세요 : ");
                int deposit = scanner.nextInt();
                //금액 유효성 검사
                if (deposit <= 0){
                    System.out.println("입금 금액이 올바르지 않습니다.");
                    break;
                }
                System.out.println();
                System.out.print("비밀번호를 입력해주세요 : ");
                int depositAccountPassword = scanner.nextInt();
                System.out.println();
                //비밀번호 확인
                if (!account.checkPassword(depositAccountPassword)){
                    System.out.println("비밀번호가 틀렸습니다.");
                    break;
                }
                account.deposit(depositAccount, deposit);
                System.out.println("입금이 완료되었습니다.");
                System.out.print("계좌 잔액 : " + account.getBalance());
                break;
            case 2:
                System.out.println("출금할 계좌를 입력해주세요.");
                String withdrawAccount = scanner.next();
                //계좌 존재 여부 확인
                if (!bank.findByAccountNumber(withdrawAccount)){
                    System.out.println("출금 계좌가 올바르지 않습니다.");
                    break;
                }
                System.out.print("출금할 금액을 입력해주세요 : ");
                int withdraw = scanner.nextInt();
                //금액 유효성 검사
                if (withdraw <= 0 || withdraw > account.getBalance()){
                    System.out.println("출금 금액이 올바르지 않습니다.");
                    break;
                }
                System.out.println();
                System.out.print("비밀번호를 입력해주세요 : ");
                int withdrawAccountPassword = scanner.nextInt();
                System.out.println();
                //비밀번호 확인
                if (!account.checkPassword(withdrawAccountPassword)){
                    System.out.println("비밀번호가 틀렸습니다.");
                    break;
                }
                account.withdraw(withdrawAccount, withdraw);
                System.out.println("출금이 완료되었습니다.");
                System.out.print("계좌 잔액 : " + account.getBalance());
                break;
            case 3:
                System.out.println("서비스를 종료합니다.");
                break;
        }

    }
}