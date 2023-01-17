package code.spring.webappdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyMessage {
    @Value("${my.messageString}")
    private String messageString;

    @Value("${my.messageInt}")
    private int messageInt;

    public int getMessageInt() {
        return messageInt;
    }

    public void setMessageInt(int messageInt) {
        this.messageInt = messageInt;
    }

    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }
}
