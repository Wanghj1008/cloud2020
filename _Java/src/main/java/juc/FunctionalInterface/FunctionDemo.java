package juc.FunctionalInterface;

//import jdk.nashorn.internal.ir.CallNode;

import java.util.function.Function;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021032021/3/4 22:48
 */
public class FunctionDemo {
    public static void main(String[] args) {
        //传入一个String  返回一个int
 /*   Function function=new Function<String,Integer>() {
        @Override
        public Integer apply(String o) {
            return Integer.parseInt(o);
        }
    };*/
        Function function1=(o)->{return o;};
        System.out.println(function1.apply("dasdsa"));
    }


}
