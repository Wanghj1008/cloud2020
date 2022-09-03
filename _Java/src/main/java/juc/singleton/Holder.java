package juc.singleton;

/**
 * 静态内部类实现单例
 *    都不安全
 */
public class Holder {
    private Holder(){

    }
    private static class singleDeom{
       private static final Holder holder=new Holder();
    }
    public Holder getInstance(){
        return singleDeom.holder;
    }
}
