package transaction.传播属性;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer save(UserInfoVo userInfoVo) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("user_info").usingColumns("user_name", "age").usingGeneratedKeyColumns("id");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("user_name", userInfoVo.getUserName());
        params.put("age", userInfoVo.getAge());
        int id = insert.executeAndReturnKey(params).intValue();
        return id;
    }

    public Integer save2(UserInfoVo userInfoVo) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("user_info").usingColumns("user_name", "age").usingGeneratedKeyColumns("id");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("user_name", userInfoVo.getUserName());
        params.put("age", userInfoVo.getAge());
        int id = insert.executeAndReturnKey(params).intValue();
        //throw new RuntimeException("测试异常");
        return id;

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}