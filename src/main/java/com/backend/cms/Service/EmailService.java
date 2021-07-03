package com.backend.cms.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.backend.cms.Model.ResearchPpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Properties;

//import com.bravo.store_managemt_system.model.Researchppr;

@Service
public class EmailService {
    private JavaMailSender javaMailSender ;

//    @Autowired
//    public EmailService(JavaMailSender javaMailSender){
//        this.javaMailSender = javaMailSender;
//    }

    public void sendEmail(ResearchPpr rr) throws MailException{


        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);
        mailSender.setUsername("shoe50048@gmail.com");
        mailSender.setPassword("shoe@1234");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");

        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("javax.net.ssl.SSLSocketFactory", "false");
        properties.setProperty("javax.net.ssl.SSLSocketFactory", "false");

        mailSender.setJavaMailProperties(properties);




        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(rr.getEmail());
        smm.setSubject("Resaerch Paper whatever");

        String emailBody = "Congratulations! \n" +
                "\n" +
                "We are happy to announce that you have been promoted as an Store Manager in our Online Shopping Store. Please Use this login Credential to log as the Store Manager.\n" +
                "\n" +
                "\n" +
                "Email :- " +rr.getEmail() + "\n" +
                "\n" +
                "Password :- " +"gg" +"\n" +
                "\n" +
                "\n" +
                "Thank you. ";


        smm.setText(emailBody);

        mailSender.send(smm);
    }
}