package biz.ejb.stateful;

import entity.User;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:UserListBeanImpl
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/3/29 下午 2:46
 * Version V1.0
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
public class UserListBeanImpl implements UserListBean{
    private List<User> userList;
    @PostConstruct
    private void initializeBean() {
        userList = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        for (User u : userList) {
            if (u.getId().equals(user.getId()))
                return;
        }
        userList.add(user);
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }

    @Override
    public void clear() {
        userList.clear();
    }
}
