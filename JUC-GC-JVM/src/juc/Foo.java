package juc;

/**
 * @author 王昊杰
 * @Program: openflatform
 * @Description:
 * @date 2021032021/3/10 11:13
 */
public class Foo {
    public static void main(String[] args) {

    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("1111");
       /* Foo f= new Foo();

        new Thread(()->{
            try {
                f.first();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                f.second();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                f.third();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C").start();*/
        System.out.println(compare("abcdea"));

    }

    public static int compare(String a) {
        System.out.println(a.contains("b"));
        System.out.println(a.trim());
        System.out.println(a.compareTo("b"));
        System.out.println(a.toLowerCase());
        int i2 = a.codePointCount(0, 2);
        System.out.println(a.replaceFirst("a", "b"));
        return i2;
    }

}