package com.example.payment.ds;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccountInfo {

    private String name;
    private double totalAmount;
    private String accountNumber;


    public AccountInfo() {
    }
}
