package sistemadetestes;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleFirstTest {
	
	private WebDriver driver;
	private String URL_BASE = "https://www.google.com";
	private String PATH_DRIVE = "src/test/resources/chromedriver.exe";
	
	private void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
		
	}
	
	@Test
	public void pesquisaNoGoogleTest() {
		//Montagem do cenário
		iniciar();
		
		//Preparação de automação
		WebElement inputPesquisa = driver.findElement(By.name("q"));
		
		//Execução de automação
		inputPesquisa.sendKeys("bolo de cenoura" + Keys.ENTER);
		String result = driver.findElement(By.id("result-stats")).getText();
		
		//Verificação e análise - assert
		assertTrue(result, result.contains("Aproximadamente"));
		
		//Fechamento
		driver.quit();
	}

}
