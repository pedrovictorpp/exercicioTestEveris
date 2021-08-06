package test.java.testesWeb.com.exercicioTeste.pages;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(how = How.ID, using = "total_price_container")	WebElement CART_TABLE_SUMMARY_TOTAL_FIELD;
	@FindBy(how = How.ID, using = "total_shipping")	WebElement CART_TABLE_SUMMARY_TOTAL_SHIPPING_FIELD;
	@FindBy(how = How.ID, using = "total_tax")	WebElement CART_TABLE_SUMMARY_TOTAL_TAX_FIELD;
	@FindBy(how = How.ID, using = "summary_products_quantity")	WebElement CART_TABLE_SUMMARY_QUANTITY_ITENS_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\'total_shipping\']")	WebElement CART_TABLE_SUMMARY_TOTAL_SHIPPING;
	@FindBy(how = How.XPATH, using = "//*[@id='total_tax']")	WebElement CART_TABLE_SUMMARY_TOTAL_TAX;

	@FindBy(how = How.XPATH, using = "//*[@id='total_price']")	WebElement CART_TABLE_SUMMARY_TOTAL;

	public Integer quantidadeItensCarrinho(WebDriver driver) {
		List<WebElement> listaItensCarrinho = driver.findElements(By.xpath("//*[@id='cart_summary']/tbody/tr"));
		Integer quantidadeInt = listaItensCarrinho.size();

		return quantidadeInt;
	}

	public Double validaValorTotalCompra(Integer quantidadeItens, WebDriver driver) {
		Double valorTotalEsperado = 0.0;
		Double valorTotalTabela = (Double.parseDouble(CART_TABLE_SUMMARY_TOTAL.getText().replace("$", "")));
		for (int i = 0; i < quantidadeItens; i++) {

			Double unitPrice = Double.parseDouble(driver
					.findElement(By.xpath(
							"/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[" + (i + 1) + "]/td[4]/span"))
					.getText().replace("$", ""));
			Integer qtdItem = Integer.parseInt(driver.findElement(By.xpath(
					"/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[" + (i + 1) + "]/td[5]/input[1]"))
					.getAttribute("value"));

			valorTotalEsperado = valorTotalEsperado + (unitPrice * qtdItem);
		}
		valorTotalEsperado = valorTotalEsperado
				+ (Double.parseDouble(CART_TABLE_SUMMARY_TOTAL_SHIPPING.getText().replace("$", ""))
						+ (Double.parseDouble(CART_TABLE_SUMMARY_TOTAL_TAX.getText().replace("$", ""))));

		assertEquals(valorTotalEsperado, valorTotalTabela);
		System.out.println(valorTotalEsperado);

		return null;

	}

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
