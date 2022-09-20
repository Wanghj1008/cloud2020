package transaction.传播属性;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import spring.mybatis.model.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer save(User user) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("user").usingColumns("name", "age").usingGeneratedKeyColumns("id");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", user.getName());
        params.put("age", user.getAge());
        int id = insert.executeAndReturnKey(params).intValue();
        return id;
    }

    public Integer save2(User user) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("user").usingColumns("name", "age").usingGeneratedKeyColumns("id");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", user.getName());
        params.put("age", user.getAge());
        int id = insert.executeAndReturnKey(params).intValue();
        throw new RuntimeException("测试异常");
//        return id;
    }
}