package biz.ejb.stateless.UserBean;

import entity.User;

import javax.ejb.Local;
import java.util.List;


@Local
public interface UserBeanLocal {
    public List<User> getAllUsers();
    public User getUserByName(String name);
}
