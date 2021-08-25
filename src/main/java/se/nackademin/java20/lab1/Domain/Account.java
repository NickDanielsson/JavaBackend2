package se.nackademin.java20.lab1.Domain;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "holder")
    private String holder;

    @Column(name = "balance")
    private int balance;

    public Account(){

    }

    public Account(String holder, int balance){
        this.balance = balance;
        this.holder = holder;
    }

    public void withdraw(int amount){
        int newBalance = this.balance - amount;
        if (newBalance < 0) throw new IllegalStateException("Account cannot go below 0");
        this.balance = newBalance;
    }

    public void deposit(int amount){
        this.balance = this.balance + amount;
    }

    public Long getId() {
        return id;
    }

    public String getHolder() {
        return holder;
    }

    public int getBalance() {
        return balance;
    }
}
