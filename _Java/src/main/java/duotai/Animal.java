package duotai;

import java.io.IOException;

/**
 * @author Wanghj
 * @Package duotai
 * @date 2021/6/25 13:53
 *  禁止指针压缩        -XX:-UseCompressedOops -XX:-UseCompressedClassPointers
 */
class Test {
    public static void test(Animal animal) {
        animal.eat();
        System.out.println(animal.toString());
    }

    public static void main(String[] args) throws IOException {
        test(new Dog());
        test(new Cat());
        System.in.read();
    }

}

abstract class Animal {
    public abstract void eat();

    @Override
    public String toString() {
        return "我是"+this.getClass().getSimpleName();
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
}

class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
