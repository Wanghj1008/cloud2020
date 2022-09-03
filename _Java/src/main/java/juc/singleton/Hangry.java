package juc.singleton;

/**
 *   饿汉单例模式  1.私有构造器  2.自己new自己 3.提供外部获取实例接口
 *        缺点    如果我这个单例模式里面开辟了其他空间。会造成资源浪费
 */
public class Hangry {

    private Hangry(){

    }
    private static final Hangry hangry=new Hangry();

    public static Hangry getInstance(){
        return hangry;
    }
}
