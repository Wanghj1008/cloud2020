package com.example.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Wanghj
 * @Package com.example.demo.pojo
 * @date 2021/4/12 16:05
 */

@Data
@NoArgsConstructor
public class User implements Serializable {
    private  static  final  long serialVersionUID=1;
    private String name;
    private int age;
    public User(String name,int age){
        this.name=name;
        this.age=age;
    }
}
