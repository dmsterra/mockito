package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {
	
	//coloca somente os elementos da página
	
	//Preparação da automação
	//WebElement inputPesquisa = driver.findElement(By.name("q")); <- 
	@FindBy(name = "q")
	public WebElement inputPesquisa; //faz a pesquisa quando chamar a ação
	
	//driver.findElement(By.id("result-stats")).getText();
	@FindBy(id = "result-stats")
	public WebElement divResultadoPesquisa;
	
	/*
	 * Construtor base para a criação da fábrica de elementos (pageFactory)
	 * @param driver (Driver do navegador atual)
	 */
	public GooglePO(WebDriver driver) {
		super(driver);

	}

}
