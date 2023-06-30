package sistemadetestes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	protected static WebDriver driver;

	private static final String URL_BASE = "file:///C:/Users/36124872021.2n/Downloads/selenium-lab-clayton/selenium-lab-main/sistema/login.html";
	private static final String PATH_DRIVE = "src/test/resources/chromedriver.exe"; //static final pois é uma constante
	
	
	//BeforeClass coloca na classe que tá automatizando a infraestrutura
	@BeforeAll
	public static void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
		
	}
	
	@AfterAll
	public static void finalizar() {
		driver.quit(); 
	}

}
