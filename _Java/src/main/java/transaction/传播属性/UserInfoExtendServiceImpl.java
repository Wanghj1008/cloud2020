package transaction.传播属性;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoExtendServiceImpl {

    @Autowired
    private UserInfoDao userInfoDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void serviceA() {
        UserInfoVo infoVo = new UserInfoVo();
        infoVo.setAge(100);
        infoVo.setUserName("ceshi1");
        userInfoDao.save(infoVo);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void serviceB() {
        UserInfoVo infoVo = new UserInfoVo();
        infoVo.setAge(200);
        infoVo.setUserName("ceshi2");
        userInfoDao.save2(infoVo);
    }
}

