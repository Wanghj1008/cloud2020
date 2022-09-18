package spring.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import spring.mybatis.service.UserService;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package spring.springmvc.controller
 * @Email: 1624302283@qq.com
 * @date 2022/9/18 20:55
 * @Copyright
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("test")
    public void test(){
        userService.getList();
    }

}
