package dao;

import entity.TimeMessage;
import entity.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @ClassName:MessageDao
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/4/15 下午 4:20
 * Version V1.0
 */
public class MessageDao {
    private BaseDao baseDao = new BaseDao();
    public void InsertMessage(TimeMessage msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "INSERT INTO message VALUE ('" + sdf.format(msg.getSendTime()) + "', '" + sdf.format(msg.getRecvTime()) + "', '"+ msg.getContent() + "');";
        baseDao.executeSql(sql);
    }
    public List<TimeMessage> SelectMessageByTimeRange(Date stTime, Date edTime) {
        Connection conn = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            conn = baseDao.getConnection();
            String sql = "select * from message where recv_time between '" + sdf.format(stTime) + "' and '" + sdf.format(edTime) + "';";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<TimeMessage> resSet = new ArrayList<>();
            while (rs.next()) {
                TimeMessage res = new TimeMessage();
                res.setSendTime(rs.getDate("send_time"));
                res.setRecvTime(rs.getDate("recv_time"));
                res.setContent(rs.getString("content"));
                resSet.add(res);
            }
            rs.close();
            stmt.close();
            return resSet;
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
