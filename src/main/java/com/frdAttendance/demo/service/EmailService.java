package com.frdAttendance.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendUserCreationEmail(String toEmail, String username,String name, String tempPassword) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your Account Has Been Created");
        message.setText("Hello " + name + ",\n\nYour account has been created.\nTemporary Password: " + tempPassword +"\nUsername:"+username+"\n\nPlease change it after first login.");

        mailSender.send(message);
    }

    public void sendPasswordResetEmail(String toEmail, String token) {
        String resetLink = "http://yourfrontendurl.com/reset-password?token=" + token;
        String subject = "Password Reset Request";
        String body = "Please click the following link to reset your password: " + resetLink +
                "\n\nThis link will expire in 1 hour.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

}
