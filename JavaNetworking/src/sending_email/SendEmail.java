/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sending_email;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.ws.wsdl.writer.document.Message;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import sun.rmi.transport.Transport;

/**
 *
 * @author AnhTu
 */

public class SendEmail {

    public static void main(String[] args) throws javax.mail.MessagingException {
        // Recipient's email ID needs to be mentioned.
        String to = "abcd@gmail.com";
// Sender's email ID needs to be mentioned
        String from = "web@gmail.com";
// Assuming you are sending email from localhost
        String host = "localhost";
// Get system properties
        Properties properties = System.getProperties();
// Setup mail server
        properties.setProperty("mail.smtp.host", host);
// Get the default Session object.
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        //message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("This is the Subject Line!");
        message.setText("This is actual message");
        //Transport.send(message);
        System.out.println("Sent message successfully....");
    }
}
