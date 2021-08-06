package test.java.testesWeb.com.exercicioTeste.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutenticarPage {

	@FindBy(how = How.ID, using = "email")	WebElement EMAIL_INPUT_FIELD;
	@FindBy(how = How.ID, using = "passwd")	WebElement PASSWORD_INPUT_FIELD;

	@FindBy(how = How.ID, using = "SubmitLogin")	WebElement SIGN_IN_BUTTON;

	public void fazerLogin(String email, String senha) {
		EMAIL_INPUT_FIELD.sendKeys(email);
		PASSWORD_INPUT_FIELD.sendKeys(senha);
		SIGN_IN_BUTTON.click();

	}

	public AutenticarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
