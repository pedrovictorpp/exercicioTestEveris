package testesWeb.com.exercicioTeste.Testes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testesWeb.com.exercicioTeste.pages.AutenticarPage;
import testesWeb.com.exercicioTeste.pages.CartPage;
import testesWeb.com.exercicioTeste.pages.IndexPage;
import testesWeb.com.exercicioTeste.pages.ProdutoPage;

public class CompraTeste {

	String email = "email@email.email";
	String senha = "tester123";
	WebDriver driver = new ChromeDriver();

	@Test
	public void realizarCompraTeste() {
		IndexPage indexPage = new IndexPage(driver);
		AutenticarPage autenticarPage = new AutenticarPage(driver);
		CartPage cartPage = new CartPage(driver);
		ProdutoPage produtoPage = new ProdutoPage(driver);

		// DADO que esteja logado
		indexPage.visitarHomePage(driver).visitarPaginaLogin();
		autenticarPage.fazerLogin(email, senha);

		// E tenha realizado a compra de um produto
		indexPage.visitarHomePage(driver);
		produtoPage.visitarPaginaProduto(1, driver);
		produtoPage.adicionarAoCarrinho(2);

		// QUANDO acessar o carrinho de compras
		indexPage.visitarHomePage(driver);
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		indexPage.visitarPaginaCarrinho();

		// ENTÃO o valor total dos produtos apresentado na tabela deve condizer com a
		// soma dos valores totais de cada item com os tributos e taxa de envio
		cartPage.validaValorTotalCompra(cartPage.quantidadeItensCarrinho(driver), driver);

	}

	@BeforeEach
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:/webDriver/chromedriver.exe");
		driver.manage().window().maximize();

	}

	@AfterEach
	public void quit() {
		driver.close();

	}

}
