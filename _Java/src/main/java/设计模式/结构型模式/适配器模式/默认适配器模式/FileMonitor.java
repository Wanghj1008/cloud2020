package 设计模式.结构型模式.适配器模式.默认适配器模式;

import org.apache.commons.io.monitor.FileAlterationObserver;

public class FileMonitor extends FileAlterationListenerAdaptor {
    @Override
    public void onStart(FileAlterationObserver fileAlterationObserver) {
        System.out.println("只重写需要的方法");
    }
}