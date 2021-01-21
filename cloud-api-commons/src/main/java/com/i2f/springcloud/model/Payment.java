package com.i2f.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021012021/1/6 13:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private long id;
    private String serial;
}
