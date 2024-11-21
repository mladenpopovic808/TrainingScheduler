package rs.ognjen_uros.notifikacije_spring_zakazivanje_treninga.service;

import com.mailersend.sdk.Email;
import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.exceptions.MailerSendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl{

    @Autowired
    public JavaMailSender mailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("makitestiranje@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public void sendWithMailerSend(String to, String subject, String text) throws MailerSendException {


        Email email = new Email();

        email.setFrom("name", "info@domain.com");
        email.addRecipient("name", "your@recipient.com");

        // you can also add multiple recipients by calling addRecipient again
        email.addRecipient("name 2", "your@recipient2.com");

        // there's also a recipient object you can use
        Recipient recipient = new Recipient("name", "your@recipient3.com");


        email.setSubject("Email subject");

        email.setPlain("This is the text content");
        email.setHtml("This is the HTML content");

        MailerSend ms = new MailerSend();

        ms.setToken("mlsn.8088201321fb358711a5777eeb2f46138edbff798557f636fe278c69794b9cf8");

        try {

            MailerSendResponse response = ms.send(email);
            System.out.println(response.messageId);
        } catch (MailerSendException e) {
            e.printStackTrace();




        }
}