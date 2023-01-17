package code.spring.webappdemo;

import org.springframework.beans.factory.annotation.Value;

public class MyProfile {

    private String messageValue;

    public String getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }

}
