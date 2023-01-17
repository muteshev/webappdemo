package code.spring.webappdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfiguration {
    @Bean
    @Profile("prod")
    public MyProfile myProfileProd(@Value("${my.messageValue}") String messageValue) {
        MyProfile myProfile = new MyProfile();
        myProfile.setMessageValue(messageValue);
        return myProfile;
    }
    @Bean
    @Profile("dev")
    public MyProfile myProfileDev() {
        MyProfile myProfile = new MyProfile();
        myProfile.setMessageValue("This is the dev method");
        return myProfile;
    }
}
