package transaction.传播属性;

import spring.mybatis.model.User;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package transaction.传播属性
 * @Email: 1624302283@qq.com
 * @date 2022/9/12 22:05
 * @Copyright
 */
public interface UserInfoDao {
     Integer save(User userInfoVo);
     Integer save2(User userInfoVo);
}
