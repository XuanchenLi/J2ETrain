package dao;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:UserDao
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/3/8 下午 2:42
 * Version V1.0
 */
public class UserDao {
    private BaseDao baseDao = new BaseDao();
    public User SelectUserByName(String name){
        Connection conn = null;
        try {
            conn = baseDao.getConnection();
            String sql = "select * from user_info where username= '" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                User res = new User();
                res.setId(rs.getLong("id"));
                res.setPassword(rs.getString("password"));
                res.setUsername(rs.getString("username"));
                res.setType(rs.getInt("type"));
                return res;
            }else {
                return null;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public List<User> SelectAllUsers() {
        Connection conn = null;
        try {
            conn = baseDao.getConnection();
            String sql = "select * from user_info";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<User> res = new ArrayList<>();
            while (rs.next()) {
                User resi = new User();
                resi.setId(rs.getLong("id"));
                resi.setPassword(rs.getString("password"));
                resi.setUsername(rs.getString("username"));
                resi.setType(rs.getInt("type"));
                res.add(resi);
            }
            return res;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
