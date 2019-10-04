package pages;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class NotificationEmail {

    public void EnviarCorreo() throws EmailException {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("src/test/java/output/fichero.txt");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("informe.txt");
        attachment.setName("Reporte");
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort (465);
        email.setAuthenticator (new DefaultAuthenticator("evaluacion092019@gmail.com", "Bellatrix2019"));
        email.setSSLOnConnect (true);
        email.addTo("arnold_matiasdlc@hotmail.com", "Arnold");
        email.setFrom("evaluacion092019@gmail.com", "Robot");
        email.setSubject("Resultado de pruebas funcionales");
        email.setMsg("Este es un archivo de ejecución automatica");
        email.attach(attachment);
        email.send();
    }
}
