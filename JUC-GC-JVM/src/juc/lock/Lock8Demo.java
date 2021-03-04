package juc.lock;


import java.util.concurrent.TimeUnit;

class Phone {
    public   synchronized  void sendSMS() throws Exception {
        System.out.println("*******************sendSMS");
    }

    public   synchronized  void sendEmail() throws Exception {
//        TimeUnit.SECONDS.sleep(3);
//        Thread.sleep(4000);   代码意思同上
        System.out.println("*******************sendEmail");
    }

    public void sayHello() throws Exception {
        System.out.println("*******************sayHello");
    }
}

/**
 * 1.     标准访问，请问先打印邮件还是短信？                                邮件
 *        某一时刻，一个线程访问了资源类里面的任何一个同步方法,那么该资源类将被锁定  锁的是当前对象this
 *        其他线程不能进入其他 synchronized方法  只能等待
 * 2.     邮件方法暂停4s，请问先打印邮件还是短信？                          邮件
 * 3.     新增普通sayHello方法，请问先打印邮件还是hello？                   hello
 *           就是个普通方法  和同步锁无关 不受锁的影响
 * 4.     两部手机，请问先打印邮件还是短信？                                短信
 *           换成两个对象 不是同一把锁 所以同时进行 短信速度快
 * 5.     两个静态同步方法，同一部手机，请问先打印邮件还是短信？             邮件
 *           静态是模板所。 锁的是当前类的Class对象
 * 6.     两个静态同步方法，2部手机，请问先打印邮件还是短信？                邮件
 * 7.     1静态同步方法，1普通同步，同一部手机，请问先打印邮件还是短信？      短信
 *          静态同步方法和非静态同步方法是两把不同的锁  没有竞争关系。
 * 8.     1静态同步方法，1普通同步，2部手机，请问先打印邮件还是短信？          短信
 */
public class Lock8Demo {
    public static void main(String[] args) throws InterruptedException {
        /**    1.     标准访问，请问先打印邮件还是短信？  邮件
         *
         *  只要在一个资源类里 不管他有多少个同步方法
         *  只要一个线程先访问了资源类里面的任何一个同步方法
         *  那么该方法所在的资源类将被锁定  被锁定后其他线程也不能进入其他 synchronized方法
         Phone phone = new Phone();

         new Thread(()->{
         try {
         phone.sendEmail();
         } catch (Exception e) {
         e.printStackTrace();
         }
         },"A").start();
         Thread.sleep(100);
         new Thread(()->{
         try {
         phone.sendSMS();
         } catch (Exception e) {
         e.printStackTrace();
         }
         },"B").start();*/

        /**   2.     邮件方法暂停4s，请问先打印邮件还是短信？  邮件
         *
         *
         *          只要在一个资源类里面 不管他有多少个同步方法
         *          只要一个线程先访问了资源类里面的任何一个同步方法 那么该方法所在的资源类将被锁定
         *         那么该方法所在的资源类将被锁定  被锁定后其他线程也不能进入其他 synchronized方法
         Phone phone = new Phone();

         new Thread(()->{
         try {
         phone.sendEmail();
         } catch (Exception e) {
         e.printStackTrace();
         }
         },"A").start();
         Thread.sleep(100);//***************************************************
         new Thread(()->{
         try {
         phone.sendSMS();
         } catch (Exception e) {
         e.printStackTrace();
         }
         },"B").start();*/

        /**3.        新增普通sayHello方法，请问先打印邮件还是hello？sayHello*/
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        Thread.sleep(100);//***************************************************
        new Thread(() -> {
            try {
                phone.sayHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

        /** 4.     两部手机，请问先打印邮件还是短信？   短信
        Phone phone = new Phone();
        Phone phone1 = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        Thread.sleep(100);//***************************************************
        new Thread(() -> {
            try {
                phone1.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();*/

        /** 5.     两个静态同步方法，同一部手机，请问先打印邮件还是短信？ 邮件
        Phone phone = new Phone();
        Phone phone1 = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        Thread.sleep(100);//***************************************************
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();*/

        /** 6.     两个静态同步方法，2部手机，请问先打印邮件还是短信？  邮件
        Phone phone = new Phone();
        Phone phone1 = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        Thread.sleep(100);//***************************************************
        new Thread(() -> {
            try {
                phone1.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();*/

        /** 7.     1静态同步方法，1普通同步，同一部手机，请问先打印邮件还是短信？ 短信
         Phone phone = new Phone();
         Phone phone1 = new Phone();

         new Thread(() -> {
         try {
         phone.sendEmail();
         } catch (Exception e) {
         e.printStackTrace();
         }
         }, "A").start();
         Thread.sleep(100);//***************************************************
         new Thread(() -> {
         try {
         phone.sendSMS();
         } catch (Exception e) {
         e.printStackTrace();
         }
         }, "B").start();*/

        /** 8.     1静态同步方法，1普通同步，2部手机，请问先打印邮件还是短信？  短信
         Phone phone = new Phone();
         Phone phone1 = new Phone();

         new Thread(() -> {
         try {
         phone.sendEmail();
         } catch (Exception e) {
         e.printStackTrace();
         }
         }, "A").start();
         Thread.sleep(1000);//***************************************************
         new Thread(() -> {
         try {
         phone1.sendSMS();
         } catch (Exception e) {
         e.printStackTrace();
         }
         }, "B").start();*/

    }
}
