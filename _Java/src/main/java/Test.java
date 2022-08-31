import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.watchers.DelayWatcher;

import java.io.File;
import java.util.*;

/**
 * @author Wanghj
 * @Package PACKAGE_NAME
 * @date 2021/6/25 13:23
 */
public class Test {



    public static void main(String[] args) {
        File configFile = new File("E:/a.txt");
        WatchMonitor watchMonitor = WatchMonitor.create(configFile, WatchMonitor.ENTRY_MODIFY, WatchMonitor.ENTRY_CREATE);
        watchMonitor.setWatcher(new DelayWatcher(new ServerConfigWatcher(), 200));
        watchMonitor.start();

//        change(new int[]{1});
    }

    private static void change(int[] a) {
        Hashtable<Object, Object> map = new Hashtable<>();
        map.put(null,1);
        map.put("name","whj");
        map.put("name",null);
        map.put(null,1);


    }
}
