package com.EnterpriseManagementSystem.EMS.services;

import com.EnterpriseManagementSystem.EMS.model.Email;
import com.EnterpriseManagementSystem.EMS.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailRepository emailRepository;
    private void sentEmail(String to,String subject,String body){
        Email e = new Email();
        e.setRecipient(to);
        e.setSubject(subject);
        e.setMessage(body);
        e.setSentAt(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);
            e.setStatus("Success");
        }
        catch(Exception ex){
            e.setStatus("Failed");
            System.out.println(ex.getMessage());
        }
        emailRepository.save(e);
    }
    public void sendResentLink(String toEmail, String resentLink){
        String subject ="Password Reset Resent Link";
        String body = "Hello, \n\n Click the below resent link to reset your password:\n"
                +resentLink+"\n\n If you don't request this, please ignore this message.";
        sentEmail(toEmail,subject,body);
    }
}
