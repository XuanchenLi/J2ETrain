package biz;

import dao.UserDao;
import entity.User;

/**
 * @ClassName:UserBiz
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/3/8 下午 2:33
 * Version V1.0
 */
public class UserBiz {
    private UserDao userDao = new UserDao();
    public User loginService(String name, String password) {
        User user = userDao.SelectUserByName(name);
        if (user == null) {
            return null;
        }
        if (!password.equals(user.getPassword())) {
            return null;
        }else {
            return user;
        }
    }
}
