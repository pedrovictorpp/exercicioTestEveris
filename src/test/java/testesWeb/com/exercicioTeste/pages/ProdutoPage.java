package testesWeb.com.exercicioTeste.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProdutoPage {

	@FindBy(how = How.NAME, using = "Submit")	WebElement ADD_TO_CART_BUTTON;

	@FindBy(how = How.ID, using = "quantity_wanted")	WebElement QUANTITY_WANTED_FIELD;

	public void visitarPaginaProduto(Integer idProduto, WebDriver driver) {
		String idProdutoInt = idProduto.toString();
		driver.get("http://automationpractice.com/index.php?id_product=" + idProdutoInt + "&controller=product");
	}

	public ProdutoPage adicionarAoCarrinho(Integer quantidade) {
		String quantidadeStr = quantidade.toString();
		QUANTITY_WANTED_FIELD.clear();
		QUANTITY_WANTED_FIELD.sendKeys(quantidadeStr);
		ADD_TO_CART_BUTTON.click();
		return this;

	}

	public ProdutoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
