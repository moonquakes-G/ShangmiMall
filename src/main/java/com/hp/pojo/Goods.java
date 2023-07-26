package com.hp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int id;
    private String cover;
    private String name;
    private String intro;
    private String spec;
    private int price;
    private int stock;
    private int sales;
    private String content;

    private int typeId;
    private String typeName;
    private int itemsAmount;


}
