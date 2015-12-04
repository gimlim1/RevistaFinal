package Modelo.Mail;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Created by Ricardo Pineda G on 23-Nov-15.
 */
public class EnviarCorreo {

    public EnviarCorreo(){}

    public void email(String Para, String Subject, String Texto) {

        try {

            Properties props = new Properties();

            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "25");
            props.setProperty("mail,smtp.user", "inforevistadigital@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("inforevistadigital@gmail.com"));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(Para));
            message.setSubject(Subject);
            message.setText(Texto);



            Transport t = session.getTransport("smtp");
            t.connect("inforevistadigital@gmail.com", "Tamarindo2015!");
            t.sendMessage(message, message.getAllRecipients());
            t.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
