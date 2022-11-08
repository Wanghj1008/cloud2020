package spring.transaction.传播属性;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl {

    @Autowired
    private UserInfoExtendServiceImpl userInfoExtendService;


    @Transactional()
    public void service() {
        userInfoExtendService.serviceA();
        userInfoExtendService.serviceB();
    }
}