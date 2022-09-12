package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JDBC事务 {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/authorization";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "cyberaudit";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            // 1、 获取连接对象Connection
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            // 开启事务
            conn.setAutoCommit(false);
            // 3. 获取预处理sql语句PreparedStatement的对象
            pstm = conn.prepareStatement("insert into admin values (?,?,?)");
            // 4. ?赋值
            pstm.setInt(1, 1);
            pstm.setString(2, "呵呵");
            pstm.setString(3, "123");
            // 5. 执行SQL操作
            pstm.executeUpdate();
            // 模拟异常
//            int x = 5 / 0;

            // 业务完成正常提交
            conn.commit();
        } catch (Exception e) {
            // 业务异常，回滚
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // 6. 释放资源
            try {
                pstm.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}