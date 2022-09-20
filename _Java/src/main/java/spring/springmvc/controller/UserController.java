package spring.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.mybatis.service.UserService;
import transaction.传播属性.UserInfoServiceImpl;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package spring.springmvc.controller
 * @Email: 1624302283@qq.com
 * @date 2022/9/18 20:55
 * @Copyright
 */
@Controller
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserInfoServiceImpl userInfoService;

    @GetMapping("test")
    @ResponseBody
    public void test() {
        userInfoService.service();
    }

}
