package biz.ejb.stateless.UserBean;

import dao.UserDao;
import entity.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @ClassName:UserBean
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/3/22 下午 9:27
 * Version V1.0
 */
@Stateless
@LocalBean
public class UserBean implements UserBeanLocal{

    private UserDao userDao = new UserDao();

    public UserBean() {

    }

    @Override
    public List<User> getAllUsers() {
        return userDao.SelectAllUsers();
    }

    @Override
    public User getUserByName(String name) {
        return userDao.SelectUserByName(name);
    }
}
