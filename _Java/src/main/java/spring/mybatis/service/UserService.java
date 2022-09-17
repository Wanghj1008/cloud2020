package spring.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mybatis.mapper.UserMapper;
import spring.mybatis.model.User;

import java.util.List;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package spring.mybatis.mapper
 * @Email: 1624302283@qq.com
 * @date 2022/9/17 20:02
 * @Copyright
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> getList(){
        return userMapper.selectList();
    }
}
