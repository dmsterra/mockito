package sistemadetestes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Button;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pageObject.LoginPO;

public class LoginTest extends BaseTest {
	
	private static LoginPO loginPage; 
	
	@BeforeAll
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);
	}
	
	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
		loginPage.inputEmail.sendKeys("");
		loginPage.inputSenha.sendKeys("");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.spanMensagem.getText();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		
	}
	
	@Test
	public void TC002_naoDeveLogarNoSistemaComEmailErradoESenhaVazia() {
		loginPage.inputEmail.sendKeys("teste");
		loginPage.inputSenha.sendKeys("");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.spanMensagem.getText();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		
	}
	
	@Test
	public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaErrada() {
		loginPage.inputEmail.sendKeys("");
		loginPage.inputSenha.sendKeys("teste");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.spanMensagem.getText();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		
	}
	
	@Test
	public void TC004_naoDeveLogarNoSistemaComEmailESenhaErrados() {
		loginPage.inputEmail.sendKeys("teste");
		loginPage.inputSenha.sendKeys("teste");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.spanMensagem.getText();
		
		assertEquals(mensagem, "E-mail ou senha inválidos");
		
	}
	
	@Test
	public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaErrada() {
		loginPage.inputEmail.sendKeys("admin@admin.com");
		loginPage.inputSenha.sendKeys("teste");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.spanMensagem.getText();
		
		assertEquals(mensagem, "E-mail ou senha inválidos");
		
	}
	
	@Test
	public void TC006_naoDeveLogarNoSistemaComEmailErradoESenhaCorreta() {
		loginPage.inputEmail.sendKeys("teste");
		loginPage.inputSenha.sendKeys("admin@123");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.spanMensagem.getText();
		
		assertEquals(mensagem, "E-mail ou senha inválidos");
		
	}
	
	@Test
	public void TC007_LoginComSucesso() {
		loginPage.inputEmail.sendKeys("admin@admin.com");
		loginPage.inputSenha.sendKeys("admin@123");
		
		loginPage.buttonEntrar.click();
		
		
	}
}
