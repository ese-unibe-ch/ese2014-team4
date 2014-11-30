package ch.unibe.ese2014.team4.controller.service;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
class SpringConfiguration {
    @Bean
    public JavaMailSenderImpl mailSender(){
        JavaMailSenderImpl object = new JavaMailSenderImpl();
        object.setHost("smtp.gmail.com");
        object.setPort(587);
        object.setPassword("ese2014Email");
        object.setUsername("team4.ese2014@gmail.com");
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        object.setJavaMailProperties(properties);
        return object;
    } 
}
/*
<!--  configuration of email sending bean -->    
<bean id="JavaMailSender" class="org.springframework.mail.javamail.JavaMailSenderImpl">
    <property name="host" value="smtp.gmail.com" />
    <property name="port" value="587" />
    <property name="username" value="team4.ese2014@gmail.com" />
    <property name="password" value="ese2014Email" />
    <property name="javaMailProperties">
        <props>
            <prop key="mail.transport.protocol">smtp</prop>
            <prop key="mail.smtp.auth">true</prop>
            <prop key="mail.smtp.starttls.enable">true</prop>
        </props>
    </property>
</bean>*/