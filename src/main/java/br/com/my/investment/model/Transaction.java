package br.com.my.investment.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Transaction {

    private String companyCode;
    private int amount;
    private LocalDate date;
    private double price;
    private double tax;
    private double totalValue;
    private Operation operation;
    private String category;
}
