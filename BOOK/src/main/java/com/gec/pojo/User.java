package com.gec.pojo;

import lombok.Data;

@Data
public class User {
    private Integer Id;
    private String username;
    private String password;
    private Integer age;
    private  String gender;
    private String email;
}
