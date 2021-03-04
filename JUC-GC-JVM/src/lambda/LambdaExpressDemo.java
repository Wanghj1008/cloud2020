package lambda;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Foo {
    //    public void sayHello();
    public int add(int x, int y);

    public default int mul(int x, int y) {
        return x * y;
    }

    static int div(int x, int y) {
        return x / y;
    }
}

/**
 * 1. 前提必须时函数式接口  才能用lambda表达式   里面必须只有一个抽象方法
 * 2. 可以有多个default方法及实现
 * 3.  可以有多个static方法及实现
 * Lambda 解决了匿名内部类也就是new 接口时代码冗余的现象
 * 拷贝小括号  写死右箭头  落地大括号
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
    /*    Foo foo=new Foo() {
            @Override
            public void sayHello() {
                System.out.println("*****hello 2015");
            }
        };
        foo.sayHello();*/

    /*Foo foo=() -> {System.out.println("*****hello 2015");};
    foo.sayHello();*/

        Foo foo = (int x, int y) -> {
            System.out.println("come in add method");
            return x + y;
        };
        System.out.println(foo.add(3, 5));

        System.out.println(foo.mul(3, 5));

        System.out.println(Foo.div(10, 2));
        List objects = new ArrayList<>();
//        objects.forEach();
    }


}
