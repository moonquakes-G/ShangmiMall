package com.hp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Curtain-call
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admins {
    private int id;
    private String username;
    private String password;
}
