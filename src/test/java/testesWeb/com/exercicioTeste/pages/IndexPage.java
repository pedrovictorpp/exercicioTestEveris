package test.java.testesWeb.com.exercicioTeste.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	public String URL = "http://automationpractice.com/index.php";

	@FindBy(how = How.CSS, using = "a[title='Log in to your customer account']")	WebElement SIGN_IN_NAV_BUTTON;
	@FindBy(how = How.CSS, using = "a[title='Add to cart']")	WebElement ADD_TO_CART_BUTTON;
	@FindBy(how = How.CSS, using = "a[title='View my shopping cart']")	WebElement CART_NAV_BUTTON;
	@FindBy(how = How.CSS, using = "button_order_cart")	WebElement CART_ORDER_BUTTON;

	public IndexPage visitarHomePage(WebDriver driver) {
		driver.get(URL);
		return this;

	}

	public void visitarPaginaLogin() {
		SIGN_IN_NAV_BUTTON.click();
	}

	public void visitarPaginaCarrinho() {
		CART_NAV_BUTTON.click();

	}

	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
