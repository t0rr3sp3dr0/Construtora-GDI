package systems.singularity.buildware.models;

import systems.singularity.buildware.enums.Bank;

/**
 * Created by phts on 05/05/16.
 * © 2016 Singularity Systems
 */
public class BankAccount {
    private int id;
    private Bank bank;
    private String agency;
    private String number;

    public BankAccount() {
        this.id = -1;
        this.bank = Bank._null;
    }

    public BankAccount id(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BankAccount bank(Bank bank) {
        this.bank = bank;
        return this;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankAccount agency(String agency) {
        this.agency = agency;
        return this;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BankAccount number(String number) {
        this.number = number;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
