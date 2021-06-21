import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wanghj
 * @Package PACKAGE_NAME
 * @date 2021/6/7 16:02
 */
public class BlokedDemo {

    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    Condition conditionD = lock.newCondition();

    private String msg = "A";

    public void demeA() throws InterruptedException {
        try {
            lock.lock();
            while (!msg.equals("A")) {
//                wait();
                conditionA.await();
            }

            System.out.println(Thread.currentThread().getName() );
            msg = "B";
        } finally {
//            notifyAll();
            conditionB.signalAll();
        }

    }

    public void demeB() throws InterruptedException {
        lock.lock();
        try {
            while (!msg.equals("B")) {
//                wait();
                conditionB.await();
            }

            System.out.println(Thread.currentThread().getName() );
            msg = "C";
        } finally {
//            notifyAll();
            conditionC.signalAll();
        }
    }

    public void demeC() throws InterruptedException {

        lock.lock();
        try {
            while (!msg.equals("C")) {
//                wait();
                conditionC.await();
            }

            System.out.println(Thread.currentThread().getName());
            msg = "D";
        } finally {
//            notifyAll();
            conditionD.signalAll();
        }
    }

    public void demeD() {
        lock.lock();

        try {
            while (!msg.equals("D")) {
//                wait();
                conditionD.await();
            }

            System.out.println(Thread.currentThread().getName());
            msg = "A";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            notifyAll();
            conditionA.signalAll();
        }
    }
    public static void main(String[] args) {
        BlokedDemo blokedDemo = new BlokedDemo();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    blokedDemo.demeA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    blokedDemo.demeB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    blokedDemo.demeC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                blokedDemo.demeD();

            }
        }, "D").start();
    }
}
