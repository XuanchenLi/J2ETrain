package entity;

import java.io.Serializable;

/**
 * @ClassName:User
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/3/8 下午 2:30
 * Version V1.0
 */
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Integer type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
