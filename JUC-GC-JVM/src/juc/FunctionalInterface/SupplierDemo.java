package juc.FunctionalInterface;

import java.util.function.Supplier;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021032021/3/4 23:14
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> objectSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "没有输入只有返回";
            }
        };
        System.out.println(objectSupplier.get());
    }
}
