package juc;

import com.sun.org.apache.bcel.internal.util.ClassPath;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Wanghj
 * @Package juc
 * @date 2021/4/6 15:41
 */
public class test {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(ClassPath.getClassPath());
        System.out.println(file);

    }


}
