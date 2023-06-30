package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
	 * Classe para a criação das novas PageObjects
	 * todas as páginas herdam esta classe 
	 */

public class BasePO {
	
	/*
	 * Driver base que será usado pelas pages
	 */
	
	protected WebDriver driver;
	
	/*
	 * Construtor base para a criação da fábrica de elementos (pageFactory)
	 * @param driver (Driver do navegador atual)
	 */
	
	public BasePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
