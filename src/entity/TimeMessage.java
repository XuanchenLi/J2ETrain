package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:Message
 * @Description: TODO
 * @Author:Dazz1e
 * @Date:2023/4/15 下午 4:18
 * Version V1.0
 */
public class TimeMessage implements Serializable {
    private Date sendTime;
    private Date recvTime;
    private String content;

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getRecvTime() {
        return recvTime;
    }

    public void setRecvTime(Date recvTime) {
        this.recvTime = recvTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
