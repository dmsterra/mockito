package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
	
	@FindBy(id = "email")
	public WebElement inputEmail;
	
	@FindBy(id = "senha")
	public WebElement inputSenha;
	
	@FindBy(id = "btn-entrar")
	public WebElement buttonEntrar;
	
	@FindBy(css = "form.form-login>div.alert>span")
	public WebElement spanMensagem;
	
	@FindBy(id = "btn-adicionar")
	public WebElement buttonCriar;
	
	public String obterTituloPagina() {
		return this.spanMensagem.getText();
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
				
	}
	
	public void executarAcaoLogin(String email, String senha) {
		escrever(inputEmail, email);
		escrever(inputSenha, senha);
		buttonEntrar.click();
	}


	public LoginPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
}
