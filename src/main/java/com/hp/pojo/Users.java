package com.hp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private int id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;
}
