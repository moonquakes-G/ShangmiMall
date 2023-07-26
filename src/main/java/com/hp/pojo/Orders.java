package com.hp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Curtain-call
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private int id;
    private int total;
    private int amount;
    private int status;
    private int paytype;
    private String name;
    private String phone;
    private String address;
    private LocalDateTime systime;
    private int userId;

//    private Items items;
//    private Goods goods;
//    private Users users;

    private int price;
    private int itemsAmount;
    private String goodName;
    private String username;
}
