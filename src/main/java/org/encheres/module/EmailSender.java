package org.encheres.module;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * La classe EmailSender est responsable de l'envoi de messages par courrier électronique en utilisant les paramètres de courrier électronique fournis.
 */
public class EmailSender {

    private static EmailSender instance;
    private final EmailSettings emailSettings;

    private final Session session;
    /**
     * Le constructeur EmailSender.
     * @param emailSettings les paramètres de l'e-mail.
     */
    private EmailSender(EmailSettings emailSettings) {
        this.emailSettings = emailSettings;
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailSettings.getUsername(), emailSettings.getPassword());
            }
        };
        this.session = Session.getInstance(emailSettings.getProperties(), auth);
    }

    /**
     * Obtenez l'instance de EmailSender. S'il n'existe pas, une nouvelle instance sera créée.
     * @return EmailSender instance.
     */
    public static EmailSender getInstance() {
        if (instance == null) {
            synchronized (EmailSender.class) {
                if (instance == null) {
                    instance = new EmailSender(EmailSettings.getSettings());
                }
            }
        }
        return instance;
    }
    /**
     * Envoyer un e-mail.
     * @param toEmail e-mail destinataire
     * @param subject sujet du e-mail
     * @param body corps du message
     */
    public void sendEmail(String toEmail,
                          String subject,
                          String body) {
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", emailSettings.getContentType());
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(emailSettings.getEmailSender(), "NoReply"));

            msg.setSubject(subject, emailSettings.getEncoding());
            msg.setText(body, emailSettings.getEncoding());

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
