package tn.esprit.spring.control;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@RestController
public class MailController {
    @Autowired
    public JavaMailSender emailSender;
 
    @ResponseBody
    @RequestMapping("/sendEmail")
    public String sendSimpleEmail(@RequestParam("sujet")String sujet,@RequestParam("message")String Message,@RequestParam("destination")String mail) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(mail);
        message.setSubject(sujet);
        message.setText(Message);
        this.emailSender.send(message);
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return "Email envoyé!";
    }
}