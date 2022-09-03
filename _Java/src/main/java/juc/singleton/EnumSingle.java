package juc.singleton;

import java.lang.reflect.Constructor;

/**
 * enum是什么？  枚举本身就是一个class类 继承了枚举
 */
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}
class test1{
    public static void main(String[] args) throws Exception {
        EnumSingle instance = EnumSingle.INSTANCE;
//        EnumSingle instance1 = EnumSingle.INSTANCE;
//        System.out.println(instance1);
        System.out.println(instance);

        //查看字节码文件发现有一个无参构造 继续使用反射尝试破坏
   /*     Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        //todo: java.lang.NoSuchMethodException:java报错没有找到对应的无参构造器
        // 说明实际是没有的 通过 Jad 反编译看到是一个有参构造器(String，int)类型的
        EnumSingle enumSingle = declaredConstructor.newInstance();*/

   //使用有参构造破坏
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        //不能使用反射创建Enum对象
        //Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        EnumSingle enumSingle = declaredConstructor.newInstance();
        System.out.println(enumSingle);

    }
}
