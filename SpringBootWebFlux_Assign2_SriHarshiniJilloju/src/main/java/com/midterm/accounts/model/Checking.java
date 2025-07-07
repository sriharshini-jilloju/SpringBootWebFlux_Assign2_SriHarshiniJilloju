package com.midterm.accounts.model;



import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("checking")
public class Checking implements Account {

    @Id
    private String id;
    private String accountHolder;
    private double balance;
    private double insufficientFundFee;

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdrawal(double amount) {
        if (amount > balance) {
            this.balance -= insufficientFundFee;
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public void updateBalance(double newBalance) {
        this.balance = newBalance;
    }

    public String processingCheck(String check) {
        return "Processed check: " + check;
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

    public void setInsufficientFundFee(double insufficientFundFee) {
        this.insufficientFundFee = insufficientFundFee;
    }

	public double getInsufficientFundFee() {
		// TODO Auto-generated method stub
		return insufficientFundFee;
	}

}

