package com.hp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tops {
    private int id;
    private int type;
    private int goodId;

    private String cover;
    private String name;
    private String intro;
    private String spec;
    private int price;
}
