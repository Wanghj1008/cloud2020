package spring.transaction.传播属性;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.mybatis.model.User;

@Service
public class UserInfoExtendServiceImpl {

    @Autowired
    private UserInfoDao userInfoDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void serviceA() {
        User user = new User();
        user.setAge(100);
        user.setName("测试1");
        userInfoDao.save(user);
    }

//    @Transactional(propagation = Propagation.NEVER)
    public void serviceB() {
        User user = new User();
        user.setAge(200);
        user.setName("测试2");
        userInfoDao.save2(user);
    }
}

