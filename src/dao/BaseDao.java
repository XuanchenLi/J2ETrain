package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @ClassName:BaseDao
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/3/8 下午 2:57
 * Version V1.0
 */
public class BaseDao {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Context cxt = null;
        try {
            cxt = new InitialContext();
            Object datasourceRef = cxt.lookup("java:jboss/datasources/MySqlDS");
            DataSource ds = (DataSource)datasourceRef;
            conn = ds.getConnection();
            return conn;
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void release(Connection connection, Statement statement) {

        // 判断连接是否为空
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void release(Connection connection, Statement statement, ResultSet resultSet) {


        //判断结果集是否为null
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 判断连接是否为空
        if (statement != null) {

            // 为了保证连接必须关闭,使用异常处理，防止因为statement关闭出现异常,connection未能够关闭
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void executeSql(String sql) {

        // 获取数据库连接
        Connection conn = null;
        Statement statement = null;
        try {

            // 获取连接
            conn = getConnection();
            statement = conn.createStatement();

            // 执行SQL语句
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放连接
            release(conn, statement);
        }
    }


}
