package sistemadetestes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pageObject.LoginPO;

public class LoginTest2 extends BaseTest {
	
	private static LoginPO loginPage; 
	
	@BeforeAll
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);
	}
	
	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
//		loginPage.inputEmail.sendKeys("");
//		loginPage.inputSenha.sendKeys("");
//		loginPage.escrever(loginPage.inputEmail, "");
//		loginPage.escrever(loginPage.inputSenha, "");
		
		loginPage.executarAcaoLogin("", "");
		
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.obterTituloPagina();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		
	}

}
