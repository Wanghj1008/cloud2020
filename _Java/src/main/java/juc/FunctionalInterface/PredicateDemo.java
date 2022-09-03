package juc.FunctionalInterface;

import java.util.function.Predicate;

/**
 * @author 王昊杰
 * @Program: cloud2020
 * @Description:
 * @date 2021032021/3/4 23:03
 */
public class PredicateDemo {
    public static void main(String[] args) {
        //输入一个String  返回一个Boolean
        //判断字符串是否为空
        Predicate<String> objectPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        Predicate<String> objectPredicate1=str->{
            return str.isEmpty();
        };
        System.out.println(objectPredicate1.test("abc"));
    }
}
