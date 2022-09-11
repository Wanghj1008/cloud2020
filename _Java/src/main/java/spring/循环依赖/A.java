package spring.循环依赖;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package spring.循环依赖
 * @Email: 1624302283@qq.com
 * @date 2022/9/11 19:10
 * @Copyright
 */
@Service
public class A {
    @Autowired
    public B b;

    @Async
    public void test(){}
}
