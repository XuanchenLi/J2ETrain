package biz.ejb.stateful;


import entity.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserListBean {
    void addUser(User user);
    void clear();
    List<User> getUserList();
}
