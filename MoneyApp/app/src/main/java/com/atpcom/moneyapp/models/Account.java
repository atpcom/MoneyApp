package com.atpcom.moneyapp.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Account {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String viewAccount;
    private String nameAccount;
    private double sumAccount;
    private String currency;

    public Account(String viewAccount, String nameAccount, double sumAccount, String currency) {
        this.viewAccount = viewAccount;
        this.nameAccount = nameAccount;
        this.sumAccount = sumAccount;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getViewAccount() {
        return viewAccount;
    }

    public void setViewAccount(String viewAccount) {
        this.viewAccount = viewAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public double getSumAccount() {
        return sumAccount;
    }

    public void setSumAccount(double sumAccount) {
        this.sumAccount = sumAccount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
