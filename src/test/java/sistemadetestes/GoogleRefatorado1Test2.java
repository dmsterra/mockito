package sistemadetestes;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pageObject.GooglePO;

public class GoogleRefatorado1Test2 extends BaseTest {
	
	private static GooglePO googlePage;
	
	@BeforeAll
	public static void preparartestes() { 
		driver.get("https://www.google.com");
		googlePage = new GooglePO(driver);
	}
	
	@Test
	public void pesquisaNoGoogle() {
		
	}
}
