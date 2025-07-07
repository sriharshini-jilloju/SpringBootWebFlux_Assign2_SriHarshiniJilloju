package com.midterm.accounts.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("savings")
public class Savings implements Account {

    @Id
    private String id;
    private String accountHolder;
    private double balance;
    private double interestRate;

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdrawal(double amount) {
        this.balance -= amount;
    }

    @Override
    public void updateBalance(double newBalance) {
        this.balance = newBalance;
    }

    public void depositMonthlyInterest() {
        this.balance += balance * (interestRate / 100.0);
    }
    @Override
    public String getAccountHolder() {
        return accountHolder;
    }

    @Override
    public double getBalance() {
        return balance;
    }
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setinterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

	public double getinterestRate() {
		// TODO Auto-generated method stub
		return interestRate;
	}

}

