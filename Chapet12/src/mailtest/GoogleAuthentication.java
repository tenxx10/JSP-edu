package mailtest;
import javax.mail.PasswordAuthentication;
import java.net.Authenticator;

public class GoogleAuthentication extends Authenticator {
	
	PasswordAuthentication passAuth;
	
	public GoogleAuthentication() {
		passAuth = new PasswordAuthentication("zoxe85", "");
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
	
}