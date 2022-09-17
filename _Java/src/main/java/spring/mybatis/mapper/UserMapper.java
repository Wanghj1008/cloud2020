package spring.mybatis.mapper;

import org.springframework.stereotype.Repository;
import spring.mybatis.model.User;

import java.util.List;

/**
 * @Description:
 * @ClassName: UserMapper
 * @Author: WHJ
 * @Date: 2022/9/16 18:10
 * @Version: 6.0.18.0
 */
@Repository
public interface UserMapper {
	List<User> selectList();
}
