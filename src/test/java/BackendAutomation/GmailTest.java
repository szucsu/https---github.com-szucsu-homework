package BackendAutomation;

import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class GmailTest extends GmailOperations{

    @Test(groups = {"Test"})
    public void checkValidEmailSending() throws MessagingException, GeneralSecurityException, IOException {

        //Send email to desired account
        sendEmail("suciu.sandor@gmail.com", "me", "PentalogHomework", "Testing purpose");
    }

    @Test(groups = {"Test"})
    public void checkInboxForEmail() throws IOException, GeneralSecurityException {

        //Search form email and read the content.
        //You can send and email to "testuserpentaloghomework1@gmail.com" to validate the functionality
        //Make sure you search for text in the body
        searchAndReadEmail("homework");
    }

    @Test(groups = {"Test"})
    public void deleteEmailFormInbox() throws IOException, GeneralSecurityException {

        //Search form email and read the content
        //You can send and email to "testuserpentaloghomework1@gmail.com" to validate the functionality
        //Make sure you search for text in the body of the email you sent before
        searchAndDeleteEmail("DO NOT DELETE!");
    }
}