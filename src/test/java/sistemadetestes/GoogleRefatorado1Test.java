package sistemadetestes;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleRefatorado1Test extends BaseTest {
	
	@Test
	public void pesquisarNoGoogle() {
		//Montagem do cenário: agora é feita quando são chamados:
		//@BeforeClass
		//public static void iniciar()
		
		//Preparação de automação
		WebElement inputPesquisa = driver.findElement(By.name("q")); //mapeia o componente
				
		//Execução de automação
		inputPesquisa.sendKeys("bolo de cenoura" + Keys.ENTER);
		String result = driver.findElement(By.id("result-stats")).getText();
				
		//Verificação e análise - assert
		assertTrue(result, result.contains("Aproximadamente"));
		
		//driver.quit();
		//Não precisa mais da linha acima, pois é chamada por:
		//@AfterClass
	}

}
