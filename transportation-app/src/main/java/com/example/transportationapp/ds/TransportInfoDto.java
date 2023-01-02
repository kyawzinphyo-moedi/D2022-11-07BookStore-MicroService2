package com.example.transportationapp.ds;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data

public class TransportInfoDto {


    private String name;
    private String orderId;

    private List<BookDto> books=new ArrayList<>();
    private double total;

    public TransportInfoDto() {
    }




}
