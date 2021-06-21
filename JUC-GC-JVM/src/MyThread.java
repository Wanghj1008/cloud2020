
public class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("线程开始执行...");
            System.out.println("业务步骤1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("业务步骤2");
            System.out.println("线程执行完毕...");
        }
    }
}